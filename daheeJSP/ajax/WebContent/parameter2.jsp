<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String region = request.getParameter("region");
 	
	System.out.println(name+":"+region);

	String str = "";

	if (name == null || region == null || name.length() < 0 || region.length() < 0 || name == "" || region == "") {
		str = "상품 이름 없음:가격 정보 없음";
	}else{
		str = name + ":" + region;
	}

	out.print(str);
%>