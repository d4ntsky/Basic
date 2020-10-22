package sample07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

@WebServlet("/sample")	//새로운 기능
public class SampleServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet do Get");
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		
		System.out.println("이름: "+name);	//이름이 ???로 오지 않음
		System.out.println("나이: "+age);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet do Post");
		
		//데이터 풀기
		HumanDto dto = (HumanDto)req.getAttribute("hman");
	
		System.out.println(dto.toString());
		
		//다시 짐 싸기
		req.setAttribute("dto", dto);
		
		//
		forward("detail.jsp", req, resp);
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
