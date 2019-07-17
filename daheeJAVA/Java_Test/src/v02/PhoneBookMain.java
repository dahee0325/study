package v02;

import util.Util;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneManager manager = new PhoneManager();
		
		while(true) {
			System.out.println("================================");
			System.out.println(" 	      메뉴 선택");
			System.out.println("================================");

			System.out.println("1. 입력	2. 종료");
			
			int choice = Util.keyboard.nextInt();
			
			switch (choice) {
			case 1:
				manager.insert();
				break;
			case 2:
				System.out.println("종료되었습니다.");
				return;
			default:
				System.out.println("메뉴중에 선택해주세요.");
				break;
			}
		}
		
		
	}

}