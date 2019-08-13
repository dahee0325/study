package com.project.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDaoInterface;
import com.project.member.domain.MemberInfo;

@Service("loginService3")
public class MemberLoginService3 {

	// 자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;

	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;

	public boolean login(String id, String pw, HttpServletRequest request) {
		
		dao = template.getMapper(MemberDaoInterface.class);
		
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
