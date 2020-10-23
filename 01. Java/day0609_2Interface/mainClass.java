package day0609_2Interface;

public class mainClass {
	
	public static void main(String[] args) {
		/*
			abstract class	: 일반 method + abstract method + variable
							다중 상속이 불가능  ex)부모클래스를 두개 받을 수 없다 그러나 다른 언어는 가능
			
			interface		: abstract method. 선언만 되어있는 요소
							다중 상속이 가능
							설계의 사양을 빠르게 파악할 수 있다는 장점
							확장성, 관리 목적을 갖고있다. 
							class가 아닌 인터페이스
		*/
		
//		MyInterface myinter = new MyInterface();				생성안됨
		MyClass mycls = new MyClass();
		mycls.method();
		
		YourClass yourcls = new YourClass();
		yourcls.method();
		
		
		MyInterface myInter = new MyClass(); 		//자식이기 때문에 가능
		myInter.method();
		MyInterface yourInter = new YourClass();
		yourInter.method();
		//하나의 interface에서 여러
	
		
		ZomClass zcls = new ZomClass();
		zcls.method();
		zcls.func();
		zcls.zomMethod();
		//다 접근 가능
		//인터페이스는 관리 목적이기 때문에 상속받은 인터페이스에 인스턴스
		
		MyInterface minter = new ZomClass();
		//가능하다.
		minter.method();				// 가능
//		minter.func();					// 불가능
		((YourInterface)minter).func();	//		> 형변환 후 가능
		
	}
}
