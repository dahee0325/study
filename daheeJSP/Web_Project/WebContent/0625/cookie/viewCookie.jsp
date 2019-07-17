<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//브라우저(client)가 (server)에 요청할때 브라우저가 가진 모든 쿠키 정보를 함께 전송
	//브라우저가 가진 쿠키정보를 Cookie 배열에 저장함
	Cookie[] cookies = request.getCookies();
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
	<h1>Cookie Data</h1>
	<%
		if(cookies != null && cookies.length > 0) {
			for(int i=0; i<cookies.length; i++){
				//cookies의 Name이 name인것만 가져옴
				//if(cookies[i].getName().equals("name")){
	%>
	<h3>
		cookie이름 : <%= cookies[i].getName() %><br>
		cookie값 : <%= cookies[i].getValue() %><br>
	</h3>
	<%
				//}
			}
		}
	
	%>
	<a href="editCookie.jsp">editCookie</a><br>
	<a href="delCookie.jsp">delCookie</a>
</body>
</html>