package main;

import dao.BaseballDao;
import view.MenuView;

public class mainClass {

	public static void main(String[] args) {
				
		BaseballDao.getInstance();
		new MenuView();		
	}

}
//D:\tmp\baseball.txt