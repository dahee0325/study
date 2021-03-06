package v04;

import util.Util;

public class PhoneBookManager {
	
	//객체저장을 목적으로 배열 생성
	//배열의 요소 컨트롤을 위한 메서드 구성
	
	//인스턴스 배열변수 선언
	final PhoneInfo[] pb;//값이 바뀌지않게 final 처리
	int cnt;
	
	//생성자를 통한 배열 초기화 (pb의 값은 이 때 지정해준다)
	//defual 값은 100
	public PhoneBookManager() {
		//pb의 크기 지정
		/*	pb = new PhoneInfo[100];
			cnt=0; */
		this(100);
	}
	
	//배열의 사이즈 지정가능
	public PhoneBookManager(int size) {
		pb = new PhoneInfo[size];
		cnt=0;
	}
	
	
	//친구정보 입력 받아 저장하는 메서드
	//PhoneInfo 타입 배열에 저장하는게 목적인 메서드
	//사용자로부터 이름, 전화번호, 생년월일 데이터를 입력받아서 인스턴스 생성
	//생성된 인스턴스를 배열에 저장하고 cnt값 증가시킴, index = cnt 
	public void insertMember() {
		
		System.out.println("사용자가 입력한 명령은 입력입니다.\n친구 정보 입력");
		System.out.print("이름을 입력해주세요 : ");
		String name = Util.keyboard.nextLine();
		
		System.out.print("전화번호를 입력해주세요 : ");
		String pNum = Util.keyboard.nextLine();
		
		System.out.print("생년월일을 입력해주세요 : ");
		String birtday = Util.keyboard.nextLine();
		
		// 저장을 위한 인스턴스의 참조변수 생성 생성
		PhoneInfo pi = null;
		
		//데이터의 저장
		//birtday 값이 없거나 앞뒤 공백을 없애도 길이값이 1보다 작으면 (값이없다면)
		if(birtday == null || birtday.trim().length() < 1) {
			//실행
			//pi = new PhoneInfo(name, pNum);
			pb[cnt++] = new PhoneInfo(name, pNum);
			//pb[0] -> cnt++ -> cnt=1
		} else {
			//pi = new PhoneInfo(name, pNum, birtday);
			pb[cnt++] = new PhoneInfo(name, pNum, birtday);
		}
		
		//배열에 저장 : PhoneInfo[] 에 PhoneInfo 참조값을 저장한다.
		//cnt = 배열의 인덱스값
		//pb[cnt] = pi;
		
		//등록된 친구정보의 개수를 1 증가 - cnt++
		//cnt++;
		
		System.out.println("입력하신 정보가 저장되었습니다.");
		System.out.println("=======================");
		
		//저장된 개수만큼만 반복해주면 되기때문에 배열의 인덱스 값을 가져온다.
		for(int i=0; i<cnt; i++) {
			//PhoneInfo 타입의 참조변수의 집합 = pb
			pb[i].showInfo();
			System.out.println("-----------------------");
		}
		
		System.out.println("=======================");
	}
	
	
	//PhoneInfor타입의 배열에 저장된 모든 데이터를 출력해주는 메서드
	public void showAllData() {
		
		System.out.println("사용자가 입력한 명령은 전체 정보출력입니다.");
		System.out.println("=======================");
		
		//저장된 배열의 인덱스 값이 0보다 클때 (저장된값이 존재할때)
		if(cnt>0) {
			for(int i=0; i<cnt; i++) {
				pb[i].showInfo();
				System.out.println("-----------------------");
			}
		} else {
			System.out.println("등록된 친구정보가 없습니다.");
		}
		System.out.println("=======================");
		
		
	}
	
	
	//친구정보를 이름기준으로 검색 후 정보를 출력하는 메서드
	//배열의 요소인 PhoneInfo 객체의 name의 문자열과 검색 키워드 문자열을 비교해
	//1. 사용자에게 찾고자하는 이름 데이터 문자열을 받는다.
	//2. 배열의 모든 요소에서 PhoneInfo 객체의 name과 키워드(검색이름) 비교
	//3. 같은 문자열이 나온 index 저장 : index값을 저장할 변수가 필요 -> 변수 선언 후에 저장하고 데이터를 전달
	//4. 찾은 index값의 배열 위치의 객체 데이터 출력
	public void serchPrint() {
		
		System.out.println("사용자가 입력한 명령은 검색입니다.");
		
		
		System.out.print("검색할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		
		//검색된 index값을 비교하고 정보 출력
		//index 값이 0보다 작으면 검색결과가 없다는 뜻.
		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			pb[index].showInfo();
		}
		
		
	}
	
