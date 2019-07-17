package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample_insert {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		
		try {
			//1. 데이터베이스 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 데이터베이스 연결 : DBurl , user name, user password
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("오라클 데이터베이스에 접속했습니다.\n");
			
			//3. Statement 객체 생성
			Statement stmt = conn.createStatement();
			
			//insert 구문
			String sqlInsert = "insert into dept values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "MARKETING");
			pstmt.setString(3, "JEJU");
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
				System.out.println(resultCnt + "행이 삽입되었습니다.\n");
			}
			
			
			//4. SQL 실행 : select / insert / update / delete
			String sql1 = "select * from dept order by deptno";
			
			// executeQuery : ResultSet 반환해줌
			ResultSet rs = stmt.executeQuery(sql1);
			
			//5. 결과 출력
			System.out.println("----------------------dept Table------------------------");
			
			//next() 읽어올수있는 행이있는지 확인하여 가져옴
			while(rs.next()) {
				//colunm 이름으로 출력
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				//colunm 순서로 가져와서 출력
				System.out.println("부서이름 : " + rs.getString(2));
				System.out.println("부서위치 : " + rs.getString(3));
				System.out.println("--------------------------------------------------------");
			}
			
			//6. 사용 객체 close : ResultSet , Statement, Connection 순으로 끝내면됨
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
