package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class UpdateTest {

	public boolean Update(String id, int age) {
		
		String sql = " UPDATE USERTEST "
				+ " SET AGE = " + age + " "
				+ " WHERE ID = '" + id + "' ";
		System.out.println("sql: " + sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null; //string sql을 위한 실행문
		
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, null);
		}
		
		return count > 0 ? true:false; //boolean
		//==return count > 0 ? true:false;
	}
}
