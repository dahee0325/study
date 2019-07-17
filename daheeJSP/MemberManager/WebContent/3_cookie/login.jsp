<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%
	CookieBox cBox = new CookieBox(request);
	String val = "";
	if(cBox.getValue("CHECK") != null){
		if(cBox.getValue("CHECK").equals("yes")) {
			if(cBox.getValue("ID") != null){
				val = cBox.getValue("ID");
				out.println("<script> $(document).ready(function () { $('#ch').prop('checked', true); }); </script>");
			}else {
				val="";
				out.println("<script> $(document).ready(function () { $('#ch').prop('checked', false); }); </script>");
			}		
		} else if(cBox.getValue("CHECK").equals("no")) {
			out.println("<script> $(document).ready(function () { $('#ch').prop('checked', false); }); </script>");
			val = "";
		}
	}else {
		out.println("<script> alert(\'회원가입해주세요.\'); history.go(-1); </script>");
	}
	
%>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/cookie/c_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/cookie/c_nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>Login Page</h3>
			<hr>
			<form action="loginProcess.jsp" method="post">
				<table>
					<tr>
						<td>아 이 디</td>
						<td><input type="text" name="id" value="<%= val %>"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2">아이디저장 <input id="ch" name="ch" value="1" type="checkbox"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="로그인"></td>
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