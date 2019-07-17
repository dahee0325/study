package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcIpServer {

	public static void main(String[] args) throws IOException {
		
		//Socket 생성
		//A Socket과 B Socket 을 생성하여 서로 연결하려는 목적
	
		
		ServerSocket serverSocket = null;
		
		int cnt = 0;
		serverSocket = new ServerSocket(7777);
		//서버가 준비된 시간도 나옴
		System.out.println(getTime() + " 서버가 준비되었습니다.");
		
		//접속하고 빠지고 하는것을 확인
		
		while(true) {
			
			System.out.println(getTime()+  " 연결을 기다립니다.");
			
			//Socket 객체 필요
			Socket socket = serverSocket.accept(); //연결되길 기다림 (대기상태) 요청이 들어오면 소켓을 생성해서 반환해줌
			
			// 요청을 받으면 ServerSocket이 새로운 연결 Socket을 생성한다. (생성하여 반환)
			//연결요청을 받고 소켓을 생성해서 반환해줌으로 바로 연결해줌
			//소켓을 통해 연결되는주소의 데이터를 받을 수 있다. : socket.getInetAddress()	
			System.out.println(getTime() + socket.getInetAddress() + "로 부터 연결 요청이 있습니다. 연결합니다.");
			
			
			//OutputStream : 문자열기반으로 반환하기 위해
			//데이터를 받아옴
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			//데이터를 쓰면 내보낼 수 있음
			dos.writeUTF("하이. from Server (" + cnt++ + ")");
			System.out.println(getTime() + " 메시지 전송");
			
			
			InputStream in = socket.getInputStream();
			DataInputStream din = new DataInputStream(in);
			
			//받은 데이터 출력
			//서버에서 보낸 데이터 출력
			System.out.println("[Client] " + din.readUTF());
			
			dos.close();
			din.close();
			socket.close();
					
		}
		
	}

	//시간정보 반환하기 위해 String타입을 반환
	public static String getTime() {
		
		//시간정보 출력
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
		
		//지금 현재시간을 문자열로 반환하여 받음
		return format.format(new Date());
		
	}
}
