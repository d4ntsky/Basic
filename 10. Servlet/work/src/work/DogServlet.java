package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.animalDto;

@WebServlet("/helloDog")
public class DogServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		animalDto dto =(animalDto)req.getAttribute("dog");
		
		System.out.println(dto.toString());
		

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Dog</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<h1>강아지</h1>");
		pw.println("이름:<input type='txt' value="+ dto.getName() + ">" + "<br>");
		pw.println("나이:<input type='txt' value="+ dto.getAge() + ">" + "<br>");
		pw.println("성격:<input type='txt' value="+ dto.getMood() + ">");
	
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}

	
}
