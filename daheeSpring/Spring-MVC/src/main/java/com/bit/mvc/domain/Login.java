package com.bit.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Login {

	//form 의 name과 같아야지 연결가능하다.
	private String uId;
	
	// JSON 처리 안하게해줌
	@JsonIgnore
	private String uPw;
	
	//default 생성자는 필수
	public Login() {}
	
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	
	
	
}
