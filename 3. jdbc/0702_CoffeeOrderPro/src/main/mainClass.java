package main;

import db.DBConnection;
import view.loginView;
import view.menuView;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();

		new loginView();
		// new menuView();
		
	}

}

/*
추가 해야되는 부분
seq!! 
렉 나는 부분
	커피 선택 안받고 기본으로 받으면 렉남
	커피 잔 수 제대로 못받으면 렉남
오더리스트뷰는 바로 받은거 배열에 저장해버림.. 표시만 하고 나중에 저장할 수 있게 해야함.
odlistview 마지막 페이지에서 주문버튼 생성해서 값 저장하는 것
*/