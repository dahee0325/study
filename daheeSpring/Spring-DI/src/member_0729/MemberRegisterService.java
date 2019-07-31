package member_0729;

import java.util.Date;

import memberExcrption.AlreadyExistingMemberException;

public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest request) throws AlreadyExistingMemberException {

		Member member = memberDao.selectByEmail(request.getEmail());

		if (member != null) {
			// 같은 이메일이 등록되어있다는 뜻
			throw new AlreadyExistingMemberException();
		}

		Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());

		memberDao.insert(newMember);
	}
}
