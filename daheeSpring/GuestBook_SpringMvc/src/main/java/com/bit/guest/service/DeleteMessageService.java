package com.bit.guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageDao;
import com.bit.guest.excrption.InvalidMessagePasswordException;
import com.bit.guest.excrption.MessageNotFoundException;
import com.bit.guest.jdbc.ConnectionProvider;
import com.bit.guest.jdbc.JdbcUtil;
import com.bit.guest.model.Message;

@Service("deleteService")
public class DeleteMessageService implements GuestBookService {
	
	@Autowired
	private MessageDao dao;
	
	public int deleteMessage(int messageId, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
		int resultCnt = 0;

		Connection conn = null;

		try {
			// 메서드를 통해 connection 생성
			conn = ConnectionProvider.getConnection();

			// 트렌젝션 처리
			conn.setAutoCommit(false);

			Message message = dao.select(conn, messageId);

			if (message == null) {
				throw new MessageNotFoundException(messageId + "번의 메세지가 존재하지 않습니다.");
			}

			if (!message.hasPassword()) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}

			if (!message.matchPassword(password)) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}

			resultCnt = dao.deleteMessage(conn, messageId);

			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (MessageNotFoundException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (InvalidMessagePasswordException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		}

		return resultCnt;
	}
}
