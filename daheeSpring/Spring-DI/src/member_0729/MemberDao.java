package member_0729;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	//데이터를 저장, 중복되지않는 아이디를 저장처리
	private static long nextId=0;
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email) {
		
		//value가 member객체 타입이기 때문에 get으로 Member객체 반환이 가능하다
		return map.get(email);
	}
	
	public void insert(Member member) {
		//값을 증가시키고 setId에 값을 저장
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		//service 클래스에서 전달받아서 저장할거
		map.put(member.getEmail(), member);	
	}
	
	public Collection<Member> selectAll() {
		
		//collection 그대로 반환해서 정렬해줌
		return map.values();
	}
	
}