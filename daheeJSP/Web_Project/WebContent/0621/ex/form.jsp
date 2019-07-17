<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action_forward / response sendRedirect</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

<h1>action_forward / response sendRedirect 비교</h1>
<form action="action_forward.jsp">
	<%--데이터받아서 전송 name값에 아무것도 안넣었을때 null값이 아닌 공백이 들어가기 때문에 문자길이 계산으로도 유효성검사를 해줘야한다.--%>
	forward action <input type="text" name="name" > <input type="submit" value="전송">
</form>
<form action="response_sendRedirect.jsp">
	<%--데이터받아서 전송 --%>
	response sendRedirect <input type="text" name="name" > <input type="submit" value="전송">
</form>

</body>
</html>