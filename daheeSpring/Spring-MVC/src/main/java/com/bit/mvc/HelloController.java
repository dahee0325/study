package com.bit.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 파일에 어노테이션 @Controller 지정
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		//FrontControllter 전송할 View 경로와 결과 데이터 저장하고 전달할 객체 -> ModelAndView
		//ModelAndView 스프링 프레임워크에서 제공
		//View 페이지에 전달해야되는 데이터를 저장하여 전달
		//defalut 생성자를 통해 setter 로 처리
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");// /WEB-INF/views/hello.jsp
		modelAndView.addObject("userName", "Cool");
		modelAndView.addObject("greeting", "하이여");
		modelAndView.addObject("now", new Date());
		
		return modelAndView;
		
	}
}
