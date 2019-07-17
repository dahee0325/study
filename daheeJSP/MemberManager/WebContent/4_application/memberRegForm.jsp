<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/application/a_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/application/a_nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>Member Join</h3>
			<hr>
			<form action="memberReg.jsp" method="post">
				<table>
					<tr>
						<td>아 이 디</td>
						<%-- required : 필수사항--%>
						<td><input type="email" name="id" placeholder="아이디 또는 이메일" required></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw" required></td>
					</tr>
					<tr>
						<td>이    름</td>
						<td><input type="text" name="name" required></td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><input type="file" name="photo"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="회원가입"></td>
					</tr>
				</table>
			</form>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>

	</div>
</body>
</html>