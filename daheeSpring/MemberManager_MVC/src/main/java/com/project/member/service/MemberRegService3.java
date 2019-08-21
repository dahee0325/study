package com.project.member.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.dao.MemberDaoInterface;
import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberRegist;

@Service("registService3")
public class MemberRegService3 {

	// 자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;

	@Autowired
	private MailSenderService mailService;

	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;

	// regist : 사용자가 입력한 값을 가지고있음
	// request : 절대경로를 처리하기 위함
	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);

		// 파일이 저장될 경로 지정
		String path = "/uploadfile/userphoto";// 리소스 매핑 필요 (servlet-context.xml에 경로지정)
		// 디렉토리 값 설정
		String dir = request.getSession().getServletContext().getRealPath(path);

		MemberInfo memberInfo = regist.toMemberInfo();

		// 새로운 파일 이름 생성

		int resultCnt = 0;
		String newFileName = "";

		try {
			if (regist.getUserPhoto() != null) {
				// 새로운 파일 이름 생성
				// String newFileName = memberInfo.getuId()+System.nanoTime();
				newFileName = memberInfo.getuserId() + "_" + regist.getUserPhoto().getOriginalFilename();
				// 파일을 서버의 지정 경로에 저장
				regist.getUserPhoto().transferTo(new File(dir, newFileName));
				// 데이터베이스 저장을 하기위한 파일 이름 set
				memberInfo.setuserPhoto(newFileName);
			}

			resultCnt = dao.insertMember(memberInfo);

			// 메일 발송
			mailService.send(memberInfo.getuserId(), memberInfo.getCode());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultCnt;
	}

	// 아이디체크
	public char idCheck(String id) {
		dao = template.getMapper(MemberDaoInterface.class);
		return dao.selectMemberById(id) == null ? 'Y' : 'N';
	}

	public String idCheck1(String id) {
		dao = template.getMapper(MemberDaoInterface.class);
		return dao.selectMemberById2(id) == null ? "Y" : "N";
	}

}
