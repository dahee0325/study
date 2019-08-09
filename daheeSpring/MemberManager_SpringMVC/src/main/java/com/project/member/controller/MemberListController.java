package com.project.member.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.member.domain.ListViewData;
import com.project.member.domain.SearchParam;
import com.project.member.service.MemberListService;
import com.project.member.service.MemberListService2;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService2 listService;
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model,@RequestParam(value = "p", defaultValue = "1") int pageNumber, @RequestParam(value = "stype", required = false) String stype, @RequestParam(value = "keyword", required = false) String keyword) {
		
		SearchParam searchParam = null; 
		
		if(stype!=null && keyword!=null && !stype.isEmpty() && !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		System.out.println("전체 회원의 수 : "+ listdata.getTotalCount());
		/* 
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}
	
}
