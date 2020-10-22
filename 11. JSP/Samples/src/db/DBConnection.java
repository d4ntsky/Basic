package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void initConnection() {

		try { // 한번만
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Driver Loading Success");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() { // 할 때마다 얻어와야함
		// conn이 db 내용을 갖고있어서?

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.7.44:1521:xe", "hr", "hr");

			System.out.println("Oracle Connection Success!");
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return conn; // db와 연결될 때
	}

}
