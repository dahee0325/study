package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//simple이라는 요청이들어오면 처리하는 서블릿
/*@WebServlet("/simple")*/
public class SimpleController extends HttpServlet implements Servlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get일때도 post방식일때도 처리되는게 똑같기 때문에
		process(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
		
	}
	
	//여기에만 구현해주면됨
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자의 요청파악 : premeter 값을 통해서 사용자의 요청을 분석/구분한다.
		// 사용자의 요청을 Prameter 이름이 type인것을 받아올것
		String command = request.getParameter("type");
		
		//응답결과를 받을 변수
		String resultObj = "";
		String viewPage = "";
		
		// 요청에맞는 기능 수행 : Medel 처리(Service + Dao + 기능 Class 등) -> 결과데이터를 반환하는 흐름
		// command 처리
		if(command == null || command.equals("greeting")) {
			
			resultObj = "안녕하세요";
			//view 페이지 경로지정 : 응답코드 생성개념
			viewPage = "/simplePage.jsp";
			
		}else if(command.equals("date")) {
			
			//현재시간을 저장
			resultObj = new Date().toString();
			viewPage = "/datePage.jsp";
			
		}else {
			resultObj = "Invalid Type";
			viewPage = "/simplePage.jsp";
		}
		
		// 결과 데이터를 request 또는 session 영역에 속성으로 저장한다 : view로 데이터 전달, 공유 하는 개념
		//  ㄴ속성에서 저장하는 목적 : view 에서 데이터를 사용할 수 있도록 하기 위함
		//result 이름으로 저장
		request.setAttribute("result", resultObj);
		
		// forwarding(보내기)
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}


}
