package v02;

public class PhoneInfo {
	
	
	//친구의 이름, 번호, 생일 저장
	String name, phoneNumber, birthday;
	
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		
		this(name, phoneNumber, "저장된 정보가 없습니다.");
		
	}
	
	
	//출력메서드
	void showInfo() {
		
			System.out.println("이름 : "+name);
			System.out.println("전화번호 : "+phoneNumber);
			System.out.println("생년월일 : "+birthday);
			
		
	}
	
	
}
