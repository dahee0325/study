package v05update;

//확장형 클래스(상속하여 데이터를 추가하는)
public class PhoneUnivInfo extends PhoneInfo{

	
	String address; //주소
	String email; 	//이메일
	String major;	//전공
	int grade;	//학년
	

	//이 생성자의 역할 : 데이터의 초기화 (인스턴스 생성시에 데이터를 받아와서 초기화) 
	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, int grade) {
		
		//상위 클래스의 생성자 호출 : 멤버변수 초기화
		//PhoineInfo에 있는 name과 pNum을 받아옴
		super(name,phoneNumber);
		
		//PhoneUnivInfo 에서 새로 정의한 변수들
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;
		
	}
	
	
	//상위 클래스의 출력 메서드 오버라이딩
	@Override
	public void showData() {
		
		//상위 클래스의 있는 출력메서드의 내용을 가져옴 : 이름과 전화번호출력 
		//System.out.println("이    름 : " + name);
		//System.out.println("전화번호 : " + phoneNumber);
		super.showData();
		System.out.println("주    소 : " + this.address);
		System.out.println("이 메 일 : " + this.email);
		System.out.println("전    공 : " + this.major +"학과");
		System.out.println("학    년 : " + this.grade +"학년");
		
	}


	//대학친구 일때만 출력
	@Override
	public void showBasicInfo() {
		System.out.printf("대학 친구 \"%s\"의 정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber +"입니다.");
		
	}
}
