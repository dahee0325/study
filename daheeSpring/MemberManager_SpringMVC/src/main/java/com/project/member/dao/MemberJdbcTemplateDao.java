package com.project.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.member.domain.MemberInfo;
import com.project.member.domain.SearchParam;

//이름 따로 지정안하면 memberDao 로 생성됨
@Repository("templateDao")
public class MemberJdbcTemplateDao {

	@Autowired
	JdbcTemplate template;

	public MemberInfo selectMemberById(String userId) {

		String sql = "select * from userInfo where uid=?";

		// 배열객체 생성하고 명시적으로 데이터를 지정 (? 에 들어갈 데이터를 지정)
		List<MemberInfo> list = template.query(sql, new Object[] { userId }, new MemberInfoRowMapper());

		return list.isEmpty() ? null : list.get(0);
	}

	public MemberInfo selectMemberById2(String userId) {

		String sql = "select * from userInfo where uid=?";

		MemberInfo memberInfo = null;
		
		// 배열객체 생성하고 명시적으로 데이터를 지정 (? 에 들어갈 데이터를 지정)
		//List<MemberInfo> list = template.query(sql, new Object[] { userId }, new MemberInfoRowMapper());
		
		try {
			memberInfo = template.queryForObject(sql, new Object[] { userId }, new MemberInfoRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	public int insertMember(MemberInfo memberInfo) {

		return template.update("insert into userInfo (uid, uname, upw, uphoto) values (?,?,?,?)",
				memberInfo.getuserId(), memberInfo.getuserName(), memberInfo.getuserPw(), memberInfo.getuserPhoto());
	}

	public List<MemberInfo> selectList(int index, int count) {

		String sql = "SELECT * FROM userInfo limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), index, count);
	}

	public int selectTotalCount(SearchParam searchParam) {

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

		return template.queryForObject(sql, Integer.class);
	}

	public List<MemberInfo> selectListById(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM userInfo where uid like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%",
				"%" + searchParam.getKeyword() + "%", index, count);
	}

	public List<MemberInfo> selectListByName(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM userInfo where uname like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%",
				"%" + searchParam.getKeyword() + "%", index, count);

	}

	public List<MemberInfo> selectListByBoth(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM userInfo where uid like ? or  uname like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%",
				"%" + searchParam.getKeyword() + "%", index, count);

	}

	public MemberInfo selectMemberByIdx(int id) {

		MemberInfo memberInfo = null;

		String sql = "select * from userInfo where idx=?";

		try {
			memberInfo = template.queryForObject(sql, new MemberInfoRowMapper(), id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return memberInfo;
	}

	public int memberUpdate(MemberInfo memberInfo) {

		String sql = "update userInfo set uname=?, upw=?, uphoto=? where idx=?";

		return template.update(sql, memberInfo.getuserName(), memberInfo.getuserPw(), memberInfo.getuserPhoto(),
				memberInfo.getIdx());
	}

	public int memberDelete(int id) {

		String sql = "delete from userInfo where idx=?";

		return template.update(sql, id);
	}
}
