package com.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberEdit;
import com.project.member.service.MemberEditService;
import com.project.member.service.MemberEditService2;

@Controller
@RequestMapping("/member/edit")
public class MemberUpdateController {
	
	@Autowired
	private MemberEditService2 editService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editForm(
			@RequestParam("memberId") int id,
			Model model
			) {
		
		MemberInfo memberInfo = editService.getEditFormData(id);
		
		model.addAttribute("editData", memberInfo);
		
		return "member/memberEditForm";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String edit(RequestMemberEdit edit, HttpServletRequest request) {
		
		editService.edit(edit, edit.getOldFile(), request);
		
		return "redirect:/member/memberList";
		
	}
	
}
