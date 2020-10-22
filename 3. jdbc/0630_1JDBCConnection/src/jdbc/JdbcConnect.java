package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
	//드라이브 있는지 없는지
	public JdbcConnect() {	//생성자 생성
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//forName 클래스가 있냐없냐
			System.out.println("Driver Loading Success");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//드라이브와 연결
	public Connection getConnection() { //jdbc의 오브젝트 return?
		
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection
						("jdbc:oracle:thin:@192.168.7.44:1521:xe","hr","hr");
						//database development에서 property로 확인 가능
				System.out.println("Oracle Connection Success!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
	}
}
/*
create table user(
	id varchar2(30) primary key,
	name varchar2(30),
	age number(2),
	joindate date
);
		*/