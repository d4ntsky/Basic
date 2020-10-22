package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/helloCat")
public class CatServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("name");
		String age = (String)session.getAttribute("age");
		String mood = (String)session.getAttribute("mood");
		System.out.println(name + " " + age + " " + mood);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Dog</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<h1>고양이</h1>");
		pw.println("이름:<input type='txt' value="+ name + ">" + "<br>");
		pw.println("나이:<input type='txt' value="+ age + ">" + "<br>");
		pw.println("성격:<input type='txt' value="+ mood + ">");
	
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
