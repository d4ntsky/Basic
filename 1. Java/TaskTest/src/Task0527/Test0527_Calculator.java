package Task0527;

import java.util.Scanner;

public class Test0527_Calculator {
	public static void main(String[] args) {
		
		//계산기
		//cf TODO는 스크롤에서 찾기 쉽게
		int num1, num2;
		String oper;
		int result = 0;
		
		//계산기 원래 문자로 받아야함
		String strNum1, strNum2;
		
		//TODO: 입력 
		//3
		strNum1 = numberInput("첫번째 수");
//------------------------------------------------------------------------	
//		
//		boolean  noNumber = false;
//		for (int i = 0; i < snum.length(); i++) {
//			char c = snum.charAt(i);//하나씩 꺼내는
//			if((int)c < 48 || (int)c > 57) {
//				noNumber = true;
//				break;
//			}
//		}
//------------------------------------------------------------------------
//		
//		while(true) {
//			System.out.print("첫번째 수 = ");
//			strNum1 = sc.next();
//			boolean b = numberOk(strNum1);
//			if(b == true) {
//				System.out.println("숫자가 아닙니다. 다시 입력해 주십시오");
//				continue;
//			}
//			break;
//		}
//
		
		//4.
//		System.out.print("(+, -, *, /) = ");
//		oper = sc.next();
		oper = calInput();//????????????????????????
		//함수식으로 만들어보기
		
		//3.
//		System.out.print("두번째 수 = ");
//		num2 = sc.nextInt();
		strNum2 = numberInput("두번째 수");
		
		//문자열 - > 숫자
		num1 = Integer.parseInt(strNum1);
		num2 = Integer.parseInt(strNum2);
		
		//TODO: 계산 //함수로 바꿀부분
//
//		switch (oper) {
//		case "+":
//			result = num1 + num2;
//			break;
//		case "-":
//			result = num1 - num2;
//			break;
//		case "*":
//			result = num1 * num2;
//			break;
//		case "/":
//			result = num1 / num2;
//			break;
//		}
		//1.
		result = calProcess(num1, num2, oper);
		
		//TODO: 결과
		System.out.println(num1 + " " + oper + " " + num2 + " = " + result);
																	//result = 0 해야함 초기화
		
	
	}
	
//------------------------------------------------------------------------
//4.목적: 사용자에게 연산자를 알려주고 연산자를 받는 입력받는 코드
// 	return : 연산자
	static String calInput() {
		Scanner sc = new Scanner(System.in);
		String solv;
		System.out.print("(+, -, *, /) = ");
		solv = sc.next();
		return solv;
	}
//------------------------------------------------------------------------
//3.목적: 숫자를 입력 받는 코드 (그 안에 입력 올바르게 받는지 표시해주는 코드가 내포되어있음)
//	return: 숫자
	static String numberInput(String num12) {
		Scanner sc = new Scanner(System.in);
		String strNum1;
		while(true) {
			System.out.print(num12 + " = ");
			strNum1 = sc.next();
			boolean b = numberOk(strNum1); //2 여기에 포함되어있음
			if(b == true) {
				System.out.println("숫자가 아닙니다. 다시 입력해 주십시오");
				continue;
			}
			break;
		}
		return strNum1;
	}
//------------------------------------------------------------------------
//2.목적: 문자열 중에 숫자를 판별하는 함수 //입력 받을때 숫자인지 문자인지 확인하는 코드
//	return: true(숫자가 아님) false(모두 숫자)
	static boolean numberOk(String snum) {
		boolean  noNumber = false;
		for (int i = 0; i < snum.length(); i++) {
			char c = snum.charAt(i);//하나씩 꺼내는
			if((int)c < 48 || (int)c > 57) {
				noNumber = true;
				break;
			}
		}
		return noNumber;
	}
//------------------------------------------------------------------------
//1.목적: 연산자와 계산하는 과정을 받는 코드
//	return: 입력받은 숫자와 연산자로 나온 결과
						//num1 oper num2 넘겨 받아야함
	static int calProcess(int n1, int n2, String oper) {
		int r = 0;
		switch (oper) {
			case "+":
				r = n1 + n2;
				break;
			case "-":
				r = n1 - n2;
				break;
			case "*":
				r = n1 * n2;
				break;
			case "/":
				r = n1 / n2;
				break;
		}
		return r;
	}
}