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

import com.project.jdbc.JdbcUtil;
import com.project.member.domain.MemberInfo;
import com.project.member.domain.SearchParam;

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

	public int selectTotalCount(Connection conn, SearchParam searchParam) {

		int totalCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from userInfo";

		if (searchParam != null) {
			sql = "select count(*) from userInfo where ";
			if (searchParam.getStype().equals("both")) {
				sql += " uid like '%" + searchParam.getKeyword() + "%' or uname  like '%" + searchParam.getKeyword()
						+ "%' ";
			}
			if (searchParam.getStype().equals("id")) {
				sql += " uid  like '%" + searchParam.getKeyword() + "%'";
			}
			if (searchParam.getStype().equals("name")) {
				sql += " uname  like '%" + searchParam.getKeyword() + "%' ";
			}
		}

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

	public List<MemberInfo> selectListById(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM userInfo where uid like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);

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

	public List<MemberInfo> selectListByName(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM userInfo where uname like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);

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

	public List<MemberInfo> selectListByBoth(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM userInfo where uid like ? or  uname like ?  limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchParam.getKeyword() + "%");
			pstmt.setString(2, "%" + searchParam.getKeyword() + "%");
			pstmt.setInt(3, index);
			pstmt.setInt(4, count);

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

	public MemberInfo selectMemberByIdx(Connection conn, int id) {

		MemberInfo memberInfo = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from userInfo where idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				memberInfo = new MemberInfo(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"),
						rs.getString("uname"), rs.getString("uphoto"), new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return memberInfo;
	}

	public int memberUpdate(Connection conn, MemberInfo memberInfo) {

		System.out.println(">>>>>>>>>>>> " + memberInfo);
		int rCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update userInfo set uname=?, upw=?, uphoto=? where idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuserName());
			pstmt.setString(2, memberInfo.getuserPw());
			pstmt.setString(3, memberInfo.getuserPhoto());
			pstmt.setInt(4, memberInfo.getIdx());
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;
	}

	public int memberDelete(Connection conn, int id) {

		int rCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "delete from userInfo where idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;
	}
}
