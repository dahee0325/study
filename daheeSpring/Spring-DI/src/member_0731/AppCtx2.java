package member_0731;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration 
public class AppCtx2 {
	
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
