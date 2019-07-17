package v06;

public class PhoneUnivInfo extends PhoneInfo{

	
	String address; //주소
	String email; 	//이메일
	String major;	//전공
	int grade;	//학년
	


	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, int grade) {

		super(name,phoneNumber);
		
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;
		
	}
	
	
	@Override
	public void showData() {
		
		super.showData();
		System.out.println("주    소 : " + this.address);
		System.out.println("이 메 일 : " + this.email);
		System.out.println("전    공 : " + this.major +"학과");
		System.out.println("학    년 : " + this.grade +"학년");
		
	}


	@Override
	public void showBasicInfo() {
		System.out.printf("대학 친구 \"%s\"의 정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber +"입니다.");
		
	}
}
