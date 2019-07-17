<%@page import="member.UserInfo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//Enumeration<String> : 이터레이터? 이전버전
	Enumeration<String> e = application.getAttributeNames();

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
<%
	//hasMoreElements() : hasNext() 와 같음 다음에 요소가 있는지확인 
	while(e.hasMoreElements()) {
		
		String name = e.nextElement();
		
		//객체를 받아옴
		Object obj = application.getAttribute(name);
		
		//받아온 객체들을 형변환연산자로 확인(UserInfo 객체인지)
		
		if(obj instanceof UserInfo) {
			//UserInfo 타입으로 형변환이 된다면 출력
			out.println(name+":"+obj+"<br>");	
		}
		
	}
%>
</body>
</html>