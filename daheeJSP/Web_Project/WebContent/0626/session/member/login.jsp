<%@page import="web.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	1. id/pw 데이터를 받기
	2. id == pw 인증
	3. 세션에 사용자 데이터 저장 : 속성을 이용해서 데이터 저장
	4. 응답처리 : 로그인되었다 또는 로그인실패(이전페이지로 이동)
 --%>
 
 <% 
 	//사용자 요청에서 한글 처리
 	request.setCharacterEncoding("utf-8");
 
 	// 1. id/pw 데이터를받기
 	String id = request.getParameter("uId");
 	String pw = request.getParameter("uPw");
 	
 	// 2. id == pw 인증
 	boolean loginChk = false;
 	
 	//id값과 pw 값이 같으면 로그인 인증처리
 	if(id != null && pw != null && id.equals(pw)) {
 		//같다면 : 세션에 사용자 데이터 저장, loginChk = true
 		//session.setAttribute("loginId", id); //사용자가 로그인했는지 여부 확인용
 		//session.setAttribute("photo", "c:\\");
 		//session.setAttribute("grade", 6);
 		//session.setAttribute("nocname", "da");
 		
 		//객체생성
 		LoginInfo loginInfo = new LoginInfo(id);
 		
 		//LoginInfo 라는 이름으로 객체값을 넣음
 		session.setAttribute("LoginInfo", loginInfo);
 		
 		loginChk = true;
 	}
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%
	if(loginChk) {
%>
		<h1><%= id %>님 로그인되었습니다.</h1>
		<a href="loginCheck.jsp">loginCheck</a>
<%
	}else{
%>
		<script>
			alert("아이디 또는 비밀번호를 확인해 주세요.");
			//location.href ='loginForm.jsp';
			history.go(-1);
		</script>
<%
	}
%>
</body>
</html>