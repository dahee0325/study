package v03;

import util.Util;

public class PhoneManager {

	
	//인스턴스 담을 변수 초기화
	final PhoneInfo[] user = new PhoneInfo[100];//100개의 정보저장가능
	int cnt;//배열 인덱스
	
	
	void insert() {
		System.out.println("================================");
		System.out.println(" 	      친구 등록");
		System.out.println("================================");
		
		//지역변수 초기화
		String name=null, pNum=null, birthday=null;
		
		System.out.print("이름     입력 : ");
		name = Util.keyboard.nextLine();
		
		System.out.print("전화번호 입력 : ");
		pNum = Util.keyboard.nextLine();
		
		System.out.print("생년월일 입력 : ");
		birthday = Util.keyboard.nextLine();
		
		System.out.println("입력이 완료되었습니다.\n");
		
		
		
		//birthday에 들어오는 값이 있느냐 없는냐에 따라 생성되는 인스턴스가 달라짐
		if(birthday == null || birthday.trim().length() < 1) {
			user[cnt++] = new PhoneInfo(name, pNum);
		} else {
			user[cnt++] = new PhoneInfo(name, pNum, birthday);
		}

	}
	
	
	void search() {
		
		System.out.println("================================");
		System.out.println(" 	      이름 검색");
		System.out.println("================================");
		
		System.out.print("이름 입력 : ");
		String searchName = Util.keyboard.nextLine();
		int index = index(searchName);
		
		if (index < 0) {
			System.out.println("등록된 사용자가 없습니다.");
		} else {
			System.out.println("검색한 이름 : " + searchName + "\n");
			user[index].showInfo();
			System.out.println("--------------------------------");

		}
			
		
	}


	void delete() {
		
		System.out.println("================================");
		System.out.println(" 	      정보 삭제");
		System.out.println("================================");
		
		System.out.print("이름 입력 : ");
		String searchName = Util.keyboard.nextLine();
		int index = index(searchName);
		
		if (index < 0) {
			System.out.println("등록된 사용자가 없습니다.");
		} else {
			for(int i=index; i<cnt-1; i++) {
				user[i] = user[i+1];
			}
			
			//저장된 친구 정보의 개수 감소
			cnt--;
			
			System.out.println("삭제 요청한 이름 : "+searchName+"\n");
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
	}
	
	
	//저장된 배열에서 사용자가 입력한 이름찾는 메서드
	int index(String searchName) {
		
		int index = -1;

		for (int i = 0; i < cnt; i++) {
			if (user[i].name.equals(searchName)) {
				index = i;
				break;
			}
		}
		return index;
		
	}
	
	
	void allData() {
		
		System.out.println("================================");
		System.out.println(" 	      전체 출력");
		System.out.println("================================");
		if(cnt>0) {
			for(int i=0; i<cnt; i++) {
				user[i].showInfo();
				System.out.println("--------------------------------");
			}
		}else {
			System.out.println("등록된 사용자가 없습니다.");
		}
		
	}
	
	
	int menuChoice() {
		
		System.out.println("================================");
		System.out.println(" 	      메뉴 선택");
		System.out.println("================================");

		System.out.printf("%d. 입력\n%d. 검색\n%d. 삭제\n%d. 전체출력\n%d. 종료\n",Util.INSERT,Util.SEARCH,Util.DELETE,Util.ALLDATA,Util.QUIT);
		
		int choice = Util.keyboard.nextInt();
		
		Util.keyboard.nextLine();
		
		return choice;
	}
}
