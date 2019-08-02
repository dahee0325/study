<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		
		width: 400px;
		border: solid 1px #DDD;
		border-radius: 20px;
		padding: 15px;
		
	}
	
	input {
		background-color: transparent;
		border: solid 1px;
		margin-bottom: 15px;
	}
	
	input[type="text"] {
		border:0;
		border-bottom: solid 1px;
	}
	
	input[type="file"] {
		border:0;
	}
	
	input[type="submit"] {
		width: 100%;
		padding: 5px;
	}
	
	hr {
		margin: 50px 0;
	}
	
</style>
</head>
<body>
	<h2>@RequestParm 이용한 파일 처리</h2>
	
	<form action="upload1" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sno"><br>
		레포트 파일 : <input type="file" name="report"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	<h2>MultipartHttpServletRequest 이용한 파일 처리</h2>
	<form action="upload2" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sno"><br>
		레포트 파일 : <input type="file" name="report"><br>
		<input type="submit" value="전송">
	</form>
	<hr>
	<h2>Command 객체 이용한 파일 처리</h2>
	<form action="upload3" method="post" enctype="multipart/form-data">
		학번 : <input type="text" name="sno"><br>
		레포트 파일 : <input type="file" name="report"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>