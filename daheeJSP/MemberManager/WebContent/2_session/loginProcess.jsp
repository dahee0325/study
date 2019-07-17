<%@page import="util.SessionMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	boolean loginCh = false;
	
	if(id != null && pw != null) {
		if(id.equals(pw)){
			SessionMember sessionM = new SessionMember(id, pw);
			session.setAttribute("LoginInfo", sessionM);
			
			loginCh = true;
		}else {
			out.println("<script> alert(\'아이디랑 패스워드를 확인하세요.\'); history.go(-1); </script>");	
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/session/s_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/session/s_nav.jsp"%>
		<%-- nav 끝 --%>
		
		<%-- contents 시작 --%>
		<div id="contents">
			<h3>세션 로그인 체크</h3>
			<hr>
			
			<%
				if(loginCh) {
					out.println("<h4>"+ id +"님 로그인되셨습니다.</h4>");
				}
			%>	
						
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>

	</div>
</body>
</html>