
//필요한 모듈 import 하기
//require : 어플리케이션에 필요한 모듈을 불러올때 사용
var http = require("http");

//언제나 "Hello World"를 리턴하는 포트 8081의 웹서버를 생성해준다.
http.createServer(function(request, response) {
    // http 헤더 전송
    response.writeHead(200, {'Content-Type' : 'text/plain'});

    // Response Body를 "Hello World" 로 설정

    response.end("Hello World\n");
    
}).listen(8081);

console.log("Server running at http://127.0.0.1:8081");