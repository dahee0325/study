<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
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
		<h3>[EL, JSTL] 회원관리 프로그램의 메인 페이지 입니다.</h3>
		</div>
		<%-- contents 끝 --%>
		
		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>
		
	</div>
</body>
</html>