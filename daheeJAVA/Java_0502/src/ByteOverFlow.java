
public class ByteOverFlow {

	public static void main(String[] args) {
		
		byte b = 0;
		int i = 0;
		
		//0~270까지 반복 b와 i출력
		
		//for(시작 변수(값), 반복의 조건(식), 증가식(탈출의조건))
		for(int x=0; x <= 270; x++)
		{
			System.out.print(b++); //b = (byte)(b+1);
			System.out.print("\t");
			System.out.println(i++);

		}
		
		
		//출력 형태 : b		i
		//		   0	0
		//		   1	1
		//		   :	:
		//		 -128  270

		//byte는 원하는 값을 넣기에 저장공간이 작아서 -를 넘어 원하는 숫자가 아닌 14가 저장이된다.
		//그래서 원하는 숫자값을 넣을 수 있게 크기를 잘 정의해야한다.

	}

}
