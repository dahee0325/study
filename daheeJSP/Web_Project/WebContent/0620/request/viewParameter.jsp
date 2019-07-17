<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>요청 파라미터 출력</h1>
	<ul>
		<li>name 파라미터 : <%=request.getParameter("name")%></li>
		<li>address 파라미터 : <%=request.getParameter("address")%></li>
		<li>pet 파라미터 : <%=request.getParameter("pet")%></li>
	</ul>
		<%-- getParameter 는 가장첫번째 선택된 값만 가져오기때문에 getParameterValues를 사용해서 배열로 여러값을 가져온다--%>
		<h3>request.getParameterValue() 이용</h3>
		<%--
		<li>pet 파라미터 :
		<%
			String[] values = request.getParameterValues("pet");
			
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
		%>
		 <%= values[i] %>
		<%
				}
			}
		%>
		</li>
		 --%>
		 
		<%
			String[] values = request.getParameterValues("pet");
		
			if(values != null && values.length > 0) {
				
		%>
		<ul>
		<%
		
			for(int i=0; i < values.length; i++){
				
		%>
		<li><%= values[i] %></li>
		<%
				} 
			}
		%>
		</ul>
		
		<h3> request.getParameterNames() </h3>
		<%
			Enumeration params = request.getParameterNames();
			
			//다음요소 있는지 없는지 확인
			while(params.hasMoreElements()) {
				String pName = (String)params.nextElement();
				
		%>
			<%= pName %><br>
		<%
			}
		%>

		<h3> request.getParameterMap : </h3>
		
		<% 
			Map parameterMap = request.getParameterMap();
		
			String[] nameParam = (String[])parameterMap.get("name");
		
			if(nameParam != null){
		%> 
		name = <%= nameParam[0] %>
		<% } %>
</body>
</html>