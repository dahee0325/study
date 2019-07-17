<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requst 테스트 정보확인 폼</title>
<link href="css/requst_css.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<div>
			<h1>requst 테스트 정보확인 폼</h1>
			<hr>
		</div>
		<div>
			<table>
				<tr>
					<td>이름</td>
					<td><%=request.getParameter("uName")%></td>
				</tr>
				<tr>
					<td>직업</td>
					<td>
						<%
							String[] userJob = request.getParameterValues("jobs");

							if (userJob != null && userJob.length > 0) {

								for (int j = 0; j < userJob.length; j++) {
									out.print(userJob[j] + "\t");
								}
							}
						%>

					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%
							String[] userCh = request.getParameterValues("check");

							if (userCh != null && userCh.length > 0) {

								for (int i = 0; i < userCh.length; i++) {
										out.print(userCh[i] + "\t");								
								}
							}
						%>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="requst_project.jsp">되돌아가기</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>