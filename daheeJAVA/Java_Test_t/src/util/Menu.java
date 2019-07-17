package util;

public interface Menu {
	
	//인터페이스 안에서는 public static final 생략 가능
	//시작메뉴
	int INSERT = 1;
	int SEARCH = 2;
	int DELETE = 3;
	int ALLDATA = 4;
	int QUIT = 5;
	
	//입력메뉴
	int INSERT_UNIV = 1, INSERT_COM = 2, INSERT_CAFE = 3;
	
}