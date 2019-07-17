package classtest;

public class Number {
	//number클래스는 실행이 목적이아니라 값을 증가해주고, 기능을 넣기 위한 클래스기 때문에 메인메소드가 필요없다
	
	//Number number라는 참조변수 생성가능
	Number number;// number = null;
	
	//인스턴스 변수 선언 영역
	//정수형 데이터를 저장하기 위한 변수
	int num; //int num = 0; 와 같다 인스턴스 변수경우에는 자동초기화가가능 (해당 데이터 타입의 기본값으로)
	
	
	//증가시켜주는 기능을 만들어주는 메소드 생성(값을 전달받아 인스턴스 변수 num에 값을 더한다.)
	//정수데이터를 받아서 int num 변수를 증가시키는 변수가 필요 - int n
	void addNum(int n) {
		num = num + n; //num+=n; 과 같다.
	}
	
	//반환해야하니까 반환값 정의
	//매개변수 필요X
	int getNum() {
		return num;
	}
}
