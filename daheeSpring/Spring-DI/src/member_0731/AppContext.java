package member_0731;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//XML 설정 없이도 자바 코드를 이용해서 생성할 빈 객체와 각 빈간의 의존 관계 설정할 수 있음
//@Configuration : 빈 설정 메타 정보를 담고 있는 클래스가 된다
@Configuration 
//@Import() : 다른클래스를 추가할때사용 ex)appCtx3.xml
public class AppContext {
	
	//여기서 주입을 바로하고 반환가능 (ex 생성자나 setter 를 사용할때)
	//@Autowired
	//MemberDao dao;
	
	//@Bean : 새로운 빈 객체를 제공할 때 사용
	//name을 통해 Bean id 를 지정
	@Bean(name = "memberDao")
	//같은타입이더라도 식별해주기 위한 이름을 줌
	//@Scope("prototype")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	//id지정을 따로하지않으면 getBoardDao 라는 이름으로 들어감
	@Bean(name = "boardDao")
	public BoardDao getBoardDao() {
		return new BoardDao();
	}
	
	
	@Bean(name = "registService2")
	public MemberRegisterService2 getMemberRegisterService2() {
		
		//@Autowired 를통한 자동주입이 됨 ( 생성자와 setter 필요없음)
		MemberRegisterService2 service = new MemberRegisterService2();
		
		//setter 를 통한 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		
		//생성자를 통한 주입
		//return new MemberRegisterService2(getMemberDao());
	}
	
	
	@Bean(name = "changePwService2")
	public ChangePasswordService2  getChangePasswordService2() {
		
		ChangePasswordService2 service = new ChangePasswordService2();
		
		//service.setMemberDao(getMemberDao());
		
		return service;
		
		//return new ChangePasswordService2(getMemberDao());
	}
	
}
