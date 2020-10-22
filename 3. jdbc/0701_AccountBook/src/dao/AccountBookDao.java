package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.AccountBookDto;
import dto.MemberDto;

public class AccountBookDao {
	
	private static AccountBookDao bdao = null;
	
	private AccountBookDao() {
		
	}
	
	public static AccountBookDao getInstance() {
		if(bdao == null) {
			bdao = new AccountBookDao();
		}
		return bdao;
	}
	
	public boolean addAccount(AccountBookDto bdto) {
		String sql = " INSERT INTO ACCOUNTBOOK(SEQ, ID, IO_KIND, AMOUNT, CONTENT, WDATE) "
				+ " VALUES(ACCOUNTBOOK_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
								//여기확인
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println("sql:" + sql);
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
		//이부분 개...
			psmt.setString(1, bdto.getId());
			psmt.setString(2, bdto.getIo_kind());
			psmt.setInt(3, bdto.getAmount());
			psmt.setString(4, bdto.getContent());

			
			count = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
	}
	
	//가계부 내용 얻는
	//public List<AccountBookDto> get
	//끝

}
