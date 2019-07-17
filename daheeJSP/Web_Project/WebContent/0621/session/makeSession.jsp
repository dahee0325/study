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

	<h1>session을 이용한 데이터 저장</h1>
	
	<%-- session : 값을 저장하거나 공유데이터(데이터를 다른곳으로 전달하여 사용)를 쓰기위해 사용 --%>
	<%
		session.setAttribute("name", "DAHEE");
		session.setAttribute("id", "dada");
		session.setAttribute("isLogin", true);
		session.setAttribute("age", 20);
	%>
	
	<h3>세션에 데이터를 저장했습니다.</h3>
	
	<a href="viewSession.jsp">viewSession1</a>
	<a href="../ex/viewSession.jsp">viewSession2</a>
	<a href="logout.jsp">logout</a>
</body>
</html>