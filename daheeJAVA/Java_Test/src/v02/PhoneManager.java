package v02;

import util.Util;

public class PhoneManager {

	void insert() {
		
		Util.keyboard.nextLine();
		
		//지역변수 초기화
		String name=null, pNum=null, birthday=null;
		
		System.out.print("이름 입력 : ");
		name = Util.keyboard.nextLine();
		
		System.out.print("전화번호 입력 : ");
		pNum = Util.keyboard.nextLine();
		
		System.out.print("생일 입력 : ");
		birthday = Util.keyboard.nextLine();
		
		System.out.println("입력이 완료되었습니다.\n");
		
		//인스턴스 담을 변수 초기화
		PhoneInfo info=null;
		
		//birthday에 들어오는 값이 있느냐 없는냐에 따라 생성되는 인스턴스가 달라짐
		if(birthday == null || birthday.trim().length() < 1) {
			info = new PhoneInfo(name, pNum);
		} else {
			info = new PhoneInfo(name, pNum, birthday);
		}
		
		info.showInfo();
		System.out.println();
	}
}
