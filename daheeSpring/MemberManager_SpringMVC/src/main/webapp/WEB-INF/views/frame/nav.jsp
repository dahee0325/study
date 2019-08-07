<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
	<ul>
		<li><a href="<c:url value="/member/regist" />">회원가입</a></li>
		<c:if test="${ loginInfo eq null }">
		<li><a href="<c:url value="/member/login" />">로그인</a></li>
		</c:if>
		<c:if test="${ loginInfo ne null }">
		<li><a href="<c:url value="/member/logout" />">로그아웃</a></li>
		</c:if>
		<li><a href="<c:url value="/member/mypage" />">마이페이지</a></li>
		<li><a href="<c:url value="/member/memberList" />">회원리스트</a></li>
		<li><a href="<c:url value="#" />">회원탈퇴</a></li>
	</ul>
</div>