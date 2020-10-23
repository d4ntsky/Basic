package Task0525;

import java.util.Scanner;

public class Task0525_Grade {


	public static void main(String[] args) {
		/*
		 * 성적 통계 프로그램
		 * 
		 * 통계를 산출할 학생의 수?
		 * 
		 * 동적할당 -> student[학생의 수][4]
		 * 이름 	국어	영어	수학
		 * 홍길동 90	80	98		 
		 * 일지매 70	78	80
		 * 
		 * 이름, 과목점수 입력
		 * >> 숫자로 입력
		 * >> 다시 입력해 주십시오
		 * 
		 * 1 ~ 100사이의 숫자
		 * 범위를 초과했습니다 다시 입력해주십시오.
		 * 
		 * 국어, 수학, 영어 최고 점수 
		 * 국어, 수학, 영어 최저 점수
		 * 모든 점수의 총합
		 * 학생수에 따른 평균
		 */
		
		//==============================================
		Scanner sc = new Scanner(System.in);
		//학생 성적 관리용 2차원 배열
		// String으로 잡아야함 -> 이름, 숫자 (-> parseInt) 
		// int -> 숫자만 관리 가능
		
		//선언부
		String student[][] = null;
		//[학생 수][이름, 국, 영, 수]
		int count; //학생수
		
		// 1. 학생 수 입력 //나중에 몇명이 될지 모르기 떄문에...
		System.out.print("학생수를 입력해주세요 = ");
		count = sc.nextInt();
		
		// 2. 동적 할당
		student = new String[count][4];
		//[count][4] 반드시 4가 들어갈 이유는 없다.하지만 명시 위해서
		
		// 3. 입력 : 이름, 국어, 영어, 수학
		for (int i = 0; i < student.length; i++) {
			System.out.print((i + 1)+"번째 학생>>");
			
			System.out.println("이름 - ");
			String name = sc.next();
			
			String lang = "";
			while(true) {
				System.out.print("국어: ");
				lang = sc.next();	// 98 100 10a
				
				boolean check = false;
				for (int j = 0; j < lang.length(); j++) {
					char c = lang.charAt(j) ;
					if((int)c <48||(int)c>57) {//아스키코드로 문자들어올시
						check = true;
						break;
					}
				}	
				if(check == true) {
					System.out.println("잘못 입력하셨습니다,다시 입력 해주세요");
					continue;
				}
				
				int numLang = Integer.parseInt(lang);
				if(numLang < 0 || numLang > 100) {
					System.out.println("범위가 틀렸습니다. 다시 입력 해주세요");
					continue;
				}
				break;
			}
		

		//영어
		System.out.print("영어: ");
		String eng = sc.next();	
		
		//수학
		System.out.print("수학: ");
		String math = sc.next();	
	
		//데이터를 배열에 대입
		student[i][0] = name;
		student[i][1] = lang;
		student[i][2] = eng;
		student[i][3] = math;
		}
		//출력
		for (int i = 0; i < student.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < student[0].length; j++) {
				System.out.print(student[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		int studentCount[][] = new int[student.length][3];
		for (int i = 0; i < student.length; i++) {
			studentCount[i][0] = Integer.parseInt(student[i][1]);
			studentCount[i][1] = Integer.parseInt(student[i][2]);
			studentCount[i][2] = Integer.parseInt(student[i][3]);
		}
		// 4. 국, 영, 수 중 최고 점수 하나만 (국어)
		int max = studentCount[0][0];
		for (int i = 0; i < student.length; i++) {
			if(max < studentCount[i][0]) {
				max = studentCount[i][0];
			}
		}
		System.out.println("최고점수: " + max);
		
		// 5. 국, 영, 수 중 최저 점수 하나만 (수학)
		int min = studentCount[0][1];//= 0 초기화가 잘못됐다
		for (int i = 0; i < student.length; i++) {
			if(min > studentCount[i][1]) {
				min = studentCount[i][1];
			}
		}
		System.out.println("최저점수: " + min);
		
		// 6. 모든 점수의 총합
		int sum = 0;
		for (int i = 0; i < studentCount.length; i++) {
			for (int j = 0; j < studentCount.length; j++) {
				sum = sum + studentCount[i][j];
			}
		}
		System.out.println("모든 점수의 합: " + sum);
		
		// 7. 학생 수에 따른 평균
		double avg = (double)sum / student.length;
		System.out.println("평균 : " + avg);
		// 8. 출력 확인
	}
}