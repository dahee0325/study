package com.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.member.service.MemberRegService2;
import com.project.member.service.MemberRegService3;

@Controller
public class MemberIdCheckController {

	@Autowired
	private MemberRegService3 registService;
	
	@RequestMapping("/member/idCheck1")
	public String idCheck1(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("result",registService.idCheck(id));
		
		return "member/idCheck";
	}
	
	@RequestMapping("/member/idCheck2")
	@ResponseBody
	public String idCheck1(@RequestParam("id") String id) {

		return registService.idCheck1(id);
	}
	
}
