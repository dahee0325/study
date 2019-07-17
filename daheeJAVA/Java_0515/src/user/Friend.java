package user;

public class Friend {

	String name;
	String phoneNum;
	String addr;

	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phoneNum = phone;
		this.addr = addr;
	}

	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("주소 : " + addr);
	}

	public void showBasicInfo() {
	}

}

class HighFriend extends Friend // 고교동창
{
	String work;

	public HighFriend(String name, String phone, String addr, String job) {
		super(name, phone, addr);
		work = job;
	}

	public void showData() {
		super.showData();
		System.out.println("직업 : " + work);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
	}
}

class UnivFriend extends Friend // 대학동기
{
	String major; // 전공학과

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}

	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("전공 : " + major);
	}
}




