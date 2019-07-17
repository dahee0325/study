package collectiontest;

class PhoneInfo {

	/*
	 * PhoneInfo 클래스의 목적 : 친구의 정보를 저장하는 클래스이기 떄문에 변수를 초기화하고 변수값을 저장하고 출력하는 기능을 가진다.
	 * • 이름		name String
	 * • 전화번호 	phoneNumber String
	 * • 생년월일 	birthday String
	 * 저장된 데이터의 적절한 출력이 가능하도록 메소드 생성
	 * 생년월일 정보는 저장할 수도있고, 저장 않을 수도있게끔 생성자 생성
	 * 
	 */
	
	//인스턴스변수
	String name; 		//친구의 이름 저장
	String phoneNumber; //친구의 전화번호 저장
	String birhday;		//친구의 생일 저장
	
	//속성 = 변수 = 필드
	
	//생성자 쉽게 생성 - shift+alt+s - fields
	//생성자 : 기본 정보 초기화(이름, 전화번호, 생일)
	PhoneInfo(String name, String phoneNumber, String birhday) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birhday = birhday;
		
	}

	//생성자 : 이름과 전화번호 저장
	PhoneInfo(String name, String phoneNumber) {
		
		//오버로딩되어있는 생성자를 호출가능하다(오버로딩의 조건 : 매개변수가 다르거나 타입이 다르거나)
		
		//this(name, phoneNumber, null);
		//생년월일이 입력안된다면 "등록된 정보가 없습니다." 라는 문자열이 출력되도록 설정
		this(name, phoneNumber, "등록된 정보가 없습니다.");
		
		/*
		 * this.name = name; 
		 * this.phoneNumber = phoneNumber;
		 */
	}
	
	//친구 정보 출력 메서드
	void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		
		//생일에 아무런 정보가 없다면 "등록된 정보가 없습니다." 가 출력된다. (this(name, phoneNumber, "등록된 정보가 없습니다.");에서 설정)
		System.out.println("생일 : "+ birhday);
		
		/*
		 * if(birhday != null) { 
		 * System.out.println("생일 : "+ birhday); 
		 * }
		 * else {
		 * System.out.println("생일에 등록된 정보가 없습니다."); 
		 * }
		 */
	}

	@Override
	public boolean equals(Object obj) {
		
		//String 전화번호가 같으면 저장 ㄴㄴ하게
		boolean result = false;
		
		if(obj != null && obj instanceof PhoneInfo) {
			//가능하면 obj를 PhoneInfo형으로 형변환을 해준다.
			PhoneInfo pi = (PhoneInfo) obj;
			
			result = this.phoneNumber.equals(pi.phoneNumber);
		}
			
		return result;
	}

	@Override
	public int hashCode() {
		
		//해시코드 생성
		//phoneNumber : String 이기 때문에 int 타입으로 변환해줘야한다.
		//전화번호에는 하이픈(-)도 올수 있기 때문에
		//01000000000 : 문자열의 마지막 문자를 추출
		
		//인덱스값에 있는 문자하나를 반환하는 charAt
		//String의 길이의 인덱스 값은 0~n-1 값이기 깨문에 length()-1값을 가져오면 마지막 문자를 가져올 수 있다.
		//char는 int자료형으로 자동형변환이 가능하기 때문에 마지막문자의 유니코드로 추출된다.
		return phoneNumber.charAt(phoneNumber.length()-1);
		
	}
	
	
	//해시코드, equals 를 오버라이딩
	
	
	
}
