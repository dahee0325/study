package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcIpClient {

	//UnknownHostException : 연결하고자하는 호스트가 알수없는 호스트(주소가잘못된) 오류가 생길 수 있음
	//IOException 가 UnknownHostException를 상속하고 있기 때문에 IOException 하나만 넣어도됨
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		int cnt = 0;
		
		//연결하기 위한 소켓 생성
		//연결하기 위한 소켓 아이피를 얻고 연결을 준비
		//Socket("로컬 호스트번호(내부아이피주소)", 서버포트번호)
		Socket socket = new Socket("127.0.0.1", 7777);
		
		//데이터를 받는 InputStream
		//socket에는 input, output이 존재함
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//받은 데이터 출력
		//서버에서 보낸 데이터 출력
		System.out.println("[Server] " + din.readUTF());
		
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeUTF("하이. from Client (" + cnt++ + ")");
		System.out.println(getTime() + " 메시지 전송");
		
		din.close();
		dos.close();
		socket.close();

	}
	
	public static String getTime() {

		// 시간정보 출력
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

		// 지금 현재시간을 문자열로 반환하여 받음
		return format.format(new Date());

	}

}
