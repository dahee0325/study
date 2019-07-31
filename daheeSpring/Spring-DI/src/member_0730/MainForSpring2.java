package member_0730;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring2 {

	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");

	public static void main(String[] args) {

		// scope 을 통한 객체 생성에 차이 비교
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("");
		MemberRegisterService registerService1 = ctx.getBean("registService", MemberRegisterService.class);
		MemberRegisterService registerService2 = ctx.getBean("registService", MemberRegisterService.class);

		// 참조변수 비교 : 참조주소값을 비교, 같은객체인지 확인 (싱글톤 처리가된다면 true)
		boolean chk = registerService1 == registerService2;

		System.out.println("registerService1 == registerService2 : " + chk);
		System.out.println("======================================================");
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("MemberRegisterService");

		// scope 은 요청할때마다 새로운 객체를 생성해 주기때문에 주소값이 다름 false
		ChangePasswordService passwordService1 = ctx.getBean("changePasswordService", ChangePasswordService.class);
		ChangePasswordService passwordService2 = ctx.getBean("changePasswordService", ChangePasswordService.class);

		chk = passwordService1 == passwordService2;
		System.out.println("passwordService1 == passwordService2 : " + chk);

	}

}
