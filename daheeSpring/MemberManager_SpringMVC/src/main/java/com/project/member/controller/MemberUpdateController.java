package com.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberUpdateController {
	
	@RequestMapping("/member/update")
	public String getForm() {
		return "member/memberUpdateForm";
	}
	
}
