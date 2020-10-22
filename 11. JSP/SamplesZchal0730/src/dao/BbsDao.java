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
//----------------------------------------------------------------------------------
	
	public void readcount(int seq) {
		String sql = "  UPDATE BBS "
				+ "	SET READCOUNT=READCOUNT+1 "
				+ " WHERE SEQ=? ";
	
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
	
//----------------------------------------------------------------------------------
	//req,step,depth
	
	public boolean answer(int seq, BbsDto bbs) {
		
		//update
		String sql1 = " UPDATE BBS "
					+ " SET STEP=STEP+1 "										//3 스탭을 늘려라
					+ " WHERE REF = (SELECT REF FROM BBS WHERE SEQ=? ) "		//1.REF가 같은 것 중
					+ "  AND STEP > (SELECT STEP FROM BBS WHERE SEQ=? ) ";		//2 현재 STEP보다 큰 스텝의
		
		//insert
		String sql2 = " INSERT INTO BBS "
					+ " (SEQ, ID, "
					+ " REF, STEP, DEPTH, "
					+ " TITLE, CONTENT, WDATE, DEL, READCOUNT) "
					+ " VALUES(SEQ_BBS.NEXTVAL, ?, "					
					+ " 	(SELECT REF FROM BBS WHERE SEQ=?), "
					+ " 	(SELECT STEP FROM BBS WHERE SEQ=?) + 1, "	//+1
					+ " 	(SELECT DEPTH FROM BBS WHERE SEQ=?) + 1, "	//+1
					+ "		?, ?, SYSDATE, 0, 0) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);				//확인
			System.out.println("1/6 answer success");
			
			// update
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			// psmt 초기화 - 두번째 쿼리문을 실행하기 위해 초기화해야한다
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
			
			conn.commit();	//db안에 
			
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
	
//----------------------------------------------------------------------------------
	
	/*
	//버튼으로 삭제 기능 해놨던거.. 삭제가 아니고 링크를 끊어줘야한다. 그냥 날리면 db에 문제가 생긴다. del값만 바뀌게...? update네...
	public boolean deleteBbs(int seq) {	//확인부분
		
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
	*/

//----------------------------------------------------------------------------------
	
	public boolean deleteBbs(int seq) {	//확인부분
			
			String sql = " UPDATE BBS "
						+" SET DEL=? "
						+" WHERE SEQ=? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			int count = 0;
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("1/6 deleteBbs success");
				
				psmt = conn.prepareStatement(sql);
				System.out.println("2/6 deleteBbs success");
				
								//title 변경
				psmt.setInt(1, 1);											//del 값 변경
				psmt.setInt(2, seq);										//들어온 seq로 그대로
				
				count = psmt.executeUpdate();
				System.out.println("3/6 deleteBbs success");
				
				System.out.println("4/6 deleteBbs success");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, null);
			}
			return count>0?true:false;
		}	
//----------------------------------------------------------------------------------	
	
	/*
	//강사님 지우는 코드
	public boolean deleteBbs(int seq) {
		
		String sql = " UPDATE BBS "
					+ " SET DEL=1 "	//내껀 밑에서 
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
	
	*/
//----------------------------------------------------------------------------------
	//내용 수정(제목/내용)
		public boolean updateBbs(int seq, String title, String content) {	//확인부분
				
				String sql = " UPDATE BBS "
							+" SET TITLE=?, CONTENT=? "
							+" WHERE SEQ=? ";
				
				Connection conn = null;
				PreparedStatement psmt = null;
				
				int count = 0;
				
				try {
					conn = DBConnection.getConnection();
					System.out.println("1/6 deleteBbs success");
					
					psmt = conn.prepareStatement(sql);
					System.out.println("2/6 deleteBbs success");
					
					//여기 부분 확인
					psmt.setString(1, title);	
					psmt.setString(2, content);
					psmt.setInt(3, seq);										
					
					count = psmt.executeUpdate();
					System.out.println("3/6 deleteBbs success");
					
					System.out.println("4/6 deleteBbs success");
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBClose.close(psmt, conn, null);
				}
				return count>0?true:false;
			}	
//----------------------------------------------------------------------------------
	/*
	//list 다시 뽑기 
		//제목/내용/작성자
			//3개로 뿌려주는게 통상적인
	
	// select의 각각의 경우로 나눠서 sql문 새로 만들어주나?
	 
		public List<BbsDto> searchList(String choice, String srchword) 
		//public String searchList(String abc)
		
		{	//리스트 잡아서 뿌려줄것
								//종류랑 값
			System.out.println(choice + " "  + srchword);
			
		//	select를 받는거로 넘어와			For문 돌려서 list뽑기
			
			String sql =     " SELECT SEQ, ID, REF, STEP, DEPTH, "
							+" TITLE, CONTENT, WDATE, "
							+" DEL, READCOUNT "
							+" FROM BBS ";
			String sql1 = " WHERE ID=? ";
			String sql2 = " WHERE TITLE=? ";
			String sql3	= " WHERE CONTENT=? ";
			
		//	list 한개
			if("wrt".equals(choice)) {
				sql = sql + sql1;
			}else if("sub".equals(choice)) {
				sql = sql + sql2;
			}else if("ctt".equals(choice)) {
				sql = sql + sql3;
			}
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			List<BbsDto> list = new ArrayList<BbsDto>();
			
			try {
				conn = DBConnection.getConnection();
				System.out.println("1/6 searchList success");
				
				System.out.println(sql);//여기까지
				System.out.println(srchword);//여기까지
				
				psmt = conn.prepareStatement(sql);				
				System.out.println("2/6 searchList success");
			
				psmt.setString(1, srchword);
				
				rs = psmt.executeQuery();
				
				System.out.println("3/6 searchList success");
				
				
				//if문으로 새로 add
				while (rs.next()) {
					int i = 1;
					//값 두개로만
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
				System.out.println("4/6 searchList success");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBClose.close(psmt, conn, rs);
				System.out.println("5/6 searchList success");
			}	
			return list;
			
			
			//밑에 코드로 바뀜
		}*/
//---------------------------------------------------------------------------------------------
	//검색 기능
		//오버로드
		public List<BbsDto> getBbsList(String choice, String searchWord) {
			
			String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
						+" TITLE, CONTENT, WDATE, "
						+" DEL, READCOUNT "
						+" FROM BBS ";
						//+" WHERE 1=1 "; 로 끝나고 " AND TITLE LIKE ~
					//	+ " WHERE TITLE LIKE %?% "	되지 않는다
					
			String sqlWord = "";
			if(choice.equals("wrt")) {	//abc abcde
				sqlWord = " WHERE ID='" + searchWord.trim() + "' AND DEL=0 ";
			}else if(choice.equals("sub")) {
				sqlWord = " WHERE TITLE LIKE '%" + searchWord.trim() + "%' AND DEL=0  ";
			}else if(choice.equals("ctt")) {
				sqlWord = " WHERE CONTENT LIKE '%" + searchWord.trim() + "%' AND DEL=0  ";
			}														
																		//DEL=0인 경우는 삭제기능과 비교
			sql = sql +  sqlWord;
						
			sql += " ORDER BY REF DESC , STEP ASC ";
																	
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
}
