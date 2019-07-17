package Test2;

public class Play {
	
	int chMarble1;// 어린이1 구슬 정보를 담는 변수
	int chMarble2;// 어린이2 구슬 정보를 담는 변수
	
	void ch1Win(int marble) {

		chMarble1 += marble;
		chMarble2 -= marble;
		
	}

	void ch2Win(int marble) {

		chMarble2 += marble;
		chMarble1 -= marble;
		
	}
	
	void marblePrint() {
		
		System.out.println("어린이1의 보유자산 : "+chMarble1);
		System.out.println("어린이2의 보유자산 : "+chMarble2);
		
	}


}
