package marblePlay;

public class Boy {
	
	//속성 = 변수
	//구슬의 개수
	int mNum; //구슬의 개수를 저장
	//플레이어 이름 지정할 수 있는 참조형 변수
	String pName;
	
	//생성자 : 초기화메소드, 인스턴스 생성시에 반드시 한번 실행한다.
	//특징 : 반환형없음, 실행이 목적이기때문에 반환형을 써주지 않음, 매개변수 정의 가능하다.
	//비어있는 생성자는 생략해도 자동으로 생성되어 실행된다.
	//밑에처럼 생성자를 생성하면 직접참조가 가능하다.
	Boy(String name,int num) {
		pName = name;
		mNum = num;
	}
	
	
	//게임 승리 : 게임에 이기면 자신의 구슬을 증가시키고 상대 구슬을 감소시키면 돼서 반환값없어도됨
	//int mNum 이라는 매개변수는 게임을 이겼을때 증가시킬 구슬의 개수 (지역변수)
	//this.mNum은 전역변수인 맨위의 mNum을 사용하기위해 mNum 변수명앞에 this로 표현해준다.
	//Boy boy는 누구와 누구가 처리가되는지 정의하기위한 매개변수
	void gameWin(int mNum, Boy boy) {
		//this.mNum += mNum;
		win(mNum);
		boy.lose(mNum);
	}
	
	
	//구슬의 증가를 처리하는 메소드
	void win(int num) {
		mNum += num;
	}
	//구슬의 감소를 처리하는 메소드
	void lose(int num) {
		mNum -= num;
	}
	
	//어린이들의 구슬 현황을 출력하는 메소드
	void showNumber() {
		System.out.println(pName + "의 구슬의 개수는" + mNum + "개 입니다.");
	}
}

