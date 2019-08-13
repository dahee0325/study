package com.project.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberJdbcTemplateDao;
import com.project.member.domain.MemberInfo;

@Service("loginService2")
public class MemberLoginService2 {

	@Autowired
	private MemberJdbcTemplateDao dao;

	public boolean login(String id, String pw, HttpServletRequest request) {

		boolean loginChk = false;
		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		if (memberInfo != null && memberInfo.pwChk(pw)) {
			// 세션에 저장
			// 세션이 없으면 새로운 세션을 생성(null이 들어간다면 오류발생)
			request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
			// loginchk 상태값을 변경
			loginChk = true;
		}

		return loginChk;
	}

}
