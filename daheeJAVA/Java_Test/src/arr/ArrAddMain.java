package arr;

import java.util.Scanner;

public class ArrAddMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrAdd arradd = new ArrAdd();

		int[][] arr={
				{1, 2},
				{3, 4, 5},
				{6, 7, 8, 9}
				};

		  
		System.out.print("배열에 더할 정수 입력 : ");
		int add = sc.nextInt();
		
		arradd.addOneDArr(arr, add);
		arradd.addPrint(arr);
		

	}

}
