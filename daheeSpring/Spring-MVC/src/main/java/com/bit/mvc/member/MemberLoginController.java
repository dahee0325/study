package com.bit.mvc.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/memberLogin")
public class MemberLoginController {

	//요청이 들어왔을때 컨트롤러 안에서 구별
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "member/loginForm2";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	//스프링에서 제공하는 Model : 객체를 저장해주는 역할을 함
	public String login(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("uId");
		String pw = request.getParameter("uPw");
		
		System.out.println(id + " : " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/login";
	}
	
}
