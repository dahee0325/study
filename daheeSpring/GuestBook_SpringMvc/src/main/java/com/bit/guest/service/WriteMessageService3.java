package com.bit.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageDao;
import com.bit.guest.dao.MessageJdbcTemplateDao;
import com.bit.guest.dao.MessageSessionTemplateDao;
import com.bit.guest.model.Message;

//서비스 빈 등록
@Service("writeService3")
public class WriteMessageService3 {
	
	@Autowired
	private MessageSessionTemplateDao dao;

	public int write(Message message) {
				
		return dao.insert(message);
	}

}
