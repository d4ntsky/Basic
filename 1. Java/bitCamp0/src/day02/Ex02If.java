package day02;
//예제:
//사용자로부터 숫자를 입력받아서
//사용자가 입력한 숫자를 보여주고
//만약 해당 숫자가 홀수이면 "홀수입니다"를 출력하는 프로그램을 작성하세요

import java.util.Scanner;
public class Ex02If {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 하나 입력해주세요: ");
		int number = scanner.nextInt();
		
		System.out.println("사용자가 입력한 숫자: " +number);
		
		//홀수는 2로 나누어서 나머지가 1이면 홀수이다.
		//나머지를 구하기 위해서?
		// % 2
		// == 1
		if(number % 2 == 1) {
			System.out.println("홀수입니다");
		}
		
		if(number % 2 == 0){
			System.out.println("짝수입니다");
		}
		
		// 이 수식이 else 구조는
		//if(number % 2 == 1 ) {
		
		scanner.close();
	}
}