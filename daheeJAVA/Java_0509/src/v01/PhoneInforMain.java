package v01;

public class PhoneInforMain {

	public static void main(String[] args) {
		
		PhoneInfor user1 = new PhoneInfor("유저1", "010-0000-4444","3월25일");
		PhoneInfor user2 = new PhoneInfor("유저2", "010-2222-7777","9월07일");
		PhoneInfor user3 = new PhoneInfor("유저3", "010-1111-4444");
		
		
		System.out.println("=======전화번호부======");
		System.out.println();
		user1.showInfo();
		System.out.println();
		user2.showInfo();
		System.out.println();
		user3.showInfo();

	}

}
