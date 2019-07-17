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
	<%-- HttpServletRequest로 형변환을 해야지 사용할 수 있음 getRequest 가 상위클래스로 정의가 되어있어서 형변환이 필요하다.--%>
	<%
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
	%>
	
	<%-- 같은 객체라면 같은 주소값,같은참조값을 가지고있을것이다. --%>
	<%= request == req	%>

	<br>
	
	<%
		out.print(123+"<br>");
		pageContext.getOut().print("같은 객체를 사용합니다.");
	%>

</h1>
</body>
</html>