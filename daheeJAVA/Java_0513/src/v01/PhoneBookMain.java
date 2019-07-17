package v01;

class PhoneBookMain {

	static void main(String[] args) {
		
		//친구의 데이터를 저장하고 출력하는 프로그램
		
		PhoneInfo pi1 = new PhoneInfo("혜원", "01099991111","19970907");
		PhoneInfo pi2 = new PhoneInfo("다혜", "01022221111");
		
		pi1.showInfo();
		System.out.println("===========================");
		pi2.showInfo();

	}

}
