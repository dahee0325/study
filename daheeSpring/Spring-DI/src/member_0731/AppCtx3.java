package member_0731;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//service, dao 클래스@Service, @Repository 를 찾아서 빈등록을 해줌
@ComponentScan(basePackages = "member_0731")
public class AppCtx3 {
	
}
