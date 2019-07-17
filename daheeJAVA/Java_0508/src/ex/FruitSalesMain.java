package ex;

public class FruitSalesMain {

	public static void main(String[] args) {
		
		//사과 장수 등록
		FruitSeller seller1 = new FruitSeller(0, 10, 1500);
		FruitSeller seller2 = new FruitSeller(0, 20, 1000);
		
		//구매자 등록
		FruitBuyer buyer1 = new FruitBuyer();
		FruitBuyer buyer2 = new FruitBuyer(10000);
		
		buyer1.buyApple(seller1, 3000);
		buyer1.buyApple(seller2, 1000);
		buyer2.buyApple(seller1, 4500);
		buyer2.buyApple(seller2, 2000);
		
		System.out.println("과일 판매자1의 현재 상황");
		seller1.showSaleResult();
		System.out.println("과일 판매자2의 현재 상황");
		seller2.showSaleResult();
		
		System.out.println("===========================");
		
		System.out.println("과일 구매자1의 현재 상황");
		buyer1.showBuyResult();
		System.out.println("과일 구매자2의 현재 상황");
		buyer2.showBuyResult();

	}

}
