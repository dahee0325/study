<!-- JSP 가 실행되는 영역 서버에서 처리하므로 화면에는 표현되지않는다. -->
<!-- page 속성정의 하는 공간 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSP에서는 html은 텍스트로 인식된다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Java Server Page</title>
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>

</script>
</head>
<body>

	<%-- JSP는 servlet class로 변환 --%>
	<%-- <% %>  : 자바코드쓸 수 있는 영역 --%>
	<%-- <%= %>: (표현식)println(new String("").toString)과 같은 역할. 출력 해줌--%>
	<h1>
		<%= new String("Test") %>
		<br>
		<%= new java.util.Date() %>
	</h1>
</body>
</html>