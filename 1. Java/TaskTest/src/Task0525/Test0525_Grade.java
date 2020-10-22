package Task0525;

import java.util.Scanner;

public class Test0525_Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 성적 통계 프로그램
		 * 
		 * 통계를 산출할 학생의 수?
		 */
		System.out.println("산출할 학생의 수는 몇 명인가?");
		int stuNum = sc.nextInt();// 산출 학생 수
		String student[][] = new String[stuNum][4];

		/*
		 * 동적할당 -> student[학생의 수][4] 이름 국어 영어 수학 홍길동 90 80 98 일지매 70 78 80 이름, 과목점수 입력
		 */
		int i = 0;
		while (i < stuNum) {
			System.out.println("이름이 뭔가요?");
			String name = sc.next();

			System.out.println("국어점수?");
			int korean = sc.nextInt();
			for (int p = 0; p < student.length; p++) {
				if (korean < 0 || korean > 100) {
					System.out.println("범위를 초과했습니다 다시 입력해주십시오.");
				}
			}
			System.out.println("영어점수?");
			int english = sc.nextInt();
			for (int q = 0; q < student.length; q++) {
				if (english < 0 || english > 100) {
					System.out.println("범위를 초과했습니다 다시 입력해주십시오.");
				}
			}
			System.out.println("수학점수?");
			int math = sc.nextInt();
			for (int r = 0; r < student.length; r++) {
				if (math < 0 || math > 100) {
					System.out.println("범위를 초과했습니다 다시 입력해주십시오.");
				}
			}
		}
		System.out.println(student[0][0]);
		System.out.println(student[0][1]);
		System.out.println(student[0][2]);
		System.out.println(student[0][3]);
		/*
		 * >> 숫자로 입력 >> 다시 입력해 주십시오
		 * 
		 * 1 ~ 100사이의 숫자 범위를 초과했습니다 다시 입력해주십시오.
		 */

		/*
		 * 국어, 수학, 영어 최고 점수 array1 최고점수 2 국어, 수학, 영어 최저 점수 모든 점수의 총합
		 * 
		 * 합계 int sum 학생수에 따른 평균 int avg = sum / stuNum
		 */

	}

}

