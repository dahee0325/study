package com.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.project.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	public MemberEntity findByIdx(Long idx);
	public List<MemberEntity> findByUnameLike(String name);
	public List<MemberEntity> findByIdxBetween(Long arg1, Long arg2);
	
	//d 라고 하는 이유는 MemberEntity 객체에 담긴 정보만 가져오기 위해서
	@Query("select d from MemberEntity d order by d.idx desc")
	public List<MemberEntity> findall();
	
}