	//친구정보를 이름기준으로 검색 후 정보를 삭제하는 메서드
	//1. 삭제하고자하는 친구의 이름 사용자로부터 받는다.
	//2. 배열에서 친구의 이름을 비교 검색 -> index 값을 찾기
	//3. 데이터를 삭제 : 배열의 요소에서 삭제하고자하는 객체를 참조하지 않으면 삭제와 동일하다.
	// : 배열이 가지고 있는 참조값을 참조하지않으면 다룰 수 없기 때문에 삭제와 동일하다.
	// : ex)pd[3] 삭제 > pd[3] = null; 로 설정을하면 참조할 대상이 사라지기 때문에 삭제와 동일하다.
	//4. 배열의 삭제 index 기준으로 <--- 이쪽 방향으로 시프트
	// : ex)pd[3]삭제가 된다면 -> pd[3] = pd[4]; pd[4] = pd[5];
	// : 3번째 인덱스에 4번째 인덱스 값을 넣으면 인덱스4값으로 대체가 되기때문에 삭제기능을 한다.
	public void serchDelete() {
		
		System.out.println("사용자가 입력한 명령은 삭제입니다.");
		
		System.out.print("삭제할 친구의 이름을 입력 : ");
		String name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		
		//데이터를 찾은 후 index값을 비교하여 값이 있으면 삭제, 없으면 데이터가없다고 출력
		if(index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {
			//삭제 : 시프트 역할
			//검색한 index 부터 저장된 위치까지 왼쪽으로 시프트 처리(값을 덮음)
			for(int i=index; i<cnt-1; i++) {
				pb[i] = pb[i+1];
			}
			
			//저장된 친구 정보의 개수 감소
			cnt--;
			
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
	}

	

	//이름을 받아와 배열에 등록된 name과 받아온 name과 일치하는게 있는지 비교하는 메서드
	//키워드로 배열의 요소, name문자열과 비교 후 매칭되는 요소의 index를 반환
	public int searchIndex(String keyword) {
		// 찾고자하는 인덱스 변수정의
		// 검색 결과의 index : -1 (검색의 결과가 없다)
		int index = -1; // 검색의 결과가 없다는 뜻의 defaul값은 -1로 초기화해준다.

		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능
		for (int i = 0; i < cnt; i++) {
			// 배열에 있는 name과 입력받은 name과 같은지 비교해 값이 있으면 index에 값을 저장
			if (pb[i].name.equals(keyword)) {
				index = i;
				break;
			}
		}
		return index;
	}
	

	
	public int printMenu() {

		// 최조 사용자가 입력하는 메뉴 (무슨 메뉴를 선택했는지 데이터를 가져오는 역할)
		System.out.println("=====================================");
		System.out.println("	   메뉴번호를 선택해 주세요.");
		//System.out.printf(Util.INSERT+".입력\n2.검색\n3.삭제\n4.전체 정보출력\n5.종료");
		System.out.printf("%d.입력\n%d.검색\n%d.삭제\n%d.전체 정보출력\n%d.종료",Util.INSERT,Util.SEARCH,Util.DELETE,Util.ALLDATA,Util.QUIT);
		System.out.println("\n=====================================");

		// Util에 저장된 키보드를 가져와서 입력을 받는다
		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine();//현재 라인의 버퍼를 출력(clear)
		
		return choice;
	}
}
