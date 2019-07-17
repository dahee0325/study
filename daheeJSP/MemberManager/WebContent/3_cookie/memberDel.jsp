<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie c1 = CookieBox.createCookie("LOGIN", "", 0);
	response.addCookie(c1);
	Cookie c2 = CookieBox.createCookie("ID", "", 0);
	response.addCookie(c2);
	Cookie c3 = CookieBox.createCookie("PW", "", 0);
	response.addCookie(c3);
	Cookie c4 = CookieBox.createCookie("NAME", "", 0);
	response.addCookie(c4);
%>
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
		<%@ include file="../frame/cookie/c_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/cookie/c_nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h1>회원탈퇴되었습니다.</h1><br>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</body>
</html>