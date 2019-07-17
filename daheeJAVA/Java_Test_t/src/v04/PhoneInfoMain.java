package v04;

import javax.swing.plaf.SliderUI;

import util.Util;

public class PhoneInfoMain {

	public static void main(String[] args) {
		/*
		//데이터 출력을 위해서 하위클래스로 형변환안해도됨 - 하위클래스에서 오버로딩을 통해 그대로 출력이 가능하기 때문
		PhoneInfo pi = new PhoneUnivInfo("다희", "010-0000-0000", "서울시", "daa_hee@naver.com", "컴퓨터공학", 4);

		pi.showData();
		*/
		
		//배열의 크기정하기
		//싱글톤패턴 때문에 직접 참조 불가능해짐
		//PhoneBookManager manager = new PhoneBookManager(100);
		
		//싱글톤패턴으로 바뀐 소스 gerInstance 를 통해 참조변수를 가져옴
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		
		while(true) {
			
			int choice = manager.printMenu();
			
			switch (choice) {
			case Util.INSERT:
				manager.insert();
				break;
			case Util.SEARCH:
				System.out.println("검색");
				manager.serchPrint();
				break;
			case Util.ALLDATA:
				System.out.println("전체보기");
				manager.showAllData();
				break;
			case Util.DELETE:
				System.out.println("삭제");
				manager.serchDelete();
				break;
			case Util.QUIT:
				System.out.println("종료");
				return;
			}
			
		}
	}

	

}

