<%@page import="web.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 이페이지의 용도는 select.jsp 에서 사용자가 select에서 선택한 a,b,c 값을 가져와서 각각 다른 응답처리를 해주기위함 --%>
<%-- 경로에서 이 페이지를 연다면 getParameter("type") 에 들어온 값이 없어서 오류가 난다. --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
%>
<%-- pType 파라미터 값을 비교 null값을 비교
		 no 파라미터 값을 비교 null값을 비교
		 uname 파라미터 값을 비교 null값을 비교
	 --%>

<c:set value="${ param.type }" var="pageType" scope="request" />
<c:if test="${ pageType eq null }">
	<c:set value="a" var="pageType" scope="request" />
</c:if>

<c:set value="${ param.num }" var="pNo" scope="request" />
<c:if test="${ pNo eq null or pNo eq '' }">
	<c:set value="0" var="pNo" scope="request" />
</c:if>

<c:set value="${ param.userName }" var="uName" scope="request" />
<c:if test="${ uName eq null or uName eq '' }">
	<c:set value="noname" var="uName" scope="request" />
</c:if>


<jsp:forward page="page_${ pageType }.jsp" />

<%-- 

	 <c:if test="${pageType eq 'a'}">
	 <c:set  value="page_a.jsp" var="url"/>
	 </c:if>
	 <c:if test="${pageType eq 'b'}">
	 	<c:set  value="page_b.jsp" var="url"/>
	 </c:if>
	 <c:if test="${pageType eq 'c'}">
	 	<c:set  value="page_c.jsp" var="url"/>
	 </c:if>

	 <jsp:forward page="${ url }"/>
	 
--%>


<%-- 

	<c:choose>
	<c:when test="${ param.type eq 'a' }">
		<c:set  value="page_a.jsp" var="url"/>
	</c:when>
	<c:when test="${ param.type eq 'b' }">
		<c:set  value="page_b.jsp" var="url"/>
	</c:when>
	<c:when test="${ param.type eq 'c' }">
		<c:set  value="page_c.jsp" var="url"/>
	</c:when>
	<c:otherwise>
		다른값이 들어오면 a페이지로 보내도록 처리
		<c:set  value="page_a.jsp" var="url"/>
	</c:otherwise>
</c:choose>

<jsp:forward page="${ url }"/>

--%>