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

<%-- 세션정보를 삭제하여 logout 처리 --%>
<%-- invalidate() : 현재 있는 세션을 삭제해준다. --%>
<%
	//request.getSession(false).invalidate();
	//같음
	session.invalidate();
%>
<h1>로그아웃 되었습니다.</h1>
<a href="viewSession.jsp">viewSession1</a>
<a href="../ex/viewSession.jsp">viewSession2</a>
</body>
</html>