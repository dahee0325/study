package arr;

import java.util.Scanner;

public class ArrValueMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrValue arrV = new ArrValue();
		
		int[] arr = new int[5];
		
		for(int i=0; i < arr.length; i++) {
			System.out.print("배열 "+(i+1)+"번째 정수 입력 : ");
			arr[i] = sc.nextInt();
		}

		System.out.println("최대값 :" + arrV.maxValue(arr));
		System.out.println("최소값 :" + arrV.miniValue(arr));

	}

}
