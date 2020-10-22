package Task0520;

import java.util.Scanner;

public class Test0520_Store {

	public static void main(String[] args) {
		/*
		 	편의점
		 	
		 	지불해야할 금액	:  3230원
		 	자신의 금액		: 10000원
		 	
		 	거스름돈		: 출력
		 	5000원		: ?장 1
		 	1000원		: ?장 1
		 	 500원		: ?개 1
		 	 100원		: ?개 2
		 	  50원		: ?개 1
		 	  10원		: ?개 2
		 */
//================================================================
		/*
			지불해야할 금액	:  3230원 > don
			자신의 금액		: 10000원 
			거스름돈		: 출력	 > reDon
			5000원		: ?장 1
			1000원		: ?장 1
			 500원		: ?개 1
			 100원		: ?개 2
			  50원		: ?개 1
	 	  	  10원		: ?개 2
		 */
		Scanner scan = new Scanner(System.in);
		int don;
		System.out.println("얼마 나왔나");
		don = scan.nextInt();
		
	//	mydon = 얼마(이게 만원)
		int reDon = 10000 - don;
	
		int a,b,c,d,e,f;
	
		a = reDon / 5000;
		b = reDon / 1000 - a;//?5000원 이상 -
		c = (reDon % 1000) / 500;
		d = ((reDon % 1000) - c) / 100;//
		e = (reDon % 100) / 50;
		f = ((reDon % 100) - e) / 10; //
		//앞에꺼 가져오지 않고 나누는 값을 달리하면 나머지가 달라진다
		
		System.out.println("거스름돈 : " + reDon + "원");
		System.out.println("5000원  : " + a + "장");
		System.out.println("1000원  : " + b + "장");
		System.out.println(" 500원  : " + c + "개");
		System.out.println(" 100원  : " + d + "개");
		System.out.println("  50원  : " + e + "개");
		System.out.println("  10원  : " + f + "개");
//================================================================
		/*
		지불해야할 금액	:  3230원 > don
		자신의 금액		: 10000원 
		거스름돈		: 출력	 > reDon
		5000원		: ?장 1
		1000원		: ?장 1
		 500원		: ?개 1
		 100원		: ?개 2
		  50원		: ?개 1
		  10원		: ?개 2
		 */
	int money;
	System.out.println("얼마 나왔나");
	money = scan.nextInt();
	
	int reMoney = 10000 - money;
	//여기선 하나씩 내려가면서
	//거스름돈에서 나눈것
	//b = (b < 0)?b:0;
	//System.out.println("n = " + n);
	//5000보다 크면 나눈 값을 true 경우 무엇으로 표시인가?
	//
	
	}

}