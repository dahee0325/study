package com.project.member.controller; 

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.project.member.domain.ListViewData;
import com.project.member.domain.SearchParam;
import com.project.member.service.MemberListService;
import com.project.member.service.MemberListService2;
import com.project.member.service.MemberListService3;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService3 listService;
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber, 
			@RequestParam(value = "stype", required = false) String stype, 
			@RequestParam(value = "keyword", required = false) String keyword) {
		
		SearchParam searchParam = null; 
		
		if(stype!=null && keyword!=null && !stype.isEmpty() && !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/json/memberListJson")	
	public @ResponseBody ListViewData memberListJson(
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletResponse response
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		
		//response.setStatus(HttpServletResponse.SC_OK);
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		
		
		
		return listdata;
	}

	
	//반환타입이 ResponseEntity<T> : 특징 - Spring 4.2버전 이상일때 사용가능
	//반환하는 Body, $tatusCode, HttpHeader
	@RequestMapping("/member/json/memberListJson2")
	public ResponseEntity<ListViewData> memberListJson2(
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		
		//response.setStatus(HttpServletResponse.SC_OK);
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		
		//응답하는 body : listdata
		ResponseEntity<ListViewData> entity = new ResponseEntity<ListViewData>(listdata, HttpStatus.OK);
		
		return entity;
	}
	
	


}
