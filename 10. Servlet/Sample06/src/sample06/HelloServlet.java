package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ObjectDto;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String sAge = req.getParameter("age");
		
		System.out.println(name);
		System.out.println(sAge);
		
		int age = 0;
		if(sAge == null || sAge.trim().equals("")) {
			resp.sendRedirect("index.html");
		}else {
			age = Integer.parseInt(sAge);
		}
		
		String fruits[] = req.getParameterValues("fruit");
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
		//1. 데이터 모으기
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		//2. 짐을 쌓은 부분!
		req.setAttribute("myfruit", dto); //!!!!!!!!
		
		// servlet(java) -> jsp
		// servlet(java) -> servlet(java) 자바에서 자바로
		// sendRedirect와 forward!!!!!!!!!!!
		// 짐이랑 같이 보내기
		
		// ResultServlet으로 이동
		//resp.sendRedirect("result");

		//3.위에서 짐을 쌓은것을 한번에 보내는 곳
			//1)짐갖고감
		//RequestDispatcher dispatch = req.getRequestDispatcher("result");
		//dispatch.forward(req, resp);
		//==
		req.getRequestDispatcher("result").forward(req, resp);
		
			//2)짐안갖고감//nullpointexception 나온다!!!
		//resp.sendRedirect("result");
//		resp.sendRedirect("result?name=" + name + "&age=" + age + "&fruit=" + fruits[0]);
		//이런식으로 보내 줄수는 있음 - 과일보내는 부분 확인!!!!!!!!!!!!
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
