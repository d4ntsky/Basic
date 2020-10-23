package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class DeleteTest {

	
//----------------------------------------------------------
	//1
	public boolean Delete(String id) {
		//ID는 PRIMARY키로 설정되어 있기 때문에 한 값 밖에 없으므로 !!

		String sql = " DELETE FROM USERTEST "
				+  " WHERE ID = '" + id + "' ";
		System.out.println("sql: " + sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null; //String sql을 위한 실행문
		
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
	}
//----------------------------------------------------------	
	//2
//prepareStatement(); 구조로 바꿔보기
	public boolean Erase(String id) {
		String sql = " DELETE FROM USERTEST "
				+  " WHERE ID = ? ";
		System.out.println("sql: " + sql);
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		int coun = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);//?부분 해당
			coun = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return coun == 0 ? true:false; 	
	}

}
