package day03;
// 무한루프를 사용한
// 메뉴 만들기
import java.util.Scanner;
public class Ex14Menu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("비트 검정고시 체크 프로그램");
			System.out.println("1.입력   2.출력   3.종료");
			int choice = scanner.nextInt();
			if(choice == 1) {
				//성적을 입력하는 코드실행
			}else if(choice == 2) {
				//성적을 출력하는 코드실행
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
				//무한루프에 끝을 맺는 가능성
			}
		}
		scanner.close();
	}
}
