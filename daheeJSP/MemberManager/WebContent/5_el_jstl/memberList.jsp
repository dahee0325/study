<%@page import="member.UserInfo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	//속성으로 들어오는 모든 데이터 저장
	//Enumeration<String> : 이터레이터? 이전버전
	Enumeration<String> e = application.getAttributeNames();
	application.setAttribute("mListName", e);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
	img.sumnail{
		height: 30px;
		margin: 2px;
	}
	
	#table, #table td {
		border: 1px soli d black;
		border-collapse: collapse;
	}
	#table td {
	padding: 5px;
	border : 1px solid #DDD;
	font-size: 14px;
	}
	
	#table tr:first-child>td {
		text-align: center;
		background-color: #EEE;
		font-weight: bold;
		font-size: 15px;
	}
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
			<h3>회원 리스트</h3>
			<hr>
				<table id="table">
					<tr>
						<td>순번</td>
						<td>아이디</td>
						<td>이름</td>
						<td>비밀번호</td>
						<td>가입일</td>
						<td>이미지</td>
						<td>관리</td>
					</tr>
					<!-- 리스트 반복 시작 -->
					<%-- varStatus="status" : 를 사용하면 인덱스, 카운트를 사용할 수 있다. --%>
					<c:forEach items="${mListName}" var="mId" varStatus="status">
					<%-- mId 가 원본에서 @를 포함하는 문자열 이 있으면--%>
					<c:if test="${fn:contains(mId, '@')}">
						<%-- [mId]에 있는 키값을 가져옴 --%>
						<c:set var="member" value="${ applicationScope[mId] }"/>
						<tr>
							<td>${ status.count }</td>
							<td>${ member.id }</td>
							<td>${ member.name }</td>
							<td>${ member.pw }</td>
							<td><fmt:formatDate value="${loginInfo.regDate}" pattern="yyyy/MM/dd H:mm"/></td>
							<td><img class="sumnail" alt="회원사진" src="../img/${ member.photo }"></td>
							<td><a href="#">수정</a> | <a href="#">삭제</a></td>
						</tr>
						</c:if>
					</c:forEach>
					
					<!-- 리스트 반복 종료 -->
				</table>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/member/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</body>
</html>