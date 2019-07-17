<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현재있는 세션정보를 강제소멸시켜준다
	request.getSession(false).invalidate();
	
	response.sendRedirect(request.getContextPath());
%>