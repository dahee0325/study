package generic.test;

public class FruiBoxTest {

	public static void main(String[] args) {
		
		//generic 타입 Apple
		FruitBox<Apple> fb1 = new FruitBox<Apple>(new Apple(100));
		//생성자 호출
		//밑에 두줄 소스를 FruitBox<Apple> fb1 = new FruitBox<Apple>(new Apple(100)); 로 줄일 수 있음
		//FruitBox<Apple> fb1 = new FruitBox<Apple>();
		//fb1.store(new Apple(100));
		Apple apple = fb1.pullOut();
		apple.showAppleWeight();
		
		
		FruitBox<Orange> fb2 = new FruitBox<Orange>(new Orange(10));
		//FruitBox<Orange> fb2 = new FruitBox<Orange>();
		//generic타입으로 정의 해놓은 타입으로만 받아올 수 있다.
		//fb2.store(new Orange(10));
		Orange orange = fb2.pullOut();
		orange.showSugarContent();
		
		
	}

}
