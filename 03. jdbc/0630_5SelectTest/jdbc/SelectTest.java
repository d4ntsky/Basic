package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;


public class SelectTest {

//----------------------------------------------------------	
// 1개의 Data 취득 ex) ID 찾기
//1)1개	
	public UserDto search(String id) { // return값은?
		// UserDto를 클래스를 만들고 void형을 UserDto를 넣어줌
		String sql = " SELECT ID, NAME, AGE, JOINDATE " + " FROM USERTEST " + " WHERE ID = '" + id + "' ";
		System.out.println("sql: " + sql); // 쿼리문 확인

		Connection conn = DBConnection.getConnection();
		Statement stmt = null; // 커리문 적용하는
		ResultSet rs = null; // DB로부터 결과를 return해주는 부분

		UserDto dto = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql); // select가 쓰는 함수 !!!!!!!!!!!!!!!!!!!!

			if (rs.next()) { // 찾는 데이터가 있는 경우
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");

				dto = new UserDto(_id, _name, _age, _joindate);
				// 다 받은다음 변수에
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}

		return dto;
	}
//----------------------------------------------------------
//2)1개 실제 더 많이 쓰는 방법

	public UserDto Select(String id) {
		
		String sql =  " SELECT ID, NAME, AGE, JOINDATE "
				 	+ " FROM USERTEST "
					+ " WHERE ID = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;		//!!!!!!!!!!!!!
		ResultSet rs = null;
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql); //!!!!!!!!!!!!!!!
			psmt.setString(1, id);//Query에서 ?부분에 해당하는 Data //쿼리문은 이 시점에서 완성됨	
			//만약 두번 째 물음표가 있을경우
			//psmt.setInt(2, 12); 이런식
			
			rs = psmt.executeQuery();//!!!!!!!!!!!!!!
			
			if(rs.next()) {
				dto = new UserDto();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoindate(rs.getString("joindate"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}		
//3) 다수의 Data 취득 ex) 전체도 몇 개만 정해서도 가져올 수 있다.
	public List<UserDto> getUserList() {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERTEST ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//!!!!!!!!!!!!!!!!!!!!!!
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				UserDto dto = new UserDto(id, name, age, joindate);
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}				//statement를 상속받아 만든거기 때문에 똑같이 닫힌다.
		return list;
	}
	
}

