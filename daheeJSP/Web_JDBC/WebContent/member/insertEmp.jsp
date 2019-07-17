<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="info.MemberInfo" />
<jsp:setProperty property="*" name="member" />
<%
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String pw = "tiger";
	
	try{
	//1. 데이터베이스 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//2. 데이터베이스 연결
	conn = DriverManager.getConnection(url,user,pw);
	
	//3. PreparedStatement 생성
	String sql = "insert into emp values(?,?,?,?,sysdate,?,null,?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, member.getEmpno());
	pstmt.setString(2, member.getEname());
	pstmt.setString(3, member.getJob());
	pstmt.setString(4, member.getMgr());
	pstmt.setInt(5, member.getSal());
	pstmt.setInt(6, member.getDeptno());
	
	
	//4. SQL 실행
	resultCnt = pstmt.executeUpdate();
	
	//5. 실행결과 출력
	} catch(SQLException se) {
		
	} finally {
		//6. 객체 close
		if(pstmt != null){
			try{
				pstmt.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
%>
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
	<h1>사원 정보 추가</h1>
	<h3><%= resultCnt %> 개 행이 처리되었습니다.</h3>
	<%= member.toString() %>
	<a href="empList.jsp">리스트</a>
</body>
</html>