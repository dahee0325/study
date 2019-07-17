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
응답처리가 진행됩니다.
</body>
</html>
<%-- 새로운페이지를 요청해서 그 페이지로 이동 --%>
<%-- 새로운 페이지가 요청되기 때문에 request값이 초기화되어서 여기서 보내는 값이 공유불가능하다. --%>
<%
	request.setAttribute("code", "code-1");

	String name = request.getParameter("name");
	response.sendRedirect("form_result.jsp?type=B-Type&name="+name);
%>