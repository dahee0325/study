package member;

import java.util.Date;

public class Member {

	//기본형 long 타입아님
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	//아이디는 중복처리를 안하고 카운트를 세서 저장할거기때문에 생성자에 필요X
	public Member(String email, String password, String name, Date regDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}

	//생성자 통해서만 받을거라서 set은 필요X (id는 set필요 생성자에 없음)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	
	public void changePassword(String oldPassword, String newPassword) throws IdPasswordNotMatchingException {
		
		//기존의 패스워드가 현재 패스워드와 같지않으면
		if(!this.password.equals(oldPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		
		this.password = newPassword;
	}
	
}
