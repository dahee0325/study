package thread2;

//값을받아 더해주는것을 완성시키기 위해 Sum을 상속받는다
public class AdderThread extends Sum implements Runnable{

	
	int start;
	int end;
	
	public AdderThread(int s, int e) {
		
		start = s;
		end = e;
	}
	
	//Runnable을 상속하기 위해서는 run 메서드가 필요함 ★★★
	@Override
	public void run() {
		
		//멤버를 다 가져올 수 있는 상황에서 실행해줄구문을 정의(Sum이 가지고있는 num을 가져옴)
		for(int i=start; i<=end; i++) {
			addNum(i);
		}
		
	}
}
