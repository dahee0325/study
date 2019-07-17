package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
	
	
	
	// 1. 접속한 사용자들을 Map에 저장 -> 모든 사용자에게 메세지를 전송하기 위해
	// 2. name, 사용자별 소켓을 이용한 스레드(기능 : 받고, 전체사용자에게 전송)
	//    ㄴ 스레드 생성 : 1. 메세지 보내기 (누구누구님이 접속했다고 접속멘트)
	//					 2. Map에 저장
	// 3. 멀티 챗 : 누가 언제 들어와도 채팅이 가능한 채팅 기능 - while(true) , socket.accept()
	
	//키랑 value 값 생략가능
	HashMap clients;
	
	public TcpIpMultichatServer() {
		
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	
	}
	
	
	public void start() throws IOException {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		serverSocket = new ServerSocket(7777);
		System.out.println("서버가 생성되었습니다.");
		
		while (true) {
			
			socket = serverSocket.accept();
			System.out.println("[ " + socket.getInetAddress() + " : "+ socket.getPort() + " ] 사용자가 접속했습니다.");
			
			ServerReceiver receiver = new ServerReceiver(socket);
			
			receiver.start();
			
			
		}
		
		
	}
	
	

	void sendToAll(String msg) {

		Iterator itr = clients.keySet().iterator();

		// 모든 접속자 에게 메시지 전송
		while (itr.hasNext()) {
			try {
				DataOutputStream dout = (DataOutputStream) clients.get(itr.next());
				dout.writeUTF(msg);
			} catch (IOException e) {
			}
		} // while
	} // sendToAll

	
	public static void main(String args[]) throws IOException {
		
		new TcpIpMultichatServer().start();
		
	}
	
	
	//내부클래스 생성
	class ServerReceiver extends Thread {
		
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
	
		public ServerReceiver(Socket s) {
			
			
			socket = s;
			
			
			try {
				in = new DataInputStream(s.getInputStream());
				out = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		public void run() {
			
			String name = "";
			
			try {
				name = in.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다.");
				clients.put(name, out);
				
				//접속 안내 매세지 데이터를 전달받아서 전체사용자에게 보내기
				while(in!=null) {
					
					sendToAll(in.readUTF());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}
}
