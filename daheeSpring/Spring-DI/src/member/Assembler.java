package member;

public class Assembler {
	//객체를 생성하고 보관하며, 객체를 요구하는쪽에 반환해줌 : 객체를 관리해줌
	//조립기 역할, 컨테이너 기능 : 관리 
	
	//보관객체
	private MemberDao memberDao;
	private MemberRegisterService registerService;
	private ChangePasswordService changePasswordService;
	
	/*
	 * public Assembler() { //생성자를 통해서 객체 생성, 주입 memberDao = new MemberDao();
	 * registerService = new MemberRegisterService(memberDao); changePasswordService
	 * = new ChangePasswordService(memberDao); }
	 */

	public MemberDao getMemberDao() {
		return memberDao;
	}


	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public MemberRegisterService getRegisterService() {
		return registerService;
	}


	public void setRegisterService(MemberRegisterService registerService) {
		this.registerService = registerService;
	}


	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}


	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	
}
