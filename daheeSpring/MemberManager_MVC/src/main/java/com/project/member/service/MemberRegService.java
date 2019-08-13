package com.project.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jdbc.ConnectionProvider;
import com.project.member.dao.MemberDao;
import com.project.member.domain.MemberInfo;
import com.project.member.domain.RequestMemberRegist;

@Service("registService")
public class MemberRegService {
	
	@Autowired
	private MemberDao dao;
	
	//regist : 사용자가 입력한 값을 가지고있음
	//request : 절대경로를 처리하기 위함
	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		
		//파일이 저장될 경로 지정
		String path = "/uploadfile/userphoto";//리소스 매핑 필요 (servlet-context.xml에 경로지정)
		//디렉토리 값 설정
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo = regist.toMemberInfo();
		
		//새로운 파일 이름 생성
		String newFileName = memberInfo.getuserId()+"_"+regist.getUserPhoto().getOriginalFilename();
		
		int resultCnt = 0;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection(); 
			
			//파일을 서버 지정 경로에 저장
			regist.getUserPhoto().transferTo(new File(dir, newFileName));
			//데이터베이스 저장을 하기위한 파일 이름을 넣어줌
			memberInfo.setuserPhoto(newFileName);
			resultCnt = dao.insertMember(conn, memberInfo);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			new File(dir,newFileName).delete();
			e.printStackTrace();
		}
		
		return resultCnt;
	}
		
}
