package com.dahee.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {

	private String userId;
	private String userPw;
	private String userName;
	private MultipartFile userPhoto;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(MultipartFile userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	
}
