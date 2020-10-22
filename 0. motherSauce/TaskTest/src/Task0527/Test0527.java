package Task0527;

import java.util.Scanner;

public class Test0527 {
	public static void main(String[] args) {
		
		/*
			함수:	 두 수를 나눈 몫, 나머지를 구하는 함수
				num1, num2
				value(몫), mod(나머지)
		*/
		valmo();
		
		
		/*
			toUpperCase -> 문자가 매개변수
				문자열 -> 대문자로 변경되서 return
			
		 */
		up();
	}
	
	
	static void valmo() {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.println("몫과 나머지를 구할 두 수를 입력 하세요");
		System.out.println("나눠질 숫자(분자) 입력");
		num1 = sc.nextInt();
		System.out.println("나눌 숫자(분모) 입력");
		num2 = sc.nextInt();
		int value = num1 / num2;
		int mod = num1 % num2;
		System.out.println("몫은 " + value + "이며 나머지는 " + mod + "입니다");
	}//아마도 숫자 이외의 것 못치게...
	
	static void up() {
		Scanner sc = new Scanner(System.in);
		System.out.println("대소문자 가리지 않고 입력 대문자 입력기");
		String str = sc.next();
		String sTr = str.toUpperCase();
		System.out.println(sTr);
	}//
}