package com.bit.mvc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurutyController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AES256Util aesUtil;
	
	@ResponseBody
	@RequestMapping("/encodePassword")
	public String bcript() {
		
		//사용자에게 받은데이터라고 가정
		String str = "password";
		
		//암호화처리한 문자열을 반환해준다.
		String encodingStr = encoder.encode(str);
		
		//encoding된 문자열을 비교하기 위한 encoder.matches
		boolean result = encoder.matches(str, encodingStr);
		
		return "befor : " + str + "<br>after: " + encodingStr +"<br>str=encodingStr => " + result;
	}
	
	@ResponseBody
	@RequestMapping("/encodePassword1")
	public String bcript1() {		
		
		String str = "password";
		
		String encodingStr = Sha256.encrypt(str);
	
		String pw ="password";
		
		boolean result = encodingStr.equals(Sha256.encrypt(pw));
		
		return "befor : " + str + "<br>after: " + encodingStr + "<br>encodinStr == pw => " + result;
	}
	
	@ResponseBody
	@RequestMapping("/encodePassword2")
	public String bcript2() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {		
		
		String str = "password";
		
		String encodingStr = aesUtil.encrypt(str);
		String decodingStr = aesUtil.decrypt(encodingStr);
		
		return str + " : " + encodingStr + " : " + decodingStr;
	}
	
}
