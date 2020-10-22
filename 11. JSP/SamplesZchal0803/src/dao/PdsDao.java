package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.PdsDto;

public class PdsDao {
	

	private static PdsDao dao = new PdsDao();
	
	private PdsDao() {
	}
	
	public static PdsDao getInstance() {
		return dao;
	}
	
//---------------------------------------------------------------------------------------
	//처음 자료실 뿌려주는
	public List<PdsDto> getPdsList() {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, FILENAME, "
				   + " READCOUNT, DOWNCOUNT, REGDATE "
				   + " FROM PDS "
				   + " ORDER BY SEQ DESC ";	//등록일 역순으로 해도 되지만 수정되면 REGDATE 바뀌는 사람도 있었어

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getPdsList success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getPdsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getPdsList success");
			
			while(rs.next()) {
				int i = 1;
				
				PdsDto dto = new PdsDto(rs.getInt(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getString(i++), 
										rs.getInt(i++), 
										rs.getInt(i++), 
										rs.getString(i++) );
				
				list.add(dto);
			}
			System.out.println("4/6 getPdsList success");
			
		} catch (Exception e) {
			System.out.println("getPdsList fail");
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
//---------------------------------------------------------------------------------------
	//자료 올리기 기능
	public boolean writePds(PdsDto pds) {
		
		String sql = " INSERT INTO PDS(SEQ, ID, TITLE, CONTENT, FILENAME, "
				   + " READCOUNT, DOWNCOUNT, REGDATE) "
				   + " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, "
				   + " 0, 0, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 writePds success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pds.getId());
			psmt.setString(2, pds.getTitle());
			psmt.setString(3, pds.getContent());
			psmt.setString(4, pds.getFilename());
			System.out.println("2/6 writePds success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 writePds success");
			
		} catch (Exception e) {
			System.out.println("writePds fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
	}

//---------------------------------------------------------------------------------------
	//
	
//---------------------------------------------------------------------------------------
	//
	
//---------------------------------------------------------------------------------------
	//
		
}
