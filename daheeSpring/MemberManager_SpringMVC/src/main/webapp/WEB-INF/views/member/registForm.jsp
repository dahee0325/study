<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberManager : 회원가입</title>
<link href="<c:url value="/css/index.css"/>" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
$(document).ready(function () {

		$('#idbox').focusout(function() {
        		
        		$('#idchkMsg').html("");
        		
        		$.ajax({
                    url: 'idCheck2',
                    type: 'GET',
                    data: {
                        id: $('#idbox').val()
                    },
                    success: function (data) {
                    	if(data=='Y') {
                    		$('#idchkMsg').html('사용가능한 아이디입니다.');
                    		$('#idchkMsg').css('color','green');
                    	}else if(data== 'N') {
                    		$('#idchkMsg').html('사용할수없는 아이디입니다.');
                    		$('#idchkMsg').css('color','red');
                    	}else {
                    		$('#idchkMsg').html('필수사항입니다.');
                    		$('#idchkMsg').css('color','red');
                    	}
                    }
                });
        	});
});
    </script>
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
			<h3>회원가입</h3>
			<hr>
			<form method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>아 이 디</td>
						<td><input id="idbox" type="text" name="userId" required>
						<h6 id="idchkMsg"></h6></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userPw" required></td>
					</tr>
					<tr>
						<td>이    름</td>
						<td><input type="text" name="userName" required></td>
					</tr>
					<tr>
						<td>사    진</td>
						<td><input type="file" name="userPhoto"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="회원가입">
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