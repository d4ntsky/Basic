package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class InsertTest {

	
	public InsertTest() {	
		
	/*
		try {	// 한번만
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	*/
	}
	
	/*
	public Connection getConnection() { //할 때마다 얻어와야함
										//conn이 db 내용을 갖고있어서?
		
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection
						("jdbc:oracle:thin:@192.168.7.44:1521:xe","hr","hr");
						
				System.out.println("Oracle Connection Success!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn; //db와 연결될 때
	}
	*/
	
	//테이블에 데이터 넣기
	
	public int insertData(String id, String name, int age) {
		
		// Query -> String 쿼리문 소문자 안먹힐때 있음
		String sql = " INSERT INTO USERTEST(ID, NAME, AGE, JOINDATE) "
		+ " VALUES('" + id + "', '" + name + "', " + age + ", SYSDATE) ";
		System.out.println("sql: " + sql);		//id와 name 작은 따옴표 확인 - 문자열
		
/**/	//Connection conn = this.getConnection(); 밑에껄로 바뀜
		Connection conn = DBConnection.getConnection();
		Statement stat = null; 
		//sql 소속 칠 때 확인
		 
		int count = 0; //몇 개가 변경되었는지? (return을 위한)
		
		try {
			
			stat = conn.createStatement();
			
			count = stat.executeUpdate(sql);	//!!!!!!!!!!!!!!!!!!!!
			
			System.out.println("성공적으로 추가 되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //무조건 실행되는
		
			/*
			try {
				if(stat != null) { //문이 안닫혔을때
				stat.close();
				} 
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 */
			DBClose.close(stat, conn, null);
		}
		
		return count;
	}
	
	
}



//만들 테이블
/*
CREATE TABLE USER(
	ID VARCHAR2(30) PRIMARY KEY,
	NAME VARCHAR2(30),
	AGE NUMBER(2),
	JOINDATE DATE
);
*/