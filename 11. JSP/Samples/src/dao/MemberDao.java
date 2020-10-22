package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {

	private static MemberDao dao = new MemberDao();

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		return dao;
	}

//-----------------------------------------------------------------------------------
	// id확인용 함수 -> 있으면 true 없으면 false
	public boolean getId(String id) {

		return true;
	}

//-----------------------------------------------------------------------------------
	// 회원 가입의 데이터 -> DB에
	public boolean addMember(MemberDto dto) {

		String sql = " INSERT INTO MEMBER "
				   + " (ID, PWD, NAME, EMAIL, AUTH) " 
				   + " VALUES(?,?,?,?,3) ";

		Connection conn = null;
		PreparedStatement psmt = null;		
		
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

//-----------------------------------------------------------------------------------
	// id확인용 함수 -> 있으면 true 없으면 false
	public MemberDto getMember(String id) {

		String sql = " SELECT ID, NAME, EMAIL " + " FROM MEMBER" + " WHERE ID=?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		MemberDto dto = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("ID"));
				dto.setPwd(rs.getString("PWD"));
				dto.setName(rs.getString("NAME"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setAuth(rs.getInt("AUTH"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}

//-------------------------------------------------------------------------
	public List<MemberDto> getMemberList() {

		String sql = " SELECT ID, PWD, NAME, EMAIL " 
					+" FROM MEMBER ";

		Connection conn = null; // DB connect
		PreparedStatement psmt = null; // Query문 적용
		ResultSet rs = null; // 나온 결과값 담을 그릇

		List<MemberDto> list = new ArrayList<MemberDto>(); // 확인

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");

				list.add(new MemberDto(id, pwd, name, email, 3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}
}
