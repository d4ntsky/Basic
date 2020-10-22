package day0602_1Oop3;

public class mainClass {	//cf mainClass와 java명은 같다 
	public static void main(String[] args) {
		/* OOP 목적
		 - Code 관리
		cf)안드로이드게임    - java
		      일반 게임	   - c		
		<->
		절차지향
			-> Array
			-> function - 분산 처리
		
		    OOP 특징
		   1. 은닉성 (==캡슐화) 
		   		: 외부와의 차단으로 변수들을 관리할 수 있다.
		   			class의 내부에서 접근(처리)이 가능하도록 접근 지정자로 제어할 수 있다.
		   			 (1) private	(개인적인) -> member variable //클래스 안에서 개인적
		   			 (2) public		(대중적인) -> member method   //어디에서나 접근가능
		   			 (3) protected	(특정)	 -> 				//상속에 관련
		   2. 상속성
		   		: 이전 조건을 받아가는/ 수정 후 사용 over ride!
		   			4단계 이후로는 복잡. 상속의 목적은 자기 기능을 하려고
		   3. 다형성	     2./3.은 같이 배워야함	
		      	: 상속을 받을때 여러 형태로 구현가능
		      		장점:
		*/
		
		//클래스형의 동적할당
		MyClass cls = new MyClass();
		//		instance
	
//		cls.number = 123;	// 은닉성에 위배 - 우리가 풀 수도 있고 막을 수도 있는
//		//에러가 난다.
		cls.name = "hello";	// 은닉성에 위배
		System.out.println(cls);			//힙 주소확인
		System.out.println(cls.getThis());	//자기 자신이 들어간 주소값
		
		/*
		cls.setNumber(246);				//setter
		int num = cls.getNumber();      //getter 값을 얻어오는
		*/
	
	
	}
}