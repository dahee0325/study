package web;

public class Member {

	private	String name;
	private String id;
	private String pNum;
	
	//public : 다른곳에서 인스턴스생성시 문제가 생기지않도록
	public Member(String name, String id, String pNum) {
		
		this.name = name;
		this.id = id;
		this.pNum = pNum;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public int getNum() {
		return 1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Member [name=" + name + ", id=" + id +", pNum =" + pNum + "]";
	}

	
}
