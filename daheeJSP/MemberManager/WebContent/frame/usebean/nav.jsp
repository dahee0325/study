<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="nav">
	<ul>
		<%-- <%= request.getContextPath() %> 를 사용하면 포트뒤에 경로를 가져와줌 --%>
		<li><a href="<%= request.getContextPath() %>/1_usebean/index.jsp">홈</a></li>
		<li><a href="<%= request.getContextPath() %>/1_usebean/login.jsp">로그인</a></li>
		<li><a href="<%= request.getContextPath() %>/1_usebean/memberRegForm.jsp">회원가입</a></li>
		<li><a href="<%= request.getContextPath() %>/1_usebean/mypage.jsp">마이페이지</a></li>
		<li><a href="<%= request.getContextPath() %>/1_usebean/logout.jsp">로그아웃</a></li>
	</ul>
</div>