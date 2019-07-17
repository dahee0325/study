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
<h1>
	type = <%= request.getParameter("type") %><br>
	name = <%= request.getParameter("name") %><br>
	code = <%= request.getAttribute("code") %><br>
	type1 = <%= request.getAttribute("type") %><br>
	name1 = <%= request.getAttribute("name") %><br>
</h1>
</body>
</html>