<%@page import="web.Member"%>
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
	<h1>Page_a.jsp 에서 만들어진 응답 결과</h1>
	<%--
	<br>
	no 파라미터의 값 : <%= request.getParameter("no") %><br>
	uname 파라미터의 값 : <%= request.getParameter("uname") %> --%>
	
	<%
		Member member = (Member)request.getAttribute("result");
	%>
	
	<%-- member 를 출력하면 member객체안에 있는 toString을 가져와 출력한다. --%>
	<%= member %><br>
	아이디 : <%= member.getId() %>
	이름 : <%= member.getName() %>
	번호 : <%= member.getpNum() %>
	<a href="../../0621/session/viewSession.jsp">데이터 확인</a>
</h1>
</body>
</html>