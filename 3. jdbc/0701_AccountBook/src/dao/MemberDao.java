package dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	//--
	private static MemberDao dao = null;	//싱글턴
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}				
	//--
	
	//id확인부분 signView Check 시작 
	public boolean getId(String id) {
		String sql = " SELECT ID "
				   + " FROM MEMBER "
				   + " WHERE ID = ? ";
		 						   //AND PW = ? " 회원가입시?
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean findid = false;
		
	
		try {
			conn = DBConnection.getConnection(); // db정보
			
			psmt = conn.prepareStatement(sql);   // db에다가 query 적용/실행/접목
			psmt.setString(1, id);	//프리페어
			
			rs = psmt.executeQuery();			 // db로부터 데이터를 취득
													//select문장에서 excute쿼리를 쓴다
			if(rs.next()) { //id 있음
				findid = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();//쿼리문 틀렸다는 
		} finally {
			DBClose.close(psmt, conn, rs); 
		}
		
		return findid;
	}
	//id확인부분 signView Check 끝

	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
				+ " VALUES(?, ?, ?, ?, 3) ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println("sql:" + sql);
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, null);			
		}		
		
		return count>0?true:false;
	}
	
	//(1) 시작
	public boolean checkidpw(String id, String pw) {	//pw확인
		String sql = " SELECT ID, PWD "
					+" FROM MEMBER "
					+" WHERE ID = ? AND PWD = ? ";	//아이디 비번
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean findidpw = false;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);						//pw확인
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				findidpw = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);			//여기 확인
		}
		return findidpw;
		
	}
	//(1) 끝

	//login
	
	private String loginID;
	
	public MemberDto login(String id, String pwd) {
		
		String sql = " SELECT ID, NAME, EMAIL, AUTH "
					+" FROM MEMBER "
					+" WHERE ID = ? AND PWD = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pwd.trim());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String _id = rs.getString(1);
				String _name = rs.getString(2);
				String _email = rs.getString(3);
				int auth = rs.getInt(4);
				
				mem = new MemberDto(_id, null, _name, _email, auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return mem;
	}
	
	public String getLoginID() {
		return loginID;		
	}
	
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}



	//(2) 시작
/*
	public boolean addMember(MemberDto dto) {
		String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
				+ " VALUES(?, ?, ?, ?, 3) ";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		System.out.println("sql:" + sql);
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, null);			
		}		
		
		return count>0?true:false;
	}
	 */
	//(2) 끝
}	
	
/*	원래 1
	public int addMember(String id, String pwd, String name, String email) {
		
		String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL) "
				+ " VALUES('" + id + "', '" + pwd + "', '" + name + "', '" + email + "') ";
		System.out.println("sql: " + sql);	
	
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
			int count = 0;
		
		try {
			stat = conn.createStatement();
			
			count = stat.executeUpdate(sql);
			
			System.out.println("성공적으로 추가 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stat, conn, null);
	}
	return count;	
	
	}
	*/
	

