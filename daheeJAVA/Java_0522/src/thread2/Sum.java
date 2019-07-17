package thread2;

//값을 더해서 저장할 클래스
public class Sum {

	
	int num;
	
	public Sum() {
		num = 0;
	}
	
	void addNum(int n) {
		
		num += n;
	}
	
	//num의 값을 반환해주는 메서드
	
	//getter메서드 규칙 : get과 num(변수명)으로 맞춰준다.
	int getNum() {
		
		return num;
		
	}
}
