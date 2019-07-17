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
<h3>
	수치연산 <br>
	<%-- 자료형타입을 지정X : 출력하는 용도로 사용하기때문에 --%>
	${10-1}, ${10+10}, ${10*10}, ${10/2} / ${10/3}, ${10%3} <br>
	<%-- 
	${10 div 2} / ${10 div 3}, ${10 mod 3}<br><br> --%>
	비교연산 <br>
	${ 1 == 1 }, ${10 != 10}, ${10 > 1 }, ${10 < 1 }, ${10 >= 1 }, ${10 <= 1 }<br>
	<%-- 크다 작다는 왼쪽기준 10보다 1이 크다 --%>
	<%-- ${ 1 eq 1 }, ${10 ne 10}, ${10 gt 1 }, ${10 lt 1 }, ${10 ge 1 }, ${10 le 1 }<br><br> --%>
	
	논리연산자<br>
	${true && true}, ${ true || false} , ${!true }<br>
	${true and true}, ${ true or false} , ${not true }

</h3>
</body>
</html>