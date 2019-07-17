package methodtest;

public class Test {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			if (test(i)) {
				System.out.println(i);
			}
		}
	}

	//int a = 매개변수 :숫자하나를 받음
	static boolean test(int a) {
		
		//1,2 는 무조건 소수.. 구간간의 숫자가 없기 때문에 2보다 높은 숫자로 비교해야한다.
		if (a > 2) {
			for (int i = 2; i < a; i++) {
				if (a % i == 0)
					return false;
			}
		}

		return true;
	}

}
