<%@page import="java.util.Enumeration"%>
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
	<%-- web에 정의한 context-param의 name값으로 value를 가져옴 --%>
	<%-- 처음에 올린 서버의 value값이 서버가 돌아가는동안에 유지가 되기때문에 value값을 바꾼 후 서버를 껐다 켜야지 내용이 바뀐다. --%>
	<%= application.getInitParameter("logEnabled") %><br>
	<%= application.getInitParameter("debugLevel") %><br>
	
	<%
		
		Enumeration initParamNames = application.getInitParameterNames();
		
		//initParamNames에 읽을게 있는지없는지 확인
		while(initParamNames.hasMoreElements()) {
			//initParamNames의 값을 가져온다. 정의해놓은 Parameter name값
			out.print(initParamNames.nextElement()+"<br>");
		}
	
	%>
</h1>
</body>
</html>