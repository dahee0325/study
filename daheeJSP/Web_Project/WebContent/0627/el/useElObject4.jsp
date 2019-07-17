<%@page import="web.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//인스턴스 생성
	request.setAttribute("member", new Member("tiger","ttt","010-000-0000"));	

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
		<%-- EL을 통한 출력 ↓  <%= request.getAttribute("name01") %> 과 같음--%>
		request 영역의 name01 : ${ requestScope.name01 }<br>
		session 영역의 name02 : ${ sessionScope.name02 }<br>
		application 영역의 name03 : ${ applicationScope.name03 } <br>
		
		<!-- requestScope : Map형태
			 member : key 
			 Mep.get("member") -> Mmber 객체
			 member에 있는id를 가져옴 id : 변수가아닌 getId()와 같음(get메서드를 불러오는거) -->
		member 객체 참조1 - id : ${ requestScope.member.id }<br>
		member 객체 참조1 - name : ${ requestScope.member.name }<br>
		<%-- 영역속성 생략가능 --%>
		member 객체 참조1 - pNum : ${ member.pNum }<br>
		<%-- Member에 있는 getNum() 메서드를 불러와서 리턴값을 받음 --%>
		member 객체 참조1 - num : ${ requestScope.member.num }
	</h3>
</body>
</html>