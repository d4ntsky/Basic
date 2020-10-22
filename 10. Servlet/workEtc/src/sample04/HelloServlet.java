package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("HelloServlet doGet");
		
		//String name = req.getParameter("name");
		//System.out.println("name : " + name);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		String name = req.getParameter("name");
		String adrNum1 = req.getParameter("adrNum1");	
		String adrNum2 = req.getParameter("adrNum2");
		String address = req.getParameter("address");
		String tele1 = req.getParameter("tele1");	//0이 지워짐
		String tele2 = req.getParameter("tele2");
		String tele3 = req.getParameter("tele3");
		String rece = req.getParameter("rece");
		String email = req.getParameter("email");
		String chotime = req.getParameter("chotime");

		pw.println("이름:" + name + "<br>");
		pw.println("우편번호:" + adrNum1+"-"+adrNum2 + "<br>");
		pw.println("주소:"+address + "<br>");
		pw.println("전화번호:"+ tele1 +"-"+ tele2 +"-"+ tele3 + "<br>");
		pw.println("true면 영수증 받음/false면 영수증 안받음      " +  rece + "<br>");
		pw.println("메일 수신 : " + email + "<br>");
		pw.println("배달시간 :" + chotime + "<br>");
		
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
