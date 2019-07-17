<%@page import="member.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("id");
	String userPw = request.getParameter("pw");
	boolean loginChk = false;

	//1. 사용자가 입력한 id로 회원 정보 검색
	//2. id가 존재한다면 해당 객체를 받는다.
	//3. 해당 객체의 pw와 사용자가 입력한 pw 를 비교해서 같다면 로그인 처리 : 세션영역에 회원 정보를 저장해준다.
	//4. 틀리다면 오류 메세지 전달하고 다시 로그인페이지로 이동한다.

	//1. 사용자가 입력한 id로 회원 정보 검색
	UserInfo userInfo = (UserInfo) application.getAttribute(userId);

	if (userInfo != null && userInfo.getPw().equals(userPw)) {
		//userInfo 가 null이 아니라면 회원정보가 존재
		//회원정보가 존재하고 비밀번호가 맞다면
		session.setAttribute("loginInfo", userInfo.toLoginInfo());
		//로그인 처리 후 메인 페이지로이동
		response.sendRedirect(request.getContextPath());
	}else {
		//id 검색결과가 null 또는 pw 비교해서 같지 않은 경우
%>
	<script>
		alert('아이디 혹은 비밀번호를 확인해주세요.');
		history.go(-1);
	</script>
<%
	}
%>