package day0602_2Constructor;

public class MyClass {
	

	/*
	constructor	:	생성자 == method
				 	class명과 같은 method
				  	return 값이 없다
				  	over load가 가능 - 같은 함수로 매개변수가 다른것
				  	자동 호출이 된다
				  	별도의 호출이 불가능하다
				  	생략이 가능하다
				  	기본 값을 설정할 경우가 많다
				  	초기화는 사용 안 하는 편이 좋다!!
													cf)파이썬 _init_
	destructor	: 	소멸자 X
	
	
	cf) structure (c언어)
	STRUCT mystruct{
		int num;
		String str;
	};
	mystruct my = { 123, "hello" }; 이렇게 초기화가 가능(c언어) class에선 불가능해서 나온게 생성자 constructor	
*/

	private int number;
	public String name;

	
	public MyClass() {				// 기본 생성자
		System.out.println("MyClass MyClass()");
	}
	
	public MyClass(int number) {	
		this.number = number;
	
		System.out.println("MyClass MyClass(int number)");
	
	}

	public MyClass(int number, String name) {
		this();
		this.number = number;
		this.name = name;
	
		System.out.println("MyClass MyClass(int number, String name)");
	}
	
	
//	public mainClass(int number, String name) {
//		
//		this.number = number;
//		this.name = name;
//	}
	
	/*
	public MyClass(int number) {
		this.number = number;
		
		System.out.println("MyClass MyClass(int number)");
	}
	
	public MyClass(int number, String name) {
		this(34);
		
		this.number = number;
		this.name = name;
		
		System.out.println("MyClass MyClass(int number, String name)");
	}
	*/
}

