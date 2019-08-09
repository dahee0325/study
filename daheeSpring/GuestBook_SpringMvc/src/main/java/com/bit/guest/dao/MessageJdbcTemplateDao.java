package com.bit.guest.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bit.guest.model.Message;

//빈으로 등록
@Repository("jdbcTemplateDao")
public class MessageJdbcTemplateDao {
	
	//servlet-context 에 지정한 bean을 불러옴
	@Autowired
	JdbcTemplate template;
	
	//컨넥션을 따로 받지 않음
	//오버로딩
	public int insert(Message message) {
		
		String sql = "insert into guestbook_message (message_id, guest_name, password, message) values(gm_mid_seq.nextval,?,?,?)";
		
		//처리된 횟수를 반환해주는 update
		return template.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());
		
	}

	public int selectCount() {
		
		//integer타입으로 결과를 반환해옴 ( 하나의 행 결과)		
		return template.queryForObject("select count(*) from guestbook_message", Integer.class);
	}

	
	public List<Message> selectList(int firstRow, int endRow){
		
		String sql = "select message_id, guest_name, password, message from ( " + 
				"select rownum rnum, message_id, guest_name, password, message from (" + 
				"select * from guestbook_message m order by m.message_id desc" + 
				") where rownum <= ? ) where rnum >= ?";
		
		return template.query(sql, new MessageRowMapper(), endRow, firstRow);
	}

	public Message select(int messageId) {

		return template.queryForObject("select * from guestbook_message where message_id=?", new MessageRowMapper(), messageId);
	}
	
	public int deleteMessage(int messageId) {
		
		return template.update("delete from guestbook_message where message_id=?", messageId);
	}
	
}
