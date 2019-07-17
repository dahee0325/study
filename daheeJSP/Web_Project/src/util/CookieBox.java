package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	// Cookie 데이터들을 Map에 저장해서 관리
	// private를 통해 메서드로 통해서만 참조할수있도록 함 (직접참조 불가능)
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	// 생성자 : 초기화 -> request 객체에서 Cookie[] 받아서 cookieMap에 저장하는초기화
	public CookieBox(HttpServletRequest request) {
		// 쿠키를 받아와서 저장
		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {
			// 반복처리 : Cookie객체를 Map에 저장
			for (int i = 0; i < cookies.length; i++) {

				// cookieMap.put(cookies[i].getName(), cookies[i]);
				Cookie c = cookies[i];
				cookieMap.put(c.getName(), c);

			}

		}
	}

	// 쿠키 생성하는 메서드 : 이름, 데이터
	public static Cookie createCookie(String name, String value) {
		Cookie c = new Cookie(name, value);
		return c;
	}

	// 쿠키생성 메서드 : 오버로딩 : 이름, 데이터, 유효시간
	public static Cookie createCookie(String name, String value, int maxAge) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(maxAge);
		return c;
	}

	// 쿠키생성 메서드 : 오버로딩 : 이름, 데이터, 유효시간, 패스(경로)
	public static Cookie createCookie(String name, String value, int maxAge, String path) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(maxAge);
		c.setPath(path);
		return c;
	}

	// 쿠키생성 메서드 : 오버로딩 : 이름, 데이터, 유효시간, 패스(경로), 도메인
	public static Cookie createCookie(String name, String value, int maxAge, String path, String domain) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(maxAge);
		c.setPath(path);
		c.setDomain(domain);
		return c;
	}
	
	//쿠키정보를 반환하는 메서드(쿠키의 이름데이터를 가져와서)
	//Map : 인스턴스 변수이기때문에 이 메서드도 static안써도됨
	public Cookie getCookie(String name) {
		//get을 통해 cookieMap에 있는 value값을 가져올 수 있는데 name값을 통해 값을 찾는다
		return cookieMap.get(name);
		
	}
	
	//쿠키의 데이터 반환메서드 : 데이터가 String타입이여서 반환타입이 String
	public String getValue(String name) {
		
		Cookie c = cookieMap.get(name);
		
		//return : 메서드 종료, 데이터 반환 이기 때문에 c가 null이라면 return 하고 종료한다.
		if(c == null) {
			return null;
		}
		
		//null이 아니라면실행
		return c.getValue();
	}
	
	//쿠키 존재여부 확인해주는 메서드
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
	
	
}
