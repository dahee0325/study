package member_0731;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import memberExcrption.AlreadyExistingMemberException;

//service 클래스로 자동으로 빈등록을 해줌
//이름지정
@Service("regMemberService")
public class MemberRegisterService2 {
	
	//생성자나 setter 없이 인스턴스변수를 찾을 수 있음 ( 자동주입 가능)
	@Autowired
	private MemberDao memberDao;
	
	//생성자를 통한 bean 주입방식을 위한 생성자
	/*
	 * public MemberRegisterService2(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */

	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
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

