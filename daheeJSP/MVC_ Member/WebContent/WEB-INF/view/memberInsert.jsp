<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${resultCnt==1}">
		<h2>회원가입되었습니다.</h2>
	</c:if>
	<c:if test="${!(resultCnt==1)}">
		<h2>회원가입실패</h2>
	</c:if>
</body>
</html>