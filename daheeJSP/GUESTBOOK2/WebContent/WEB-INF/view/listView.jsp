<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		padding: 5px;
		border: solid 1px;
		border-radius: 10px;
		font-size: 16px;
		width: 400px;
	}
</style>
</head>
<body>
	<c:if test="${viewData.messageTotalCount>0}">		
		<c:forEach items="${viewData.messageList}" var="message">
		<div>
			메세지 번호 : ${message.id}<br>
			손님 이름 : ${message.guestName}<br>
			메세지 : ${message.message}<br>
			<a href="confirmDeletion.jsp?messageId=${message.id}">삭제하기</a>
		</div>
		</c:forEach>
		
		<c:forEach begin="1" end="${viewData.pageTotalCount}" step="1" var="num">
			<a href="guestList?page=${num}">[${num}]</a>
		</c:forEach>
	</c:if>
</body>
</html>