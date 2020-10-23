package main;

import db.DBConnection;
import view.TermView;
import view.loginView;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		new loginView();
		// new TermView();
	}

}

















