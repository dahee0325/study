<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 회원가입</title>
<link href="<c:url value='/css/index.css'/>" rel="stylesheet" type="text/css">
<script>
	var chk = ${resultCnt};
	
	if(chk != 1) {
		alert("회원가입에 실패하였습니다.");
		history.go(-1);
	}
</script>
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="../frame/header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="../frame/nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>회원가입</h3>
			<hr>
			
			${ requestMemberRegist.userName } ( ${ requestMemberRegist.userId } ) 님 회원가입되었습니다.
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="../frame/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</body>
</html>