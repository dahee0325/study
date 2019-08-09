package com.bit.guest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bit.guest.model.Message;

public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//행 하나하나를 읽어서 가져와줌
		Message msg = new Message();
		msg.setId(rs.getInt(1));
		msg.setGuestName(rs.getString(2));
		msg.setPassword(rs.getString(3));
		msg.setMessage(rs.getString(4));
		
		return msg;
	}

}
