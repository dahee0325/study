package com.project.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberRegist;
import com.project.member.service.MemberDeleteService3;
import com.project.member.service.MemberListService3;
import com.project.member.service.MemberRegService4;

//자원의 경로는 하나를 만들어서 사용 : /rest-api/members
// /rest-api/members GET         -> 전체 리스트, 페이징 처리된 리스트
// /rest-api/members/{id} GET    -> 회원 한명의 정보 반환
// /rest-api/members POST        -> 회원 정보를 저장
// /rest-api/members/{id} PUT    -> 회원 정보를 수정
// /rest-api/members/{id} DELETE -> 회원 정보를 삭제

@Controller
@RequestMapping("/rest-api/members")//기본맵핑
public class MemberRestApiController {

	@Autowired
	private MemberListService3 listService;

	@Autowired
	private MemberRegService4 regService;
	
	@Autowired
	private MemberDeleteService3 deleteService;
	
	//모든 도메인 허용 (지정할 수도있음 ex) 네이버에서 들어오는 도메인만 허용 @CrossOrigin("https://www.naver.com"))
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<MemberInfo> getAllList() {
		return listService.getAllList();
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String regMember(@RequestBody RequestMemberRegist regRequest, HttpServletRequest request) {

		int result = regService.memberInsert(request, regRequest);
		
		return result>0?"success":"fail";
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteMember(@PathVariable("id") int idx) {
		
		int result = deleteService.memberDelete(idx);
		
		return result>0?"회원가입되었습니다.":"회원가입실패";
	}
}
