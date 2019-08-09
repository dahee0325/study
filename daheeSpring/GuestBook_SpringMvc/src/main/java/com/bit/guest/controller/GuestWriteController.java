package com.bit.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.guest.model.RequestGuestWrite;
import com.bit.guest.service.WriteMessageService;
import com.bit.guest.service.WriteMessageService2;

@Controller
public class GuestWriteController {
	
	@Autowired
	private WriteMessageService2 writeService;
	
	@RequestMapping("/guest/writeForm")
	public String getWriteForm() {
		
		return "guest/writeForm";
	}
	
	
	@RequestMapping(value = "/guest/write", method = RequestMethod.POST)
	public String write(RequestGuestWrite requestGuestWrite, Model model) {
		
		int cnt = writeService.write(requestGuestWrite.toMessage());
		
		model.addAttribute("resultCnt", cnt);
		
		return "guest/write";
	}
	
}
