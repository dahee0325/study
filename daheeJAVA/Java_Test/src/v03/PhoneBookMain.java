package v03;

import util.Util;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneManager manager = new PhoneManager();
		
		while(true) {
			
			int choice = manager.menuChoice();
			
			switch (choice) {
			case Util.INSERT:
				manager.insert();
				break;
			case Util.SEARCH:
				manager.search();
				break;
			case Util.DELETE:
				manager.delete();
				break;
			case Util.ALLDATA:
				manager.allData();
				break;
			case Util.QUIT:
				System.out.println("종료되었습니다.");
				return;
			default:
				System.out.println("메뉴중에 선택해주세요.");
				break;
			}
		}
		
		
	}

}