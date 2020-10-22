package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet");
		
		//String name = req.getParameter("name");
		//System.out.println("name : " + name);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		String code = req.getParameter("code");
		
		if(code.equals("200")) {
			pw.println("<p>200:SC_OK</p>");
		}
		else {
			if(code.equals("404")) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "못 찾겠다는 에러입니다.");
			}
			else if(code.equals("500")) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "코드가 틀렸다는 에러입니다.");
			}
		}
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost");
	}

}
