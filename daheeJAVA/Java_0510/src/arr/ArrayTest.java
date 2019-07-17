package arr;

public class ArrayTest {

	public static void main(String[] args) {
		
		//밑에도 arr변수가 있지만 지역변수기때문에 괜찮
		int[] arr = {1,2,3,4,5};
		int[] ref;
		
		ref = addAllArray(arr,7); //arr = 위에 배열의 숫자가 들어가있음
		
		//arr과 ref가 가진 주소값이 같은지 확인
		if(arr==ref) {
			
			System.out.println("같은 배열 참조");
			
		} else {
			
			System.out.println("다른 배열 참조");
			
		}//if end
		
		//같은 배열 참조하는지 배열의 요소확인
		System.out.println("=================================");
		System.out.println("\t arr배열의 요소 출력");
		for(int i=0; i<arr.length; i++) {
			//배열의 참조는 인덱스를 참조하기 때문에 인덱스 번호를 출력해준다.
			System.out.println(arr[i]);
		}
		
		System.out.println("=================================");
		System.out.println("\t ref배열의 요소 출력");
		for(int i=0; i<ref.length; i++) {
			System.out.println(ref[i]);
		}
	}
	
	
	//1.특정 int[]배열과 증가값을 받아서
	//2.배열의 각 요소에 값을 증가시키고
	//3.처리한 배열을 다시 반환하는 메서드 구성
	/*
	 * 1, 3번
	 * int[] addAllArray(int[] arr, int addNum) {
	 * 
	 * 
	 * return arr; 
	 * 
	 * }
	 */
	
	
	//main메소드가 static메소드기때문에 메인에서 불러오려면 static이 필요하다.
	static int[] addAllArray(int[] arr, int addNum) {
		
		//2. 배열의 각 요소의 값을 증가시키는 구문
		//배열의 인덱스는 0부터시작이기때문에 i=0
		for(int i=0; i<arr.length; i++) {
			//전달받은 숫자를 arr[i]번째에 더해줌
			arr[i] = arr[i] + addNum;
		}
		
		return arr;
	}

}
