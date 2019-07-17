package v06;

public class PhoneCompanyInfo extends PhoneInfo{
	
	
	String company;	//회사이름
	String email;	//이메일
	
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company, String email) {
		
		super(name, phoneNumber);
		
		this.company = company;
		this.email = email;
		
	}
	
	

	@Override
	public void showData() {
		

		super.showData();
		
		System.out.println("회사이름 : " + company);
		System.out.println("이 메 일 : " + email);
	}


	@Override
	public void showBasicInfo() {
		System.out.printf("회사 동료 \"%s\"의 정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber +"입니다.");
		
	}

}
