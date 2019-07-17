package service;


import javax.servlet.http.HttpServletRequest;

public class OtherService implements Service {
	public String getViewPage(HttpServletRequest request) {

		// 핵심처리
		// 결과를 request 속성에 저장
		request.setAttribute("result", "Other Type");

		// view 지정하여 반환
		return "/simplePage.jsp";

	}
}
