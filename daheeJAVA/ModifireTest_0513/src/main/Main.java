package main;

import aaa.AAA;

public class Main {

	public static void main(String[] args) {

		//인스턴스 생성 (생성자 범위가 default면 인스턴스 생성이 불가능하다)
		AAA a =new AAA();
		
		/* num은 private(같은 클래스 내에서 사용) , printNum() 은 default(패키지내에서 사용)
		 * a.num; 
		 * a.printNum();
		 */

	}

}
