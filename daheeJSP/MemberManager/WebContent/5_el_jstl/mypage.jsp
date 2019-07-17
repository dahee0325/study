<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<%@ include file="../frame/el_jstl/el_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/el_jstl/el_nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>My Page</h3>
			<%--  --%>
			<c:if test="${ loginInfo ne null }">
			<hr>
			<%-- Map.get("loginInfo")와 같음 --%>
			<%-- ${ sessionScope.loginInfo } : loginInfo에 저장된 데이터를 불러옴(LoginInfo에 있는 toString메서드를 불러와서 출력해줌) --%>
			<form>
				<table>
					<tr>
						<td>아 이 디</td>
						<td>${loginInfo.id }</td>
					</tr>
						<td>이    름</td>
						<td>${loginInfo.name }</td>
					</tr>
					</tr>
						<td>가입일</td>
						<td><fmt:formatDate value="${loginInfo.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><img src="../img/${loginInfo.photo}">
					</tr>
				</table>
			</form>
			</c:if>
		</div>
		<c:if test="${loginInfo eq null }">
			<script>
				alert('로그인 후 이용가능한 페이지 입니다.');
				location.href='login.jsp';
			</script>
		</c:if>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>

	</div>
</body>
</html>