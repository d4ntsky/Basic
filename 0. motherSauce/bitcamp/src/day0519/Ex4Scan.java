package day0519;

import java.util.Scanner;

public class Ex4Scan {

	public static void main(String[] args) {
		/*
		입력 : input
		출력 : output -> 콘솔 text
			System.out.println();
		cf)UI user interface		 
		
		출력과 달리 입력은 저장해 놓을 공간(변수)을 필요로 한다.
		 */
	
		Scanner scan = new Scanner(System.in);
		// boolean	(true/false)
		//ex) 체크박스
		boolean b;
		System.out.print("b = ");     //입력 받는 건 명시해주는게 좋음
		b = scan.nextBoolean();       // true/false
				System.out.println("b: " + b);		  //결과
		
		// int		(정수)
		int number; //입력받았을때 들어갈 공간
		System.out.print("number = ");
		number = scan.nextInt(); //받는 
				System.out.println("number: "+number); //결과
		//에러와 버그 잡는게 중요
		
		// double	(실수)
		double d;
		System.out.print("d = ");
		d = scan.nextDouble();
				System.out.println("d: "+d);			  //결과
		
		// String	(문자열)
		//next, nextln ??????????????????
			String _str;
			System.out.print("_str = ");
			_str = scan.next();
						System.out.println("_str: "+ _str);
				
		String str;
		System.out.print("str = ");
		str = scan.next();
			System.out.println("str: "+ str);			  //결과
		//' ' == null 문자(빈문자)
			
			//scan.close(); 이게 필요한 이유는 나중
	}

}