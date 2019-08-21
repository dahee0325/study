package com.bit.rc;

import java.util.Date;


// usebean Class
public class MemberInfo {

	// 각 변수의 저근 제어지시자는 private
	private int idx;
	private String uId;
	private String uPw;
	private String uName;
	private String uPhoto;
	private Date regDate;

	// default 생성자 필수
	public MemberInfo() {
		this.regDate = new Date();
	}

	public MemberInfo(String userId, String userPw, String userName, String userPhoto) {
		super();
		this.uId = userId;
		this.uPw = userPw;
		this.uName = userName;
		this.uPhoto = userPhoto;
		this.regDate = new Date();
	}

	public MemberInfo(int idx, String userId, String userPw, String userName, String userPhoto, Date regDate) {
		super();
		this.idx = idx;
		this.uId = userId;
		this.uPw = userPw;
		this.uName = userName;
		this.uPhoto = userPhoto;
		this.regDate = regDate;
	}

	// 변수들의 Getter/Setter 시작

	public String getuserId() {
		return uId;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setuserId(String userId) {
		this.uId = userId;
	}

	public String getuserPw() {
		return uPw;
	}

	public void setuserPw(String userPw) {
		this.uPw = userPw;
	}

	public String getuserName() {
		return uName;
	}

	public void setuserName(String userName) {
		this.uName = userName;
	}

	public String getuserPhoto() {
		return uPhoto;
	}

	public void setuserPhoto(String userPhoto) {
		this.uPhoto = userPhoto;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", userId=" + uId + ", userPw=" + uPw + ", userName=" + uName + ", userPhoto=" + uPhoto
				+ ", regDate=" + regDate + "]";
	}

	// 비밀번호 체크 확인
	// 2017.07.25 메서드 추가
	public boolean pwChk(String pw) {
		return uPw != null && uPw.trim().length() > 0 && uPw.equals(pw);
	}

}
