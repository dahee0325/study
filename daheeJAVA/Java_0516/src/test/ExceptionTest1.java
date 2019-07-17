package test;

public class ExceptionTest1 {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 0;
		
		try {
			System.out.println("num1 / num2 = "+num1/num2);
			System.out.println("연산이 완료되었습니다.");
			//method1();
			
		}catch (ArithmeticException e) {
			System.out.println("0으로 나누어서 예외가 발생했습니다.");
			System.out.println(e.getMessage());
			//오류단계 출력해줌 첫줄이 제일 먼저 오류가 발생한것
			e.printStackTrace(); 
			
		}catch (Exception e) {
			System.out.println("특정 예외가 발생했습니다. 다시 연산해주세요.");
			
		}

	}

	
	static void method1() {
		method2();
	}
	
	static void method2() {
		int a = 10/0;
	}
}
