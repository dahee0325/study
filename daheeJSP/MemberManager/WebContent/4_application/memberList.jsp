<%@page import="member.UserInfo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//Enumeration<String> : 이터레이터? 이전버전
	Enumeration<String> e = application.getAttributeNames();

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
		border: 1px solid black;
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
		<%@ include file="../frame/application/a_header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/application/a_nav.jsp"%>
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
						<td>이미지</td>
						<td>관리</td>
					</tr>
					<!-- 리스트 반복 시작 -->
					<%
					int cnt=0;
					
					while(e.hasMoreElements()) {
						
						String name = e.nextElement();
						
						//객체를 받아옴
						Object obj = application.getAttribute(name);
						
						//받아온 객체들을 형변환연산자로 확인(UserInfo 객체인지)
						
						if(obj instanceof UserInfo) {
							UserInfo userinfo = (UserInfo)obj;
					%>
					<tr>
						<td><%= ++cnt %></td>
						<td><%= userinfo.getId() %></td>
						<td><%= userinfo.getName() %></td>
						<td><%= userinfo.getPw() %></td>
						<td><img class="sumnail" alt="회원사진" src="../img/<%= userinfo.getPhoto() %>"></td>
						<td><a href="#">수정</a> | <a href="#">삭제</a></td>
					</tr>
					<%
						}
						
					}
					
					%>
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