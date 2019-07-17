package aaa;

public class aaaMain {

	public static void main(String[] args) {
		
		//같은패키지라 인스턴스 생성은 가능 
		//( AAA.java 에서 pivate로 막는다면 같은 패키지라도 인스턴스생성은 불가능하다)
		AAA a = new AAA();
		
		//a.num; 은 직접참조 불가능 (수정X)
		
		a.printNum();;

	}

}
