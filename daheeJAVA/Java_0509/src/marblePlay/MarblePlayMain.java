package marblePlay;

public class MarblePlayMain {

	public static void main(String[] args) {
		/*
		 * 어린이1의 보유자산 : 구슬 15개
		 * 어린이2의 보유자산 : 구슬 9개
		 * 인스턴스 생성
		 */
		
		//서로 독립적인 존재인 아이1 아이2의 인스턴스를 생성
		/*생성자 호출을 통해 직접참조가 가능해서 플레이어 이름과 구슬개수를 바로 입력하여 값을 할당해준다.*/
		Boy boy1 = new Boy("혜원이",15); //어린이 1의 인스턴스생성 Boy(플레이어이름,구슬개수)를 통해서는 생성자가 호출된다.
		Boy boy2 = new Boy("다희",9); //어린이 2의 인스턴스
		
		//변수를 참조하여 구슬의 개수를 설정한다.
		//각 어린이에게 구슬개수를 할당해줌
		/*생성자 정의 후 필요없어진 코드
		boy1.mNum = 15;
		boy2.mNum = 9;
		*/
		
		
		//처음에 가지고 있는 각 어린이의 구슬의 개수를 출력
		System.out.println("============어린이들의 구슬현황=============");
		boy1.showNumber();//어린이1의 구슬현황
		boy2.showNumber();//어린이2의 구슬현황
		System.out.println();
		/*	게임플레이	*/
		
		//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다” -> 어린이1이 win 2개획득
		//어린이1이 게임에서 이겨 2개를 획득하고 boy2가 진다.
		System.out.println("===============첫번째게임================");
		boy1.gameWin(2, boy2);
		boy1.showNumber();
		boy2.showNumber();
		System.out.println();

		
		//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
		System.out.println("===============두번째게임================");
		boy2.gameWin(7, boy1);
		boy1.showNumber();
		boy2.showNumber();
	}

}
