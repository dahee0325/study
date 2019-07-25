package member.model;

import java.util.Date;

public class Member {
	
	private int userNum;		//회원번호
	private String userId;		//회원아이디
	private String userPw;		//회원비밀번호
	private String userName;	//회원이름
	private Date userRegDate;	//회원가입날짜
	private String userRegDay;	//회원가입날짜 변환
	
	public Member() {};
	
	public Member(int userNum, String userId, String userPw, String userName) {
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	
	public Member(int userNum, String userId, String userPw, String userName, Date userRegDate) {
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userRegDate = userRegDate;
	}
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
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
	public Date getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}
	public String getUserRegDay() {
		return userRegDay;
	}
	public void setUserRegDay(String userRegDay) {
		this.userRegDay = userRegDay;
	}
	
	
	
}
