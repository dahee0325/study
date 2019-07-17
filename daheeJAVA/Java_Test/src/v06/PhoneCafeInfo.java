package v06;

public class PhoneCafeInfo extends PhoneInfo{

	
	String nickName; //닉네임

	
	public PhoneCafeInfo(String name, String phoneNumber, String nickName) {
		
		super(name, phoneNumber);
		this.nickName = nickName;
		
	}
	
	
	@Override
	public void showData() {
		
		super.showData();
		
		System.out.println("닉 네 임 : " + nickName);
		
	}
	
	
	@Override
	public void showBasicInfo() {
		System.out.printf("동호회 회원 \"%s\"의 정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber +"입니다.");
		
	}
	
}
