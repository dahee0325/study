<%@page import="dateShare.service.message.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="message" class="dateShare.Model.Message" />
<jsp:setProperty property="*" name="message" />
<%
	WriteMessageService mService = WriteMessageService.getInstance();
	int cnt = mService.write(message);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DATE SHARE : MESSAGE</title>
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>
		<%= cnt > 0 ? cnt + "개의 메세지를 보냈습니다." : "메세지 전송에 실패하였습니다." %>
	</h1>
</body>
</html>