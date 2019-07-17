//Member 객체들을 저장하기 위한 배열 생성
//var members = [];

var members;

//저장소 변수 선언
//localStrage 에서 데이터 유무에 따라 배열 선언

//사용자 정보를 받아서 저장하는 객체 생성
//회원 데이터 저장 목적으로 하는 생성자 함수 정의
//id : 회원의 아이디 혹은 이메일 주소
//pw : 회원의 비밀번호
//name : 회원의 이름

//생성자함수 - 이름정의 할 때 대문자로 시작한다.
function Member(id, pw, name) {
    this.userId = id;
    this.userPw = pw;
    this.userName = name;
}

//메서드 정의 : 사용자의 데이터를 가지고 html 텍스트를 완성하는 메서드
Member.prototype.makeHtml = function (index) {

    var nHtml = '';

    nHtml += '<tr>\n';
    nHtml += '<td>' + index + '</td>\n';
    nHtml += '<td>' + this.userId + '</td>\n';
    nHtml += '<td>' + this.userPw + '</td>\n';
    nHtml += '<td>' + this.userName + '</td>\n';
    nHtml += ' <td><a onclick="editMember(' + index + ');">수정</a> |<a onclick="delMember(' + index + ')"> 삭제</a></td>\n';
    nHtml += '</tr>\n';

    return nHtml;
};

//사용자의 정보를 등록 후 등록된 정보를 보여주는 메서드
Member.prototype.showData = function () {
    alert('아이디 : ' + this.userId + ' \n비밀번호 :' + this.userPw + ' \n이름 : ' + this.userName);
};

//div에 정보들을 쭉 출력
Member.prototype.toString = function () {

    var str =
        '<h4>아이디 : ' +
        this.userId +
        '비밀번호 : ' +
        this.userPw +
        '이름 : ' +
        this.userName + '</h4>\n';


    return str;
};


window.onload = function () {

    //getItem 결과값 String (아무것도 저장된 상태가아닐때 null값이 나옴)
    if (localStorage.getItem('members') == null) {

        //최초 실행될때 배열을 생성
        members = [];

        //localStorage에 배열을 저장
        //JSON.stringify(members) : JSON타입의 문자열로 저장되는 members요소들
        localStorage.setItem('members', JSON.stringify(members));

    } else {
        //null이 아닌상태라면 실행됨 : localStorage에 memebers 가 존재할때
        //members에 저장
        members = JSON.parse(localStorage.getItem('members'));
        setListTable();
    }



    //regForm 문서객체 만들기
    var regForm = document.getElementById('regForm');

    //회원입력 폼의 submit 재정의
    regForm.onsubmit = function () {

        //사용자 입력 데이터 input 캐스팅
        var uId = document.getElementById('userId');
        var uPw = document.getElementById('userPw');
        var uName = document.getElementById('userName');

        if (uId.value.length < 1) {
            alert('아이디를 입력해주세요.');
            uId.focus();
            return false;
        }

        if (uPw.value.length < 1) {
            alert('비밀번호를 입력해주세요.');
            uPw.focus();
            return false;
        }

        if (uName.value.length < 1) {
            alert('이름을 입력해주세요.');
            uName.focus();
            return false;
        }

        //어디에 값을 보내는게 아니라 정상적으로 입력이 되면
        //객체를 생성해줄거기때문에 return값이 필요없다.
        //새로운 데이터로 객체생성
        var newMember = new Member(uId.value, uPw.value, uName.value);

        //newMember.showData();

        //배열에 요소 추가 : 변경이 일어남
        members.push(newMember);

        //localStorage에 배열 요소 추가
        localStorage.setItem('members', JSON.stringify(members));

        alert('회원가입되었습니다.');
        setListTable();

        regForm.reset();

        return false;

    };


    //회원수정 폼의 submit 재정의
    var editForm = document.getElementById('editForm');
    editForm.onsubmit = function () {

        //공백을 체크하는 유효성 검사
        //1. 캐스팅
        //2. 객체.value 값을 검사 : 문자열의 길이 검사
        var editId = document.getElementById('editId');
        var editPw = document.getElementById('editPw');
        var editName = document.getElementById('editName');
        var editIndex = document.getElementById('editIndex').value;

        if (editId.value.length < 1) {
            alert('아이디를 입력해주세요.');
            editId.focus();
            return false;
        }

        if (editPw.value.length < 1) {
            alert('비밀번호를 입력해주세요.');
            editPw.focus();
            return false;
        }

        if (editName.value.length < 1) {
            alert('이름을 입력해주세요.');
            editName.focus();
            return false;
        }

        //아이디 수정
        members[editIndex].userId = editId.value;
        //비밀번호 수정
        members[editIndex].userPw = editPw.value;
        //이름 수정
        members[editIndex].userName = editName.value;

        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');

        setListTable();
        editForm.reset();

        document.getElementById('editBox').style.display = 'none';

        return false;

    };

    var cBtn = document.getElementById('close');
    cBtn.onclick = function () {

        document.getElementById('editBox').style.display = 'none';

    };

};

//new Member();

//members 배열의 요소들을 출력하는 기능 생성
//전역변수들을 사용하면 되어서 매개변수가 필요없다.
function setListTable() {

    var newHtml = '';
    
    for (var i = 0; i < members.length; i++) {
        //i번째의 있는 정보를 가지고 위에 만들어놓은 toString 메서드가 실행됨
        //newHtml += members[i].toString();
        //newHtml += members[i].makeHtml(i);

        newHtml += '<tr>\n';
        newHtml += '  <td>' + i + '</td>\n';
        newHtml += '  <td>' + members[i].userId + '</td>\n';
        newHtml += '  <td>' + members[i].userPw + '</td>\n';
        newHtml += '  <td>' + members[i].userName + '</td>\n';
        newHtml += '  <td><a onclick="editMember(' + i + ');">수정</a> | <a onclick="delMember(' + i + ');">삭제</a></td>\n';
        newHtml += '</tr>\n';
        
    }

    //document.getElementById('memberlist').innerHTML = newHtml;

    //alert(newHtml);
    document.getElementById('listTable').innerHTML = newHtml;

};

//수정폼만들기
function editMember(index) {

    document.getElementById('editBox').style.display='block';

    //수정 폼의 아이디, 비밀번호, 이름 input 캐스팅
    var eId = document.getElementById('editId');
    var ePw = document.getElementById('editPw');
    var eName = document.getElementById('editName');
    var eIndex = document.getElementById('editIndex');

    //기존 데이터를 캐스팅한 객체에 value값을 대입(기존데이터를 가져온다)
    eId.value = members[index].userId;
    ePw.value = members[index].userPw;
    eName.value = members[index].userName;
    eIndex.value = index;

};

function delMember(index) {
    //alert(index + '번째 회원 삭제');

    var delChk = confirm('삭제하시겠습니까?');

    if (delChk) {
        //삭제 -> 배열에서 요소 삭제
        members.splice(index, 1);

        localStorage.setItem('members', JSON.stringify(members));

        alert('삭제되었습니다.');
        setListTable();
    }
};