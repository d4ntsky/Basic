package sample09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginId")
public class LoginIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<h3>login Id session</h3>");

		HttpSession session = null; //쿠키와 달리 Object부터 잡음
		if(session == null) {
			pw.println("<p>session을 등록합니다</p>");
			session = req.getSession(true);
			
			session.setAttribute("id", "abc123");
			session.setAttribute("name", "홍길동");
			session.setAttribute("visited", "1");
		}
		/*
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		pw.println("<p>id : "+ id +"</p>");
		pw.println("<p>name : "+ name +"</p>");
		*/
		
		Enumeration<String> enum_session = session.getAttributeNames();
		
		while(enum_session.hasMoreElements()) {
			String key = enum_session.nextElement();
			String value = (String)session.getAttribute(key);
			
			pw.println("<p>"+ key +" : " + value + "</p>");
		}
		
		pw.println("<a href=delObj>name 삭제</a>");
		
		pw.println("<a href=sessionDel>session 삭제</a>");
		
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
