<%@page import="web.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name01", "requestData");
	session.setAttribute("name02", "sessionData");
	application.setAttribute("name03", "applicationData");
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
	<h3>	
		<%-- EL을 통한 출력 ↓  <%= request.getAttribute("name01") %> 과 같음--%>
		request 영역의 name01 : ${ requestScope.name01 }<br>
		session 영역의 name02 : ${ sessionScope.name02 }<br>
		application 영역의 name03 : ${ applicationScope.name03 } 
	</h3>

</body>
</html>