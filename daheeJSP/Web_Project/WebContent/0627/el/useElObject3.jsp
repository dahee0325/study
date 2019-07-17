<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name01", "requestData");
	session.setAttribute("name02", "sessionData");
	application.setAttribute("name03", "applicationData");
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
	<h3>
		<%-- 속성영역(pageScope, requestScope, sessionScope, applicationScope)은 생략 가능하다.--%>
		<%-- name01을 page->request->session->application 영역 순으로 차례대로 찾는다. --%>
		<%-- 이름이 같더라면 먼저 찾는 순으로 데이터를 출력한다. --%>
		<%-- 이름을 같게하고 그 뒤에꺼를 가져오려면 속성영역을 정의해줘야한다. --%>
		<%-- 찾는 영역에서 name01을 찾으면 출력 없으면 null = null은 출력되지않는다. --%>
		request 영역의 name01 : ${ name01 }<br>
		session 영역의 name02 : ${ name02 }<br>
		application 영역의 name03 : ${ name03 }<br>
		
		<%-- <%= request.getParameter("code") %> 와 같음 --%>
		code 파라미터 : ${ param.code }<br>
		code 파마미터 : <%= request.getParameter("code") %> <br>
		<%-- pageContextPath를 가져옴  : <%= request.getContextPath() %> 와 같음--%>
		contextPath : ${ pageContext.request.contextPath }<br>
		<a href="${ pageContext.request.contextPath }/index.html">경로1</a>
		<a href="<%= request.getContextPath() %>/index.html">경로2</a>
		
	</h3>

</body>
</html>