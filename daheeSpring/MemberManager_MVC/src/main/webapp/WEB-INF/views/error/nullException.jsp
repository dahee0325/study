<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager</title>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<%-- header 끝 --%>
		
		<%-- nav 시작 --%>
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<%-- nav 끝 --%>
		
		<%-- contents 시작 --%>
		<div id="contents">
		<h3>NullPointException ERROR 발생</h3>
		</div>
		<%-- contents 끝 --%>
		
		<%-- footer 시작 --%>
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</html>