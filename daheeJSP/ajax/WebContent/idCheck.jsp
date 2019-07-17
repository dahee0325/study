<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String id = request.getParameter("uId");
 	
	/* System.out.println("id : "+id);

	String str = "";

	if (id == null) {		
		str = "아이디나 비밀번호를 입력해주세요.";
	}else{
		str = id + "님 멋진 아이디 입니다.";
	}

	out.print(str); */

	if(!id.equals("admin")) {
		out.print("Y");
	}else {
		out.print("N");
	}
%>