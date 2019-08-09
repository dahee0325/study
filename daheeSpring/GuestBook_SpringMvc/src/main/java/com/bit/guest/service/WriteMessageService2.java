package com.bit.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageDao;
import com.bit.guest.dao.MessageJdbcTemplateDao;
import com.bit.guest.model.Message;

//서비스 빈 등록
@Service("writeService2")
public class WriteMessageService2 {
	
	@Autowired
	private MessageJdbcTemplateDao templateDao;

	public int write(Message message) {
				
		return templateDao.insert(message);
	}

}
