package day0603_1Oop4;

public class Parent {
	
	private int number; //@@ 세팅하고 싶다. 자식클래스에서 main까지
	protected String name;
	//protected 접근지정자 자식클래스에서 접근을 허용 하지만 외부에서 접근은 차단. (getter/setter)
	
	public Parent() {	// 기본 생성자
		System.out.println("Parent Parent()");
	}
	
	public Parent(int number) {	//(2)
		this.number = number;//@@ 세팅하고 싶다. 자식클래스에서 main까지
		System.out.println("Parent Parent(int number)");
	}//변수를 줬다. 이 걸로 생성하고 싶으면 **(자식클래스 확인)
																		//생성자가 두개
	public void Parent_method() {
		System.out.println("Parent Parent_method()");
		//@@ 세팅하고 싶다. 자식클래스에서 main까지
		System.out.println("number = " + number);
	}
}