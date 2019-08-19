package com.bit.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bit.mvc.domain.Login;

@RestController
public class RestAPIController {
	
	//@PostMapping // method = RequestMethod.POST
	//@PutMapping  // method = RequestMethod.PUT
	//@DeleteMapping  //method = RequestMethod.DELETE 와 같음
	
	//@GetMapping(value = "/restapi/hello") 이런식으로 요청을 하려면
	@RequestMapping(name = "/restapi/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	// JSON으로 변환해주는 라이브러리가 없다면 오류뜸★ (그대로 객체로 반환하기때문에 오류)
	@RequestMapping("restapi/login")
	public Login login() {
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456789");
		
		return login;
	}
	
	
	@RequestMapping("restapi/loginList")
	public List<Login> loginList() {
		
		List<Login> list = new ArrayList<Login>();
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456789");
		
		list.add(login);
		
		//만드는이유 : 리스트에서 서로다른 객체를 넣어보기 위해
		login = new Login();
		login.setuId("Hot");
		login.setuPw("password");
		
		list.add(login);
		
		return list;
	}
	
	@RequestMapping("restapi/loginMap")
	public Map<String, Login> loginMap() {
		
		Map<String, Login> maps = new HashMap<String, Login>();
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456789");
		
		maps.put("1", login);
		
		login = new Login();
		login.setuId("Hot");
		login.setuPw("password");
		
		maps.put("2", login);
		
		return maps;
	}
	
}
