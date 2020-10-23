package main;

import java.util.List;
import db.DBConnection;
import dto.UserDto;
import jdbc.SelectTest;

public class mainClass {

	public static void main(String[] args) {
		
		DBConnection.initConnection();
		
		//다른 클래스 다 끝내고 마지막
		SelectTest st = new SelectTest();
		
		//1)
		String id = "abc";					// 검색 여기서
		UserDto dto = st.search(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}
		else { 
			System.out.println("등록되어 있지 않은 id입니다");
		}
		
		//2)	
		id = "bcd";
		dto = st.Select(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}
		else { 
			System.out.println("등록되어 있지 않은 id입니다");
		}
		
		//3)결과가 다수인
		List<UserDto> list = st.getUserList();
		for (UserDto user : list) {
			System.out.println(user.toString());			
		}
	}

}//
