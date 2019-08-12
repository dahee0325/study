package com.bit.guest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageDao;
import com.bit.guest.dao.MessageJdbcTemplateDao;
import com.bit.guest.dao.MessageSessionDao;
import com.bit.guest.dao.MessageSessionTemplateDao;
import com.bit.guest.model.Message;

//서비스 빈 등록
@Service("writeService4")
public class WriteMessageService4 {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao dao;

	public int write(Message message) {
		
		dao = template.getMapper(MessageSessionDao.class);
		
		return dao.insert(message);
	}

}
