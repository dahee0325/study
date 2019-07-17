package tirangle;

public class TriangleMain {

	public static void main(String[] args) {
		
		/* 주소값 저장을 위한 참조변수 선언 및 객체(인스턴스)생성
		 * Triangle tri;
		 * tri = new Triangle();
		 * 도 가능 */
		Triangle tri = new Triangle();
		
		//밑변과 높이 정보 가져와서 변경 : 데이터설정
		tri.setData(2.5f,6.5f);
		
		//출력
		System.out.println("높이 : "+ tri.hight + "cm");
		System.out.println("밑변 : "+ tri.width + "cm");
		System.out.println("삼각형 넓이 : "+ tri.calArea() +"cm");

	}

}
