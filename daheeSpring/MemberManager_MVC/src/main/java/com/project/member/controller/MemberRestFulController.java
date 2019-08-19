package com.project.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberEdit;
import com.project.member.domain.RequestMemberRegist;
import com.project.member.service.MemberDeleteService3;
import com.project.member.service.MemberEditService4;
import com.project.member.service.MemberListService3;
import com.project.member.service.MemberRegService4;

//@ResponseBody 생략
@RestController
@RequestMapping("/rest/members")
public class MemberRestFulController {
	
	@Autowired
	private MemberListService3 listService;
	
	@Autowired
	private MemberDeleteService3 delService;
	
	@Autowired
	private MemberRegService4 regService;
	
	@Autowired
	private MemberEditService4 editService;
	
	//@ResponseBody 는 @RestController로 정의했기 때문에 생략가능하다
	//@GetMapping()와 같음  = @RequestMapping(method = RequestMethod.GET)
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<MemberInfo>> getAllList() {
		
		List<MemberInfo> list = listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity = new ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);
		
		//보내주는 상태코드값
		//HttpStatus.OK -> 200
		//HttpStatus.NOT_FOUND -> 404
		//HttpStatus.INTERNAL_SERVER_ERROR -> 500
		
		return entity;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/{id}") //rest/members/12 -> 라고 들어오면 12 부분을 변수(id)로 받아서 처리할 수 있음
	public ResponseEntity<String> deleteMember(@PathVariable("id") int idx) {
		
		return new ResponseEntity<String>(delService.memberDelete(idx)>0 ? "success" : "fail", HttpStatus.OK);
		
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(RequestMemberRegist regRequest, HttpServletRequest request) {
		
		return new ResponseEntity<String>(regService.memberInsert(request, regRequest) > 0 ? "success" : "fail", HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public MemberInfo editMemberForm(@PathVariable("id") int idx) {
		
		MemberInfo info = editService.getEditFormData(idx);
		
		return info;
		
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<String> editMember(@PathVariable("id") int id, @RequestBody RequestMemberEdit editRequest, HttpServletRequest request){
		
		editRequest.setIdx(id);
		
		int cnt = editService.edit(editRequest, request);
		
		return new ResponseEntity<String>(cnt>0?"success":"fail" , HttpStatus.OK);
	}
	
}
