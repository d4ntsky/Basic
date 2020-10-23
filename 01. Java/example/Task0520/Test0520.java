package Task0520;

import java.util.Scanner;

public class Test0520 {
	
	public static void main(String[] args) {
		
//과제1 //! 다음의 결과값을 먼저 기입하고 결과를 확인해라
		int number;									//!
		number = 5;									//!
		System.out.println(number);
		
		number = number << 4;						//!
		System.out.println(number);
		
		number = number >> 5;						//!
		System.out.println(number);
		
		number = number >> 1;						//!
		System.out.println(number);
//-------------------------------------------------------------	
		
//과제2 다음의 결과 값을 먼저 기입하고 결과를 확인하라.
//		int num1, num2;  							//!
//		num1 = 128; num2 = 56; 						//!  
//		16진수로 바꾼다 								//!
			// num 1 =  16진수 0x80; 2진수 1000 0000
			// num 2 =  16진수 0x38; 2진수 0011 1000
//		num1 = (num1 & num2) | (num1 & num2); 		//!
			// 1000 0000 | 1000 0000
			// 0011 1000 | 0011 1000
			// 0000 0000 | 0000 0000
				//0000 0000
				//0000 0000
				//0000 0000 = 0
		         
//		num2 = ~(num1 ^ num2); 						//!
			// 1000 0000 
			// 0011 1000
				//^ 1011 1000
				//~ 0100 0111 = 4*16 + 7 = 16진법 0x47 = 10진법 71  
		 
//-------------------------------------------------------------	
		
//과제3	
//		하나의 수를 입력 받고 삼항 연산자를 사용하여 양수인지 음수인지 판단하라. 
//		// 수를 입력 
//		// 판단 
//		// 출력 양수입니다 
		Scanner scan = new Scanner(System.in);
		int a;
		System.out.println("수를 입력해주세요");
		a = scan.nextInt();
		String str = (a > 0)?"양수입니다":"음수입니다";
		System.out.println(str);
		
		
//-------------------------------------------------------------
		
//과제4
//		랜덤 수를 취득하라.  
//		범위: 0 ~ 99  개수: 1개 
//		범위: 11, 12, 13, 14, 15  개수: 1개 
//		범위: 1 ~ 45  개수: 6개 
		
		int ranNum;
		ranNum = (int)(Math.random() * 100); 
		System.out.println("0 ~ 99 = " + ranNum);
		
		int ranNum2;
		ranNum2 = (int)((Math.random() * 5)) + 11; 
		System.out.println("11 ~ 15 = " + ranNum2);
		
		int l,o,t,e,r,y;
		l = (int)((Math.random() * 45)) + 1; 
		o = (int)((Math.random() * 45)) + 1; 
		t = (int)((Math.random() * 45)) + 1; 
		e = (int)((Math.random() * 45)) + 1; 
		r = (int)((Math.random() * 45)) + 1; 
		y = (int)((Math.random() * 45)) + 1; 
		//로또기계라면 같은 수가 나오는 경우가 발생함으로 필요한 코드?
		
		System.out.println(l + "," + o + "," + t + "," + e + "," + r + "," + y);
	
//-------------------------------------------------------------
		
	}
}