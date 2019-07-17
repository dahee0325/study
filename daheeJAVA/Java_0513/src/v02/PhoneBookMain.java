package v02;

import java.util.Scanner;

import util.Util;

public class PhoneBookMain {

	/*
	 * static Scanner keyboard = new Scanner(System.in);
	 * 대신 Util.java에 있는 keyboard를 import해서 가져올 수 있다 public을 통해
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		
		/* 1. 프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
		 * 2. 단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
		 * 3. 프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐. (종료는 return사용 : 메소드의 종료는 리턴으로 종료가능)*/
		
		//java.util.Scanner kyboard; 는 import를 하지않아도 사용할 수 있다
		//입력 스캐너 생성
		
	
		//Manager.java 의 인스턴스 생성이 가능해짐
		Manager manager = Manager.getinstance();
		
		
		while(true) {
			
			System.out.println("==================================");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 입력     2. 프로그램종료");
			System.out.println("==================================");
			
			int choice = Util.keyboard.nextInt();
			
			if(choice == 1) {
				
				//입력받는 메서드
				manager.insertMember();
				
				
			}else if(choice == 2) {
				
				//프로그램 종료하기 위해 return을 사용
				System.out.println("프로그램을 종료합니다.");
				//return이 아닌 break도 가능
				return;//메인 메소드 종료 -> 프로그램의 종료
				
			}else {
				
				System.out.println("정상적인 메뉴번호를 입력해주세요.");	
				
			}
			
		}
		
	}
	


}
