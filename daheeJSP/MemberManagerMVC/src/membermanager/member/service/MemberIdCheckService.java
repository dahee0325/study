package membermanager.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membermanager.member.dao.MemberDao;
import membermanager.member.model.MemberInfo;

public class MemberIdCheckService implements MemberService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("uId");
		
		Connection conn = null;
		
		MemberDao dao = MemberDao.getInstance();
		//이 객체가 있는지 없는지에 따라서 결과값을 받음
		MemberInfo memberInfo = null;
		//memberInfo 객체의 유무의 따른 결과값
		String resultCode = "N";
		
		try {
			conn = jdbc.ConnectionProvider.getConnection();
			
			memberInfo = dao.selectMemberById(conn, id);
			
			if(memberInfo == null) {
				resultCode = "Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("resultCode", resultCode);
		
		return "/WEB-INF/view/member/idCheck.jsp";
	}

}
