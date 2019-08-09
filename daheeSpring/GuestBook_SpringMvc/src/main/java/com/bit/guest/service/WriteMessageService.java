package com.bit.guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageDao;
import com.bit.guest.dao.MessageJdbcTemplateDao;
import com.bit.guest.jdbc.ConnectionProvider;
import com.bit.guest.model.Message;

//서비스 빈 등록
@Service("writeService")
public class WriteMessageService {
	
	//Dao를 빈으로 등록후에 타입이 불러와 주입해줌
	@Autowired
	private MessageDao dao;

	public int write(Message message) {
				
		Connection conn = null;
		
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			//4. insert 메서드 실행
			resultCnt = dao.insert(conn, message);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultCnt;
	}

}
