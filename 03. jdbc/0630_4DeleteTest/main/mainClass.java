package main;

import db.DBConnection;
import jdbc.DeleteTest;


public class mainClass {

	public static void main(String[] args) {
		
		DBConnection.initConnection();
		
		DeleteTest dt = new DeleteTest();
		
		//1
		String id = "abc";
		
		boolean b = dt.Delete(id);
		if(b == true) {
			System.out.println("정상적으로 삭제되었습니다.");
		}
		
		
		
		//2
		id = "bcd";
		b = dt.Erase(id);
		if(b == false) {
			System.out.println("정상적으로 삭제되었다.");
		}

	}
}