package calendarEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

public class CalendarDao {

//-------------------------------------------------------------------------	
	
	private static CalendarDao dao = new CalendarDao();
	
	private CalendarDao() {
		
	}
	
	public static CalendarDao getInstance() {
		return dao;
	}
	
//-------------------------------------------------------------------------
	
	public List<CalendarDto> getCalendarList(String id, String yyyyMM) {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " 
				   + " FROM ( " 
				   									//OVER() 안에서 행해지는 거에 따라 번호가 매겨지는
				   + "		SELECT ROW_NUMBER()OVER(PARTITION BY SUBSTR(RDATE, 1, 8)ORDER BY RDATE ASC) AS RNUM, " //파티션으로 나눈거 숫자로 한걸 번호를 매겼다.
				   					//행 넘버로							//일별 일정:20200731
				   + "				SEQ, ID, TITLE, CONTENT, RDATE, WDATE " 
				   + "		FROM CALENDAR "  
				   + "		WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? " 
				   					//누구의		  //월별			202007
				   + " ) " 
				   + " WHERE RNUM BETWEEN 1 AND 5 "; // 다섯개넘으면 보이는 달력에 5개가 넘어가면 모양이 깨짐..
		//월별로 가져와서 일별로 뿌려줌
		//적은 날짜(WDATE)는 중요치 않고 RDATE가 중요
		
		// cf) SQL쿼리문은 테스트 해보고 쿼리 가져가기
		
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try {
			
			conn = DBConnection.getConnection();
			System.out.println("1/6 getCalendarList success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM);
			System.out.println("2/6 getCalendarList success");
			//System.out.println(sql);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getCalendarList success");
			
			while(rs.next()) {
				
				int i = 1;
				
				//CalendarDto dto = new CalendarDto(seq, id, title, content, rdate, wdate);
				
				CalendarDto dto = new CalendarDto(	rs.getInt(i++), 
													rs.getString(i++), 
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++) );
				
				list.add(dto);
			}
			System.out.println("4/6 getCalendarList success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

//-------------------------------------------------------------------------
	//일정 올려주는
	public boolean addCalendar(CalendarDto cal) {
		
		String sql = " INSERT INTO CALENDAR(SEQ, ID, TITLE, CONTENT, RDATE, WDATE) "
				   + " VALUES(SEQ_CAL.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			System.out.println("1/6 addCalendar success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getId());
			psmt.setString(2, cal.getTitle());
			psmt.setString(3, cal.getContent());
			psmt.setString(4, cal.getRdate());
			System.out.println("2/6 addCalendar success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 addCalendar success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count>0?true:false;
		
	}
	
//-------------------------------------------------------------------------	
	//detail 일정 누르면 불러오는 부분
	public CalendarDto getMeeting(int seq) {
		
		String sql = " SELECT * "
				   + " FROM CALENDAR "
				   + " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CalendarDto dto = null;
				
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 getMeeting success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 getMeeting success");
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getMeeting success");
			
			if(rs.next()) {
				int i = 1;
				dto = new CalendarDto( rs.getInt(i++), 
										rs.getString(i++), 
										rs.getString(i++),  
										rs.getString(i++), 
										rs.getString(i++),  
										rs.getString(i++) );
			}
			System.out.println("4/6 getMeeting success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}
//-------------------------------------------------------------------------	
	//일정 누르면 그날의 일정을 모두 불러오는 부분
	public List<CalendarDto> getTheCalList(String id, String yyyyMMdd) {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE " 
				   + " FROM ( " 
				   + "		SELECT ROW_NUMBER()OVER(PARTITION BY SUBSTR(RDATE, 1, 8)ORDER BY RDATE ASC) AS RNUM, " 
				   + "				SEQ, ID, TITLE, CONTENT, RDATE, WDATE " 
				   + "		FROM CALENDAR "  
				   + "		WHERE ID=? AND SUBSTR(RDATE, 1, 8)=? " 
				   + " ) " 
				   + " WHERE RNUM BETWEEN 1 AND 5 "; // 다섯개넘으면 보이는 달력에 5개가 넘어가면 모양이 깨짐..
		//월별로 가져와서 일별로 뿌려줌
		//적은 날짜(WDATE)는 중요치 않고 RDATE가 중요
		
		// cf) SQL쿼리문은 테스트 해보고 쿼리 가져가기
		
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try {
			
			conn = DBConnection.getConnection();
			System.out.println("1/6 getTheCalList success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMMdd);
			System.out.println("2/6 getTheCalList success");
			//System.out.println(sql);
			
			rs = psmt.executeQuery();
			System.out.println("3/6 getTheCalList success");
			
			while(rs.next()) {
				
				int i = 1;
				
				//CalendarDto dto = new CalendarDto(seq, id, title, content, rdate, wdate);
				
				CalendarDto dto = new CalendarDto(	rs.getInt(i++), 
													rs.getString(i++), 
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++) );
				
				list.add(dto);
			}
			System.out.println("4/6 getTheCalList success");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
//-------------------------------------------------------------------------	
	//일정 삭제	
	public boolean deleteCal(int seq) {	//확인부분
			
			String sql = " DELETE FROM CALENDAR "						 
					   + " WHERE SEQ=? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			int count = 0;
						
			try {
				conn = DBConnection.getConnection();
				System.out.println("1/6 deleteBbs success");
				
				psmt = conn.prepareStatement(sql);
				System.out.println("2/6 deleteBbs success");
					
				psmt.setInt(1, seq);										//들어온 seq로 그대로
				
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
//-------------------------------------------------------------------------	
	//일정 수정
	public boolean updateCal(int seq, String title, String content, String rdate) {	
		
		String sql = " UPDATE CALENDAR "
				   + " SET TITLE=?, CONTENT=?, RDATE=? "
				   + " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 deleteBbs success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 deleteBbs success");
			
			psmt.setString(1, title);	
			psmt.setString(2, content);
			psmt.setString(3, rdate);
			psmt.setInt(4, seq);
			
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

//-------------------------------------------------------------------------	
}
