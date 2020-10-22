package sample01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet doGet");
		
		createHTML("GET방식", req, resp);
		/*
		 	Servlet -> Java(html)
		 	JSP -> html(java)
		 */
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet doPost");
		//아이디/패스워드 등 
		//회원가입할 때 get방식으로 하면 정보가 다 드러나기 때문에
		//post 방식을 사용해야 한다.
		
		createHTML("POST방식", req, resp);
	}
	
	public void createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		System.out.println("name : " + name);
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<p>"+ methodType + "</p>");
		pw.println("<h3>name : " +name+"</h3>");
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
		// DB 접근 (MVC model2)
	}
}
