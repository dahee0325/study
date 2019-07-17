<%@page import="util.CookieBox"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//쿠키 등록 방법 (쿠키를 굽는다)
	//1. Cookie객체를 생성 : new Cookie("쿠키이름","쿠키값(데이터)");
	//2. response 객체에 Cookie를 추가 : response.addCookie(쿠키객체의 참조변수); 
	//Cookie cookie = new Cookie("code", "ace");
	Cookie cookie = CookieBox.createCookie("code", "0");
	response.addCookie(cookie);
	
	
	//Cookie c = new Cookie("name", "다희");
	Cookie c = CookieBox.createCookie("name", "다희");
	response.addCookie(c);
	
	//setMaxAge를 설정하지 않는다면 브라우저를 닫는순간 쿠키가 사라지지만 설정을하면 시간이 지나야 사라진다.
	//로컬호스트에 담겨서 사라지지않음
	//Cookie c1 = new Cookie("id","dahee");
	//c1.setMaxAge(60);//60초(1분)
	Cookie c1 = CookieBox.createCookie("nicname", "hot", 60*30);//30분동안 쿠키존재
	response.addCookie(c1);
	
	//Cookie c2 = new Cookie("email","test@test.com");
	//c2.setMaxAge(60*60);//1시간
	Cookie c2 = CookieBox.createCookie("pw", "1234", 60*60*2);//2시간동안 쿠키존대
	response.addCookie(c2);
%>
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
	<h1>Cookie Make</h1>
	<h2>쿠키가 생성되었습니다.</h2>
	<a href="viewCookieBox.jsp">viewCookie</a><br>
	<a href="../viewCookieJs.jsp">viewCookie</a><br>
</body>
</html>