package com.boot.project.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.project.dao.MemberDaoImpl;
import com.boot.project.domain.MemberInfo;
import com.boot.project.entity.MemberEntity;
import com.boot.project.mapper.MemberMapper;
import com.boot.project.repository.MemberRepository;

@Controller
public class IndexController {

	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private MemberMapper mapper;
	
	//void : 는 메서드 이름의 파일명을 찾음 
	//modelandview 에서는 view 이름을 반환했음
	@RequestMapping("/")
	@ResponseBody
	public List<MemberEntity> index() {
		
		List<MemberEntity> list = repository.findall();
		
		return list;
	}
	
	@RequestMapping("/hello")
	public void hello() {
		
	}
	
	@RequestMapping("/memberInfo")
	public void selectById() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		MemberInfo info = mapper.selectMemberById("dahee03250@naver.com");
		
		System.out.println(info);
	}
	
	@RequestMapping("/members")
	@ResponseBody
	public List<MemberInfo> selectMembers() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		List<MemberInfo> members = mapper.selectAll();
		
		/*
		 * 	for(MemberInfo memberInfo : members) {
				System.out.println(memberInfo);
			}
		*/
		
		return members;
		
	}
	
	
	@RequestMapping("/member/list")
	@ResponseBody
	public List<MemberEntity> getMemberList(){
		
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
		
	}
	
	@RequestMapping("/member/insert")
	@ResponseBody
	public String insetMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setUid("cool@hot");
		entity.setUname("COOLin");
		entity.setUpw("12345");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/edit/{idx}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		entity.setUid("cool@hot.com");
		entity.setUname("COOLinHOT");
		entity.setUpw("editPW");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/delete/{idx}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		
		repository.delete(entity);
		
		return "delete success";
		
	}
	
	@RequestMapping("/member/member/{idx}")
	@ResponseBody
	public MemberEntity getMeberInfo(@PathVariable("idx") long idx ) {
		
		MemberEntity entity = null;
		
		entity = repository.findByIdx(idx);
		
		System.out.println(entity);
		
		return entity;
		
		
	}

	
	@RequestMapping("/member/memberbyname/{fname}")
	@ResponseBody
	public List<MemberEntity> getMeberInfo(@PathVariable("fname") String name ) {
		
		System.out.println("enter : " + name);
		
		List<MemberEntity> entitys = null;
		
		
		
		entitys = repository.findByUnameLike("%"+name+"%");
		
		System.out.println(entitys.isEmpty());
		
		for (MemberEntity memberEntity : entitys) {
			System.out.println(memberEntity);
		}
		
		return entitys;
		
		
	}

	@RequestMapping("/member/memberbybetwwen")
	@ResponseBody
	public List<MemberEntity> getMeberInfo() {
		
		
		List<MemberEntity> entitys = null;
		
		entitys = repository.findByIdxBetween(20L, 39L);
		
		System.out.println(entitys.isEmpty());
		
		for (MemberEntity memberEntity : entitys) {
			System.out.println(memberEntity);
		}
		
		return entitys;
		
		
	}
	
	//EntityManager를 주입받을수있게해줌
	@PersistenceContext
	EntityManager entityManager;
	
	private MemberDaoImpl dao;
	
	//생성자를 통한 주입방식이 유지보수가좋음
	public IndexController() {
		this.dao = new MemberDaoImpl(entityManager);
	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public List<MemberEntity> memberListAll(){
		
		this.dao = new MemberDaoImpl(entityManager);
		
		List<MemberEntity> list = dao.getAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	@RequestMapping("/listbyidx/{idx}")
	@ResponseBody
	public MemberEntity memberByIdx(@PathVariable("idx") long idx){
		
		this.dao = new MemberDaoImpl(entityManager);
		
		MemberEntity entity = dao.findByIdx(idx);
		
		System.out.println(entity);
	
		return entity;
	}
	
	@RequestMapping("/listbyname/{name}")
	@ResponseBody
	public List<MemberEntity> memberByName(@PathVariable("name") String name){
		
		this.dao = new MemberDaoImpl(entityManager);
		
		List<MemberEntity> list = dao.findByUname(name);
		
		System.out.println(list);
	
		return list;
	}
	
	@RequestMapping("/listfind/{str}")
	@ResponseBody
	public List<MemberEntity> memberListFind(@PathVariable("str") String str){
		
		this.dao = new MemberDaoImpl(entityManager);
		
		List<MemberEntity> list = dao.find(str);
		
		System.out.println(list);
	
		return list;
	}
	
}
