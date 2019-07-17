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
<%-- 연산되는 값 표현이 가능하다 --%>
boolean : ${ true } / ${ false } <br>
정수 / 실수 : ${ 256 } / ${ 3.141592 } <br>
정수 / 실수 : ${ 2+10 } / ${ 3.1+0.5 } <br>
문자열 : ${ "문자열1" } / ${ '문자열2' } <br>
<%-- <a href="${"문자열"}">링크</a> : 오류 난다. --%>
<a href="${'url'}">링크</a><br>
<%-- null은 값이없다라고 생각하고 값처리를 해주지않는다. --%>
null 값 표현 : ${ null }
</h1>
</body>
</html>