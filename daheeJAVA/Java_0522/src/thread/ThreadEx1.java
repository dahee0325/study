package thread;

public class ThreadEx1  extends Thread{

	@Override
	public void run() {
		
		//실행되야하는 처리가 들어갈자리
		for(int i=0; i<5; i++) {
			//조상 Thread의 메서드 getName()
			System.out.println(getName() + " : " + getId());
		}
		
	}

}
