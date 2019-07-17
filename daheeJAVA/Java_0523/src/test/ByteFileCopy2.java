package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy2 {

	//FileNotFoundException 는 IO 인셉션을 상속
	//IOException 는 FileNotFoundException보다 상위클래스
	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("penguins.jpg");
		
		//OutputStream 은 추상클래스;
		OutputStream out = new FileOutputStream("copy.jpg");
		
		
		
		int copyByte = 0; // 전송된 사이즈 카운트 
		int bData = 0;	  // 스트림을 통해 전송받은 데이터 : byte사이즈만큼
		
		//★
		int readLen = 0;
		//읽어오고 쓰는데 더 빠름 : 바이트배열
		byte[] buf = new byte[1024];
		
		
		while (true) {
			
			//파일 데이터 읽기
			//file을 가져 올 때 read를 통해 파일을 읽어옴
			//배열에 담아 쓰면 속도가 빨라짐
			//bData = in.read(); //byte 사이즈의 데이터,모두 전송된 후에는 -1값을 반환한다
			
			//buf에다가 바이트를 쌓아서 저장할건데 이 바이트의 크기를 readLen에 저장
			readLen = in.read(buf);
			
			
			//기존에 있는 데이터에 -1 연산을 해버리면 안되니까 무한루프를 빠져나올 조건을 준다
			/*if(bData < 0) {
				break;
			}*/
			
			
			//들어올게 없더라면
			if(readLen == -1) {
				break;
			}
			
			
			//파일 쓰기
			//out.write(bData);
			//배열전체를 받아서 쓰는게 아니라 딱 떨어지게
			//buf는 1024개를 담을 수 있는 바이트배열
			//그 전에 읽어왔던 데이터가 있다면 그 뒤에 쓰여지기 때문에
			// 현재 읽어오는 크기를 알고 사용해야한다.
			out.write(buf, 0, readLen);
			
			
			//copyByte++;//읽고 쓰고온 데이터의 크기
			
			copyByte += readLen;
			
		}
		
		//스트림 닫기 ★★★★★
		in.close();
		out.close();
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 byte 크기 : " + copyByte);

	}

}
