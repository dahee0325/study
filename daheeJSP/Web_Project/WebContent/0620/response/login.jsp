<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인이 정상적으로된다면 특정페이지로 보내기 --%>
<%

	String id = request.getParameter("id");

	String name = "다희";
	
	//그냥 값을 넣어 보내면 한글이 깨지기 때문에 인코딩 작업을 해줌
	String newStr = URLEncoder.encode(name, "utf-8");

	if(id != null && id.equals("test")) {
		
		//아이디가 test랑 같다면 메인페이지로 이동
		//response.sendRedirect("/web/index.html");
		
		//response.sendRedirect("view.jsp?name="+name);
		response.sendRedirect("view.jsp?name="+newStr);
	}
	
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
	<h1>인증처리된 아이디가 아닙니다.</h1>
</body>
</html>