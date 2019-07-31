package member_0730;

public interface Dao {
	
	public Member selectByEmail(String email);

	public void update(Member member);

	public void insert(Member member);
}
