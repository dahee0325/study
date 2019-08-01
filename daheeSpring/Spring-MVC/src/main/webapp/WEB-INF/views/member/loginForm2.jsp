<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<hr>
	<form action="memberLogin" method="post">
		ID : <input type="text" name="uId"><br>
		PW : <input type="password" name="uPw"><br>
		<input type="submit" value="로그인">
		<a href="../index.jsp">돌아가기</a>
	</form>
</body>
</html>