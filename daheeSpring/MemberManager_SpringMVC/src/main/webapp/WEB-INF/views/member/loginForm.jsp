<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 로그인</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<%-- nav 끝 --%>

		<!-- 컨텐츠 시작 -->
		<div id="contents">
			<h3>로그인</h3>
			<hr>
			<form method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userId" required></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userPw" required></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="로그인"> <a
							id="home_a" href="<c:url value="/main"/>">홈으로</a></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 컨텐츠 끝 -->


		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>