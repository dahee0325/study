package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebServlet2
 */

//name= 서블릿 이름을 지정해준다.
@WebServlet(name="servlet", urlPatterns ="/first")

//HttpServlet 을 상속해줘야지 servlet 클래스라고 불릴수 있다
public class FirstWebServlet extends HttpServlet {
       
	/**
	 * request, response : 사용자의 요청정보를 변수로 담고있다. (담아온 데이터를 담고있는 변수의 객체만 있으면 필요한 정보를 찾아 사용할 수 있다.)
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답하는 타입에 대한 정의를 해주는 setContentType
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//out객체를 통해 출력
		out.println("<html><head><title>first Web</title></head>");
		out.println("<body><h1>시간 : " + new Date());
		out.println("</h1></body></html>");
	}

}
