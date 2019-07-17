package dateShare.Model;

import java.util.Date;

public class Message {
	
	private int u_num; 		  //보낸사람 회원번호
	private String m_to; 	  //받는사람
	private String m_title;   //쪽지제목
	private String m_content; //쪽지내용
	private Date m_writedate; //보낸시간
	
	
	
	public String getM_to() {
		return m_to;
	}
	public void setM_to(String m_to) {
		this.m_to = m_to;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public Date getM_writedate() {
		return m_writedate;
	}
	public void setM_writedate(Date m_writedate) {
		this.m_writedate = m_writedate;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	
	
	
	
}
