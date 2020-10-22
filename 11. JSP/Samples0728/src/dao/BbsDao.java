package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {

	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
		
	}
	
	public static BbsDao getInstance() {
		return dao;
	}
//---------------------------------------------------------------------------	
	public List<BbsDto> getBbsList() {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
					+" TITLE, CONTENT, WDATE, "
					+" DEL, READCOUNT "
					+" FROM BBS "
					+" ORDER BY REF DESC , STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getId success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getId success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getId success");
			
			while (rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++), 		//1
										rs.getString(i++), 		//2
										rs.getInt(i++), 
										rs.getInt(i++),
										rs.getInt(i++), 
										rs.getString(i++),  
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getInt(i++), 
										rs.getInt(i++));
				
				list.add(dto);
			}
			System.out.println("4/6 getId success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
//---------------------------------------------------------------------------	
	
	public boolean writeBbs(BbsDto dto) {
		
		String sql = " INSERT INTO BBS "
					+" (SEQ, ID, REF, STEP, DEPTH, "
					+" TITLE, CONTENT, WDATE, "
					+" DEL, READCOUNT) "
					+" VALUES( SEQ_BBS.NEXTVAL, ?, "
					+" (SELECT NVL(MAX(REF), 0)+1 FROM BBS), 0, 0, " //REF SEQ_BBS.NEXTVAL을 못 넣음 처음 실행되기 때문에!! /REF는 SEQUENCE랑 같음
					+" ?, ?, SYSDATE, "
					+" 0, 0) ";
		
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writeBbs success");
			
			psmt = conn.prepareStatement(sql);
			//ID, TITLE, CONTENT
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println("2/6 writeBbs success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writeBbs success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
	}		
//----------------------------------------------------------------------------------
	public BbsDto readBbs(int seq) {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
					+" TITLE, CONTENT, WDATE, "
					+" DEL, READCOUNT "
					+" FROM BBS "
					+" WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto bdto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getSeq success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getSeq success");
			
			psmt.setInt(1, seq);					//string?
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getSeq success");
			
			if (rs.next()) {
				int bbsseq = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(6);
				String content = rs.getString(7);
				String wdate = rs.getString(8);
				
				bdto = new BbsDto(bbsseq, id, 0, 0, 0, title, content, wdate, 0, 0);
			}
			System.out.println("4/6 getSeq success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return bdto;
	}	
//-----------------------------------------------------------
	public boolean deleteBbs(int seq) {
		
		String sql = " DELETE FROM BBS "
					+" WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 deleteBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 deleteBbs success");
			
			psmt.setInt(1, seq);					//string?
			
			count = psmt.executeUpdate();
			System.out.println("3/6 deleteBbs success");
			
			System.out.println("4/6 getSeq success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
	}	

}
