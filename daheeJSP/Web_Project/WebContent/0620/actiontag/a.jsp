<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A페이지</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>A 페이지 입니다.</h1>
	
	<%-- 요청 페이지를 다른 페이지로 전환할 때 사용 --%>
	<%-- a.jsp 가 실행되었지만 b.jsp 파일이 결과로 보여진다(url 경로는 a.jsp) --%>
	<jsp:forward page="b.jsp" />
</body>
</html>