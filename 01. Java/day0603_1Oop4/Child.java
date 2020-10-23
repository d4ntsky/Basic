package day0603_1Oop4;

public class Child extends Parent { // 자식클래스 extends 부모클래스명 - 부모클래스를 상속받는다는 뜻(생성자를 제외한 모든것?)

	public Child(){								//이걸 실행시 부모클래스 나온 다음 자식
		// super : 부모 클래스의 reference(pointer==주소/참조)
		// this	 : 자기 자신의 	 reference!
		super(7);//(부모클래스 확인)** 이 부분 넣을 때 int number가 생겼다.             (기본생성자로 사용할땐 생략된다.)
		System.out.println("Child Child()");
	}
	//public Child() : Parent()?????????????????????????
	
	//부모클래스의 기본생성자가 없으면 에러가 난다.
	public Child(int num) {//부모클래스에 변수에 접근할려면 super가 들어간다.
		super(num);//(3)
	}//@@ 세팅하고 싶다. 자식클래스에서 main까지
	
	public void func() {
		//부모 클래스에서 모르는
//		number = 1; 	// 부모클래스에서 private으로 되어있기때문에 상속받아도 사용 못한다.
		name = "홍길동"; 	// protected 접근지정자 자식클래스에서 접근을 허용 하지만 외부에서 접근은 차단.
	}
}
