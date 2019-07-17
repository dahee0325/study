package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {

	public static void main(String[] args) {

		// 출력용도는 java.util.Date

		// 현재 시간을 가져옴
		Date today = new Date();
		// 시간 출력
		System.out.println(today);
		
		//시간 패턴지정 : yyyy.MM.dd 년.월.일
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
		
		//String타입의 dateStr에 패턴이 지정된 객체에 오늘 시간을 넣음
		String dateStr = date.format(today);
		//출력
		System.out.println(dateStr);
		
		//시간 패턴지정 : 시:분:초 PM/AM(오후/오전)
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String timeStr = time.format(today);
		System.out.println(timeStr);
		

	}

}
