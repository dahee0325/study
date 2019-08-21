package com.project.member.domain;

import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

// usebean Class
public class MemberInfo {
/*
	2019.08.20
	verify 컬럼 추가, 	code 추가
	verify : 인증 여부 코드
	code : 난수 코드
*/
	
// usebean Class
	// 각 변수의 저근 제어지시자는 private
	private int idx;
	private String userId;
	@JsonIgnore
	private String userPw;
	private String userName;
	private String userPhoto;
	private Date regDate;
	private char verify;
	@JsonIgnore
	private String code;
	
	// default 생성자 필수
	public MemberInfo() {
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(String userId, String userPw, String userName, String userPhoto) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(int idx, String userId, String userPw, String userName, String userPhoto, Date regDate) {
		super();
		this.idx = idx;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.regDate = regDate;
		getRandomSting();
	}

	// 변수들의 Getter/Setter 시작

	public String getuserId() {
		return userId;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getuserPw() {
		return userPw;
	}

	public void setuserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getuserPhoto() {
		return userPhoto;
	}

	public void setuserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
		
	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", uId=" + userId + ", uPW=" + userPw + ", uName=" + userName + ", uPhoto=" + userPhoto
				+ ", regDate=" + regDate + ", verify=" + verify + ", code=" + code + "]";
	}

	// MemberInfo 객체 -> LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {

		return new LoginInfo(userId, userName, userPhoto, regDate);

	}

	// 비밀번호 체크 확인
	// 2017.07.25 메서드 추가
	public boolean pwChk(String pw) {
		return userPw != null && userPw.trim().length() > 0 && userPw.equals(pw);
	}

	// 2019.08.20 추가
		// 영문 + 숫자 난수 발생
		private void getRandomSting() {
			
			Random r = new Random(System.nanoTime());
			StringBuffer sb = new StringBuffer();
			
			for(int i=0 ; i<20 ; i++ ) {
				if(r.nextBoolean()) {
					sb.append(r.nextInt(10));
				} else {
					sb.append((char)(r.nextInt(26)+97));
				}
			}
			
			setCode(sb.toString());
			
			//return  sb.toString();	
		}
	
}
