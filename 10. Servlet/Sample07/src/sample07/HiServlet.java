package sample07;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.HumanDto;

public class HiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("HiServlet do Post");
		
		//문자열 깨지는거 고치는
		req.setCharacterEncoding("utf-8");
		
		
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age") );
		
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		
		/*
		//Get으로 가는 방식		
		String ename = URLEncoder.encode(name);//한글일 경우 번거롭다.
						//@webservlet 적은 이름
		resp.sendRedirect("sample?name=" + ename + "&age=" + age);					
		*/
		
		//Post로 가는 방식
		HumanDto dto = new HumanDto(name, age);
		req.setAttribute("hman", dto);
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("sample");
		//dispatcher.forward(req, resp);	// post -> post
		//==
		this.forward("sample", req, resp);	// 밑에 따로 만들어주는
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
