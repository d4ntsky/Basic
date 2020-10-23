package day0519;

public class Ex2Number01 {

	public static void main(String[] args) {
		/*
		    main 프로그램 시작 ~ 끝
		    main 함수에서 구동 C#, C++, ObjectiveC
		 */

		/*
			숫자(상수): 변할 수 없는 숫자를 일컫는다.
			ex) 1 2 3 4 34 123
				 2진수 BIN : 0, 1 (기계어)
				 8진수 OCT : 0 ~ 7  8진수에서   8 -> 10 / 9 -> 011
				10진수 DEC : 0 ~ 9
				16진수 HEX : 0 ~ 9/A/B/C/D/E/F(15) -> 0xff
				2진수 1111 1111은 256 > 16진수로는 0xff
				2,10,16진수가 많이 쓰임
				
			변수(공간): 그릇(크기) -> 담아 놓는다(숫자데이터). variable
					    크기가 다 다르고, 종류도 다양하다.
					   ex) 숫자, 소수, 문자, 문자열, 판정 등
					    별명을 작명.
					    
				자료형 별명;	선언
				별명 = 값;		대입
				
				integer == 정수
				ex)
				int number;		선언
				number = 123;	대입			
		 */
		
		int var; //선언  // 정수 -2, 0, 12, 234
		// integer == 자료형
		// var == 변수명
		var = 135; //대입
		// variable = value
		// ? 변수의 목적은 값을 대입할 수 있고, 각각 다른 값을 사용하여 만들 수 있다.
		var = 246;
		
		System.out.println(var);
		
		// 변수 명의 작명 규칙
		int a; // ASCII Code -> 97
		int A; // ASCII Code -> 65
		// 예약어 -> 누군가 정의되어 있는 언어
		//int int; 예약어 불가 -> 누군가 정의되어 있는 언어
		//int 2a;  숫자도 불가 -> 숫자는 뒤에 와야 한다.(요즘 나오는 언어는 됨)
		int a2;
		//int 234; 상수도 불가
		int _abc;
		//int -abc;  연산자는 사용 불가
		//int *abc; // pointer? (자바에선 사용하긴 하는데)
		int number_postion_char; //토나옴
		int numberpostionchar; //보기힘듬
		int numPosChar; //낙타 기법 -> 활용도 높음
		
		int 마징가;
		마징가 = 378;
		System.out.println(마징가);
		//한글은 되지만 문제 발생한다.
		
		int icharPosEdit; // i charPosEdit 현업용
		icharPosEdit = 45;
		numPosChar = icharPosEdit;
		System.out.println(numPosChar);
		
		a = 35;
		// A = a;
		// a2 = a;
		A = a2 = a;
		System.out.println(a2);
		System.out.println(A);
		
		// 변수명은 옆에 사람이 알아볼정도
		// 가능한 흔한 명칭은 피한다. ex) object, length, number
		// 흔한 명칭은 충돌될 확률이 있다.
		
		
	}

}