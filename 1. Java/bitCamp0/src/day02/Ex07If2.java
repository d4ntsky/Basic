package day02;
//사용자로부터 국영수 점수를 입력받아서
//총합이 210점이고 점수가 모두 60점 이상이면 합격!
//그 외에는 불합격이 뜨는 프로그램을 작성하세요! (10분)

import java.util.Scanner;
public class Ex07If2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("국어: ");
		int korean = scanner.nextInt();
		
		System.out.println("영어: ");
		int english = scanner.nextInt();
		
		System.out.println("수학: ");
		int math = scanner.nextInt();
		
		//1. 점수의 합이 210점인지 체크 && 각각이 60점 이상
		if(korean + english + math >= 210
		 && korean >=60
		 && english >=60
		 && math >= 60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		//조건이 한 곳에 수식에 &&로 다 들어갔다.

		scanner.close();
	}
}