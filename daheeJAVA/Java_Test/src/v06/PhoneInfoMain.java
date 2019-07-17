package v06;


import util.Menu;


public class PhoneInfoMain {

	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		
		while(true) {
			
			int choice = manager.printMenu();
			
			switch (choice) {
			case Menu.INSERT:
				manager.insert();
				break;
			case Menu.SEARCH:
				System.out.println("검색");
				manager.serchPrint();
				break;
			case Menu.ALLDATA:
				System.out.println("전체보기");
				manager.showAllData();
				break;
			case Menu.DELETE:
				System.out.println("삭제");
				manager.serchDelete();
				break;
			case Menu.QUIT:
				System.out.println("종료");
				return;
			}
			
		}
	}

	

}

