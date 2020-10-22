package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

@WebServlet("/list")
public class CustUserListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustUserDao dao = CustUserDao.getInstance();
		
		List<CustUserDto> list = dao.getCustUserList();
		
		req.setAttribute("custlist", list);		// 짐싸		
		forward("custuserlist.jsp", req, resp);	// 거길루 가!
		
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//muldel 추가
		String work = req.getParameter("work");
		
		if(work.equals("mulDel")) {				// delete
			CustUserDao dao = CustUserDao.getInstance();
		String delck[] = req.getParameterValues("delck");
		
		boolean isS = true;
		if(delck != null){
			isS = dao.deleteCustUsers(delck);	

			resp.sendRedirect("list");	
			}

		}
	}	
	
	public void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher(link);
		dis.forward(req, resp);		
	}
	
}





