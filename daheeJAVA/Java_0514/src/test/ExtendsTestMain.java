package test;

public class ExtendsTestMain {

	public static void main(String[] args) {


		//인스턴스 생성
		BusinessMan bMan = new BusinessMan("다희","집","백수");
		
		//bMan.name = "다희";
		bMan.tellYourName();
		bMan.tellYourInfor();

		Man man = new Man("tester");
		
	}

}
