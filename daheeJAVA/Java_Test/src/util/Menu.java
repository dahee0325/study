package util;

public interface Menu {
	
	//인터페이스 안에서는 public static final 생략 가능
	//시작메뉴
	int INSERT = 1;
	int SEARCH = 2;
	int UPDATE = 3;
	int DELETE = 4;
	int ALLDATA = 5;
	int QUIT = 6;
	
	//입력메뉴
	int INSERT_UNIV = 1, INSERT_COM = 2, INSERT_CAFE = 3;
	
}