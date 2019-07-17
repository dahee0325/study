<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- name 파라메터를 받아서 정보 출력 --%>

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
		String name = request.getParameter("name");
	
		//받아온 데이터를 인코딩하여 한글도 표현해준다.
		String dName = URLDecoder.decode(name, "utf-8");
	
	%>
	<h1>
		<%= dName %>
	</h1>
</body>
</html>