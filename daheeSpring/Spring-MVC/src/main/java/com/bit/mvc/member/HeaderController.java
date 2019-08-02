package com.bit.mvc.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HeaderController {
	
	//header 정보를 가져올수있음 (ex) http://localhost:8080/mvc/ 에서 링크를 누르면 경로를 출력가능하다)
	@RequestMapping("/header/getHeader")
	public String getHeader(@RequestHeader("referer") String referer, Model model) {
		
		System.out.println(referer);
		
		model.addAttribute("referer", referer);
		
		return "header/header";
		
	}
}
