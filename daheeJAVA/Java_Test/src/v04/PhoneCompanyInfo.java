package v04;

public class PhoneCompanyInfo extends PhoneInfo{
	
	
	String company;	//회사이름
	String email;	//이메일
	
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company, String email) {
		
		//상위클래스
		super(name, phoneNumber);
		
		//PhoneCompanyInfo에서 초기화하는 변수
		this.company = company;
		this.email = email;
		
	}
	
	
	//상위 클래스의 출력 메서드 오버라이딩
	@Override
	public void showData() {
		
		//상위클래스의 출력메서드를 불러옴 이름, 전화번호 출력
		super.showData();
		
		//데이터 추가하여 오버라이딩
		System.out.println("회사이름 : " + company);
		System.out.println("이 메 일 : " + email);
	}

}
