package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

@WebServlet("/update")
public class CustUserUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String work = req.getParameter("work");
				
		CustUserDao dao = CustUserDao.getInstance();
		if(work.equals("updateView")) {				// update view로 이동			
			String id = req.getParameter("id");
			CustUserDto cust = dao.getCustuser(id);
			
			req.setAttribute("cust", cust);
			forward("custuserupdate.jsp", req, resp);
		}
		else if(work.equals("updateAf")) {			// 수정후 DB에 저장
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			
			dao.updateCustUser(id, name, address);			
			resp.sendRedirect("list");
		}
		else if(work.equals("del")) {				// delete
			System.out.println("work.equals(\"del\")");
			String id = req.getParameter("id");
			
			dao.deleteCustUser(id);
			resp.sendRedirect("list");			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	public void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher(link);
		dis.forward(req, resp);		
	}
}
