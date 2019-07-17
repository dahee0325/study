package v03;

import util.Util;

public class PhoneBookMain1 {

	//프로그램의 전체적인 흐름만 존재하는 main 메서드
	public static void main(String[] args) {
		
		//인스턴스생성, 배열 사이즈 할당
		PhoneBookManager manager = new PhoneBookManager(200);
		
		//5는 종료
		int choice = 5;
		
		while(true) {
			
			//사용자가 가져온 번호값은 choice에 저장
			 choice = manager.printMenu();
			 
			 switch (choice) {
			 // case 1 과 같은뜻
			 case Util.INSERT:
				 manager.insertMember();
				 break;
			 case Util.SEARCH:
				 manager.serchPrint();
				 break;
			 case Util.DELETE:
				 manager.serchDelete();
				 break;
			 case Util.ALLDATA:
				 manager.showAllData();
				 break;
			 case Util.QUIT:
				 System.out.println("프로그램을 종료합니다.");
				 return;
			 }
			
		}
	}

}
