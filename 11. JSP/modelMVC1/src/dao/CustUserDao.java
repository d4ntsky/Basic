package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CustUserDto;

// Model
public class CustUserDao {
//--------------------------------------------------------------
	//singleton?
	private static CustUserDao dao = new CustUserDao();
	
	private CustUserDao() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver load Success");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static CustUserDao getInstance() {
		return dao;
	}
//--------------------------------------------------------------
	//모델 준비
	public List<CustUserDto> getCustUserList() {
		
		String sql = " SELECT ID, NAME, ADDRESS "
				   + " FROM CUSTUSER "
				   + " ORDER BY ID DESC ";
	
		Connection conn = null;				//DB connect
		PreparedStatement psmt = null;		//Query문 적용
		ResultSet rs = null;				//나온 결과값 담을 그릇
		
		List<CustUserDto> list = new ArrayList<CustUserDto>();	//확인
	
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				list.add( new CustUserDto(id, name, address) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(conn, psmt, rs);
		}
		
		return list;
	}
	
//--------------------------------------------------------------
	//고객 추가 기능
	public boolean addCustUser(CustUserDto dto) {
		
		String sql = " INSERT INTO CUSTUSER(ID, NAME, ADDRESS) "
					+" VALUES(?,?,?) ";
		
		Connection conn = null;				//DB connect
		PreparedStatement psmt = null;		//Query문 적용
		
		int count = 0;
		
		try {
			conn = this.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddress());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		
		return count>0?true:false;
	}
//--------------------------------------------------------------	
	//고객 업데이트
		public int updateCustUser(String id, String address) {
			
			String sql = " UPDATE CUSTUSER "
					+ " SET ADDRESS=?"
					+ " WHERE ID=? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			int count = 0;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, address.trim());
				
				psmt.setString(2, id.trim());
				
				count = psmt.executeUpdate();
				
			} catch (SQLException e) {			
				e.printStackTrace();
			} finally{
				close(conn, psmt, null);			
			}
			
			return count;
		}
	//위에서 얻은걸 update sql = " update id		
		
//--------------------------------------------------------------	
	//고객 삭제
	public boolean delCustUser(String id) {
		
		String sql = " DELETE FROM CUSTUSER "
					+" WHERE ID = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = this.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		return count>0?true:false;
	}
//--------------------------------------------------------------	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------
										//localhost로 바꿔서
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@192.168.7.44:1521:xe";
		String user = "hr";
		String password = "hr";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		
			try {
				if(conn != null) {
					conn.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
	}
}
