package com.project.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.member.service.MemberLoginService;
import com.project.member.service.MemberLoginService2;
import com.project.member.service.MemberLoginService3;
import com.project.member.service.MemberLoginService4;

@Controller
@RequestMapping("/member/login")
public class LoginController {

	@Autowired
	private MemberLoginService4 loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {

		String view = "member/loginForm";

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("loginInfo") != null) {
			view = "redirect:/main";
		}

		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("userId") String id, @RequestParam("userPw") String pw, HttpServletRequest request) {

		String view = "member/loginfail";

		// 2019.08.21
		// 서비스 로그인 처리 후 반환 타입 변경
		int loginChk = loginService.login(id, pw, request);

		switch (loginChk) {
			case 1:
				// 새로운 view(jsp) 추가
				view = "member/notVerify";	
				break;
			case 2:
				view = "redirect:/main";
				break;
		}

		return view;

	}
}
