package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public List<BbsDto> getBbsList() {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
						+ " TITLE, CONTENT, WDATE, "
						+ " DEL, READCOUNT "
						+ " FROM BBS "
						+ " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success");
			
			while(rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++), 
										rs.getString(i++), 
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
			System.out.println("4/6 getBbsList success");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return list;
	}
	
	public boolean writeBbs(BbsDto dto) {
		
		String sql = " INSERT INTO BBS "
					+ " (SEQ, ID, REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, "
					+ " DEL, READCOUNT) "
					+ " VALUES( SEQ_BBS.NEXTVAL, ?, "
							+ "	(SELECT NVL(MAX(REF), 0)+1  FROM BBS), 0, 0, "
							+ " ?, ?, SYSDATE, "
							+ " 0, 0) "; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writeBbs success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println("2/6 writeBbs success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writeBbs success");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBClose.close(psmt, conn, null);			
		}
		return count>0?true:false;
	}
	
	public BbsDto getBbs(int seq) {
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE,"
				+ " DEL, READCOUNT "
				+ " FROM BBS "
				+ " WHERE SEQ=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		BbsDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbs success");
		
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbs success");
			
			psmt.setInt(1, seq);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbs success");
			
			if(rs.next()) {
				int i = 1;
				dto = new BbsDto(rs.getInt(i++), 
								rs.getString(i++), 
								rs.getInt(i++), 
								rs.getInt(i++), 
								rs.getInt(i++), 
								rs.getString(i++), 
								rs.getString(i++), 
								rs.getString(i++), 
								rs.getInt(i++), 
								rs.getInt(i++));
			}
			System.out.println("4/6 getBbs success");
			
		} catch (Exception e) {
			System.out.println("getBbs fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return dto;
	}
	public void readcount(int seq) {
		String sql = " UPDATE BBS "
				+ 	 " SET READCOUNT=READCOUNT+1 "
				+ 	 " WHERE SEQ=? ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 readcount success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);			
			System.out.println("2/6 readcount success");
			
			psmt.executeUpdate();
			System.out.println("3/6 readcount success");
			
		} catch (Exception e) {
			System.out.println("readcount fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);			
		}	
	}
	
	public boolean answer(int seq, BbsDto bbs) {		
		// update
		String sql1 = " UPDATE BBS "
					+ " SET STEP=STEP+1 "
					+ " WHERE REF=(SELECT REF FROM BBS WHERE SEQ=? ) "
					+ " 	AND STEP>(SELECT STEP FROM BBS WHERE SEQ=? ) ";
		
		// insert
		String sql2 = " INSERT INTO BBS "
					+ " (SEQ, ID, "
					+ " REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, DEL, READCOUNT) "
					+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
					+ "		(SELECT REF FROM BBS WHERE SEQ=?), "
					+ "		(SELECT STEP FROM BBS WHERE SEQ=?) + 1, "
					+ "     (SELECT DEPTH FROM BBS WHERE SEQ=?) + 1, "
					+ "		?, ?, SYSDATE, 0, 0) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			// update
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
						
			// psmt 초기화
			psmt.clearParameters();
			
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);
			psmt.setInt(3, seq);
			psmt.setInt(4, seq);
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("5/6 answer success");
			
			conn.commit();
			
		} catch (Exception e) {			
			e.printStackTrace();			
			try {
				conn.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
		} finally {			
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			DBClose.close(psmt, conn, null);
			System.out.println("6/6 answer success");
		}
		return count>0?true:false;
	}

	public boolean deleteBbs(int seq) {
		
		String sql = " UPDATE BBS "
					+ " SET DEL=1 "
					+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 S deleteBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 S deleteBbs");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 S deleteBbs");
			
		} catch (Exception e) {		
			System.out.println("fail deleteBbs");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);			
		}
		
		return count>0?true:false;
	}
	
	public List<BbsDto> getBbsList(String choice, String searchWord) {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
						+ " TITLE, CONTENT, WDATE, "
						+ " DEL, READCOUNT "
						+ " FROM BBS ";					
						
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' AND DEL=0 ";
		}else if(choice.equals("writer")) {
			sqlWord = " WHERE ID='" + searchWord.trim() + "'"; 
		}else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
		} 
		sql = sql + sqlWord;
				
		sql += " ORDER BY REF DESC, STEP ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success");
			
			while(rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++), 
										rs.getString(i++), 
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
			System.out.println("4/6 getBbsList success");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return list;
	}
	
	public boolean updateBbs(int seq, String title, String content) {
		String sql = " UPDATE BBS SET "
				+ " TITLE=?, CONTENT=? "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 S updateBbs");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setInt(3, seq);
			
			System.out.println("2/6 S updateBbs");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 S updateBbs");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, null);
			System.out.println("5/6 S updateBbs");
		}		
		
		return count>0?true:false;
	}
	
	// 글의 모든 갯수
	/*
	public int getAllBbs() {
		String sql = " SELECT COUNT(*) FROM BBS ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int len = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				len = rs.getInt(1);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return len;
	}
	*/
	public int getAllBbs(String choice, String searchWord) {
		String sql = " SELECT COUNT(*) FROM BBS ";
		
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' ";
		}else if(choice.equals("writer") && !searchWord.equals("")) {
			sqlWord = " WHERE ID='" + searchWord.trim() + "'";
		}else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
		}
		sql += sqlWord;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int len = 0;
				
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				len = rs.getInt(1);
			}			
		} catch (Exception e) {
			System.out.println("getAllBbs fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return len;		
	}
	
	public List<BbsDto> getBbsPagingList(String choice, String searchWord, int page) {
		
		/*
			1. row 번호
			2. 검색
			3. 정렬
			4. 범위 1 ~ 10
		*/
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, "
				+ " DEL, READCOUNT "
				+ " FROM ";
		
		sql += "(SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM, " + 
				"	SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT " + 
				" FROM BBS ";
		
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' AND DEL=0 ";
		}else if(choice.equals("writer")) {
			sqlWord = " WHERE ID='" + searchWord.trim() + "'"; 
		}else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
		} 
		sql = sql + sqlWord;
		
		sql += " ORDER BY REF DESC, STEP ASC) ";
		sql += " WHERE RNUM >= ? AND RNUM <= ? ";
		
		int start, end;
		start = 1 + 10 * page;	// 시작 글의 번호
		end = 10 + 10 * page;	// 끝 글의 번호
		
		/*
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
						+ " TITLE, CONTENT, WDATE, "
						+ " DEL, READCOUNT "
						+ " FROM BBS ";					
						
		String sqlWord = "";
		if(choice.equals("title")) {
			sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' AND DEL=0 ";
		}else if(choice.equals("writer")) {
			sqlWord = " WHERE ID='" + searchWord.trim() + "'"; 
		}else if(choice.equals("content")) {
			sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' ";
		} 
		sql = sql + sqlWord;
				
		sql += " ORDER BY REF DESC, STEP ASC ";
		*/
		
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<BbsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getBbsList success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			System.out.println("2/6 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getBbsList success");
			
			while(rs.next()) {
				int i = 1;
				BbsDto dto = new BbsDto(rs.getInt(i++), 
										rs.getString(i++), 
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
			System.out.println("4/6 getBbsList success");
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);			
		}
		return list;
	}
	
	
	
}
















