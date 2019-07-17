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
<%
	//속성이름, 객체
	request.setAttribute("code", "code-0");
	request.setAttribute("name", request.getParameter("name"));
	request.setAttribute("type", "A-Type");

%>
</body>
</html>

<%-- 새로운요청을 하는것이아니기때문에 위에 setAttribute로 저장한값이 공유가 된다. --%>
<%-- load되는 페이지는 이페이지뿐 --%>
<%-- forward를 만난순간 다른 코드들은 무시되고, 정의한 페이지로 이동한다.
	 param을 통해 데이터도 보낼 수 있음 --%> 
<jsp:forward page="form_result.jsp" />
	<%--
		<jsp:param value="A-Type" name="type"/>
		<jsp:param value='<%= request.getParameter("name") %>' name="name"/>
		</jsp:forward>
	--%>
