package com.bit.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.guest.model.MessageListView;
import com.bit.guest.service.GetMessageListService2;
import com.bit.guest.service.GetMessageListService3;
import com.bit.guest.service.GetMessageListService4;


@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService4 getMessageListService;
	
	@RequestMapping("/guest/list")
	public String getList(@RequestParam(value = "page", defaultValue = "1") int pageNum, Model model) {
		
		MessageListView listView = getMessageListService.getMessageList(pageNum);
		model.addAttribute("viewData", listView);
		
		return "guest/list";
	}
	
	@RequestMapping("/guest/listJson")
	@ResponseBody
	public MessageListView getListJson(@RequestParam(value = "page", defaultValue = "1") int pageNumber,Model model) {
		
		MessageListView listView = getMessageListService.getMessageList(pageNumber);
		
		return listView;
	}
}
