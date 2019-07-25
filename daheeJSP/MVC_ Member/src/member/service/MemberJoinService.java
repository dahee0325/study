package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class MemberJoinService implements MemberService{

	public int insert(Member member) {
		int rCnt = 0;

		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 시랭

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			MemberDao dao = MemberDao.getInstance();

			rCnt = dao.insert(conn, member);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rCnt;
	}

	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {

		// 응답 view 지정
		String viewName = "/WEB-INF/view/memberInsert.jsp";

		// 응답 view 로 전달할 결과 데이터생성
		// 데이터베이스에 데이터 저장
		// 데이터를 받기.

		// 1. 사용자 입력데이터 받기
		// 인코딩
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");

		// 2. Message 객체 생성
		Member member = new Member(0, userId, userPw, userName);

		// 3. Dao 생성, Connection 생성
		MemberDao dao = MemberDao.getInstance();

		Connection conn = null;

		int resultCnt = 0;

		try {
			conn = ConnectionProvider.getConnection();

			// 4. insert 메서드 실행
			resultCnt = dao.insert(conn, member);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. 결과 데이터를 request 속성에 저장
		request.setAttribute("resultCnt", resultCnt);

		return viewName;
	}
}
