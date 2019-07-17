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
	<h3>
		<%-- EL 의 경우에는 null값을 표현하지않는다 표현식은 null을 null이라고 출력한다. --%>
		<%-- 데이터가 유지되는 : request는 페이지, session은 브라우저, application은 서버 --%>
		request 영역의 name01 : ${ requestScope.name01 }<br>
		session 영역의 name02 : ${ sessionScope.name02 }<br>
		application 영역의 name03 : ${ applicationScope.name03 } 
	</h3>

</body>
</html>