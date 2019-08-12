package com.bit.guest.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.guest.dao.MessageSessionDao;
import com.bit.guest.excrption.InvalidMessagePasswordException;
import com.bit.guest.excrption.MessageNotFoundException;

import com.bit.guest.model.Message;

@Service("deleteService4")
public class DeleteMessageService4 {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao dao;
	
	@Transactional
	public int deleteMessage(int messageId, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
		
		int cnt = 0;
		
		// dao 생성
		dao = template.getMapper(MessageSessionDao.class);
		
		try {

			Message message = dao.select(messageId);
			
			if (message == null) {
				throw new MessageNotFoundException(messageId + "번의 메세지가 존재하지 않습니다.");
			}

			if (!message.hasPassword()) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}

			if (!message.matchPassword(password)) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}
			
			cnt = dao.deleteMessage(messageId);
			
		}catch(MessageNotFoundException e) {
			e.printStackTrace();
			throw e;
		}catch(InvalidMessagePasswordException e) {
			e.printStackTrace();
			throw e;
		}
		
		return cnt;
	}
}
