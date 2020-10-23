package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.AccountBookDto;
import dto.MemberDto;

public class AccountBookDao {

	private static AccountBookDao ab = new AccountBookDao();
	
	private AccountBookDao() {		
	}
	
	public static AccountBookDao getInstance() {
		return ab;
	}
	
	public boolean addAccount(AccountBookDto dto) {
		
		String sql = " INSERT INTO ACCOUNTBOOK(SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE) "
					+ " VALUES(SEQ_BOOK.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getIo_kind());
			psmt.setInt(3, dto.getAmount());
			psmt.setString(4, dto.getContent());
			
			count = psmt.executeUpdate();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);			
		}
		
		return count>0?true:false;
	}
	
	public List<AccountBookDto> getABookList(String id, String sdate, String edate) {
		
		String sql = "SELECT IO_KIND, AMOUNT, CONTENT, WDATE "
				  + " FROM ACCOUNTBOOK "
				  + " WHERE WDATE BETWEEN TO_DATE( ?, 'YYMMDD') "
					+ " AND TO_DATE( ?, 'YYMMDD') "
					+ " AND ID = ? ";  
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<AccountBookDto> list = new ArrayList<AccountBookDto>();		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sdate);
			psmt.setString(2, edate);
			psmt.setString(3, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String io_kind = rs.getString("IO_KIND");
				int amount = rs.getInt("AMOUNT");
				String content = rs.getString("CONTENT");
				String wdate = rs.getString("WDATE");
				
				list.add(new AccountBookDto(0, "", io_kind, amount, content, wdate));
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		
		return list;
	}
	
}




