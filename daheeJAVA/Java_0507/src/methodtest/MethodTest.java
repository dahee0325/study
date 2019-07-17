package methodtest;

//class 는 메모리에 올려서 사용 = 객체
public class MethodTest {

	// static 프로그램을 시작하려면 반드시 필요한 키워드, 없으면 실행 불가능
	public static void main(String[] args) {
	//위에서 아래로 실행
		
		System.out.println("프로그램 시작");
		
		//1.밑에 메소드 호출하여 2.메소드 안의 기능실행 후 3.호출한 쪽의 세미콜론을 만나 한 구문 종료
		//만약 2번 메소드안의 기능에서 반환값이 없으면 그냥 돌아오고 반환값이있으면 갖고 돌아온다.
		hiEveryone(12);
		hiEveryone(13);
		
		System.out.println("프로그램 종료");
	}

	// static : 키워드, 코드 자체들을 프로그램시작시에 메모리에 저장하게 해줌 그래서 static사용시 new 키워드를 사용하여
	// 정의해주지않아도 프로그램 구동가능
	
	// int age : 나이값을 받아서 출력하기 위한 변수
	static void hiEveryone(int age) {

		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는" + age + "세 입니다.");

	}
}
