<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requst 테스트 폼</title>
<link href="css/requst_css.css" rel="stylesheet" type="text/css">
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<div>
			<h1>requst 테스트 폼</h1>
			<hr>
		</div>
		<div>
			<form action="requst_test.jsp" method="post">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name="uName"></td>
					</tr>
					<tr>
						<td>직업</td>
						<td>
							<select name="jobs">
									<option value="default">선택하세요</option>
									<option value="프로그래머">프로그래머</option>
									<option value="퍼블리셔">퍼블리셔</option>
									<option value="그래픽디자이너">그래픽디자이너</option>
									<option value="테스터">테스터</option>
									<option value="학생">학생</option>
									<option value="직장인">직장인</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>관심분야</td>
						<td id="ch">
							<input type="checkbox" name="check" value="JAVA">JAVA<br>
							<input type="checkbox" name="check" value="HTML5">HTML5<br>
							<input type="checkbox" name="check" value="CSS">CSS<br>
							<input type="checkbox" name="check" value="jQuery">jQuery
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="확인">
							<input type="reset" value="취소"></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>