package util;

import java.text.SimpleDateFormat;

public class SessionMember {

	private String id;
	private String pw;
	private String name;
	private String photo;
	private SimpleDateFormat date;
	
	
	public SessionMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	}
	
	public SessionMember(String id, String pw, String name, String photo, SimpleDateFormat date) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
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

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}
	
	
}
