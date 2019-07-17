package v04;

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
	
}
