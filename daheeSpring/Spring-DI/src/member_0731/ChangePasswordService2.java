package member_0731;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import memberExcrption.IdPasswordNotMatchingException;
import memberExcrption.MemberNotFoundException;

@Service("changePwService")
public class ChangePasswordService2 {
	
	@Autowired
	private Dao memberDao;
	
	/*
	 * public ChangePasswordService2(Dao memberDao) { this.memberDao = memberDao; }
	 */

	/*
	 * public void setMemberDao(Dao memberDao) { this.memberDao = memberDao; }
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

