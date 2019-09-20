package com.boot.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.boot.project.domain.MemberInfo;

public interface MemberMapper {
	
	//mapper.xml에 처리하지않아도 여기서 처리 가능하다
	@Select("select * from userinfo")
	public List<MemberInfo> selectAll();
	
	public MemberInfo selectMemberById(String uid);
	
}
