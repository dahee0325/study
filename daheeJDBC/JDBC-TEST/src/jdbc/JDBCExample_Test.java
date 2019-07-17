package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample_Test {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("오라클 데이터베이스에 접속했습니다.\n");
			
			Statement stmt = conn.createStatement();
			
			//1. emp 테이블에 새로운 사원정보를 입력하는 프로그램
			String sqlInsert = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, 7777);
			pstmt.setString(2, "DAHEE");
			pstmt.setString(3, "MANAGER");
			pstmt.setInt(4, 7839);
			pstmt.setString(5, "97/03/25");
			pstmt.setInt(6, 5000);
			pstmt.setInt(7, 2000);
			pstmt.setInt(8, 10);
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
				System.out.println(resultCnt + "행이 삽입되었습니다.\n");
			}
			
			
			//2. emp 테이블의 모든 데이터를 출력
			String sql1 = "select * from emp";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			System.out.println("---------------------- emp Table ------------------------");

			while(rs.next()) {
				System.out.println("EMPNO : " + rs.getInt("empno"));
				System.out.println("ENAME : " + rs.getString(2));
				System.out.println("JOB : " + rs.getString("job"));
				System.out.println("MGR : " + rs.getInt(4));
				System.out.println("HIREDATE : " + rs.getDate("hiredate"));
				System.out.println("SAL : " + rs.getInt(6));
				System.out.println("COMM : " + rs.getInt("comm"));
				System.out.println("DEPTNO : " + rs.getInt("deptno"));
				System.out.println("--------------------------------------------------------");
			}
			
			//3. emp 테이블에서 "SCOTT" 사원의 급여(sal) 정보를 1000으로 변경
			String sqlUpdate = "update emp set sal = 1000 where ename='SCOTT'";
			
			rs = stmt.executeQuery(sqlUpdate);
			System.out.println("\n수정되었습니다.\n");
			
			
			//4.emp 테이블에서 "SCOTT" 이름으로 검색한 결과를 출력
			String sql2 = "select * from emp where ename='SCOTT'";
			rs = stmt.executeQuery(sql2);
			
			System.out.println("--------------------- SCOTT 출력 -----------------------");

			while(rs.next()) {
				System.out.println("EMPNO : " + rs.getInt("empno"));
				System.out.println("ENAME : " + rs.getString(2));
				System.out.println("JOB : " + rs.getString("job"));
				System.out.println("MGR : " + rs.getInt(4));
				System.out.println("HIREDATE : " + rs.getDate("hiredate"));
				System.out.println("SAL : " + rs.getInt(6));
				System.out.println("COMM : " + rs.getInt("comm"));
				System.out.println("DEPTNO : " + rs.getInt("deptno"));
				System.out.println("-------------------------------------------------------");
			}
			
			
			//5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성
			String sql3 = "select * from emp join dept using (deptno)";
			rs = stmt.executeQuery(sql3);
			
			System.out.println("----------------------- 출력 ---------------------------");

			while(rs.next()) {
				System.out.println("DEPTNO : " + rs.getInt("DEPTNO"));
				System.out.println("EMPNO : " + rs.getInt("EMPNO"));
				System.out.println("ENAME : " + rs.getString("ENAME"));
				System.out.println("JOB : " + rs.getString("JOB"));
				System.out.println("MGR : " + rs.getInt("MGR"));
				System.out.println("HIREDATE : " + rs.getDate("HIREDATE"));
				System.out.println("SAL : " + rs.getInt("SAL"));
				System.out.println("COMM : " + rs.getInt("COMM"));
				System.out.println("DNAME : " + rs.getString("DNAME"));
				System.out.println("LOC : " + rs.getString("LOC"));
				System.out.println("-------------------------------------------------------");
			}
			
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
