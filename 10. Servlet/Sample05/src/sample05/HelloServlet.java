package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("helloServlet doPost");
		
		String url = req.getParameter("url");
		
		// link를 설정한 경우
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		
		if(url.equals("naver.com")) {
			resp.setHeader("Location", "http://www.naver.com");
		}
		else if(url.equals("google.com")) {
			resp.setHeader("Location", "http://www.google.com");
		}
		else {
			resp.setHeader("Location", "http://zum.com");
		}
	}

}
