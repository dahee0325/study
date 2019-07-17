package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	//FileNotFoundException 는 IO 인셉션을 상속
	//IOException 는 FileNotFoundException보다 상위클래스
	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("penguins.jpg");
		
		//OutputStream 은 추상클래스;
		OutputStream out = new FileOutputStream("copy.jpg");
		
		
		
		int copyByte = 0; // 전송된 사이즈 카운트 
		int bData = 0;	  // 스트림을 통해 전송받은 데이터 : byte사이즈만큼
		
		while (true) {
			
			//파일 데이터 읽기
			//file을 가져 올 때 read를 통해 파일을 읽어옴
			//배열에 담아 쓰면 속도가 빨라짐
			bData = in.read(); //byte 사이즈의 데이터,모두 전송된 후에는 -1값을 반환한다
			
			//기존에 있는 데이터에 -1 연산을 해버리면 안되니까 무한루프를 빠져나올 조건을 준다
			if(bData < 0) {
				break;
			}
			
			
			//파일 쓰기
			out.write(bData);
			
			copyByte++;//읽고 쓰고온 데이터의 크기
		}
		
		//스트림 닫기 ★★★★★
		in.close();
		out.close();
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 byte 크기 : " + copyByte);

	}

}
