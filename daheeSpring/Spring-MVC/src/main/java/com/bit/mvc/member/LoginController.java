package com.bit.mvc.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.mvc.domain.Login;

@Controller
public class LoginController {
	
	//로그인 폼 페이지 요청
	@RequestMapping(value = "/member/login")
	public String getLoginForm() {
		
		//view 의 경로 : Resolver의 범위에 포함된 경로
		return "member/loginForm";
		// /WEB-INF/views/member/loginForm.jsp
	}
	
	
	//method = RequestMethod.POST : 전달되는 데이터의 형태를 post방식으로 전달
	@RequestMapping(value = "/member/loginProcess", method = RequestMethod.POST)
	//사용자의 데이터를 전달받기 위한 request 정의 : loginProcess 를 실행할때 현재에 있는 request 를 매개변수로 전달해줌 : 사용가능해짐
	public ModelAndView loginProcess(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			String id = request.getParameter("uId");
			String pw = request.getParameter("uPw");
			
			//View Name 설정
			modelAndView.setViewName("member/login");
			//view page 에 전송
			//저장할 수 있는 공간(Model)영역에 저장해서 사용할 수 있도록 해준다.
			modelAndView.addObject("id",id);
			modelAndView.addObject("pw",pw);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	//@RequestParam : 파라미터의 값을 가져와서 변수에 저장해준다.
	//받고자하는 파라미터 아이디를 가져와서 String id에 저장해준다.
	//받는 파라미터가 적다면 편하게사용 할 수 있다
	//값이 안들어온다면 400에러가 뜨는데 필수가 아닌 파라미터인 경우 required 속성 값을 false로 지정하면된다.
	@RequestMapping("/member/loginProc")
	public String loginproc(@RequestParam(value = "uId", defaultValue = "user") String id, @RequestParam(value = "uPw", required = false) String pw, Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		System.out.println(id +" : "+ pw);
		
		return "member/login";
	}
	
	
	@RequestMapping("/member/loginOk")
	//매개변수로 login 객체를 받아와서 데이터를 가져올 수 있다. (model에 저장되어있는 상태)
	//@ModelAttribute : 객체의 이름을 변경해줄 수 있다. / user 이름으로 객체사용가능 (jsp 내에서 el 에 출력할때)
	public String loginOk(@ModelAttribute("user")Login login) {
		
		System.out.println("id : "+ login.getuId() +", pw : "+login.getuPw());
		
		//데이터를 받고, 그 데이터를 가공하여 가공한데이터를 내보낼 수 있음
		login.setuId(login.getuId()+"님");
		
		return "member/login";
	}
	
}
