package day0603_5Static;

public class MyClass {
	private int memNum;		// member variable 멤버변수

	//새로 선언
	static int staticVar;	// static variable
	
	
	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	//새로 선언한것 따라적
	public void method() {					//instance method
		int i = 0;												//local  블럭문 빠져나갈때 사라짐
		i = i + 1;

		memNum = memNum +1 ;									//member 가비지 컬렉터로 삭제 됐을때
		System.out.println("memNum = " + memNum);
		
		staticVar = staticVar +1 ;								//static 사라지지 않는다.
		System.out.println("staticVar = " + staticVar);
	}
	
	public static void staticMethod() {		//class method
		System.out.println("MyClass staticMethod() 호출");
		
		//접근 못하는 요소
		//this,super 접근을 못한다.
	}
}
