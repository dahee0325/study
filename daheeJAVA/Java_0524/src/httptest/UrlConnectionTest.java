package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

	public static void main(String[] args) throws IOException {
		
		//URLConnectionTest : http 기반의 통신연결해주는 클래스
		//URL 클래스의 openConnection() 메서드로 URLConnection 객체 반환하여 받아올 수 있다.
		
		URL url = null;
		String urlStr = "http://www.ctware.net"; //default값으로 처리해놓으면 index.html을 호출해준다.
		
		//연결처리가 안되거나 주소가 틀릴수 있으니까 예외처리를 해줘야한다. (넘기려면 메서드에 throws MalformedURLException 정의)
		url = new URL(urlStr);
		
		//연결정보를 가져옴
		URLConnection conn = url.openConnection();
		
		BufferedReader in = null;
		
		//openStream()을 통해 url을 연결
		// openConnection() -> URLConnecton -> getInputStream()
		//in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		//URL 정보가 없었을때 conn.getInputStream() 로 파일을 읽어올수있다.
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		
		
		String str = null;
		
		while(true) {
			
			//줄단위로 다음줄로 내려가면서 읽어옴(다음줄에 값이 없다면 null값을 반환함)
			str = in.readLine();
			
			if(str == null) {
				break;
			}			
			
			//url의 홈페이지 소스내용이 출력됨
			System.out.println(str);
			
		}
		
		
		
		
		
		
		
		
		/*
		System.out.println("conn.toString():" + conn);
		System.out.println("getAllowUserInteraction():" + conn.getAllowUserInteraction());
		System.out.println("getConnectTimeout():" + conn.getConnectTimeout());
		System.out.println("getContent():" + conn.getContent());
		System.out.println("getContentEncoding():" + conn.getContentEncoding());
		System.out.println("getContentLength():" + conn.getContentLength());
		System.out.println("getContentType():" + conn.getContentType());
		System.out.println("getDate():" + conn.getDate());
		System.out.println("getDefaultAllowUserInteraction():" + conn.getDefaultAllowUserInteraction());
		System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
		System.out.println("getDoInput():" + conn.getDoInput());
		System.out.println("getDoOutput():" + conn.getDoOutput());
		System.out.println("getExpiration():" + conn.getExpiration());
		//요청하고 응답하면 끝나는개 http 의 특징 : 톰캣이라는것을 사용하여 실시간 통신(실시간으로 데이터를 주고받을 수 있음)
		System.out.println("getHeaderFields():" + conn.getHeaderFields());//★★ 프로토콜내용가져올수있음
		System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
		System.out.println("getLastModified():" + conn.getLastModified());
		System.out.println("getReadTimeout():" + conn.getReadTimeout());
		System.out.println("getURL():" + conn.getURL());
		System.out.println("getUseCaches():" + conn.getUseCaches());
		*/
	}

}
