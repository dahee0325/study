package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp : doGet에 정의되어있는 변수
		resp.setContentType("text/html; charset=utf-8");
		
		//resp 를 객체를 만들어 응답처리를 한다.
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HELLO Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(new Date());
		out.println("</body>");
		out.println("</html>");
		
	}	
	
}
