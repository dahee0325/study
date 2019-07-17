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

<%
	//현재 request에 있는 세션을 새로운 session객체에 저장
	session = request.getSession(false);
%>

	name : <%= session.getAttribute("name") %><br>
	id : <%= session.getAttribute("id") %><br>
	isLogin : <%= session.getAttribute("isLogin") %><br>
	age : <%= session.getAttribute("age") %><br>
	<%= session.getAttribute("user") %>
</body>
</html>