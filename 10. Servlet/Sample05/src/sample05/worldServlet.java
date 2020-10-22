package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class worldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getParameter("url");
		
		if(url.equals("naver.com")) {
			resp.sendRedirect("http://www.naver.com");
		}
		else if(url.equals("google.com")) {
			resp.sendRedirect("http://www.google.com");
		}
		else {
			resp.sendRedirect("http://www.daum.net");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
