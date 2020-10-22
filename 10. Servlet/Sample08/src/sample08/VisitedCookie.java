package sample08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitedCookie") //namespace
public class VisitedCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head");
		pw.println("<body>");		
		
		pw.println("<p>방문 횟수</p>");	
		
		Cookie cookies[] = req.getCookies();
		Cookie visitedCookie = null;	//키 관리를 위한 쿠키
		
		if(cookies != null)	{
			// 검색
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("visited")) {
					visitedCookie = cookies[i];
									//cf)쿠키명 같으면 덧씌워짐.
					break;
				}
			}
			// 찾음
			if(visitedCookie != null) {
				int count = Integer.parseInt( visitedCookie.getValue() ) + 1;
				pw.println("<p>"+ count + "번째 방문입니다<p>");
				
				//cookie값을 갱신
				visitedCookie.setValue(count + "");
				visitedCookie.setMaxAge(60); //365일*24시*60분*60초=1년//기간 설정
				resp.addCookie(visitedCookie);
			}
			// 못 찾음
			else {
				// 쿠키를 생성
				pw.println("<p>첫번째 방문입니다<p>");
				Cookie newCookie = new Cookie("visited", "1");
				resp.addCookie(newCookie);
			}
			//
		}else {
			
		}
		
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
