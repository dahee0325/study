package product;

public class Buyer {

	
	int money = 1000;
	int bonusPoint = 0;
	
	//사는사람 입장
	//무엇을 사는지 지정이 필요해서 Product p 라는 매개변수를 받아온다
	void buy(Product p) {//컴퓨터, Tv, 오디오를 불러올수있다.
		
		
		if(money >= p.price){ 
			 money -= p.price;
			 bonusPoint += p.bonusPoint;
			 System.out.println(p+"를(을) 구입하셨습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		
		
		/*
		 * //내 돈이 제품의 가격보다 적다면 
		 * if(money < p.price) {
		 * System.out.println("잔액이 부족으로 구매할 수 없습니다."); 
		 * return;//메소드 종료 
		 * }
		 * 
		 * money -= p.price; //제품의 가격만큼 돈을 뺀
		 * bonusPoint += p.bonusPoint; //보너스포인트에 제품에따라 보너스포인트가 들어오게한다.
		 * System.out.println(p+"을/를 구입하셨습니다.");
		 */
		
		
		/*
		 * if(!(money < p.price)){ 
		 * money -= p.price;
		 * bonusPoint += p.bonusPoint;
		 * System.out.println(p+"을/를 구입하셨습니다.");
		 * }
		 */
		
	}
}
