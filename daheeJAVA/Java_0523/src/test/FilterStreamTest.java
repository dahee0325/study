package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilterStreamTest {

	public static void main(String[] args) throws IOException {
		
		//저장하기 위해서
		OutputStream out = new FileOutputStream("data.bin");
		
		//기본형 데이터 형식으로 저장 : DataOutputStream 필터 스트림 생성
		//필터스트림의 생성자에 기본 스트림은 인자로 전달
		DataOutputStream dOut = new DataOutputStream(out);
		
		//기본형타입을 가져올때는 타입에 맞는 write를 사용
		dOut.writeInt(275);
		dOut.writeDouble(45.79);
		dOut.writeBoolean(true);
		
		dOut.close();
		
		System.out.println("파일 저장 완료");
		
		//생성했던 data.bin 은 유니코드로 작성되었기때문에 우리가 못읽어서
		//input을 통해 읽어온다 (기본스트림으로는 읽기불가능, 팔터스트림을 사용해야한다.)
		//기본스트림 생성
		InputStream in = new FileInputStream("data.bin");
		
		//필터스트림생성
		DataInputStream dIn = new DataInputStream(in);
		//dIn을 통해 필터하여 읽어온다.
		int num1 = dIn.readInt();
		double num2 = dIn.readDouble();
		boolean check = dIn.readBoolean();
		
		in.close();
		dIn.close();
		
		System.out.println("첫번째 데이터 "+ num1);
		System.out.println("두번째 데이터 "+ num2);
		System.out.println("세번째 데이터 "+ check);
		
		
	}

}
