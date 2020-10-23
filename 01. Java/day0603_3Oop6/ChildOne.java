package day0603_3Oop6;

public class ChildOne extends Parent {

	public ChildOne() {
		
	}
	
	//오버라이딩할 메소드
	public void method() {
		System.out.println("ChildOne method()");
	}
	
	//차일드원에만 있는 - parent에선 이걸 접근 못함
	public void func() {
		System.out.println("ChildOne func()");
	}
	
}
