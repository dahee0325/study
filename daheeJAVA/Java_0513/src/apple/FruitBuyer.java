package apple;

public class FruitBuyer {
	
	//private를 통한 변수 보호(직접참조를 통해 수정이 불가능하도록 만들음)
	private int myMoney;
	private int numOfApple;

	
	public FruitBuyer(int money) {
		myMoney = money;
		numOfApple = 0; //최조보유 개수는 0으로 처리 초기화 처리는 했지만 명시적으로 정의
	}

	//매개변수 없을 때는 직접 금액을 초기화하면서 정의
	FruitBuyer() {
		myMoney = 5000;
	}
	
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}

	public void showBuyResult() {
		System.out.println("현재 잔액: " + myMoney);
		System.out.println("사과 개수: " + numOfApple);
	}
	
}
