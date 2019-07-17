package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		
		
		char c1 = 'A';
		char c2 = 'B';
		
		//test.txt 파일이 없으면 생성한다.
		Writer writer = new FileWriter("test.txt");
		
		//유니코드가 읽혀서 데어터가 들어간 파일이 생성이됨
		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);
		
		
		writer.close();
		
		System.out.println("파일이 작성/생성 되었습니다.");
		
		Reader reader = new FileReader("test.txt");
		
		//데이터를 10개 (문자를 10개 받아오겠다.)
		//빠르게 읽기위해 배열사용
		char[] cBuf = new char[10];
		
		int readCnt = 0;
		
		//0~cBuf.length(cBuf 데이터가 있는 길이까지) 의 데이터를 읽어서 데이터를 저장해준다.
		readCnt = reader.read(cBuf, 0, cBuf.length);
		
		for(int i=0; i<readCnt; i++) {
			System.out.println(cBuf[i]);
		}
		
		reader.close();

		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
		out.write("손흥민 – 리버플전에 골을 넣는데 집중하겠다.");
		out.newLine();
		out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
		out.newLine();
		out.write("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
		out.newLine();
		out.write("환상적인 결승전이 될 것이다.");
		out.newLine();
		out.newLine();
		out.write("기사 제보 및 보도자료");
		out.newLine();
		out.write("press@goodnews.co.kr");
		out.close();
		System.out.println("기사 입력 완료.");

		BufferedReader reader2 = new BufferedReader(new FileReader("String.txt"));
		String str = null;
		
		while (true) {
			str = reader2.readLine();
			if (str == null)
				break;
			System.out.println(str);
		}
		
		reader2.close();

	}

}
