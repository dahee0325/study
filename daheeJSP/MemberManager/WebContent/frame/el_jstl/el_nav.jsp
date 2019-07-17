<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
	<ul>
		<%-- url에서는 context 경로를 가져와주기 때문에 index페이지는 /만 사용해도됨 --%>
		<li><a href="<c:url value='/5_el_jstl/index.jsp' />">홈</a></li>
		<li><a href="<c:url value='/5_el_jstl/login.jsp' />">로그인</a></li>
		<li><a href="<c:url value='/5_el_jstl/memberRegForm.jsp' />">회원가입</a></li>
		<li><a href="<c:url value='/5_el_jstl/mypage.jsp' />">마이페이지</a></li>
		<li><a href="<c:url value='/5_el_jstl/memberList.jsp' />">회원리스트</a></li>
		<li><a href="<c:url value='/5_el_jstl/logout.jsp' />">로그아웃</a></li>
	</ul>
</div>