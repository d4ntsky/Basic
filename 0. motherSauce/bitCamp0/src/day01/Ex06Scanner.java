package day01;
//Scanner는
//자바에서 입력을 담당하는 클래스이다.
//외부 클래스이기 때문에 사용하기 위해서
//import를 해주어야 한다.

import java.util.Scanner;
public class Ex06Scanner {
	public static void main(String[] args) {
		//스캐너의 선언과 초기화
		Scanner scanner = new Scanner(System.in);
		
		//우리가 정수를 입력을 받을때에는 scanner의 nextInt() 메소드를 실행해주면 된다.
		System.out.println("숫자를 입력하세요: ");
		int userNumber = scanner.nextInt();
		System.out.println("사용자가 입력한 숫자: "+userNumber);
		
		//실수는 nextDouble로 입력받으면 된다.
		System.out.println("실수를 입력하세요: ");
		double userDouble = scanner.nextDouble();
		System.out.println("사용자가 입력한 실수: "+userDouble);
		
		//String은 nextLine으로 입력받으면 된다.
		System.out.println("글자들을 입력하세요: ");
		String myString = scanner.nextLine();
		System.out.println("사용자가 입력한 String: "+myString);
		
		//하지만 nextLine에는 한가지 버그가 존재한다.
		//스캐너는 임시저장소인 버퍼메모리라는 곳을 읽어오게 되는데
		//nextInt, nextDouble등의 숫자를 입력을 받으면
		//사용자가 입력이 끝날 때 enter를 누르게 된다.
		//하지만 enter는 \n이라는 하나의 문자이기 때문에
		//nextInt등과 같은 숫자를 입력받은 메소드는
		//\n을 버퍼메모리에 남겨둔다.
		//그렇게 버퍼메모리에 남겨져 있는 enter키들을 보고
		//nextLine은
		//"아, 사용자가 아무런 입력없이 입력을 종료시켰구나!"하고 착각하게 된다.
		//따라서 우리가 nextInt등의 숫자를 입력받은 메소드를 실행한 후에
		//String 입력을 받을때에는
		//버퍼메모리 안에 남겨진 enter키들을 없애주어야 한다.
		//없애는 방법은
		//scanner.nextLine()을 단독 실행시켜주면 된다.
		System.out.println("숫자를 입력하세요: ");
		userNumber = scanner.nextInt();
		System.out.println(userNumber);
		
		//scanner.nextLine을 단독 실행할 때에는
		//이클립스의 자동완성 기능이 nextLine 이 아니라
		//hasNextLine으로 완선시키기 때문에 여러분들이
		//키보드의 방향키로 nextLine을 선택하고 엔터눌러주어야 한다!
		scanner.nextLine();
		
		System.out.println("스트링을 입력하세요: ");
		myString = scanner.nextLine();
		System.out.println(myString);
		
		//스캐너와 같이 메모리를 참조하는 객체는
		//가장 마지막 줄에
		//close 메소드를 호출해야한다.
		scanner.close();
	}
}