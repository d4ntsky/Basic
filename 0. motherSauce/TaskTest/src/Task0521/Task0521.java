package Task0521;

import java.util.Scanner;

public class Task0521 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//과제1
//1부터 1000 사이 수의 합은: //문제가 나오면 주제별 파악이 필요하다.
		//선언부
		int sum;
		int num;
		//초기화 initialize
		sum = 0;//초기화는 따로 이니셜라이즈
		num = 1;
		//처리 processing
		for(int i = 0; i < 1000; i++) {
			sum = sum + num;
			num = num + 1;
		}
		//출력 printing
		System.out.println("합계:" + sum);
		
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제2
//하나의 수를 입력 받고 10의 배수로 입력 받은 수는 어느 범위에 있는지 출력되는  프로그램을 작성하라. 
//예) >> 45 
//입력한 수는 40보다 크고 50보다 작다. 
		int inNum;
		
		System.out.print("숫자입력 = " );
		inNum = scan.nextInt();
		/*
		if(number > 0 && number <= 10 ) {
			System.out.println("number는 0보다 크고 10보다 작거나 같다");
		}
		else if(number > 10 && number <=20 ) {
			System.out.println("number는 0보다 크고 10보다 작거나 같다");
		}
		:
		:
		:
		*/ //줄이자
		int a = 0;
		for(int b = 0; b < 10; b++) {
			a = 10 * b; // 0 10 20 30 ... 90
			if(inNum > a && inNum <= (a + 10)) {
				System.out.println("number는" + a + "보다 크고 " + ( a+10 ) + "보다 작거나 같다");
			}
		}
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제3
//1 ~ 100 사이에 짝수의 합과 홀수의 합을 각각 출력하도록 작성하라. 
//1부터 100사이 짝수의 합은:	
//1부터 100사이 홀수의 합은:
		int sum1, sum2;
		sum1 = sum2 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {		//홀수
				sum1 = sum1 + i;
			}else {					//짝수
				sum2 = sum2 + i;
			}
		}
		System.out.println("홀수의 합:" + sum1);
		System.out.println("짝수의 합:" + sum2);
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제4
//구구단을 1단부터 9단까지 출력하는 프로그램을 작성하라. (for, while) 
//1 * 1 = 1 1 * 2 = 2 1 * 3 = 3... 
		for(int w = 1; w <= 10; w++) {
			
			for(int v = 1; v <= 10; v++) {
				
				System.out.print(w + " x " + v + " = " + (w*v) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제5
//임의 수를 입력 받고 그 해당하는 수의 구구단을 출력하는 프로그램을 작성하라. (for, while) 
//>> 입력 
//3 * 1 = 3 3 * 2 = 6 3 * 3 = 9... 
		System.out.print("출력하고 싶은 구구단 = ");
		int goo = scan.nextInt();
		for(int i = 1; i <= 10 ; i++) {
			System.out.println(goo + " x " + i + " = " + (goo*i));
		}
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제6
//		***** //가로 5 세로 9
//		***** 
//		***** 
//		***** 
//		***** 
//		***** 
//		***** 
//		***** 
//		***** 
		for(int j = 0; j < 9; j++) {
			for(int k = 0; k < 5; k++) {
				System.out.print("*");
			}
		System.out.println();
		}
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제7
//		* 
//		** 
//		*** 
//		**** 
//		***** 
//		**** 
//		*** 
//		** 
//		* 
		int l = 0; //*하나 시작
		for(int m = 0; m < 9; m++) {	//0 ~ 8
			
			if( m < 5 ) l = l + 1;
			else     	l = l - 1;	
			
			for(int n = 0; n < l; n++) {
				System.out.print("*");
			}
		System.out.println();
		}//다시
		System.out.println("--------------------------------------------------------------");
		
//		**
//		*
//		***
//		*****
//		*
//		****
		int stars[] = { 2, 1, 3, 5, 1, 4 };
		for(int p = 0; p < 6; p++) {
			for(int q = 0; q < stars[p]; q++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제8
//사칙연산을 할 수 있는 프로그램을 작성하라. 
//첫 번째 수>> 
//연산자>> 
//두 번째 수>>  
		int numf, nums;
		String oper; // + - * /
		int result = 0;
		
		System.out.print("첫번째 수 = ");
		numf = scan.nextInt();
		
		System.out.print("(+, -, *, /) = ");
		oper = scan.next();
		
		System.out.print("두번째 수 = ");
		nums = scan.nextInt();
		
		switch(oper) {
			case "+":
				result = numf + nums;
				break;
			case "-":
				result = numf - nums;
				break;
			case "*":
				result = numf * nums;
				break;
			case "/":
				result = numf / nums;
				break;
		}
		System.out.println(numf + " " + oper + " " + nums + " = " + result);
		System.out.println("--------------------------------------------------------------");
//---------------------------------------------------------------------
//과제9
//유저로부터 입력 받은 수들의 합계와 평균을 구하는 프로그램을 작성하라.\ 
//연산하고 싶은 숫자의 개수를 입력>> 
//배열 동적 할당>> 
//개수에 맞게 숫자를 입력 받음>> 
//합계를 연산 
//평균을 연산 
//출력
		
//---------------------------------------------------------------------
	}
}