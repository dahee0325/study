package networkreal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient5 {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("10.10.10.28", 7777);
		System.out.println("서버 연결 성공!");

		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		
				
			pw.println();
			pw.flush();
			
		//str1 = br.readLine();
		//System.out.println("서버 : " + str1);
		}
		/*
		 * Sender sender = new Sender(socket); Receiver receiver = new Receiver(socket);
		 * 
		 * sender.start(); receiver.start();
		 */
	}

