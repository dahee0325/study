package ex;

public class FruitBuyer {
	
	int myMoney;
	int numOfApple;

	
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
