package test;

//Object class 명시되어있지는 않지만 상속하고있다. 
public class Man {
	
	String name;
	
	public void tellYourName() {
		
		System.out.println("나의 이름은 "+name+"입니다.");
	}
	
	//상위클래스에 생성자가 정의되었다면 하위클래스에도 정의되어야한다.
	//생성자
	//name - 초기화
	public Man(String name) {
		this.name = name;
	}
	
	/* default값을 지정
	 * public Man() {
	 *  this.name = "name"; 
	 *  }
	 */
}
