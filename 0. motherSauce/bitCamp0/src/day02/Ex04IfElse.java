package day02;
//사용자로부터 숫자를 입력받아서
//홀수인지 짝수인지를 출력하는 프로그램을 작성하세요.(5분)
import java.util.Scanner;
public class Ex04IfElse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 하나 입력해주세요:");
		int number = scanner.nextInt();
				
		if(number % 2 == 1) {
			System.out.println("홀수입니다");
		}else {
			System.out.println("짝수입니다");
		}		
		
		scanner.close();
	}
}
