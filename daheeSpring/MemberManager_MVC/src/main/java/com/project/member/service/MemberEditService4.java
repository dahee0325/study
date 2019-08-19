package com.project.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDaoInterface;
import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberEdit;

@Service("editService4")
public class MemberEditService4 {

	// 자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;

	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;

	public MemberInfo getEditFormData(int id) {
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);

		return dao.selectMemberByIdx(id);
	}

	public int edit(RequestMemberEdit edit, HttpServletRequest request) {

		dao = template.getMapper(MemberDaoInterface.class);
		MemberInfo memberInfo = edit.toMemberInfo();

		return dao.memberUpdate(memberInfo);
	}

}
