package com.project.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.member.domain.MemberInfo;

//이름 따로 지정안하면 memberDao 로 생성됨
@Repository("dao")
public class MemberDao {

	public MemberInfo selectMemberById(Connection conn, String userId) {

		MemberInfo memberInfo = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from userInfo where uid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				memberInfo = new MemberInfo(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"),
						rs.getString("uname"), rs.getString("uphoto"), rs.getDate("regDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			com.project.jdbc.JdbcUtil.close(rs);
			com.project.jdbc.JdbcUtil.close(pstmt);
		}

		return memberInfo;
	}

	public int insertMember(Connection conn, MemberInfo memberInfo) {

		PreparedStatement pstmt = null;

		int rCnt = 0;

		String sql = "insert into userInfo (uid, uname, upw, uphoto) values (?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuserId());
			pstmt.setString(2, memberInfo.getuserName());
			pstmt.setString(3, memberInfo.getuserPw());
			pstmt.setString(4, memberInfo.getuserPhoto());
			rCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;

	}

	public List<MemberInfo> selectList(Connection conn, int index, int count) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM userInfo limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"),
						rs.getString("uname"), rs.getString("uphoto"), new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public int selectTotalCount(Connection conn) {

		int totalCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from userInfo";

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCnt;
	}

}
