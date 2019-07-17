package test;

public class StringTest1 {

	
	public static void main(String[] args) {
		
		// ""가 실행되면 인스턴스가 생성된다.
		String str1 = "My JAVA";
		String str2 = "My JAVA";
		String str3 = "Your JAVA";
		
		//문자열은 같지만 새로운 인스턴스 str4를 생성해줘서 참조하는 주소값이 다르다.
		String str4 = new String("My JAVA");
			
		
		//문자열의 내용을 비교할때는 equals() 를 사용한다.
		boolean strCheck = str1.equals(str4);
		if(strCheck) {
			System.out.println("문자열이 같다");
		} else {
			System.out.println("문자열이 다르다");
		}
		
		
		if(str1 == str2) {
			System.out.println("참조하는 주소값이 같다.");
		}
		else {
			System.out.println("참조하는 주소값이 다르다.");
		}
		
		if(str1==str3) {
			System.out.println("참조하는 주소값이 같다.");
		}
		else {
			//새로운객체가 생성됐다는 의미
			System.out.println("참조하는 주소값이 다르다.");
		}
		
		if(str1==str4) {
			System.out.println("참조하는 주소값이 같다.");
		}
		else {
			System.out.println("참조하는 주소값이 다르다.");
		}
	}
}
