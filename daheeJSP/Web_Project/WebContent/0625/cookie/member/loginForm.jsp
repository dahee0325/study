<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>로그인</h1>
	<hr>
	<form action="login.jsp" method="post">
		아이디 <input type="text" name="id"> <br> 
		비밀번호 <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
	</form>
	<br>
	<a href="loginCheck.jsp">로그인 체크</a>
</body>
</html>