package com.bit.guest.service;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.guest.dao.MessageJdbcTemplateDao;
import com.bit.guest.dao.MessageSessionTemplateDao;
import com.bit.guest.model.Message;
import com.bit.guest.model.MessageListView;

@Service("getMessageListService3")
public class GetMessageListService3 {

	@Autowired
	private MessageSessionTemplateDao dao;

	// 1. 한페이지에 보여줄 게시글의 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) {

		// 2. 현재 페이지 번호
		int currentPageNumber = pageNumber;

		MessageListView view = null;

		// 전체 게시물의 개수
		int messageTotalCount = dao.selectCount();

		// 게시물 내용 리스트, DB 검색에 사용할 start_row, end_row 구하기
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;

		if (messageTotalCount > 0) {
			// 있다면
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("firstRow", firstRow);
			params.put("endRow", endRow);
			messageList = dao.selectList(params);

		}else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		
		view = new MessageListView(messageTotalCount, currentPageNumber, messageList, MESSAGE_COUNT_PER_PAGE,firstRow, endRow);
		
		return view;
	}
}

