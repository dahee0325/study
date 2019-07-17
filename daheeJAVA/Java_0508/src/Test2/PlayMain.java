package Test2;

public class PlayMain {

	public static void main(String[] args) {
		
		Play play = new Play();
		
		play.chMarble1 = 15;
		play.chMarble2 = 9;
		
		System.out.println("1차 게임에서 어린이1은 어린이2의 구슬 2개를 획득한다");
		play.ch1Win(2);
		play.marblePrint();
		System.out.println("2차 게임에서 어린이2은 어린이1의 구슬 7개를 획득한다.");
		play.ch2Win(7);
		play.marblePrint();
		
	}

}
