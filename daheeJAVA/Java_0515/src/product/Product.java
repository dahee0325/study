package product;

public class Product {
	
	int price;//가격
	int bonusPoint;//상품사면 올라가는 포인트
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0f);
	}

	
}

class Tv extends Product {
	
	Tv() {
		//상위 생성자 price 매개변수에 100 전달
		super(100); //Tv가격은 100만원
	}
	
	
	//@Override 어노테이션 : 추가적으로 의미부여해준다.
	@Override
	public String toString() {
		//return super.toString();//Object가 가지고있던 toString가져옴
		return "Tv";
	}
}


class Computer extends Product {

	Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}


class Audio extends Product {

	Audio() {
		super(50);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}


