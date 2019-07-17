package increment;

public class Increment {

	
	int num = 0;
	
	//synchronized : 하나의 스레드의 작업이 끝날동안 다른 스레드는 작업중지해놓음
	public synchronized void Increment() {
		num++;
	}
	
	public int getNum() {
		
		return num;
		
	}
	
	
	public static void main(String[] args) {
		
		//0~10000까지 돌아감
		Increment inc = new Increment();
		
		IncThread t1 = new IncThread(inc);
		IncThread t2 = new IncThread(inc);
		IncThread t3 = new IncThread(inc);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			
			t1.join();
			t2.join();
			t3.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}

		System.out.println(inc.getNum());
	}

}


class IncThread extends Thread {
	
	Increment inc;

	public IncThread(Increment inc) {
		this.inc = inc;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			inc.Increment();
		}
	}
}