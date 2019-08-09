package com.project.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jdbc.ConnectionProvider;
import com.project.member.dao.MemberDao;

@Service("deleteService")
public class MemberDeleteService {

	@Autowired
	private MemberDao dao;
	
	public int memberDelete(int id) {
		
		int rCnt = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			rCnt = dao.memberDelete(conn, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rCnt;
	}

}