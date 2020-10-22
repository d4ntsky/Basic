package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.CustomerDto;

public class CustomerDao {

	private static CustomerDao cudao = null;

	private CustomerDao() {

	}

	public static CustomerDao getInstance() {
		if (cudao == null) {
			cudao = new CustomerDao();
		}
		return cudao;
	}
	// -----------------------------------------------------

	private String loginID;// ?????????

	// id 있나없나 체크
	public boolean getId(String id) {

		String sql = " SELECT ID " + " FROM CUSTOMER " + " WHERE ID = ? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		boolean findid = false;

		try {

			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				findid = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return findid;
	}

	// 회원가입 시작
	public boolean addCustomer(CustomerDto dto) {
		String sql = " INSERT INTO CUSTOMER(ID, PWD, NAME, CUGE) " + " VALUES(?, ?, ?, ?) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		System.out.println("sql: " + sql);

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getCuge());

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count > 0 ? true : false;

	}
	// 회원가입 끝

	// 로그인 시작
	public CustomerDto login(String id, String pwd) {

		String sql = " SELECT ID, NAME, CUGE " // 왜 패스워드는 빠졌어야 될까?
				+ " FROM CUSTOMER " + " WHERE ID=? AND PWD=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		CustomerDto cus = null;

		conn = DBConnection.getConnection();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, pwd.trim());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String ide = rs.getString(1);
				String name = rs.getString(2);
				String cuge = rs.getString(3);

				cus = new CustomerDto(ide, null, name, cuge); // 오류나던곳 다시씀

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return cus;

	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginId(String loginID) {
		this.loginID = loginID;
	}
	// 로그인 끝

}
