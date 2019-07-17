package constructor;

public class Number {
	
	int num;
	
	//생성자 선언
	Number() {
		num=10;
		System.out.println("생성자 호출");
	}
	
	int getNum() {
		
		return num;
		
	}
	
	public static void main(String[] args) {
		
		//인스턴스생성하여 생성자 호출
		Number number = new Number();//new Number() 가 생성자를 호출
		System.out.println(number.getNum());
		
		Number number1 = new Number();
		System.out.println(number1.getNum());
		
	}
}
