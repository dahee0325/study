package thread2;

public class RunnableThreadMain {

	public static void main(String[] args) {
		
		
		// Runnable 객체를 이용한 쓰레드 생성
		// 1. Runnable interface를 구현하는 클래스 기반의 객체 생성
		
		//1~100까지 더하려고하는데 느릴거같아서 두개로 나눠서 작업을 시킴
		//0~50까지 더한 숫자를 num에 저장
		AdderThread aT1 = new AdderThread(0, 50);
		//51~100까지 더함
		AdderThread aT2 = new AdderThread(51, 100);
		
		
		// 2. Thread 생성 : 해야할일을 정의
		Thread t1 = new Thread(aT1);
		Thread t2 = new Thread(aT2);
	
		// 3. Thread의 실행
		t1.start();
		t2.start();
		
		//쓰레드를 두개두고 동시에 처리하게되면 쓰레드의 작업처리시간을 보장받을 수 없어서
		//작업처리가 늦으면 main이 처리되는 시간보다 늦어져서 잘못된값이 나온다
		
		//쓰레드가 다 실행될때까지 메인메서드를 잠시 멈춰놓는다. : join(); 을 사용
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("aT1 num : "+ aT1.getNum());
		System.out.println("aT2 num : "+ aT2.getNum());
		System.out.println("0~100까지의 합은 : " + (aT1.getNum() + aT2.getNum()));

	}

}
