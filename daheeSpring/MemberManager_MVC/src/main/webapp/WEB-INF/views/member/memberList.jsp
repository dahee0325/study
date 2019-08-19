<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 회원리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet"
	type="text/css">
<style>
table {
	border-collapse: collapse;
	border: 0;
}

td {
	padding: 5px 15px;
	border: 1px solid #999;
}

#pagingBox {
	overflow: hidden;
	margin-top: 20px;
	width: 400px;
	margin: auto;
}

#pagingBox a {
	display: inline-block;
	padding: 15px 5px;
	text-decoration: none;
	color: gray;
}

#pagingBox a:hover {
	color: black;
}

.searchBox input[type="text"]{
	width: 15%;
}

.searchBox input[type="submit"]{
	width: 10%;
	height: 25px;
	font-size: 13px;
}
</style>
</head>
<body>
	<div id="wrap">
		<%-- header 시작 --%>
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<%-- header 끝 --%>

		<%-- nav 시작 --%>
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<%-- nav 끝 --%>

		<!-- 컨텐츠 시작 -->
		<div id="contents">
			<h3>회원 리스트</h3>
			<hr>
			<div class="searchBox">
				<form>
					<select name="stype">
						<option value="both">아이디+이름</option>
						<option value="id">아이디</option>
						<option value="name">이름</option>
					</select>
					<input type="text" name="keyword">
					<input type="submit" value="검색">
				</form>

			</div>
			<table>
				<tr>
					<td>no</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>이름</td>
					<td>사진</td>
					<td>가입일</td>
					<td>관리</td>
				</tr>

				<c:forEach items="${viewData.memberList}" var="memberInfo" varStatus="stat">
					<tr>
						<td>
							<%-- ${memberInfo.idx} / ${stat.index} / ${stat.count} / ${viewData.totalCount} /  --%>${viewData.no-stat.index}</td>
						<td>${memberInfo.userId}</td>
						<td>${memberInfo.userPw}</td>
						<td>${memberInfo.userName}</td>
						<td><img src="<c:url value='/uploadfile/userphoto/${memberInfo.userPhoto}'/>" height="30"></td>
						<td><fmt:formatDate value="${memberInfo.regDate}" pattern="yyyy.MM.dd" /></td>
						<td><a href="edit?memberId=${memberInfo.idx}">수정</a>
						<a href="#" onclick="delMember(${memberInfo.idx})">삭제</a>
					</tr>
				</c:forEach>

			</table>
			<c:if test="${viewData.totalCount>0}">
				<div id="pagingBox">
					<c:forEach begin="1" end="${viewData.pageTotalCount}" var="num">
						<%-- <div><a href="memberList?p=${num}">${num}</a> </div> --%>
							<a href="memberList?p=${num}&stype=${param.stype}&keyword=${param.keyword}">${num}</a>
					</c:forEach>

				</div>
			</c:if>
		</div>
		<!-- 컨텐츠 끝 -->


		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
<script>
	function delMember(idx) {
		
		if(confirm("삭제하시겠습니까?")){
			location.href = 'delete/'+idx;
		}
		
	}
</script>
</html>