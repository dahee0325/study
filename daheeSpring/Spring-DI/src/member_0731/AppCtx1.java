package member_0731;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//appCtx8.xml 의 <context:component-scan base-package="member"/> 과 같은 기능
//@ComponentScan(basePackages = "member")
public class AppCtx1 {
	
	@Bean(name = "memberDao")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
}
