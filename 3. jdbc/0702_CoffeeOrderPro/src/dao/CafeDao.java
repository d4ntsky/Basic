package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CafeDto;

public class CafeDao {

	private static CafeDao cadao = null;

	private CafeDao() {

	}

	public static CafeDao getInstance() {
		if (cadao == null) {
			cadao = new CafeDao();
		}
		return cadao;
	}

	// -----------------------------------------------------
	// 주문받기
	public boolean addOrder(CafeDto dto) { // dto겹치나?

		String sql = " INSERT INTO CAFE(ID, COFFEE, CUPSIZE, ADDSYRP, ADDSHOT, ADDWHIP, CUPS, PRICE) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?) "; // menu 오더버튼

		Connection conn = null;
		PreparedStatement psmt = null;

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			// ID,
			psmt.setString(1, dto.getId()); // 확인
			// COFFEE,
			psmt.setString(2, dto.getCoffee());
			// CUPSIZE,
			psmt.setString(3, dto.getCupsize());
			// ADDSYRP,
			psmt.setString(4, dto.getAddsyrp());
			// ADDSHOT,
			psmt.setString(5, dto.getAddshot());
			// ADDWHIP,
			psmt.setString(6, dto.getAddwhip());
			// CUPS,
			psmt.setInt(7, dto.getCups());
			// PRICE
			psmt.setInt(8, dto.getPrice());

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		return count > 0 ? true : false;

	}
	// 주문 받기 끝
	
	/*
	 * //주문 내역 보기??????????????????? 
	 * public List<CafeDto> getOrderList (String id,
	 * String coffee, String cupsize, String addsyrp, String addshot, String
	 * addwhip, int cups, int price){ //받아오는 부분 //전체 받는데 아스트리크? String sql =
	 * " SELECT ?, ?, ?, ?, ?, ?, ?, ? " + " FROM CAFE ";
	 * 
	 * Connection conn = null; PreparedStatement psmt = null; ResultSet rs = null;
	 * 
	 * List<CafeDto> list = new ArrayList<CafeDto>();
	 * 
	 * 
	 * try { conn = DBConnection.getConnection(); psmt = conn.prepareStatement(sql);
	 * psmt.setString(1, id); psmt.setString(2, coffee); psmt.setString(3, cupsize);
	 * psmt.setString(4, addsyrp); psmt.setString(5, addshot); psmt.setString(6,
	 * addwhip); psmt.setInt(7, cups); psmt.setInt(8, price);
	 * 
	 * rs = psmt.executeQuery();
	 * 
	 * //와일부분 필요한가 그냥 다 보면되는디... while(rs.next()) { String id1 = rs.getString("ID");
	 * String coffee1 = rs.getString("COFFEE"); String cupsize1 =
	 * rs.getString("CUPSIZE"); String addsyrp1 = rs.getString("ADDSYRP"); String
	 * addshot1 = rs.getString("ADDSHOT"); String addwhip1 =
	 * rs.getString("ADDWHIP"); int cups1 = rs.getInt("CUPS"); int price1 =
	 * rs.getInt("PRICE");
	 * 
	 * list.add(new CafeDto (id1, coffee1, cupsize1, addsyrp1, addshot1, addwhip1,
	 * cups1, price1)); }
	 * 
	 * //아이디로 해서 아이디가 동일한 것만 보게하나?
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } finally { DBClose.close(psmt, conn, rs); } return
	 * list;
	 * 
	 * } //주문 내역 끝내기
	 * 
	 */

	// 그냥 갖고오기
	public List<CafeDto> getOrderList() {
		// 받아오는 부분 //전체 받는데 아스트리크?
		String sql = " SELECT * " + " FROM CAFE ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<CafeDto> list = new ArrayList<CafeDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			// 와일부분 필요한가 그냥 다 보면되는디...
			while (rs.next()) {
				/*
				 * String id1 = rs.getString("ID"); String coffee1 = rs.getString("COFFEE");
				 * String cupsize1 = rs.getString("CUPSIZE"); String addsyrp1 =
				 * rs.getString("ADDSYRP"); String addshot1 = rs.getString("ADDSHOT"); String
				 * addwhip1 = rs.getString("ADDWHIP"); int cups1 = rs.getInt("CUPS"); int price1
				 * = rs.getInt("PRICE");
				 */
				String id = rs.getString(1);
				String coffee = rs.getString(2);
				String cupsize = rs.getString(3);
				String addsyrp = rs.getString(4);
				String addshot = rs.getString(5);
				String addwhip = rs.getString(6);
				int cups = rs.getInt(7);
				int price = rs.getInt(8);

				CafeDto dto = new CafeDto(id, coffee, cupsize, addsyrp, addshot, addwhip, cups, price);

				list.add(dto);
			}

			// 아이디로 해서 아이디가 동일한 것만 보게하나?

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;

	}
	// 그냥,,
}

/*
 * CREATE TABLE CAFE( ID VARCHAR2(30), COFFEE VARCHAR2(30) NOT NULL, CUPSIZE
 * VARCHAR2(30) NOT NULL, ADDSYRP VARCHAR2(30), ADDSHOT VARCHAR2(1), ADDWHIP
 * VARCHAR2(1), CUPS VARCHAR2(5), PRICE VARCHAR2(30), CONSTRAINT FK_CAFE FOREIGN
 * KEY(ID) REFERENCES CUSTOMER(ID) );
 */