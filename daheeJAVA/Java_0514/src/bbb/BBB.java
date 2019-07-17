package bbb;

import aaa.AAA;

public class BBB extends AAA {
	
	int c;
	
	//생성자
	BBB() {
		c = num1 + num2;
		
		//↓오류남 num3은 default 변수기때문에 다른 패키지에서 불러올수없음
		//protected 사용해야함
		//System.out.println(num3);
	}

}
