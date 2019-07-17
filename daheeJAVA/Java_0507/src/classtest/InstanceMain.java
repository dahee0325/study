package classtest;

public class InstanceMain {

	//Number.java에 있는 기능을 사용하기 위해서는 메인메소드에서 Number.java에 있는 메소드를 호출해서 사용해야한다.
	public static void main(String[] args) {
		
		//참조변수를 선언하고 null값으로 초기화했다.
		Number nInst = null;//초기화해줌
		
		//참조변수에 참조값을 대입하여 인스턴스를 생성함
		//인스턴스를 만들기 위해 참조값을 넣어줌
		//변수 생성, 메서드의 코드가 메모리에 로드된다. -> 인스턴스 생성
		nInst = new Number();//1.nInst에 0x100대입 
		
		//직접변수를 참조하는 (참조변수)nInst.(Number.java에 있는 직접참조 변수를 가져옴)num -> Number.java에서 초기화한 0을 가져옴
		System.out.println("인스턴스의 메소드 호출전 : num의 값 -> " + nInst.num);//2.nInst에 0x100대입
		
		//num의 값을 가져올 수 있는 메소드인 getNum()
		System.out.println("인스턴스의 메소드 호출전 : num의 값 -> " + nInst.getNum());//3.nInst에 0x100대입
		
		//nInst라는 참조값을 전달
		simpleMethod(nInst);//5.
		System.out.println("인스턴스의 addNum메서드 실행 후 : num의 값 -> " + nInst.getNum());
	}


	//반환하지는않지만 참조변수를 전달 받아 인스턴스의 메소드를 호출해서 값을 증가시킨다.
	//Number number라는 참조변수는 simpleMethod() 메소드안에서만 사용된다.
	static void simpleMethod(Number number) {
		
		//4.number에 있는 초기값을 10으로 바꿔줌
		number.addNum(10);
		
	}
}
