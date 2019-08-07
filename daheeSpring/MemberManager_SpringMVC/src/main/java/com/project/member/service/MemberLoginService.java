package com.project.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jdbc.ConnectionProvider;
import com.project.member.dao.MemberDao;
import com.project.member.domain.MemberInfo;

@Service("loginService")
public class MemberLoginService {

	@Autowired
	private MemberDao dao;
	
	public boolean login(String id, String pw, HttpServletRequest request) {
		
		boolean loginChk = false;
		MemberInfo memberInfo = null;
		Connection conn = null ;
		
		try {
			
			conn=ConnectionProvider.getConnection();
			
			memberInfo = dao.selectMemberById(conn, id);
			
			if(memberInfo != null && memberInfo.pwChk(pw)) {
				//세션에 저장
				//세션이 없으면 새로운 세션을 생성(null이 들어간다면 오류발생)
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo()); 
				//loginchk 상태값을 변경
				loginChk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return loginChk;
	}

}



