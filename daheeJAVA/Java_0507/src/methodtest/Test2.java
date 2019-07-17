package methodtest;

public class Test2 {

	public static void main(String[] args) {

		int i = 0, sum = 0;
		
		while(sum<100) {
			i++;
			if(i%2 == 0) {
				sum -= i;
			}
			else {
				sum += i;
			}
		}
		System.out.println(i+"를(을) 더했을 때 100이상");
		
	}



}
