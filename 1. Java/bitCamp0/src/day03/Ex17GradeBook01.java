package day03;
//사용자로부터 국어, 영어, 수학 점수를 입력받아서
//출력하는 프로그램을 작성하세요 (20분)

//조건 1: 사용자가 잘못된 점수(-12 or 12341)을 입력하면
//	  	   잘못입력했다는 것을 알려주고 올바른 점수가 입력될 때까지 다시 입력받으세요.
//조건 2: 성적을 출력할 때에는 이를 국어 영어 수학 총점 평균을 보여주고
//		   국어 영어 수학 총점은 3자리 왼쪽은 0으로 채워서 출력하고
//		   평균은 소숫점 2번째 자리까지 출력하세요.

import java.util.Scanner;
public class Ex17GradeBook01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("비트 검정고시 체크 프로그램");
			System.out.println("1.입력   2.출력");
			int choice = scanner.nextInt();
			if(choice == 1) {
				
				System.out.println("이름을 입력하세요: ");
				String name = scanner.nextLine();
				System.out.println("국어: ");
				int korean = scanner.nextInt();
				System.out.println("영어: ");
				int english = scanner.nextInt();
				System.out.println("수학: ");
				int math = scanner.nextInt();
				while(korean > 100 || korean < 0) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("숫자를 다시 입력해주세요 :");}
				while(english > 100 || english < 0) {
						System.out.println("잘 못 입력하셨습니다.");
						System.out.println("숫자를 다시 입력해주세요 :");}
				while(math > 100 || math < 0) {
							System.out.println("잘 못 입력하셨습니다.");
							System.out.println("숫자를 다시 입력해주세요 :");}
			if(choice == 2) {
				System.out.printf("\n %s학생의 성적\n 국어: %03d점 영어: %03d점 수학: %03d점 평균: %.2f점","name", korean, english, math, (korean+english+math)/3.0);
				System.out.println("사용해주셔서 감사합니다.");
			}
			
			}
				
		scanner.close();
	}}}