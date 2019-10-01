//모듈 로드
//Http.Server
var http = require('http');
//포스트로 받은 내용을 객체형식으로 처리
var querystring = require('querystring');

//데이터
var movieList = [
    {title : '스타워즈', director : '조지루카스'},
    {title : '스타', director : '조지'}
];

var server = http.createServer(function(req,res){

    var url = req.url;
    var method = req.method.toLocaleLowerCase();

    if(url =='/' && method == 'get'){

        list(req, res);

    }else if(url.indexOf('/images/') == 0 && method == 'get') {

    }

});

//포트 설정
server.listen(3000);

function addMovie(req, res) {

    //res의 'data' / 'end' 이벤트를 이용해서 body의 내용을 읽어 처리한다.

    var body = '';

    //chunk 는 String
    req.on('data', function(chunk){

        body += chunk;
        console.log(body);

    });

    req.on('end', function() {

        var parseData = querystring.parse(body);
        console.log('parsed : ', parseData);

        movieList.push({title : parseData.title, director : parseData.director});
        console.log('영화 추가완료');

        //list(rqu, res);

        //리스트를 따로 부르지않아도 get으로가 리스트를 호출
        res.statusCode = 302;
        res.setHeader('Location', '.');
        res.end('success');

    });

}

function list (rqu, res) {

    //movieList 데이터를 출력해서 보여주는 html 파일을 생성하여 응답처리
    
    //응답하기 위한 해더 설정
    res.writeHeader(200), {'Content-Type':'text/html; charset=UTF-8'};

    // 내용(body) 설정
    res.write('<html>');
    res.write('<meta charset="UTF-8">');
    res.write('<body>');
    res.write('<h3>Favorite Movie</h3>');
    res.write('<div><ul>');
    //반복할내용 item 객체의 값을 반환해줌
    movieList.forEach(function(item){
        res.write('<li>'+item.title+'('+item.director+')</li>');
    });
    res.write('</ul></div>');

    res.write(
        '<form method="post"><h4>새 영화 입력</h4>' +
        '<div><input type="text" name="title" placeholder="영화제목"></div>' +
        '<div><input type="text" name="director" placeholder="감독"></div>' +
        '<input type="submit" value="upload">' +
        '</form>'
        );
    res.write('</body>');
    res.write('</html>');

    // 응답 실행
    res.end();
}