package main;

import java.util.Scanner;

import DaoClass.AllPrintClass;
import DaoClass.DeleteClass;
import DaoClass.FileSaveClass;
import DaoClass.InsertClass;
import DaoClass.SelectClass;
import DaoClass.UpdateClass;
import DaoInterface.DaoImpl;
import fileLoad.FileLoadClass;


public class MainClass {

	public static void main(String[] args) {	
	/*
	 * main에서 전부다 생성
		insertClass - deleteClass - selectClass - updateClass - allprintClass
		각각 process proc method 함수들이 있고 map으로 되있는거보단 list
		file 클래스도 마찬가지. save load > filesaveClass fileloadClass - micro System.
		singleton 클래스에 arraylist가 있으면 모든 클래스가 들어올수 있게 
		mainclass는 호출만
		
		각각클래스명
		dao 패키지명안에다가 기능 클래스
		file패키지load save 클래스
		싱긅턴 패키지 
		main하나
	 */
		Scanner scan = new Scanner(System.in);
		
		(new FileLoadClass()).process();
		
		while(true) {			
			DaoImpl dao = null;			
			
			System.out.println("1. 선수 등록 ");
			System.out.println("2. 선수 삭제 ");
			System.out.println("3. 선수 검색 ");
			System.out.println("4. 선수 수정 ");
			System.out.println("5. 선수 모두 출력 ");			
			System.out.println("6. 데이터 저장 ");
			System.out.println("0. 프로그램 종료 ");
			
			System.out.print("메뉴 번호 입력 >>> ");
			int choice = scan.nextInt();
			
			switch(choice) {
				case 1:
					dao = new InsertClass();
					break;
				case 2:
					dao = new DeleteClass();
					break;
				case 3:
					dao = new SelectClass();
					break;
				case 4:
					dao = new UpdateClass();
					break;
				case 5:
					dao = new AllPrintClass();
					break;
				case 6:
					dao = new FileSaveClass();
					break;			
			}
					
			dao.process();
						
		}

	}

}