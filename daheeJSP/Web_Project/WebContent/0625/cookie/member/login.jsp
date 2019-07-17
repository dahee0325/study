<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	boolean chk = false;
	
	if(id.length() > 0 && id != null) {
	
		if(id.equals(pw)){
			//쿠키생성 : 사용자 데이터를 저장
			//-1 : 브라우저 종료시 쿠키삭제
			Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", -1);
			response.addCookie(c1);
			Cookie c2 = CookieBox.createCookie("ID", id, -1);
			response.addCookie(c2);
			
			chk = true;
		}
		
	}
	
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
		if(chk) {
			out.println("<h2>로그인 되었습니다.</h2>");
			out.println("<a href=\"loginCheck.jsp\">로그인체크</a>");
			
		}else {
			out.println("<script> alert(\'아이디랑 패스워드를 확인하세요.\'); history.go(-1); </script>");
		}
	%>
</body>
</html>