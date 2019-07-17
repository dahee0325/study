package v07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import util.Menu;
import util.Util;

public class UserInfoManager {

	/*
	final TreeMap<String, UserInfo> userinfo = new TreeMap<String, UserInfo>();
	
	
	//싱글톤 패턴
	public static UserInfoManager getInstance() {
		
		if(m == null) {
			m = new UserInfoManager();
		}
		return m;
	}
	
	
	private static UserInfoManager m = new UserInfoManager();
	
	
	
	//메인메뉴 출력
	public int printMainMenu() {

		//메인메뉴
		System.out.println("=====================================");
		System.out.println("	      Main Menu");
		System.out.printf("%d.로그인\n%d.회원가입\n%d.전체보기\n%d.종료하기",Menu.LOGIN,Menu.MEMBER,Menu.ALLDATA,Menu.QUIT);
		System.out.println("\n=====================================");

		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine();//현재 라인의 버퍼를 출력(clear)
		
		return choice;
	}
	
	public void allMamber() {
		
		NavigableSet<String> navi = userinfo.navigableKeySet();
		Iterator<String> itr=navi.iterator();
		while (itr.hasNext()) {
			System.out.println(userinfo.get(itr.next()));
		}
	}
	
	//로그인
	public void login() {

		System.out.print("아이디   : ");
		String id = Util.keyboard.nextLine();
		System.out.print("비밀번호 : ");
		String pw = Util.keyboard.nextLine();
		
		int idIndex = idIndex(id);
		
		if (idIndex < 0) {
			System.out.println("회원가입 정보가 존재하지않습니다.\n회원가입해주세요.");
			printMainMenu();
		} else {
			for (int i = 0; i < userinfo.size(); i++) {
				if (userinfo.get(i).getId().equals(id) && userinfo.get(idIndex).getPassword().equals(pw)) {
					System.out.println("로그인되었습니다.");
					System.out.println(id + "(" + userinfo.get(i).getNickname() + ")" + "님 환영합니다.");
					break;
				}
				else {
					System.out.println("아이디와 비밀번호를 확인해주세요.");
					login();
				}
			}
		}
	}
	
	
	//회원가입
	public void joinMember() {
		
		UserInfo ui = null;
		

		System.out.println("아이디를 입력해주세요.");
		String id = Util.keyboard.nextLine();

		int idIndex = idIndex(id);

		if (idIndex < 0) {

			System.out.println("비밀번호를 입력해주세요.");
			String pw = Util.keyboard.nextLine();

			System.out.println("닉네임을 입력해주세요.");
			String nName = Util.keyboard.nextLine();
			ui = new UserInfo(id, pw, nName);
			userinfo.put(id, ui);

			System.out.println(id + "(" + nName + ")" + "님 회원가입이 완료되었습니다.");

		} else {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			joinMember();
		}
		
	}
	
	
    public void regMem(UserInfo ui){       
    	userinfo.put(ui.getId(),ui);      
    }
   
    public void regMem(String id, String pw,String nName){     
    	userinfo.put(id, new UserInfo(id, pw, nName));      
    }

	
	//입력된  id와 같은 인덱스 값 찾기
	public int idIndex(String idKeyword) {

		int index = -1; 

		for (int i = 0; i < userinfo.size(); i++) {
			if (userinfo.get(i).getId().equals(idKeyword)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	//입력된  pw와 같은 인덱스 값 찾기
		public int pwIndex(String pwKeyword) {

			int index = -1; 

			for (int i = 0; i < userinfo.size(); i++) {
				if (userinfo.get(i).getPassword().equals(pwKeyword)) {
					index = i;
					break;
				}
			}
			return index;
		}
	
	
	//회원수정
	public void updateInfo() {
		
	}
	
	
	//로그아웃
	public void logout() {
		
	}
	
	
	//회원탈퇴
	public void deleteMember() {
		
	}
	*/
}
