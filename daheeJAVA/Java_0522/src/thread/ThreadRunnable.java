package thread;

public class ThreadRunnable implements Runnable{

	@Override
	public void run() {
		
		for(int i=0; i<5; i++) {
			
			//TheadRunnable의 이름을 출력
			//currentThread : 현재 돌고있는 스레드
			System.out.println(Thread.currentThread().getName());
		}
		
	}

}
