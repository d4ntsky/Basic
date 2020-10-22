package Task0521;

import java.util.Scanner;

public class Test0521 {

	public static void main(String[] args) {
//과제1
//1부터 1000 사이 수의 합은: 
		int num = 0;
			for(int i = 1; i <= 1000; i++) {
				num = num + i;
			}	System.out.println(num);
//---------------------------------------------------------------------
//과제2
//하나의 수를 입력 받고 10의 배수로 입력 받은 수는 어느 범위에 있는지 출력되는  프로그램을 작성하라.
	Scanner scan = new Scanner(System.in);
		int inNum;//예) >> 45 
		System.out.println("숫자를 입력해주세요");
		inNum = scan.nextInt();
		int number = inNum;
		
		//입력한 수는 40보다 크고 50보다 작다. 
		if(number >= 100) 		System.out.println("100 이상은 사용할수 없습니다.");
		else if(number >= 90 && number < 100) 	System.out.println("입력한 수는 90보다 크거나 같고 100보다 작습니다.");
		else if(number >= 80 && number <  90) 	System.out.println("입력한 수는 80보다 크거나 같고   90보다 작습니다.");
		else if(number >= 70 && number <  80) 	System.out.println("입력한 수는 70보다 크거나 같고   80보다 작습니다.");
		else if(number >= 60 && number <  70) 	System.out.println("입력한 수는 60보다 크거나 같고   70보다 작습니다.");
		else if(number >= 50 && number <  60) 	System.out.println("입력한 수는 50보다 크거나 같고   60보다 작습니다.");
		else if(number >= 40 && number <  50) 	System.out.println("입력한 수는 40보다 크거나 같고   50보다 작습니다.");
		else if(number >= 30 && number <  40) 	System.out.println("입력한 수는 30보다 크거나 같고   40보다 작습니다.");
		else if(number >= 20 && number <  30) 	System.out.println("입력한 수는 20보다 크거나 같고   30보다 작습니다.");
		else if(number >= 10 && number <  20) 	System.out.println("입력한 수는 10보다 크거나 같고   20보다 작습니다.");
		else if(number >=  0 && number <  10) 	System.out.println("입력한 수는   0보다 크거나 같고   10보다 작습니다.");
		else { System.out.println("다시 입력해주세요.");}
		
		if(number >= 100) 		System.out.println("100 이상은 사용할수 없습니다.");
		else if(number >= 90) 	System.out.println("입력한 수는 90보다 크거나 같고 100보다 작습니다.");
		else if(number >= 80) 	System.out.println("입력한 수는 80보다 크거나 같고   90보다 작습니다.");
		else if(number >= 70) 	System.out.println("입력한 수는 70보다 크거나 같고   80보다 작습니다.");
		else if(number >= 60) 	System.out.println("입력한 수는 60보다 크거나 같고   70보다 작습니다.");
		else if(number >= 50) 	System.out.println("입력한 수는 50보다 크거나 같고   60보다 작습니다.");
		else if(number >= 40) 	System.out.println("입력한 수는 40보다 크거나 같고   50보다 작습니다.");
		else if(number >= 30) 	System.out.println("입력한 수는 30보다 크거나 같고   40보다 작습니다.");
		else if(number >= 20) 	System.out.println("입력한 수는 20보다 크거나 같고   30보다 작습니다.");
		else if(number >= 10) 	System.out.println("입력한 수는 10보다 크거나 같고   20보다 작습니다.");
		else if(number >=  0) 	System.out.println("입력한 수는   0보다 크거나 같고   10보다 작습니다.");
		else { System.out.println("다시 입력해주세요.");}
//---------------------------------------------------------------------
//과제3
//1 ~ 100 사이에 짝수의 합과 홀수의 합을 각각 출력하도록 작성하라. 
		
		//1부터 100사이 짝수의 합은:		
		int aNum = 0;
		int a = 0;
			for(a = 1; a <= 100; a++) {
				if( a % 2 == 0)
			aNum = aNum + a;
		} System.out.println("1부터 100사이 짝수의 합은? " + aNum + "이다");
			
		//1부터 100사이 홀수의 합은:
		int aNum2 = 0;
		int b = 0;
			for(b = 1; b <= 100; b++) {
				if( b % 2 == 1)
			aNum2 = aNum2 + b;
		} System.out.println("1부터 100사이 홀수의 합은? " + aNum2 + "이다");
//---------------------------------------------------------------------
//과제4
//구구단을 1단부터 9단까지 출력하는 프로그램을 작성하라. (for, while) 
//1 * 1 = 1 1 * 2 = 2 1 * 3 = 3... 
		
//---------------------------------------------------------------------
//과제5
//임의 수를 입력 받고 그 해당하는 수의 구구단을 출력하는 프로그램을 작성하라. (for, while) 
//>> 입력
		//3
		//3*1/*2
//3 * 1 = 3 3 * 2 = 6 3 * 3 = 9... 
//---------------------------------------------------------------------
//과제6
//		***** 
//		***** 
//		***** 
//		***** 
//		***** 
			for(int r = 0; r < 5; r++) { //r < 줄 수
				System.out.println("*****");
			}
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
			//for(int r = 0; r < 5; r++) { //r < 줄 수
				//r = r + 1;
				//System.out.println("*");
			//}
			
//---------------------------------------------------------------------
//과제8
//사칙연산을 할 수 있는 프로그램을 작성하라. 
//첫 번째 수 >> 
			//int p = 3;
//연산자	  >> +-*/
			//char q = *
//두 번째 수  >> 
			//int r = 7
					
					//pqr 넣는식
//---------------------------------------------------------------------
//과제9
//유저로부터 입력 받은 수들의 합계와 평균을 구하는 프로그램을 작성하라.\ 
       // a b c a b c a b c
//연산하고 싶은 숫자의 개수를 입력>>
			//a b c
//배열 동적 할당>> 
			
//개수에 맞게 숫자를 입력 받음>> 
			
//합계를 연산
		//a+b+c=
//평균을 연산 
		//a+b+c=/3
//출력 
		//합계는 0 평균은 0
//---------------------------------------------------------------------
	}

}