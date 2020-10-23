package day0601_2Oop2;

public class mainClass {

	public static void main(String[] args) {

//객체를 만들어서(생성)
				//cls는 instance(클래스변수)	클래스형
//		MyClass cls = new MyClass();//객체를 만들어서
		//==
		MyClass cls = null;
		cls = new MyClass(); 
		
//도트로 접근한다	
		cls.number = 1;				
		cls.name = "홍길동";
		cls.age = 24;
		cls.address = "서울시";
		
		cls.func();
		cls.method();
		
//새로운 객체 - 객체는 다 독립적
		MyClass mcls = new MyClass();
	
		System.out.println(cls);
		System.out.println(mcls);
		
		/*
		 절차 지향에서는 순서의 처리가 중요했다
			절차 지향
			 1. 입력
			 2. 정렬처리
			 		swap
			 3. 출력
		
		객체 지향에서는 처리가 중요하다.
			객체 지향
			 입력, 정렬, 교환(swap), 출력 - 동일선상
			 순서에 맞게 호출만
		
		*/
	}

}

//cf) 클래스 모델

/* 클래스명
 * Sorting
 */

/* 멤버변수
 * number[] : int
 * updown[] : boolean
 */

/* 멤버메소드명
 * input()
 * sorting()
 * swap(int, int)
 * result()
 */


