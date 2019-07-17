<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);
	boolean loginChk = cBox.exists("LOGIN") && cBox.getValue("LOGIN").equals("SUCCESS");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
	h4 {
		padding: 20px;
	}
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
			<h3>회원관리 프로그램의 메인 페이지 입니다.</h3>
			<h4>
			<% 
				if(loginChk) {
					out.println(cBox.getValue("ID")+"("+ cBox.getValue("NAME")+")님 로그인되었습니다.");
				}else {
					out.println("로그인해주세요.");
				}
			%>
			</h4>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</body>
</html>