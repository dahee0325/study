<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#msg {
		padding: 5px;
		border: solid 1px;
		border-radius: 10px;
		font-size: 16px;
		width: 400px;
	}
	
	a {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		color: pink;
	}
</style>
</head>
<body>
	<h2>방명록</h2>
	<div style="text-align: right; width: 400px; padding-bottom: 10px;"><a href="guestWriteForm">글쓰기</a></div>
	<c:if test="${viewData.messageTotalCount>0}">		
		<c:forEach items="${viewData.messageList}" var="message">
		<div id="msg">
			메세지 번호 : ${message.id}<br>
			손님 이름 : ${message.guestName}<br>
			메세지 : ${message.message}<br>
			<div style="text-align: right; padding: 5px 10px 10px 0">
			<a href="guestDelForm?messageId=${message.id}">삭제하기</a>
			</div>
		</div>
		</c:forEach>
		<div style="text-align:center; width: 400px; padding: 10px 0 10px 0">
		<c:forEach begin="1" end="${viewData.pageTotalCount}" step="1" var="num">
			<a href="guestList?page=${num}">[${num}]</a>
		</c:forEach>
		</div>
	</c:if>
</body>
</html>