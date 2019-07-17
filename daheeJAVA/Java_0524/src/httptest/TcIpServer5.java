package httptest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class TcIpServer5 {

	// 스레드를 사용함으로 동시에 받고 쓸수가있다 ( 스레드를 사용하지않으면 무전기 형식으로 한쪽이 보낼동안 한쪽은 대기해야한다)
	public static void main(String[] args) throws IOException {

		
		ServerSocket serverSocket = null;
		Socket socket = null;

		// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
		serverSocket = new ServerSocket(7777);
		System.out.println(" 서버가 준비되었습니다.");

		socket = serverSocket.accept();

		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);

		sender.start();
		receiver.start();

	}

}

class Sender extends Thread {

	// 소켓 필요
	// 소켓 객체 받음
	Socket socket;
	DataOutputStream out;
	String name;

	public Sender(Socket socket) throws IOException {

		this.socket = socket;

		out = new DataOutputStream(socket.getOutputStream());
		
		if(socket.getPort() == 7777) {
	         name = "[clntname] " ;
	      }else {
	         name = "[servname] " ;
	      }

	}

	public void run() {

		Scanner scanner = new Scanner(System.in);

		while (out != null) {

			try {

				out.writeUTF(name + scanner.nextLine());

			} catch (IOException e) {

				e.printStackTrace();

			}
		}
	} // run()
}



class Receiver extends Thread {

	Socket socket;
	DataInputStream in;

	public Receiver(Socket s) throws IOException {

		socket = s;
		in = new DataInputStream(socket.getInputStream());

	}

	public void run() {

		
		while (in != null) {
			// 출력
			try {
				
				System.out.println(in.readUTF());	
					
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}