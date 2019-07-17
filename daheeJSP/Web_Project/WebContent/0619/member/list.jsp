<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- trimDirectiveWhitespaces를 사용하여 페이지소스보기에서 맨위의 공백을 없애줌 --%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<style>
img {
	width: 200px;
	border: 1px solid black;
	border-radius: 50%;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<%
		//싱글톤이 되어있는 Calendar
		//날짜 정보를 가져온다.
		Calendar c = Calendar.getInstance();
	%>

	<%-- 접속하는 날짜에 따라 바뀌도록 MONTH 는 인덱스가 0부터 시작하여 +1 을 해줘야한다. --%>
	<h1>
		회원 리스트
		<%=c.get(Calendar.YEAR)%>년
		<%=c.get(Calendar.MONTH) + 1%>월
		<%=c.get(Calendar.DATE)%>일
	</h1>

	<%--상대경로 : memberInsert는 자신과 같은 경로안에 있기 때문에--%>
	<a href="memberInsert.jsp">회원가입</a>
	<img alt="이미지" src="../../img/mini1.jpg">
	<a href="file.jsp">파일</a>

</body>
</html>