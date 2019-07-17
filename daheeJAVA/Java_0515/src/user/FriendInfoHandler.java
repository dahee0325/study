package user;

import util.Util;

public class FriendInfoHandler {

	private Friend[] myFriends;
	private int numOfFriends;

	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}

	private void addFriendInfo(Friend fren) {
		myFriends[numOfFriends++] = fren;
	}

	public void addFriend(int choice) {
		String name, phoneNum, addr, job, major;
		System.out.print("이름 : ");
		name = Util.keyboard.nextLine();
		System.out.print("전화 : ");
		phoneNum = Util.keyboard.nextLine();
		System.out.print("주소 : ");
		addr = Util.keyboard.nextLine();
		if (choice == 1) {
			System.out.print("직업 : ");
			job = Util.keyboard.nextLine();
			addFriendInfo(new HighFriend(name, phoneNum, addr, job));
		} else {
			System.out.print("학과 : ");
			major = Util.keyboard.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNum, addr, major));
		}
		System.out.println("입력 완료! \n");
	}

	public void showAllData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showData();
			System.out.println("");
		}
	}

	public void showAllSimpleData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("");
		}
	}
}
