package day03;
// while 반복문을 통해서
// 사용자가 0 ~ 100 사이의 숫자를 입력하지 않으면
// 다시 입력을 무한히 받는 프로그램
import java.util.Scanner;
public class Ex12While {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자를 하나 입력해주세요: ");
		int number = scanner.nextInt();
		//<
		while(number > 100 || number < 0) {
			System.out.println("잘 못 입력하셨습니다.");
			System.out.println("숫자를 다시 입력해주세요 :");
			number = scanner.nextInt();
		}   //cf) number = scanner.nextInt();을 없애고 0<number<100을 벗어난 값을 치면 무한루프를 돌게된다.
		//>무한 true가 나올때까지
				
		System.out.println("사용자가 입력한 숫자: "+number);
		
		scanner.close();
	}
}
