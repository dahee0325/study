package com.project.member.domain;

public class MemberRestApiRegRequest {
	
	private String uId;
	private String uName;
	private String uPw;
	
	
	// getter , setter 가 있어야지 자동 매핑이 가능
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	
	
	@Override
	public String toString() {
		return "MemberRestApiRegRequest [uId=" + uId + ", uName=" + uName + ", uPw=" + uPw + "]";
	}
	
	
	public MemberInfo toMemberInfo() {
		MemberInfo member = new MemberInfo();
		member.setuserId(uId);
		member.setuserName(uName);
		member.setuserPw(uPw);
		
		return member;
	}
	
}
