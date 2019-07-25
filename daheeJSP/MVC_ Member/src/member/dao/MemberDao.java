package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	//인스턴스 생성
	private static MemberDao dao = new MemberDao();
	
	//외부에서 dao 객체를 가져갈수있도록 처리 : 싱글톤
	public static MemberDao getInstance() {
		return dao;
	}
	
	private MemberDao() {}
	
	public int insert(Connection conn, Member member) {
		int rCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into userInfo values (userInfo_seq.nextval,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rCnt;
		
	}
	
	public Member login(Connection conn, String userId) {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select userNum, userId,userPw,userName,userRegDate from userInfo where userId=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setUserNum(rs.getInt(1));
				member.setUserId(rs.getString(2));
				member.setUserPw(rs.getString(3));
				member.setUserName(rs.getString(4));
				member.setUserRegDate(rs.getDate(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}
	
}
