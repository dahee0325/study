<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 정보수정</title>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<%-- header 끝 --%>
		
		<%-- nav 시작 --%>
		<%@ include file="/WEB-INF/views/frame//nav.jsp"%>
		<%-- nav 끝 --%>

		<%-- contents 시작 --%>
		<div id="contents">
			<h3>내 정보수정</h3>
			<hr>
			<form method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>아 이 디</td>
						<td><input type="hidden" name="idx" value="${ editData.idx }">${ editData.userId }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="uPW" required></td>
					</tr>
					<tr>
						<td>이    름</td>
						<td><input type="text" name="uName" value="${editData.userName }" required></td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><input type="text" name="oldFile" value="${editData.userPhoto}" readonly>
						<input type="file" name="uPhoto"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="수정">
						<a id="home_a" href="<c:url value="/main"/>">홈으로</a></td>
					</tr>
				</table>
			</form>
		</div>
		<%-- contents 끝 --%>

		<%-- footer 시작 --%>
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<%-- footer 끝 --%>
	</div>
</body>
</html>