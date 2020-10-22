package day0520;

public class Ex2Operator2 {

	public static void main(String[] args) {
		// 논리 연산자(true/false)
		/*
			&&	AND		그리고
			||	OR		또는
			!	NOT		~아닌
			
			제어문과 같이 사용(if, while, do while)
			
			비교 연산자
			<, >, <=, >=, == 
		*/
		int number = 0;
		System.out.println(number > 0);//false
		
		 /*
		 	AND 0 0 -> 0
		 	AND 0 1 -> 0
		 	AND 1 0 -> 0
		 	AND 1 1 -> 1
		  */
		System.out.println(number > 0 && number < 10);//false
		
		 /*
	 		OR	0 0 -> 0
	 		OR	0 1 -> 1
	 		OR	1 0 -> 1
	 		OR	1 1 -> 1
		  */
		System.out.println(number > 0 || number < 10);//true
		
		 /*
 			NOT 	0 -> 1    1 -> 0
		  */
		number = 5;
		System.out.println(number == 5);//같을때		//true
		System.out.println(number != 5);//같지 않을때 	//false
	
		System.out.println(!(number > 5 && number < 10));
		//추천하지 않는방법 			//false란 답을 true로 바뀌어 버림
		System.out.println(!(number < 5));
						   //number >= 5 	이렇게 적는게 낫다
	
		// 삼항연산자
		// 조건에 따라서 값을 대입
		 /*
			value = ( 조건 ) ? '값1' : '값2' ;
			이 조건이 참이면 값1 이 조건이 거짓이면 값2
		  */
		
		//위에 number를 받아 5인상태
		char c;
		c = (number > 0)?'Y':'N';
		System.out.println("c = " + c);
		
		int n;
		n = (number < 5)?10:20;
		System.out.println("n = " + n);
		
		String str;
		str = (number > 3)?"3보다 크다":"3보다 작다";
		System.out.println(str);
	}

}