package main;

import jdbc.InsertTest;

public class mainClass {

	public static void main(String[] args) {
		
		InsertTest it = new InsertTest();
		//누르면 드라이버 석세스 뜨고
		int count = it.insertData("abc", "이방일", 31);
					count = it.insertData("bcd", "이순신", 32); //여기에 추가하면 추가는 가능
		if(count == 1) {
			System.out.println("데이터가 " + count + "개 추가 되었습니다");
		}
	}

}
/* 
DB DEVELOPMENT에서 SQL에서 테이블 만들 것 

CREATE TABLE USERTEST(
	ID VARCHAR2(30) PRIMARY KEY,
	NAME VARCHAR2(30),
	AGE NUMBER(2),
	JOINDATE DATE
);
*/