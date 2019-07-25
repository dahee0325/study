package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService implements MemberService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "/WEB-INF/view/login.jsp";
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		Connection conn = null;
		
		String msg ="";
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDao dao = MemberDao.getInstance();

			Member member = dao.login(conn, userId);
			
			
			if (member == null) {
				
				msg = "아이디랑 패스워드를 확인하세요.";

			} else if (member.getUserId() != null && member.getUserId().equals(userId) && member.getUserPw() != null
					&& member.getUserPw().equals(userPw)) {
				
				request.setAttribute("userInfo", member);
				
				msg = "로그인되었습니다.";

			} else {
				msg = "아이디랑 패스워드를 확인하세요.";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		
		return viewName;
	}
	
}
