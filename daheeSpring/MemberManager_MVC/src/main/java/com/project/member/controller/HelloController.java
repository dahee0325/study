package com.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.member.domain.MemberInfo;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String page() {
		
		MemberInfo info = null;
		
		System.out.println(info.getIdx());
		
		return "main";
	}
	
	//이 컨트롤러에서 nullpoint 오류가 뜬다면 특정 페이지로 이동
	@ExceptionHandler(NullPointerException.class)
	public String handlerNullPointException(NullPointerException e) {
		
		return "error/nullException";
		
	}
}
