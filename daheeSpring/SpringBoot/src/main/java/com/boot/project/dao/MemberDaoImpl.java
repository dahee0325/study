package com.boot.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.boot.project.entity.MemberEntity;

public class MemberDaoImpl implements MemberDao<MemberEntity> {

	private EntityManager entityManager;
	
	//생성자를 통해 주입하는 방식
	public MemberDaoImpl() {}
	
	public MemberDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<MemberEntity> getAll() {
		
		//from 테이블명이 아닌 Entity객체이름이 들어가야함
		Query query = entityManager.createQuery("from MemberEntity");
		
		//Entity를 List로 반환해줌
		List<MemberEntity> list = query.getResultList();
		
		entityManager.clear();
		
		return list;
	}

	
	@Override
	public MemberEntity findByIdx(long idx) {
		Query query = entityManager.createQuery("from MemberEntity where idx="+idx);
		
		MemberEntity entuty = (MemberEntity) query.getSingleResult();
		
		return entuty;
	}

	@Override
	public List<MemberEntity> findByUname(String name) {
		
		Query query = entityManager.createQuery("from MemberEntity where uname='"+name+"'");
		
		//list 받을 수 있는 메서드 getResultList()
		List<MemberEntity> list = query.getResultList();
		
		return list;
	}

	@Override
	public List<MemberEntity> find(String fstr) {
		
		List<MemberEntity> list = null;
		
		String qSql = "from MemberEntity where idx=:fidx or uname like :fname or uid like :fid";
		
		Long fIdx = 0L;
		
		try {
			//fstr에 숫자가 들어왔을때 형변환
			fIdx = Long.parseLong(fstr);
		}catch(Exception e) {}
		
		//Query query = entityManager.createQuery(qSql).setParameter("fidx", fIdx).setParameter("fname", "%"+fstr+"%").setParameter("fid", "%"+fstr+"%");
		
		Query query = entityManager.createNamedQuery("findWithParam").setParameter("fidx", fIdx).setParameter("fname", "%"+fstr+"%").setParameter("fid", "%"+fstr+"%");
		
		list = query.getResultList();
		
		return list;
	}
	
}
