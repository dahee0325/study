package v02;

import util.Util;

class Manager {
	
	//인스턴스를 여러개 생성할 예정이 아니라면 배열하나를 만들어서 활용 (????????????)
	//PhoneInfo[] pb = new PhoneInfo[100];
	
	
	//Singleton 패턴 적용
	
	//1. 생성자의 접근제어 지시자를 private 정의 : 외부에서 생성자 호출 불가능 -> 인스턴스 생성 불가능
	
	private Manager() {
		
	}
	
	//위에서 생성한 생성자의 인스턴스 생성 (private이기 때문에 이 클래스 내에서만 생성가능하다)
	//2. 사용할 인스턴스 생성 : static 메서드에서 사용가능하도록 처리해준다.
	// : 외부의 직접참조를 막기위한 private 처리
	//   private설정을 안하면 외부에서 null로 바꿀수있기 때문에 private로 설정하여 외부에서 수정못하게 처리해준다.
	static private Manager m = new Manager();
	
	//3. 외부에서 인스턴스 요청할 메서드 : static을 통한 외부 호출이 가능하도록 처리해줘야 한다.
	//						     외부 어디에서든 호출이 가능하도록 public 처리
	public static Manager getinstance() {
		
		//m == null 이라면 Manager() 인스턴스를 생성해줌
		if(m == null) {
			m = new Manager();
		}
		
		return m;
	}
	
	
	void insertMember() {
		
		//입력받기 -> 인스턴스 생성 -> 출력
		
		//현재 입력 스캐너의 버퍼를 삭제
		Util.keyboard.nextLine();
		
		//이름, 폰번호, 생년월일 입력받는 지역변수생성(지역변수는 초기화값을 지정해주자)
		//사용자의 입력데이터 임시 저장(if문이 끝나면 사라질 변수이기 때문에)
		String name = null;
		String pNumber = null;
		String birhday = null;
		
		System.out.println("데이터 입력");
		System.out.println("친구 이름 : ");
		name = Util.keyboard.nextLine();
		
		System.out.println("친구 전화번호 : ");
		pNumber = Util.keyboard.nextLine();
		
		System.out.println("친구 생일 : ");
		birhday = Util.keyboard.nextLine();
		
		//사용자로부터 입력받은 데이터로 인스턴스 생성(객체의 변수에 저장)
		PhoneInfo pi = null;
		
		//입력받은데이터에 따라서 인스턴스 생성값이 다르다. (생년월일의 값이 있는지 없는지에 따라)
		//trim()이라는 메서드는 문자열의 앞과 뒤의 공백을 제거해주는 메서드
		//trim()메서드를 사용하여 공백을 다 지운 후 문자열의 길이(length())가 1보다 작다면 공백X
		if(birhday == null || birhday.trim().length() < 1) {
			pi = new PhoneInfo(name, pNumber);
		} else {
			pi = new PhoneInfo(name, pNumber, birhday);
		}
		
		pi.showInfo();
		
		
	}
}
