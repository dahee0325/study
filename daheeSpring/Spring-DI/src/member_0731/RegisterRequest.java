package member_0731;

public class RegisterRequest {
	
	//저장하기 위해선 id가 필여
	private String email;
	private String password;
	//입력하고자하는 패스워드를 받기 위한거(제대로 잘 썼는지)
	private String confirmPassword;
	private String name;
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//입력한 패스워드랑 확인하는 패스워드랑 같은지 확인
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
	
}
