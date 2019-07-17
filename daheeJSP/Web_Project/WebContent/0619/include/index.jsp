<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
}

div {
	width: 45%;
	padding : 10px;
	float: left;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<%-- index.jsp 가 실행되면서 top.jsp 에 있는 코드를 가져오고 마지막 사용에게 응답되어 가는 코드는 index.jsp이기 때문에 스타일은 여기서만 넣어도된다. --%>
	<h1>include 지시어</h1>
	<hr>
	<%-- 메뉴시작 --%>
	<%@ include file="top.jsp"%>
	<%-- 메뉴 끝 --%>
	<%-- 왼쪽영역 시작 --%>
	<%@ include file="left.jsp"%>
	<%-- 왼쪽영역 끝 --%>
	<%-- 오른쪽영역 시작 --%>
	<%@ include file="right.jsp"%>
	<%-- 오른쪽영역 끝 --%>
	
	<%-- footer 시작 --%>
	<%-- jsp 액션태그 --%>
	<jsp:include page="footer.jsp">
		<jsp:param value="010-2222-3333" name="tel" />
		<jsp:param value="test@test.com" name="email" />
	</jsp:include>
	<%-- footer 끝 --%>
</body>
</html>