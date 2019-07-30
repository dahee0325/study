package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring2 {

	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
	
	public static void main(String[] args) {
		
		//scope 을 통한 객체 생성에 차이 비교
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("");
		MemberRegisterService registerService1 = ctx.getBean("registService", MemberRegisterService.class);
		MemberRegisterService registerService2 = ctx.getBean("registService", MemberRegisterService.class);
		
		//참조변수 비교 : 참조주소값을 비교, 같은객체인지 확인 (싱글톤 처리가된다면 true)
		boolean chk = registerService1==registerService2;
		
		System.out.println("registerService1 == registerService2 : "+ chk);
		System.out.println("======================================================");
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("MemberRegisterService");
		
		// scope 은  요청할때마다 새로운 객체를 생성해 주기때문에 주소값이 다름 false
		ChangePasswordService passwordService1 = ctx.getBean("changePasswordService", ChangePasswordService.class);
		ChangePasswordService passwordService2 = ctx.getBean("changePasswordService", ChangePasswordService.class);
		
		chk = passwordService1==passwordService2;
		System.out.println("passwordService1 == passwordService2 : "+ chk);
		
	}

	
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		//MemberRegisterService service = assembler.getRegisterService();
		MemberRegisterService service = ctx.getBean("registService", MemberRegisterService.class);
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(arg[1]);
		request.setName(arg[2]);
		request.setPassword(arg[3]);
		request.setConfirmPassword(arg[4]);

		// isPasswordEqualToConfirmPassword() 는 암호가 같을때 반환하기때문에 부정해줌
		if (!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}

		try {
			service.regist(request);
			System.out.println("등록되었습니다.");
		} catch (AlreadyExistingMemberException e) {
			e.printStackTrace();
			System.out.println("이미 존재하는 이메일입니다.");
		}

	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		//ChangePasswordService service = assembler.getChangePasswordService();
		ChangePasswordService service = ctx.getBean("changePasswordService", ChangePasswordService.class);

		try {
			service.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("------------------------명령어 사용법------------------------");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
}
