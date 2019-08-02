<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<h4>
		학번 : ${ sno } / ${ report.sno }<br>
		레포트이름 : ${ fileName } ( ${ fileSize }byte ) / ${ report.fileName } ( ${ report.fileSize }byte )
	</h4>
</body>
</html>