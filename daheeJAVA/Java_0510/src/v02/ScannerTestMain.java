package v02;
import java.util.Scanner;

public class ScannerTestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("======전화번호부 등록======");
		while(true) {
			System.out.println();
			System.out.println("이름, 전화번호, 생년월일 순으로 입력해주세요 ");
			ScannerTest user = new ScannerTest(sc.next(), sc.next(), sc.next());
			System.out.println("\n=====입력된 전화번호======");
			user.showInfo();

		}

	}

}
