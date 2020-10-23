package main;

import db.DBConnection;
import view.addView;
import view.contentView;
import view.loginView;
import view.menuView;
import view.periodView;
import view.signView;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		new loginView();
		//new signView();
		//new menuView();
		//new addView();
		//new contentView();
		//new periodView();
	}

}

/*
CREATE TABLE ACCOUNTBOOK(
	SEQ NUMBER(8),
	ID VARCHAR2(30),				-- 외래키
	IO_KIND VARCHAR2(1),			-- 수입/지출(IN/OUT)
	AMOUNT NUMBER(9),				-- 금액
	CONTENT VARCHAR2(200),			-- 사용내역
	WDATE DATE						-- 입력일 - 적은 날짜가 SYSDATE
);

-- SEQUENCE

-- 외래키(ID)
*/

//addview 쪽 초기화 부분 확인해서 커피주문프로 확인