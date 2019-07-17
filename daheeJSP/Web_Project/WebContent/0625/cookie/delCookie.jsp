<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//어차피 사라질거라 공백문자를 넣음
	Cookie c = new Cookie("name","");
	c.setMaxAge(0);//setMaxAge(시간정보=초단위) : 60*60*24 : 하루, 60*60*24*365 : 1년
	response.addCookie(c);
	
	Cookie c1 = new Cookie("code","");
	c1.setMaxAge(0);
	response.addCookie(c1);
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
	<h1>Cookie Delete</h1>
	<a href="viewCookie.jsp">viewCookie</a>
</body>
</html>