<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//자바코드 작성가능 영역
	//문자열 객체 생성
	//String str = new String("회원가입 폼");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
img {
	width: 200px;
	border: 1px solid black;
	border-radius: 50%;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<h1>회원가입 폼</h1>
	<%-- href : localhost:8080 까지의 루트를 가지고있음 --%>
	<%-- 절대경로 /web/member/list.jsp --%>
	<a href="/web/member/list.jsp">회원리스트</a>
	<img alt="이미지" src="/web/img/mini2.jpg">
	<script>
		
		$(document).ready(function() {
			
			alert('회원 가입 페이지입니다.');
			
		});
	
	</script>
	
</body>
</html>