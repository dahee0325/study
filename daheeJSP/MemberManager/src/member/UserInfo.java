package member;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfo {
	
	private String id;
	private String pw;
	private String name;
	private String photo;
	private Date regDate;


	public UserInfo() {
		this.regDate = new Date();
	}

	
	public UserInfo(String id, String pw, String name, String photo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regDate = new Date();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void Date(Date regDate) {
		this.regDate = regDate;
	}

	// 화면 결과 출력을 위한 HTML 코드 반환
		public String makeHtmlDiv() {
			String str = "";
			
			str += "<div class=\"mInfor\"> \n";
			str += "	<h3> \n";
			str += "		" + id + "("+ name +")\n";
			str += "	</h3> \n";
			str += "	<p> \n";
			str += "		"+ pw;
			str += "	</p> \n";
			str += "</div> \n";
			
			
			
			return str;
		}
		

	//MemberInfo 객체에서 LoginInfo 객체를 반환
	public LoginInfo toLoginInfo() {
		
		//인스턴스 생성 후 반환
		return new LoginInfo(id, name, photo, regDate);
	}


	
}