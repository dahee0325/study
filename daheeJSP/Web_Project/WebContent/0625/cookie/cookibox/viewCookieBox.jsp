<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);
%>


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
	<h1>Cookie Data</h1>
	
	<h3>
		name : <%= cBox.getValue("name") %><br>
		nicname : <%= cBox.getValue("nicname") %><br>
		pw : <%= cBox.getValue("pw") %>
	</h3>
	
	<a href="editCookieBox.jsp">editCookie</a><br>
	<a href="delCookieBox.jsp">delCookie</a>
</body>
</html>