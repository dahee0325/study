package com.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService deleteService;
	
	@RequestMapping("/member/delete")
	public String delete(
			@RequestParam("memberId") int id
			) {
		
		deleteService.memberDelete(id);
		
		return "redirect:/member/memberList";
	}

}

