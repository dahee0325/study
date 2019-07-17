package aaa;

//public이 아닌default로 지정한다면 다른 패키지에서 사용 불가능하다. (참조 X)
public class AAA {

	//클래스 내부에서만 사용가능한 num
	private int num;
	
	//내부에서는 내부호출 가능
	AAA a = new AAA();
	
	AAA() {
		
	}
	
	
	void printNum() {
		System.out.println(num);
	}
}
