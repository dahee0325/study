<%@page import="web.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 이페이지의 용도는 select.jsp 에서 사용자가 select에서 선택한 a,b,c 값을 가져와서 각각 다른 응답처리를 해주기위함 --%>
<%-- 경로에서 이 페이지를 연다면 getParameter("type") 에 들어온 값이 없어서 오류가 난다. --%>

<%

	//select 의 name값을 통해 선택된 값을 가져온다.
	String pType = request.getParameter("type");
	String no = request.getParameter("num");
	String uname = request.getParameter("userName");
	
	//jajvaResources > src > web > Member 에 정의한 멤버 인스턴스 생성
	Member member = new Member(uname, pType, no);
	
	//데이터 세개를 남은 객체를 속성으로 담아서 다른페이지에 공유할수있도록한다
	request.setAttribute("result", member);
	
	//새로운 request에도 session을 통해 데이터를 가져갈 수 있다.
	session.setAttribute("user", member);
	
	//경로에서 이 페이지를 연다면 getParameter("type") 에 들어온 값이 없어서 null값이 들어가 오류가난다
	//오류를 방지하기 위한 pType의 기본값을 만들음
	if(pType == null) {
		pType = "a";
	}
	
	if(no == null) {
		no = "0";
	}
	
	if(uname == null) {
		uname = "noname";
	}
	
	//들어온 pType 값에 따라 다른 응답을 해줌
	if(pType.equals("a")){
%>
	<jsp:forward page="page_a.jsp" />
	<%--<jsp:param value="<%= no%>" name="no"/>
		<jsp:param value="<%= uname %>" name="uname"/> --%>
		
	<%-- 속성으로 만든 member 를 사용해서 데이터를 공유한다. --%>
<%
	}else if(pType.equals("b")){
%>
	<jsp:forward page="page_b.jsp" />
	<%--<jsp:param value="<%= no%>" name="no"/>
		<jsp:param value="<%= uname %>" name="uname"/> --%>
<%
	}else {
%>
	<jsp:forward page="page_c.jsp" />
	<%--<jsp:param value="<%= no%>" name="no"/>
		<jsp:param value="<%= uname %>" name="uname"/> --%>
<%
	}
%>