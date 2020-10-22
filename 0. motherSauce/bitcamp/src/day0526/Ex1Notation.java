package day0526;

//진수 변환기
import java.util.Scanner;

public class Ex1Notation {

	public static void main(String[] args) {
		/*
		 * 숫자 입력 >> 메뉴 번호
		 * 
		 * 1. 10진수를 2진수로 변환해서 출력
		 * 2. 2진수를 10진수로 변환해서 출력 
		 * 3. 10진수를 16진수로 변환해서 출력 
		 * 4. 16진수를 10진수로 변환해서 출력 
		 * 5. 2진수를 16진수로 변환해서 출력 
		 * 6. 16진수를 2진수로 변환해서 출력 
		 * 7. 종료
		 */
		Scanner sc = new Scanner(System.in);

		// 숫자 입력 받기
		while (true) {
			System.out.println("진수 변환을 원하는 숫자를 입력해주세요");
			int num = sc.nextInt();

			// 메뉴 선택 1~7
			System.out.println(num + " = 원하는 메뉴를 선택해주세요");
			System.out.println("1. 10진수를 2진수로 변환해서 출력");
			System.out.println("2. 2진수를 10진수로 변환해서 출력");
			System.out.println("3. 10진수를 16진수로 변환해서 출력");
			System.out.println("4. 16진수를 10진수로 변환해서 출력");
			System.out.println("5. 2진수를 16진수로 변환해서 출력");
			System.out.println("6. 16진수를 2진수로 변환해서 출력");
			System.out.println("7. 종료");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: // 10 > 2
				System.out.println(num+"을 10진수에서 2진수로 하면 " + Integer.toBinaryString(num));
				break;
			case 2: // 2 > 10
				String ca1 = String.valueOf(num);
				int ca11 = Integer.parseInt(ca1, 2);
				System.out.println(num+"을 2진수에서 10진수로 하면 " + ca11);
				break;
			case 3: // 10 > 16
				System.out.println(num+"을 10진수에서 16진수로 하면 " + Integer.toHexString(num));
				break;
			case 4: // 16 > 10
				String ca2 = String.valueOf(num);
				int ca22 = Integer.parseInt(ca2, 16);
				System.out.println(num+"을 16진수에서 10진수로 하면 " + ca22);
				break;
			case 5: // 2 > 16
				String ca3 = String.valueOf(num);
				int ca33 = Integer.parseInt(ca3, 2);
				System.out.println(num+"을 2진수에서 16진수로 하면 " + Integer.toBinaryString(ca33));
				break;
			case 6: // 16 > 2
				String ca4 = String.valueOf(num);
				int ca44 = Integer.parseInt(ca4, 16);
				System.out.println(num+"을 16진수에서 2진수로 하면 " + Integer.toHexString(ca44));
				break;
			case 7:
				System.out.println("종료");
				break;
			}

			// 재사용
			String msg;
			System.out.println("다시 시작하시겠습니까(y/n)?");
			msg = sc.next();

			if (msg.equals("y") || msg.equals("Y")) {
				System.out.println("새로 시작합니다");
			}

			if (msg.equals("n") || msg.equals("N")) {
				System.out.println("안녕히 가십시오");
				break;
			}
		}
		System.out.println("================================================");
		
		sc.close();
	}

}