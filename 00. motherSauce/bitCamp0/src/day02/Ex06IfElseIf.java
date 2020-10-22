package day02;
//사용자로부터 점수를 입력받아서
//90~100 : A
//80~89  : B
//70~79  : C
//60~69  : D
//~60    : F 가 출력되는 프로그램을 작성하세요.(10분)

import java.util.Scanner;
public class Ex06IfElseIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수를 입력해주세요 :" );
		int score = scanner.nextInt();
		
		if(score >= 90 && score <= 100) {
			System.out.println("A");
		}else if(score >= 80 && score <= 89) {
			System.out.println("B");
		}else if(score >= 70 && score <= 79) {
			System.out.println("C");
		}else if(score >= 60 && score <= 69) {
			System.out.println("D");
		}else  {
			System.out.println("F");
		}
		
		//_____________________________________________________
		//if(score >=90) {
		//	System.out.println("A");
		//}else if(score >=80) {
		//	System.out.println("B");
		//}else if(score >=70) {
		//	System.out.println("C");
		//}else if(score >=60) {
		//	System.out.println("D");
		//}else {
		//	System.out.println("F");
		//}
		// 이것이 15000이나 -14444를 넣을 경우 A이나 F의 결과로 나옴
		// 위의 코드는 아직 사용자의 데이터를 검증(validation)하지 않았고
		// 따라서 사용자가 말도 안되는 점수를 입력해도 A 혹은 F가 출력되는 형태이다.
		// 그렇다면 어떻게 해야 데이터 검증이 가능할까? 범위?
		
		// 1. 점수의 범위를 빡빡하게 설정한다.
		if(score >= 90 && score <= 100) {
			System.out.println("A");
		}else if(score >= 80 && score <= 89) {
			System.out.println("B");
		}else if(score >= 70 && score <= 79) {
			System.out.println("C");
		}else if(score >= 60 && score <= 69) {
			System.out.println("D");
		}else if(score >= 0 && score <= 59) {
			System.out.println("F");
		}else  {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		// 2. 사용자가 점수를 입력했을 때 선 검증 후 올바른 점수일때만
		// if-else if 구조로 들어간다. (안에 포함된 구조로 내용이 들어갔다)
	if(score >= 0 && score <= 100) {
			//올바른 점수
		if(score >=90) {
			System.out.println("A");
		}else if(score >=80) {
			System.out.println("B");
		}else if(score >=70) {
			System.out.println("C");
		}else if(score >=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
	    }
	}else {
			//올바르지 않은 점수
			System.out.println("잘 못 입력하셨습니다.");
		}
		
		
		scanner.close();
	}
}
