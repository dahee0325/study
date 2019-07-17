<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String ch = request.getParameter("ch");
	
	CookieBox cBox = new CookieBox(request);
	
	if(id.length() > 0 && pw.length() > 0 && id != null && pw != null) {
		
		if(id.equals(cBox.getValue("ID")) && pw.equals(cBox.getValue("PW"))) {
			
			Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", -1);
			response.addCookie(c1);
			
			 if(ch == null){
				 Cookie check = CookieBox.createCookie("CHECK", "no", 60*60*24*7);
				 response.addCookie(check);
				 Cookie c = CookieBox.createCookie("ID", id, -1);
				 response.addCookie(c);
				 response.sendRedirect("index.jsp");
			}else {
				Cookie check = CookieBox.createCookie("CHECK", "yes", 60*60*24*7);
				response.addCookie(check);
				Cookie c = CookieBox.createCookie("ID", id, 60*60*24*7);
				response.addCookie(c);
				out.println("<script> alert(\'아이디를 7일간 저장합니다.\'); location.href ='index.jsp'; </script>");
			} 
		}else {
			out.println("<script> alert(\'아이디랑 패스워드를 확인하세요.\'); history.go(-1); </script>");
		}
		
	}

%>
