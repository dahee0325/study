package arr;

public class ArrValue {

	public static int miniValue(int[] arr) { 
		
		int min = arr[0]; // 기준이되는 값을 정의한다
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		} // end of for
		
		return min;
		
	} // 최소값 반환

	public static int maxValue(int[] arr) {
		
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		} // end of for
		
		return max;
		
	} // 최대값 반환

}
