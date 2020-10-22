package day02;
//의도적으로 break를 생략해서 코드를 간략하게 만들어보자
//사용자가 숫자를 입력하면 해당 월의 마지막 날의 보여주는 프로그램
import java.util.Scanner;
public class Ex09Switch {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("월을 입력해주세요: ");
		int month = scanner.nextInt();
		
		
		//브레이크를 생략할 수 없다면 코드는 아래와 같이 된다.
		System.out.println("break 생략 안 한 버젼");
		switch(month) {
		case 1:
			System.out.println("31일");
			break;
		case 2:
			System.out.println("28일");
			break;
		case 3:
			System.out.println("31일");
			break;
		case 4:
			System.out.println("30일");
			break;
		case 5:
			System.out.println("31일");
			break;
		case 6:
			System.out.println("30일");
			break;
		case 7:
			System.out.println("31일");
			break;
		case 8:
			System.out.println("31일");
			break;
		case 9:
			System.out.println("30일");
			break;
		case 10:
			System.out.println("31일");
			break;
		case 11:
			System.out.println("30일");
			break;
		case 12:
			System.out.println("31일");
			break;
		}
		
		System.out.println("break를 생략한 버젼");
		switch(month) {
		case 2:
			System.out.println("28일까지입니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일까지입니다.");
			break;
		default:
			System.out.println("31일까지입니다.");
			break;
		//case 1:
		//case 3:
		//case 5:
		//case 7:
		//case 8:
		//case 10:
		//case 12:
		//System.out.println("31일까지입니다.");
		//break; > 이걸 default로 13월을 칠 경우는 는 default 값으로 나오기 때문에 범위가 필요?
		//현업에서 쓰지않는 편이다 case가 너무 많아지기 때문이다. 예시로 나이로 따지면 복잡해짐
			
		}
		
		scanner.close();
	}
}