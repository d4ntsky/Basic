package main;

import jdbc.JdbcConnect;

public class mainClass {

	public static void main(String[] args) {
		/*
			JDBC
			Java DataBase Connectivity
		 */
		
		JdbcConnect jc = new JdbcConnect();
		
		jc.getConnection();
	}

}
