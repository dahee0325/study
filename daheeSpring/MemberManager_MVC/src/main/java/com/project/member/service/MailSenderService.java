package com.project.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSenderService")
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;

	public int send(String email) {

		MimeMessage message = sender.createMimeMessage();

		try {
			message.setSubject(email + "님 신규 회원가입을 축하합니다.", "UTF-8");
			String htmlMsg = "<h2>회원가입을 축하합니다.</h2>";
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("daa_hee@naver.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, "신규회원님", "UTF-8"));

			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}

	public void send(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();

		try {

			message.setSubject("[안내] 회원가입을 축하합니다.", "UTF-8");
			String htmlMsg = "<h1>회원가입을 축하합니다.</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/member/member/verify?id=" + getuId + "&code=" + code
					+ "\" >인증하기</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("daa_hee@naver.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "신규회원님", "utf-8"));

			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void reSend(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();

		try {

			message.setSubject("[인증안내] 이메일 인증을 해주세요.", "UTF-8");
			String htmlMsg = "<h1>이메일 인증을 해주세요.</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/member/member/verify?id=" + getuId + "&code=" + code
					+ "\" >인증하기</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("daa_hee@naver.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "신규회원님", "utf-8"));

			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
