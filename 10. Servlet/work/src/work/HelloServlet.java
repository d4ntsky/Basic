package work;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.animalDto;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("doget");
		
		//String animal = req.getParameter("animal");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mood = req.getParameter("mood");	
		
		animalDto dto = new animalDto(name, age, mood);
		
		
		/*
		HttpSession session = null;
		session = req.getSession();
		 */
		req.getSession().setAttribute("name", dto.getName());	// key:name, value:파라미터로 넘어온
		req.getSession().setAttribute("age", dto.getAge());
		req.getSession().setAttribute("mood", dto.getMood());

		resp.sendRedirect("helloCat");
		

	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("dopost");
	
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String animal = req.getParameter("animal");
		String mood = req.getParameter("mood");
		/*
		System.out.println(name);
		System.out.println(age);
		System.out.println(animal);
		System.out.println(charac);
		*/
		/*
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<h1>Hello Servlet</h1>");
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
		*/
	
		animalDto dto = new animalDto(name, age, mood);
		
	
			//강아지 서블릿으로
			req.setAttribute("dog", dto);
			
			//this.forward("helloDog", req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher("helloDog");
			dispatcher.forward(req, resp);
			//고양이 서블릿으로
		
		
	}
	
	public void forward(String linkname, HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher(linkname);
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
