<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value='/css/index.css'/>" rel="stylesheet" type="text/css">
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
			<h1>
				인증되었습니다. <br>로그인 후 정상적인 서비스 실행이 가능합니다.<br> 감사합니다.
			</h1>
			<h3>
				<a href="login">로그인 하기</a>
			</h3>
		</div>
		<!-- 컨텐츠 끝 -->

		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- footer 끝 -->

	</div>
</body>
</html>
