<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);
	boolean loginChk = cBox.exists("LOGIN") && cBox.getValue("LOGIN").equals("SUCCESS");
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
	<h1>로그인 여부 확인</h1>
	<h3>
	<%
		if(loginChk){
			out.println(cBox.getValue("ID")+"님 로그인 상태입니다.");
			out.println("<a href=\"logout.jsp\">로그아웃</a>");
			
		}else {
			out.println("로그인되어있는 상태가 아닙니다.");
		}
	%>
	</h3>
</body>
</html>