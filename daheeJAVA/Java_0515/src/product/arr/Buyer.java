package product.arr;

public class Buyer {

	
	int money = 1000;
	int bonusPoint = 0;
	
	//제품을 담을 배열을 생성
	Product[] cart = new Product[10];
	int cartCnt;//카트에 몇개의 제품이들어가있는지에 대한 인덱스역할
	
	//사는사람 입장
	//무엇을 사는지 지정이 필요해서 Product p 라는 매개변수를 받아온다
	void buy(Product p) {//컴퓨터, Tv, 오디오를 불러올수있다.
		
		
		if(money >= p.price){ 
			 money -= p.price;
			 bonusPoint += p.bonusPoint;
			 
			 //카드에 제품을 담은 후 Cnt증가
			 cart[cartCnt++] = p;//p는 컴퓨터,Tv,오디오 일수도있다
			 
			/* cart[cartCnt++] = p; 
			   cartCnt++;//카드에 제품을 담은 후 cart인덱스값을 증가시켜준다. (제품 하나담을때마다 1증가)
			 */
			 
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
	
	
	
	void summary() {
		
		//얼마나 돈을 사용했는지
		int sum = 0;
		String itemList = "";
		
		for(int i=0; i<cartCnt; i++) {

			sum += cart[i].price;
			itemList += cart[i]+"\n";//toString메서드 호출이되고 문자열끼리 +연산이됨
		}
		
		System.out.println("구입하신 제품들의 총 구매액은 "+ sum +"만원 입니다.");
		System.out.println("\n구입하신 제품의 목록은 \n"+ itemList +"입니다.\n");
	}

}
