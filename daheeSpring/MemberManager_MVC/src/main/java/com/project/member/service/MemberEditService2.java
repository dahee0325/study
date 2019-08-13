package com.project.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberJdbcTemplateDao;
import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberEdit;

@Service("editService2")
public class MemberEditService2{

	@Autowired
	private MemberJdbcTemplateDao dao;
	
	public MemberInfo getEditFormData(int id) {

		return dao.selectMemberByIdx(id);
	}

	
	public int edit(RequestMemberEdit edit, String oldFileName, HttpServletRequest request) {
		
		MemberInfo memberInfo = edit.toMemberInfo();
		
		String path = "/uploadfile/userphoto";
		String dir = request.getSession().getServletContext().getRealPath(path);

		// 신규 파일 체크
		if(edit.getuPhoto() != null && !edit.getuPhoto().isEmpty() && edit.getuPhoto().getSize()>0) {
			
			String newFileName = edit.getuId()+"_"+edit.getuPhoto().getOriginalFilename();
			
			try {
				// 신구파일 저장 
				edit.getuPhoto().transferTo(new File(dir, newFileName));
				// 데이터 베이스 저장을 위한 새로운 파일 이름
				memberInfo.setuserPhoto(newFileName);
				// 이전 파일 삭제
				new File(dir, oldFileName).delete();
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			// 신규파일이 없으면 이전 파일 이름을 그대로 업데이트
			memberInfo.setuserPhoto(oldFileName);
		}
		
		return dao.memberUpdate(memberInfo);
	}

}
