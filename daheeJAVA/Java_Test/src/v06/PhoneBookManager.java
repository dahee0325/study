package v06;

import java.util.ArrayList;

import util.Menu;
import util.Util;

public class PhoneBookManager {
	

	final ArrayList<PhoneInfo> pb = new ArrayList<PhoneInfo>();


	public static PhoneBookManager getInstance() {
		
		if(m == null) {
			m = new PhoneBookManager();
		}
		return m;
	}
	
	
	private static PhoneBookManager m = new PhoneBookManager();
	

	public void insertMember(int select) {
		

		PhoneInfo pi = null;
		
		System.out.println("친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();
		System.out.println("친구의 전화번호를 입력해주세요.");
		String phoneNumber = Util.keyboard.nextLine();
		
		
		if(select == Menu.INSERT_UNIV) {
			
			//대학친구의 추가정보 받기
			System.out.println("주소를 입력해주세요.");
			String address = Util.keyboard.nextLine();
			
			System.out.println("이메일을 입력해주세요.");
			String email = Util.keyboard.nextLine();
			
			System.out.println("전공을 입력해주세요.");
			String major = Util.keyboard.nextLine();
			
			System.out.println("학년을 입력해주세요.");
			int grade = Util.keyboard.nextInt();
			
			//인스턴스 생성
			pi = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);
			
		}else if(select == Menu.INSERT_COM) {
			
			//회사친구의 추가정보 받기
			System.out.println("회사이름을 입력해주세요.");
			String company = Util.keyboard.nextLine();
			
			System.out.println("이메일을 입력해주세요.");
			String email = Util.keyboard.nextLine();
			
			//인스턴스 생성
			pi = new PhoneCompanyInfo(name, phoneNumber, company, email);
			
		} else if(select == Menu.INSERT_CAFE){
			
			//동호회친구의 추가정보 받기
			System.out.println("닉네임을 입력해주세요.");
			String nickName = Util.keyboard.nextLine();
			
			//인스턴스 생성
			pi = new PhoneCafeInfo(name, phoneNumber, nickName);
			
		} else {
			System.out.println("메뉴중에 선택해주세요.");
		}
		

		//ArrayList pb에 입력된 데이터 추가
		pb.add(pi);
		System.out.println("입력하신 정보가 저장되었습니다.");
		
		
	}
	
	
	//모든 데이터를 출력해주는 메서드
	public void showAllData() {
		
		System.out.println("=====================================");

		if(pb.size()>0) {
			for(int i=0; i<pb.size(); i++) {
				pb.get(i).showData();
				System.out.println("-------------------------------------");
			}
		} else {
			System.out.println("등록된 친구정보가 없습니다.");
		}
		System.out.println("=====================================");
		
		
	}
	
	

	//검색한 이름의 정보 출력
	public void serchPrint() {
		
		System.out.print("검색할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			pb.get(index).showBasicInfo();
		}
		
		
	}
	

	
	//정보 삭제
	public void serchDelete() {

		System.out.print("삭제할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			
			pb.remove(index);			
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
	}

	

	//입력된 이름과 같은 인덱스값 찾기
	public int searchIndex(String keyword) {

		int index = -1; 

		for (int i = 0; i < pb.size(); i++) {
			if (pb.get(i).name.equals(keyword)) {
				index = i;
				break;
			}
		}
		return index;
	}
	

	
	public int printMenu() {

		System.out.println("=====================================");
		System.out.println("	   메뉴번호를 선택해 주세요.");
		System.out.printf("%d.입력\n%d.검색\n%d.삭제\n%d.전체보기\n%d.종료",Menu.INSERT,Menu.SEARCH,Menu.DELETE,Menu.ALLDATA,Menu.QUIT);
		System.out.println("\n=====================================");


		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine();//현재 라인의 버퍼를 출력(clear)
		
		return choice;
	}
	
	
	public void insert() {
		
		System.out.println("=====================================");
		System.out.println("	    입력 형태를 선택해주세요.");
		System.out.printf("%d.대학친구 \n%d.회사친구 \n%d.동호회친구\n",Menu.INSERT_UNIV,Menu.INSERT_COM,Menu.INSERT_CAFE);
		System.out.println("=====================================");
		
		int select = Util.keyboard.nextInt();
		
		Util.keyboard.nextLine();
		
		insertMember(select);
		

	}
}
