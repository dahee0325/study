package thread;

public class ThreadMain {

	public static void main(String[] args) {


		//thread 클래스를 상속하는 Thread 객체 생성
		ThreadEx1 t1 = new ThreadEx1();
		
		
		//Runnable 인터페이스를 구현한 클래스 생성
		ThreadRunnable r = new ThreadRunnable();
		
		//Runnable 클래스 기반으로 Thread 인스턴스 생성
		Thread t2 = new Thread(r);
		
		//스레드의 실행은 start() 메서드로 시작한다.
		//-> 스레드 생성(일의 흐름) -> run() 메서드 호출
		t1.start();
		t2.start();
		
		
	}

}
