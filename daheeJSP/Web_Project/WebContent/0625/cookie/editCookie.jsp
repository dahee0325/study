<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//쿠키의 이름이 name인 쿠키 데이터(값)을 변경
	//기존이름의 쿠키객체를 생성할때 새로운 데이터(값)를 넣으면된다.
	Cookie c = new Cookie("name", "혜원");
	response.addCookie(c);

	Cookie c1 = new Cookie("code", "zero");
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
	<h1>Cookie Update</h1>
	<a href="viewCookie.jsp">viewCookie</a>
	<br>
</body>
</html>