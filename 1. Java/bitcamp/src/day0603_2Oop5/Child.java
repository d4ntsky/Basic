package day0603_2Oop5;

public class Child extends Parent { //class 만들때 superclass에서 부모클래스 선택하면

	public Child() {
//		super();
		super(123);
	}
	
	// Over Ride 실시한 method  //override 목적 - 관리 용이
	public void method() {
		System.out.println("Child method()");
	//	super.method();//밑에다 적은 이유는 호출을 위해                      //기본 생성자를 호출때만 맨위에 쓰인다.
	}
	
	//override 규칙
	//메소드의 완전하게 사양이 같아야함 public 이름() 완전 같아야...
	
	
	public void func() {
		System.out.println("Child func()");
	}
}