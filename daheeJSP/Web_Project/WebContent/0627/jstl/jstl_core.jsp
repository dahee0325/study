<%@page import="java.util.ArrayList"%>
<%@page import="web.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 라이브러리 쓰기위한 정의★★ --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Member> list = new ArrayList<Member>();
	
	list.add(new Member("홍길동1","hong1","010-0000-0000"));
	list.add(new Member("홍길동2","hong2", null));
	list.add(new Member("홍길동3","hong3","010-0000-0000"));
	list.add(new Member("홍길동4","hong4","010-0000-0000"));
	list.add(new Member("홍길동5","hong5", null));
	list.add(new Member("홍길동6","hong6", null));
	list.add(new Member("홍길동7","hong7","010-0000-0000"));
	list.add(new Member("홍길동8","hong8","010-0000-0000"));
	
	application.setAttribute("members", list);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.nopnum {
		color: red;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h3>
		<%-- value값 속성을 통해서 tiger를 출력 --%>
		<c:out value="tiger" /><br>
		
		<%-- value값에 el이 들어올수있는데 el에 값이 안들어오면 표현이 안되기때문에
	 		  default를 통해서 값이 안들어왔을때 기본값을 설정해준다. --%>
		<c:out value="${param.code1}" default="A" />
		
		<%-- c:out 단일태그가아니라 사이에 값을 넣어주면 default값을 설정가능하다--%>
		<%--  escapeXml : 기본값이 true인데 true로 되어있으면 태그 사이의 값이 문자(text)로만 취급하게한다.--%>
		<%-- false면 html 태그도 인식가능해진다. --%>
		<c:out value="${param.code2}" escapeXml="false">
			<span style="color: red">B</span>
		</c:out>
	</h3>
	<hr>
	<table>
		<tr>
			<td>index/count</td>
			<td>이름</td>
			<td>아이디</td>
			<td>전화번호</td>
		</tr>
	<%-- forEach안에 들어간 요소를 반복 --%>
	<%-- 반복해야하는 원본★ 필수요소 : items="${ members }" --%>
	<%-- var="member" : Member객체 하나하나 요소들의 변수명--%>
	<c:forEach items="${ members }" var="member" varStatus="status" begin="0" end="5">
		<tr>
			<td> ${status.index} / ${ status.count }</td>
			<td>${ member.name}</td>
			<td>${ member.id}</td>
			<td>
				<c:out value="${ member.pNum}" escapeXml="false">
					<span class="nopnum">전화번호없음</span>
				</c:out>
			</td>
		</tr>
	</c:forEach>
	</table>
	
	<hr>
	
	<%-- ,를 기준으로 자름 --%>
	<c:forTokens items="홍길동,010-8888-6666, 서울" delims="," var="sel">
		${sel}<br>
	</c:forTokens>
	
	<hr>
	
	<%-- msg라는 이름으로 test값을 넣어서 pagecontext속성에 저장 scope 지정을안하면 default가 page  --%>	
	<c:set value="test" var="msg" />
	msg : ${ msg } <br>
	
	<%-- test에 있는 값이 true가 나온다면 if사이의 영역이 출력된다. --%>
	<c:if test="${msg eq 'test'}">
		msg의 문자열은 test와 같습니다.
	</c:if>
	<c:if test="${ msg eq 'test'}" var="condition"/><br>
	
	결과값은 : ${ condition }
	
	<hr>
	
	<%-- url 사이에 param이라고 정의하고 pno이름으로 5값을 넣으면 url경로에 pno=5 값이 들어간다.--%>
	<%-- http://localhost:8080/web/0619/member/list.jsp?pno=5 --%>
	<c:url value="/0619/member/list.jsp" var="uri_mList">
		<c:param name="pno">5</c:param>
	</c:url>
	<h3>
		단순 출력 ${ uri_mList }<br>
	     링크 연동1 : <a href="${ uri_mList }">회원 리스트</a><br>
	     <%-- 단일태그로 사용하면 단순출력 --%>
	     링크 연동2 : <a href="<c:url value='/0619/member/list.jsp'/>">회원 리스트</a><br>
	</h3>
</body>
</html>