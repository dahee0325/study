package first;

import java.util.Scanner;

public class Hellojava {

	public static void main(String[] args) {
		
		//문제1.
		System.out.println("2+5="+2+5);
		System.out.println("2+5="+(2+5));
		
		//문제2.
		int i=0;
		while(i < 5)
		{
			int num = 15;
			System.out.println(num);
			i+=1;
		}
		
		System.out.println(7);
		System.out.println(3.15);
		System.out.println("3+5=" + 8);
		System.out.println(3.15 + "는 실수입니다.");
		System.out.println("3+5" + "의 연산결과는 8입니다.");
		System.out.println(3+5);
		
		
		System.out.println("------------");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 : ");
		int num = sc.nextInt();
		
		if(num%2 == 0)
		{
			System.out.println("짝수입니다.");
		}
		else if(num%2 == 1)
		{
			System.out.println("홀수입니다.");
		}
		else
		{
			System.out.println("숫자를 입력해주세요.");
		}
	}

}
