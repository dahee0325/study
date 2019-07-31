package member_0730;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import memberExcrption.IdPasswordNotMatchingException;
import memberExcrption.MemberNotFoundException;

@Service
public class ChangePasswordService {
	
	//원래 사용하던 객체생성
	//private MemberDao dao = new MemberDao();
	
	//인스턴스 변수를 생성해서 참조를 하지않아도 null값으로 생성
	@Autowired(required = false)
	//@Autowired
	//@Qualifier("sys")
	private Dao memberDao;
	
	//5까지사용
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	/*
	 * public ChangePasswordService(MemberDao dao) { memberDao = dao; }
	 */
	

	public void changePassword(String email, String oldPw, String newPw) throws MemberNotFoundException, IdPasswordNotMatchingException {
		
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
		
	}
	
}

