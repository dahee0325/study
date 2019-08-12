package com.bit.guest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.guest.excrption.InvalidMessagePasswordException;
import com.bit.guest.excrption.MessageNotFoundException;
import com.bit.guest.service.DeleteMessageService;
import com.bit.guest.service.DeleteMessageService2;
import com.bit.guest.service.DeleteMessageService3;
import com.bit.guest.service.DeleteMessageService4;

@Controller
@RequestMapping("/guest/delete")
public class GuestDeleteController {
	
	@Autowired
	private DeleteMessageService4 deleteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm() {
		return "guest/deleteForm";
	}
	 
	@RequestMapping(method = RequestMethod.POST)
	public String getDelete(@RequestParam(value = "messageId") int messageId, @RequestParam(value = "password") String password, Model model) {
		
		boolean chk = false;
		int resultCnt = 0;
		String msg = "";
		
		try {
			resultCnt = deleteService.deleteMessage(messageId, password);
			chk = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		} catch (MessageNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidMessagePasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		model.addAttribute("resultCnt", resultCnt);
		model.addAttribute("chk",chk);
		model.addAttribute("msg",msg);
		
		return "guest/delete";
	}
}
