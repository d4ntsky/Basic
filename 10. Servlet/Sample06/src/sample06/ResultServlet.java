package sample06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ObjectDto;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//1) (짐)데이터 넘어왔는지 확인
		ObjectDto dto = (ObjectDto)req.getAttribute("myfruit");
		System.out.println(dto.toString());
		
			//2) sendRedirect는 getParameter로 받아야함 
		
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		
		pw.println("<h1>Hello Result</h1>");
		
			//1)
		//확인 부분
		
		pw.println("이름:<input type='txt' value="+ dto.getName() + ">");
		pw.println("나이:<input type='txt' value="+ dto.getAge() + ">");
		
		String fruits[] = dto.getFruit();
		for (int i = 0; i < dto.getFruit().length; i++) {
			pw.println("<p>"+ fruits[i] + "</p>");
		} 
		
			//2)
		/*
		String name = req.getParameter("name");
		int age =  Integer.parseInt(req.getParameter("age"));
		String fruits[] = req.getParameterValues("fruit");
		pw.println("이름:<input type='txt' value="+ name + ">");
		pw.println("나이:<input type='txt' value="+ age + ">");
		for (int i = 0; i < fruits.length; i++) {
			pw.println("<p>" + fruits[i] + "</p>");
			
		}
		*/
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();//오는 지 확인용
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
