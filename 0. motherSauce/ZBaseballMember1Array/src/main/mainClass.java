package main;

import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		// Menu 구성 == front end - view가 된다.
		// DAO부터 만들어야 정석
		
		//1. 선수 등록
		//2. 선수 삭제
		//3. 선수 검색
		//4. 선수 수정
		//5. 모든 선수 목록
									//만드는 순서는 대게 1>5>
		//.........로드 저장
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDao();
		
		while(true) {
			
		System.out.println("1. 선수 등록");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 선수 검색");
		System.out.println("4. 선수 수정");
		System.out.println("5. 모든 선수 목록");
		System.out.println("6. 데이터 저장");
		System.out.println("7. 방어율 Ranking");	//1~n pitcher 	//cf 방어율 좋고
		System.out.println("8. 타율 Ranking");	//1~n batter	//cf 타율 
		System.out.println("9. ");
		System.out.println("10. 종료");
		
		System.out.println("메뉴 번호 입력>>>>>");
		
		int choice = sc.nextInt();

		switch(choice) {
			case 1:			//선수 등록
				dao.insert();
				break;	
			case 2:			//선수 삭제
				dao.delete();
				break;
			case 3:			//선수 검색
				dao.select();
				break;
			case 4:			//선수 수정
				dao.update();
				break;
			case 5:			//모든 선수 목록
				dao.allprint();
				break;
			case 6:			//데이터 저장
				dao.saveData();
				break;
//			case 7:			//방어율 순위 정렬
//			
//				break;
//			case 8:			//타율 순위 정렬
//				
//				break;
//			case 9:			//
//				
//				break;
			case 10:		//종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			
			}
		}
	}
}