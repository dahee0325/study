<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>방명록 글쓰기</h3>
	<hr>
	<form action="write" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="guestName"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea rows="3" cols="30" name="message"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>