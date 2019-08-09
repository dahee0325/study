package com.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberJdbcTemplateDao;

@Service("deleteService2")
public class MemberDeleteService2 {

	@Autowired
	private MemberJdbcTemplateDao dao;
	
	public int memberDelete(int id) {

		return dao.memberDelete(id);
	}

}