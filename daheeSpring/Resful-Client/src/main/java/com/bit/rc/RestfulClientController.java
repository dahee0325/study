package com.bit.rc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestfulClientController {
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public List<MemberInfo> getAllList() {
		
		//Rest 템플릿을 사용하기 위해서는 객체생성
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo[] members = restTemplate.getForObject("http://localhost:8080/member/rest/members", MemberInfo[].class);
		
		List<MemberInfo> list = Arrays.asList(members);
		
		for(MemberInfo m : list) {
			System.out.println(m);
		}
		
		return list;
	}
	
	
	@RequestMapping("/member/{idx}")
	public String getMember(@PathVariable("idx") int idx) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo info = restTemplate.getForObject("http://localhost:8080/member/rest/members/{id}", MemberInfo.class, idx);
		
		System.out.println(info);
		
		
		return null;
	}
	
}
