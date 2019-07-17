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
	<h3>EL을 이용한 cookie 참조</h3>
	<%-- 쿠키값들을 Map<쿠키이름, 쿠키값(쿠키객체)> 저장되어있는것을 가져옴 --%>
	<%-- cookie.쿠키이름(키값).value 를 사용하면 해당 키값에 있는 value값을 가져올수있다. --%>
	<h4> name : ${ cookie.name.value} <br>
		 id : ${ cookie.id.value } <br>
		 email : ${ cookie.email.value } <br>
		 <%-- null은 출력X --%>
		 type1 : ${cookie.type1.value}
	</h4>
	<hr>
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