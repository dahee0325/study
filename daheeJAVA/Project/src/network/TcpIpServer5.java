package network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpIpServer5 {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket socket = null;

		serverSocket = new ServerSocket(7777);
		System.out.println("서버가 열렸습니다. ");

		socket = serverSocket.accept();
		System.out.println("클라이언트가 접속했습니다. ");
		System.out.println("==========================");
		System.out.println("가위바위보!!");
		System.out.println("==========================");
		System.out.println("가위바위보를 시작합니다.");

		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);

		sender.start();
		receiver.start();
	}
}


class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		out = new DataOutputStream(socket.getOutputStream());

	}

	public void run() {
		super.run();
		
		try {
			String send;
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(socket.getOutputStream());

			while (true) {
				send = tmpbuf.readLine();
				
				TcpIpServer5 server = new TcpIpServer5();
				
				if (send.equals("가위")) {
				
				} else if (send.equals("바위")) {
					
				} else if (send.equals("보")) {
					
				} else {
					sendWriter.println(send);
					sendWriter.flush();
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class Receiver extends Thread {

	Socket socket;
	DataInputStream in;

	public Receiver(Socket s) throws IOException {
		socket = s;
		in = new DataInputStream(s.getInputStream());
	}

	public void run() {

		super.run();

		try {			
			BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String receive;
			
			while (true) {
				receive = read.readLine();
				
				System.out.println(receive);
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}