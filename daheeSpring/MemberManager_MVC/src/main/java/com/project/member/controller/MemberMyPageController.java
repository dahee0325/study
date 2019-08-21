package com.project.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMyPageController {

	@RequestMapping("/member/mypage")
	public String mypage(HttpSession session) {
		String view = "member/mypage";
		
		if(session == null || session.getAttribute("loginInfo") == null) {
			view = "redirect:/member/login";
		}
		
		return view;
	}
	
	
	//interceptor 사용 ( logincheck )
	@RequestMapping("/member/mypage/mypage")
	public String mypage2(HttpSession session) {
		
		return "member/mypage";
	}
}
