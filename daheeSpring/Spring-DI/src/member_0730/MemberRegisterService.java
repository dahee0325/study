package member_0730;

import java.util.Date;

import memberExcrption.AlreadyExistingMemberException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registService")
public class MemberRegisterService {
	
	@Autowired(required = false)
	// @Qualifier("sys")
	//@Resource(name = "memberDao1")
	private Dao memberDao;
	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */

	/*
	 * public MemberRegisterService(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */

	public void regist(RegisterRequest request) throws AlreadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			//같은 이메일이 등록되어있다는 뜻
			throw new AlreadyExistingMemberException();
		}
		
		Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		memberDao.insert(newMember);
	}
}
