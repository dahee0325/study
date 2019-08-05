package com.bit.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.guest.model.MessageListView;
import com.bit.guest.model.RequestGuestWrite;
import com.bit.guest.service.GetMessageListService;
import com.bit.guest.service.WriteMessageService;

@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService getMessageListService;
	
	@RequestMapping("/guest/list")
	public String getList(@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		
		MessageListView listView = getMessageListService.getMessageList(pageNum);
		model.addAttribute("viewData", listView);
		
		
		return "guest/list";
	}
		
}
