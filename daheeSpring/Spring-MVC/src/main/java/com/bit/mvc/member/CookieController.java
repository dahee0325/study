package com.bit.mvc.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/makeForm")
	public String getMakeForm() {
		
		return "cookie/makeForm";
		
	}
	
	@RequestMapping("/cookie/makeCookie")
	//응답처리를 위한 response 정의
	public String makeCookie(@RequestParam(value = "cName", defaultValue = "none") String cookieName, @RequestParam(value = "cValue", defaultValue = "none") String cookieValue, HttpServletResponse response) {
		
		//쿠키생성
		Cookie c = new Cookie(cookieName, cookieValue);
		
		//response를 통해 쿠키전송 (응답하면서 쿠키가 전송됨)
		response.addCookie(c);
		
		return "cookie/mekeCookie";
	}
	
	
	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.GET)
	public String selectCookie() {
		return "cookie/selectForm";
	}
	
	//@CookieValue : cookie1 의 정보를 가져올수있음
	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.POST)
	public String viewCookie(@CookieValue(value = "cookie1", defaultValue = "none") String cValue,@RequestParam(value = "cName", required = false) String cName, HttpServletRequest request, Model model) {
		
		//쿠키 정보를 가져와 배열에 넣음
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
			//사용자가 검색하고싶은 쿠키이름이 같은 쿠키가 있는지 확인
			if(cookies[i].getName().equals(cName)) {
				model.addAttribute("cName",cName);
				model.addAttribute("cValue", cookies[i].getValue());
			}
		}
		
		//쿠키이름이 cookie1 인 쿠키의 정보를 넣음
		//model.addAttribute("cName", "cookie1");
		//model.addAttribute("cValue", cValue);
		
		return "cookie/viewCookie";
	}
	
}
