package ex;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] score = new int[10];

		for (int i = 0; i < score.length; i++) {

			score[i] = score[sc.nextInt()];

		}
		
		System.out.println("최대값 : "+ maxValue(score));
		System.out.println("최소값 : "+ miniValue(score));

	}

	public static int miniValue(int[] arr) {
		
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	} // 최소값 반환

	public static int maxValue(int[] arr) {

		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		} // 최대값 반환
		return max;
	}

}