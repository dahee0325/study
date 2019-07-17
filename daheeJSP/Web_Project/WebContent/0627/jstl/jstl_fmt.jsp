<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:set var="price" value="100000" />
	<c:set var="pi" value="3.141592"/>
	<%-- 위에 정의한 price를 number타입으로 numberType이름으로 저장 --%>
	<%-- groupingUsed="false" : , 표현을 안한다는뜻 default값은 true --%>
	<fmt:formatNumber value="${price}" type="number" var="numberType"/>
	현재 숫자 : ${ numberType }<br>
	
	<%-- var 지정하지않으면 출력 --%>
	<%-- currencySymbol="\\" : 숫자앞에 문구를 표현해줌 (ex) 원 등등)--%>
	통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"/><br>
	% 표현 : <fmt:formatNumber value="${price}" type="percent" groupingUsed="false" /><br>
	% 표현 : <fmt:formatNumber value="${pi}" type="percent" groupingUsed="false" /><br>
	<%-- pattern : 자리수를 표현 특정자리수에 특정형태로 표현하고싶을때 사용--%>
	패턴표현 : <fmt:formatNumber value="${price}" pattern="00,000,000.00"/><br>
	패턴표현 : <fmt:formatNumber value="${pi}" pattern="00000000.00"/><br>
</h3>
<hr>
<h3>
	<%-- 날짜와 시간 표현 --%>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/> /
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="full"/> /
	<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
	<%-- 날짜 시간 둘다 표현 --%>
	<fmt:formatDate value="${now}" type="both" /><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /> /
	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
	<%-- 패턴을 지정하여 표헌 z: 나라 / a:AM, PM / hh:시간(대문자로하면 24시로 표현됨) --%>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss" /><br>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a h:mm" /><br>
	
	<%-- timeZone 안에 있는 시간들은 hongkong시간으로 표현됨 --%>
	<fmt:timeZone value="Hongkong">
		홍콩 : <fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss" /><br>
	</fmt:timeZone>
	<fmt:timeZone value="New_York">
		뉴욕 : <fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss" /><br>
	</fmt:timeZone>
	<br>
	<%-- value에 넣을 정의된 나라명들 출력 --%>
	<c:forEach var="id" items="<%=java.util.TimeZone.getAvailableIDs()%>">${id}<br />
	</c:forEach>
</h3>
</body>
</html>