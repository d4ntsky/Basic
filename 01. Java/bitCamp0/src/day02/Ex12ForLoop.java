package day02;
// 사용자로부터 입력을 받아서
// 1부터 그 수까지의 합을 구하는 프로그램
// for loop 시작 지점과 끝 지점을 돌리는것
import java.util.Scanner;
public class Ex12ForLoop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자를 하나 입력해주세요: ");
		int number = scanner.nextInt();
		
		//1~사용자가 입력한 숫자까지의 합을 저장할 변수가 하나 필요하다.
		//왜냐면 for loop 안에서 만드는 변수는 범위(scope)가 그 for loop 안에서만
		//유효하ㅣ 때문이다.
		int result = 0;
		for(int i = 1; i <= number; i++) {
			//result = result + i;
			//줄여서 쓰면 위의 코드는 
			result += i;
			//로 쓸 수 있다
		}
		System.out.println("1부터 "+number+"까지의 합: "+result);
		
		//사용자로부터 숫자를 입력받아서
		//만약 숫자가 14보다 작거나 같으면 1~그 숫자까지의 곱을 구해서 출력하고
		//아니면 "숫자가 너무 커집니다" 라고 출력하는 프로그램을 작성하세요(5분)
		
		System.out.println("숫자를 다시 입력해주세요: ");
		number = scanner.nextInt();
		result = 1;
		if(number <= 14) {
			//곱을 구하는 for loop 작성
			for(int i = 1; i <= number; i++) {
				result *= i;
			}
			System.out.println("1부터"+number+"까지의 곱"+ result);
		}else {
			System.out.println("숫자가 너무 커집니다.");
		}
		
		scanner.close();
	
	}
}

