package util;

import java.util.Scanner;

public class Util {
	
	//public 을 통해 다른 코드에서도 Scanner keboard 가 보인다.
	//static 어디에서나 사용할 수 있도록 suatic앞에는 거의 public이 붙여진다.
	public static Scanner keyboard = new Scanner(System.in);
	
	
	//메뉴이름들을 상수처리 (PhoneBookManager에서 사용 swith-case문)
	//public static 을 붙여주면 외부에서도 사용가능
	public static final int INSERT = 1;
	public static final int SEARCH = 2;
	public static final int DELETE = 3;
	public static final int ALLDATA = 4;
	public static final int QUIT = 5;
	
	public static final int UNI = 1;
	public static final int COM = 2;
	public static final int CAFE = 3;
}
