package arr;

public class ArrChange {

	public void changeArr(int[][] arr) {
		
		//비어있는 1차원배열 정의. 초기화(arr.length-1 : 배열의 마지막요소 저장)
		int[] temp = arr[arr.length-1];
		//arr[0]은 arr[1]로 arr[1]은 arr[2]로 쉬프트하는역할
		for(int i=arr.length-1 ; i>=1; i--) {
			
			arr[i] = arr[i-1];
		}
		//temp에 옮겼던 마지막값을 arr[0]번째에 다시 옮김
		arr[0] = temp;
	}
	
	public void arrPring(int[][] arr) {
		for (int i = 0; i < arr.length * arr[0].length; i++) {
            int row = i / arr[0].length; // 행
            int column = i % arr[0].length; // 열
            System.out.print(arr[row][column] + "\t");
 
            if (column == arr[0].length - 1) {
                System.out.println();
            }
        }
	}
}
