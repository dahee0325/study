<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main_wrap">
		<div id="header"></div>
		<div id="nav"></div>
		<div id="content">
			<form action="login" method="post">
					아이디 <input type="text" name="userId">
					비밀번호 <input type="password" name="userPw">
					<a href="#">이전으로</a>
					<input type="submit" value="로그인">
			</form>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>