package web;

public class LoginInfo {
	
	private String id;
	private String name;
	private String photo;
	private String nicname;
	private int grade;
	private String pNum;
	
	
	public LoginInfo(String id) {
		super();
		this.id = id;
		this.name = "다희";
		this.photo = "noimg";
		this.nicname = "DA";
		this.grade = 100;
		this.pNum = "000-0000-0000";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getNicname() {
		return nicname;
	}


	public void setNicname(String nicname) {
		this.nicname = nicname;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getpNum() {
		return pNum;
	}


	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
	
	
	
}