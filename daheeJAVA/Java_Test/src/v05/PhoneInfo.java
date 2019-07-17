package v05;

//상속을 목적으로 사용할 예정이라서 private를 사용X (참조 불가능해서)
//인터페이스인 PhoneInfoBasic를 상속하기 위해 추상클래스로 만들어줌
public abstract class PhoneInfo implements PhoneInfoBasic{

	//데이터보호목적
	//외부에서 보지못하게 private 처리
	//private String name;		//친구이름 저장
	//private String phoneNumber; //친구번호 저장
	
	String name;
	String phoneNumber;
	
	//생성자를 통한 PhoneInfo 변수 초기화( 외부에서는 참조 불가능 private 때문)
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}
	

	//출력하는 메서드
	public void showData() {
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}


	/*
	//데이터 보호하는 목적으로 private 를 사용
	//private 때문에 직접참조가 불가능하니까 참조할 수 있는 메서드를 생성해준다
	//변수의 값을 참조하는 메서드 : getter 메서드
	String getName() {
		return this.name;
	}

	
	//변수에 값을 대입하는 메서드 : setter 메서드
	//이 메서드를 통해서만 값이 들어오게함
	//직접참조가 불가능하니까 이 메서드를 통해 값을 받아온다
	void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	*/
	
}
