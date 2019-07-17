package v05update;

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


	//똑같은 showBasicInfo() 인데 오버라이딩하는 이유는 회사동료, 대학친구 등등 출력을 다르게하기위해
	@Override
	public void showBasicInfo() {
		System.out.printf("회사 동료 \"%s\"의 정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber +"입니다.");
		
	}

}
