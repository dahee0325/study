package thread;

import javax.swing.JOptionPane;

public class ThreadEx2 {
	
	//값이 들어오는지 체크하기 위한 변수
	static boolean inputCheck = false;

	public static void main(String[] args) {
		
		//쓰레드를 사용하기 위한 객체생성
		//Thread가 Thread4 의 상위클래스라 가능
		Thread t1 = new Thread4();
		t1.start();
		
		
		//특징 : 창이 뜨고 확인이나 취소버튼을 누를때까지 showInputDialog에 멈춰있다.
		String str = JOptionPane.showInputDialog("값을 입력해주세요");
		//값이 들어오면 inputCheck = true; 로 변함
		inputCheck = true;
		System.out.println("입력완료 : "+str);
		
		//10초 안에 입력하도록
		//i가 0보다 클때 시작. i--를 하므로 카운트다운
		//showInputDialog 창이 올라왔을때 카운트를 세게하려면 스레드가 필요하다.
		//밑의 for문을 스레드로 작성
		
		/*for(int i=10; i>0; i--) {
			System.out.println(i);
			
			//1초마다 한번씩 반복
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

	}

}


class Thread4 extends Thread {
	
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			
			//1초마다 한번씩 반복
			try {
				Thread.sleep(1000);
				if(ThreadEx2.inputCheck) {
					//값이 들어오면 카운트다운종료
					System.out.println("카운트 다운을 중단합니다.");
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//10초가 지나면 종료
		System.out.println("입력시간을 초과해서 종료합니다.");
		System.exit(0);
		
		/*
		//inputCheck 가 false라면
		if(!ThreadEx2.inputCheck) {
			//현재돌아가는 프로세스 종료
			System.exit(0);
		}
		*/
	}
}