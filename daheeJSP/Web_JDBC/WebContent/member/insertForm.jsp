<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>사원정보 추가</h1>
	<hr>
	
	<form action="insertEmp.jsp" method="post">
		사원번호 <input type="number" name="empno" required> <br>
		사원이름 <input type="text" name="ename" required> <br>
		사원직급 <input type="text" name="job" required> <br>
		매니저 <input type="text" name="mgr"> <br>
		급여 <input type="number" name="sal" required> <br>
		부서번호 <input type="number" name="deptno" required> <br>
		<input type="submit" value="추가">
	</form>
</body>
</html>