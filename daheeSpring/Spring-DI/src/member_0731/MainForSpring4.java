package member_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import memberExcrption.AlreadyExistingMemberException;
import memberExcrption.IdPasswordNotMatchingException;
import memberExcrption.MemberNotFoundException;

public class MainForSpring4 {
	
	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx3.class);
	
	//class 두개 사용도 가능
	//private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx1.class, AppCtx2.class);
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("명렁어를 입력하세요:");
			String command = reader.readLine();

			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}

			
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}

	}

	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}

		MemberRegisterService2 service = ctx.getBean("regMemberService", MemberRegisterService2.class);
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(arg[1]);
		request.setName(arg[2]);
		request.setPassword(arg[3]);
		request.setConfirmPassword(arg[4]);

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

		ChangePasswordService2 service = ctx.getBean("changePwService", ChangePasswordService2.class);

		try {
			service.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			System.out.println("존재하지 않는 이메일입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			e.printStackTrace();
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
