package v02;
public class ScannerTest {

	
	String name, phoneNumber, birthday;
	
	
	public ScannerTest(String name, String phoneNumber, String birthday) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		
	}

	
	public ScannerTest(String name, String birthday) {

		this(name, null,birthday);
	}
	
	void showInfo() {

			System.out.println("이름 : " + name);
			System.out.println("전화번호 : " + phoneNumber);
			System.out.println("생년월일 : " + birthday);
		}

	}

