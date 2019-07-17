<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="loginInfo" class="member.UserInfo" scope="session" />
<jsp:setProperty property="id" name="loginInfo"/>
<jsp:setProperty property="pw" name="loginInfo"/>
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

	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/usebean/header.jsp"%>
		<%-- header 끝 --%>
		
		<%-- nav 시작 --%>
		<%@ include file="../frame/usebean/nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>로그인 요청처리페이지</h3>
			<hr>
				<table>
					<tr>
						<td>아 이 디</td>
						<td><%= loginInfo.getId() %></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><%= loginInfo.getPw() %></td>
					</tr>
				</table>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>

	</div>
</body>
</html>