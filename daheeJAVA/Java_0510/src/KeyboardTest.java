import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 : ");
		int num3 = sc.nextInt();
		
		int sum = num1+num2+num3;
		
		System.out.printf("입력된 정수 %d,%d,%d 의 합은 %d 이다.",num1,num2,num3,sum);

	}

}
