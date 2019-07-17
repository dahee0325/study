package v05update;

import util.Menu;
import util.Util;

public class PhoneBookManager {
	

	final PhoneInfo[] pb;
	int cnt;
	

	public static PhoneBookManager getInstance() {
		
		if(m == null) {
			m = new PhoneBookManager();
		}
		return m;
	}
	

	private static PhoneBookManager m = new PhoneBookManager(200);
	

	private PhoneBookManager() {
		//pb의 크기 지정
		/*	pb = new PhoneInfo[100];
			cnt=0; */
		this(100);
	}
	
	//배열의 사이즈 지정가능
	private PhoneBookManager(int size) {
		pb = new PhoneInfo[size];
		cnt=0; 
	}
	
	

	public void insertMember(int select) {

		PhoneInfo pi = null;
		
		//1. 기본정보 받기 : 이름, 전화번호
		System.out.println("친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();
		System.out.println("친구의 전화번호를 입력해주세요.");
		String phoneNumber = Util.keyboard.nextLine();
		
		//2. 입력의 흐름처리
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
		
		//3. 인스턴스를 배열에 저장
		pb[cnt++] = pi;
		
		System.out.println("입력하신 정보가 저장되었습니다.");
		
		
	}
	
	
	//PhoneInfor타입의 배열에 저장된 모든 데이터를 출력해주는 메서드
	public void showAllData() {
		
		System.out.println("=====================================");
		
		//저장된 배열의 인덱스 값이 0보다 클때 (저장된값이 존재할때)
		if(cnt>0) {
			for(int i=0; i<cnt; i++) {
				pb[i].showData();
				System.out.println("-------------------------------------");
			}
		} else {
			System.out.println("등록된 친구정보가 없습니다.");
		}
		System.out.println("=====================================");
		
		
	}
	
	
	public void serchPrint() {
		
		System.out.print("검색할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {

			pb[index].showBasicInfo();
		}
		
		
	}
	

	//수정
	public void serchUpdate() {
		System.out.print("수정할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		if (index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			System.out.println("=====================================");
			System.out.println("	  수정할 친구의 정보");
			pb[index].showData();
			System.out.println("\n수정할 내용을 입력해주세요.");

			insert();
			pb[index] = pb[--cnt];
		}
		
	}
	
	
	
	//삭제
	public void serchDelete() {

		System.out.print("삭제할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		

		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {

			for(int i=index; i<cnt-1; i++) {
				pb[i] = pb[i+1];
			}
			
			//저장된 친구 정보의 개수 감소
			cnt--;
			
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
	}
	

	

	public int searchIndex(String keyword) {

		int index = -1; 

		for (int i = 0; i < cnt; i++) {

			if (pb[i].name.equals(keyword)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	public int printMenu() {


		System.out.println("=====================================");
		System.out.println("	   메뉴번호를 선택해 주세요.");

		System.out.printf("%d.입력\n%d.검색\n%d.수정\n%d.삭제\n%d.전체보기\n%d.종료",Menu.INSERT,Menu.SEARCH,Menu.UPDATE,Menu.DELETE,Menu.ALLDATA,Menu.QUIT);
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
