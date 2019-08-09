<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 마이페이지</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet" type="text/css">
<style>
	img {
		width: 150px;
	}
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
			<h3>마이페이지</h3>
			<hr>
				<table>
					<tr>
						<td>아 이 디</td>
						<td>${loginInfo.userId }</td>
					</tr>
					<tr>
						<td>이    름</td>
						<td>${loginInfo.userName }</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><fmt:formatDate value="${loginInfo.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><img src="<c:url value='/uploadfile/userphoto/${loginInfo.userPhoto}'/>">
					</tr>
					<tr>
						<td colspan="2"><a id="home_a" href="#">내 정보수정</a></td>
					</tr>
					
				</table>
		</div>
		<!-- 컨텐츠 끝 -->


		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>