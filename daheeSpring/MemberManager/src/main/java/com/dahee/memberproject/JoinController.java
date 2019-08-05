package com.dahee.memberproject;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dahee.memberproject.domain.MemberInfo;

@Controller
public class JoinController {
	
	String path = "/uploadfile";
	
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String getJoinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String getJoin(MemberInfo info, HttpServletRequest request) {
		
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		try {
			if(!info.getUserPhoto().isEmpty() && info.getUserPhoto().getSize() > 0) {
				info.getUserPhoto().transferTo(new File(dir, info.getUserId()+"_"+info.getUserPhoto().getOriginalFilename()));
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "member/join";
	}
	
}
