package com.bit.guest.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bit.guest.model.Message;

//빈으로 등록
@Repository("SessionDao")
public class MessageSessionTemplateDao {

	// mapper 를 찾아서 해당 sql 을 사용해야함
	@Autowired
	private SqlSessionTemplate template;

	// guestMapper.xml 에서 정의한 namespace
	private String nameSpace = "com.bit.guest.mapper.mybatis.guestMapper";

	// 컨넥션을 따로 받지 않음
	// 오버로딩
	public int insert(Message message) {

		int rCnt = template.update(nameSpace + ".inserMessage", message);

		return rCnt;
	}

	public int selectCount() {

		return template.selectOne(nameSpace + ".selectCount");
	}

	public List<Message> selectList(Map<String, Object> params) {

		return template.selectList(nameSpace + ".selectList", params);
	}

	public Message select(int messageId) {

		return template.selectOne(nameSpace+".select", messageId);
	}

	public int deleteMessage(int messageId) {

		return template.update(nameSpace+".deleteMesaage", messageId);
	}

}
