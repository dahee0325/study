package test;

//extends 상속시 사용 오른쪽에 있는 클래스 이름이 상위(부모)클래스
public class BusinessMan extends Man{

	
	String company;
	String job;
	
	//하위 클래스(자손클래스) 생성자는 반드시 상위 클래스의 생성자를 호출해서 실행해야한다.
	//상위 클래스에서 생성자를 통한 초기화 과정이 있다면
	//하위 클래스에서 데이터를 받아서 상위 클래스에 생성자를 호출한다. 
	public BusinessMan(String name, String comName, String job) {
		
		/* default값 출력가능
		 * super(); */
		super(name);
		this.company = comName;
		this.job = job;
		
	}
	
	
	void tellYourInfor() {
		//출력
		tellYourName();
		System.out.println("나의 직장은 "+company+"입니다.");
		System.out.println("나의 직업은 "+job+"입니다.");
	}
	
	//name.tellYourName()

}
