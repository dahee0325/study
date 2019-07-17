package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient5 {

	public static void main(String[] args) throws IOException, IOException {
		
		Socket socket = new Socket("127.0.0.1", 7777);
		System.out.println("서버 연결 성공!");
		
		System.out.println("==========================");
		System.out.println("원하는 메뉴를 입력해주세요. \n게임시작 : start \n채팅종료 : quit");
		System.out.println("==========================");
		
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter sendWriter = new PrintWriter(socket.getOutputStream());
		
		Firstgame firstgame;
		String str = "", str1 = "";
		
		str = tmpbuf.readLine();
		if(tmpbuf.equals("start")) {
		while (true) {
			
			System.out.print("숫자4개입력>>");
			

			if (str.length() < 4) {

				System.out.println("다시 입력하세요\n숫자4개입력>>");
				str = tmpbuf.readLine();
			}
			// 서버로 전송
			sendWriter.println(str);
			sendWriter.flush();

			str1 = tmpbuf.readLine();

			// System.out.println("서버>>"+str1.substring(0, 5));
			System.out.println("서버>>" + str1);

			if (str1.subSequence(6, 8).charAt(0) != 'F') {
				break;
			}

		}
		}
		sender.start();
		receiver.start();

	}

}
