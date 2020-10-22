package cust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CustUserDto;
import net.sf.json.JSONObject;

@WebServlet("/custuser")
public class CustUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("CustUserServlet doGet");
		
		//수신 받는 부분
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println(id + " " + pwd);
		
//jsonObject에 넣는 방법
		/*
		//1 Data(String) 전송
		JSONObject jobj = new JSONObject();							//json을 object로 바꿔주는?
		jobj.put("str", "Hello");	
		
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().print(jobj);		
		*/
		
		
		/*
		//2 Data(HashMap) 전송
		HashMap<String, Object> map = new HashMap<String, Object>();	//생성
		map.put("title", "사과");											//값 넣기
		
		JSONObject jobj = new JSONObject();								//json을 object로 바꿔주는?	//java map을 json으로 바꾼뒤?
		jobj.put("map", map);					
		
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().print(jobj);		
		*/
		
		
		//3 Data(list) 전송
			//list에 데이터를 저장
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		list.add(new CustUserDto("aaa", "홍길동", "서울시"));
		list.add(new CustUserDto("bbb", "일지매", "부산시"));
		
			//HashMap에 list를 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("custlist", list);
		
			//전송할 데이터를 추가
		JSONObject jobj = new JSONObject();	
		jobj.put("map", map);
		
			//전송
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().print(jobj);									//날리기인가?
																		 
																		 															
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("CustUserServlet doPost");
		
	}

	
}
