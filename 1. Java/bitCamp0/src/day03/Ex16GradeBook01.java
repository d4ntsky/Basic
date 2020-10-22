package day03;
//사용자로부터 국어, 영어, 수학 점수를 입력받아서
//출력하는 프로그램을 작성하세요 (20분)

//조건 1: 사용자가 잘못된 점수(-12 or 12341)을 입력하면
//	  	   잘못입력했다는 것을 알려주고 올바른 점수가 입력될 때까지 다시 입력받으세요.
//조건 2: 성적을 출력할 때에는 이를 국어 영어 수학 총점 평균을 보여주고
//		   국어 영어 수학 총점은 3자리 왼쪽은 0으로 채워서 출력하고
//		   평균은 소숫점 2번째 자리까지 출력하세요.

import java.util.Scanner;
public class Ex16GradeBook01 {
	static final int NUMBER_OF_SUBJECTS = 3;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생의 이름: ");
		String name = scanner.nextLine();
		System.out.print("국어: ");
		int korean = scanner.nextInt();
		
		//올바른 점수인지 확인해서 아니면 다시 입력을 받는다.
		while(korean < 0 || korean > 100) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			System.out.println("국어 점수를 다시 입력해주세요.");
			System.out.print("국어: ");
			korean = scanner.nextInt();
		}
		
		System.out.print("영어: ");
		int english = scanner.nextInt();
		
		while(english < 0 || english > 100) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			System.out.println("영어 점수를 다시 입력해주세요.");
			System.out.print("영어: ");
			english = scanner.nextInt();
		}
		
		System.out.print("수학: ");
		int math = scanner.nextInt();
		
		while(math < 0 || math > 100) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			System.out.println("수학 점수를 다시 입력해주세요.");
			System.out.print("수학: ");
			math = scanner.nextInt();
		}
		
		//평균과 총점을 저장할 변수를 만들어준다.
		int sum = korean + english + math;
		//double average = sum / 3.0;
		//위의 코드에서처럼 갑자기 3.0을 넣는 것은
		//프로그래밍 언어로 "마술의 숫자"라고 한다.
		//이러한 마술의 숫자는 하드코딩에서 찾아볼 수 있고
		//유지보수를 할 때 어려워지는 요인이 된다.
		//따라서 저렇게 마술의 숫자를 쓰는대신
		//상수를 만들어서 그 상수를 호출하는 방식으로
		//코딩을 해야 유지보수가 쉬워진다!
		double average = sum / (NUMBER_OF_SUBJECTS * 1.0); //맨위에 클래스 이름 다음에 표기한 상수 바꾸기 쉽게
		
		System.out.printf("이름: %s \n 국어: %03d점, 영어: %03d점, 수학: %03d점, \n 총점: %03d점, 평균 %.2f점", name, korean, english, math, sum, average);
		
		scanner.close();
	}
}