<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/application/a_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/application/a_nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
		<%
		
			if(loginInfo != null) {
		%>
			<h3>My Page</h3>
			<hr>
			<%-- Map.get("loginInfo")와 같음 --%>
			<%-- ${ sessionScope.loginInfo } : loginInfo에 저장된 데이터를 불러옴(LoginInfo에 있는 toString메서드를 불러와서 출력해줌) --%>
			<form>
				<table>
					<tr>
						<td>아 이 디</td>
						<td><%= loginInfo.getId() %> / ${sessionScope.loginInfo.id }</td>
					</tr>
						<td>이    름</td>
						<td><%= loginInfo.getName() %> / ${sessionScope.loginInfo.name }</td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><img src="../img/<%= loginInfo.getPhoto() %>">
							<img src="../img/${sessionScope.loginInfo.photo }"></td>
					</tr>
				</table>
			</form>
		</div>
		<%
			}else {
				
		%>
			<script>
				alert('로그인 후 이용가능한 페이지 입니다.');
				location.href='login2.jsp';
			</script>
		
		<%
			}
		%>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>

	</div>
</body>
</html>