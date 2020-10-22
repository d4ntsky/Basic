package TaskStudentScore;

import java.util.Scanner;
//testpage < test < test01
public class Task0601_Studentscore {

	public static void main(String[] args) {
		/*
			학생 성적 관리
			String student[][];
			
			메뉴----
			1. 학생 정보 추가 		insert		(예: 홍길동, 나이, 영어, 수학)
			2. 학생 정보 삭제 		delete
			3. 학생 정보 검색 		search
			4. 학생 정보 수정 		update
			5. 모든 학생 정보 출력 	print
		
			6. 과목의 총점			1. 영어
			7. 과목의 평균			
		
			8. 성적 순으로 정렬 출력
		*/
		
		Scanner sc = new Scanner(System.in);
		String student[][] = new String[20][4];
		int choice;
		
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				student[i][j] = ""; //초기화 // 나중에 필요없음1
			}
		}
		
		while(true) {
			System.out.println("======메뉴======");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 삭제");	//이름으로 검색해서 삭제
			System.out.println("3. 학생 정보 검색");	//이름으로 검색
			System.out.println("4. 학생 정보 수정");	//을 찾고 수정
			System.out.println("5. 모든 학생 정보 출력");	//
			
		System.out.println("메뉴 번호를 입력해 주십시오.");
		System.out.print(">>> ");
		choice = sc.nextInt();
		
		switch(choice) {
			case 1:		//학생 추가
				insert(student);
				break;
			case 2:		//학생 삭제
				delete();
				break;
			case 3:		//학생 검색
				search();
				break;
			case 4:		//학생 수정
				update();
				break;
			case 5:		//모든 학생 정보 출력
				print();
				break;
				
			}
		}
	}
	
	//create
	static void insert(String student[][]) {
		Scanner sc = new Scanner(System.in);
		
		int findIndex = -1;//-1인 이유 0으로 해두면 제로번지? 
		for (int i = 0; i < student.length; i++) {
			if(student[i][0].contentEquals("")) { //0 1 2 데이터가 있으면
				findIndex = i;
				break;
			}
		}
		System.out.println("findIndex: " + findIndex); //확인작업
	
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		String age = sc.next();
		
		System.out.print("영어: ");
		String eng = sc.next();
		
		System.out.print("수학: ");
		String math = sc.next();
		
		student[findIndex][0] = name;
		student[findIndex][0] = age;
		student[findIndex][0] = eng;
		student[findIndex][0] = math;
		
		System.out.println("입력완료: " + student[findIndex][0]);
	}
	static void delete() {
		
	}
	static void search() {
		
	}
	static void update() {
	
	}
	static void print() {
	
	}

}

