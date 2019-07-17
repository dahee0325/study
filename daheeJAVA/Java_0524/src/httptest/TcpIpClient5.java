package httptest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient5 {

	public static void main(String[] args) throws IOException {


		Socket socket = new Socket("127.0.01", 7777);
		System.out.println("서버에 연결되었습니다.");
		
		//연결이되었다면 socket을 전달 받았음
		//보내고 받고 할 수 있는 클래스를 받아 객체를 생성해줌
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
		
		
	}

}
