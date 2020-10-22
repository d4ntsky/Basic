package day0609_1Abstract;

public class mainClass {

	public static void main(String[] args) {
		/*
			Abstract class	: 추상 class (껍데기 밖에 없는 method?)
					추상 method : 선언만 되어있는 함수
							abstract int method(char c, int i); 	- prototype(사양) 
								상속받는 곳에 정의해서 쓴다. cf)확장성이 있고 협업 시 사용한다. 
							생성은 불가능하다. 상속받은 class에서 정의한 후에 생성 가능
				
			class 			: 일반 class
					method의 내용이 모두 설정되어있는 것
							int method(char c, int i) {
									처리
							}
		
		*/

		
		childClass ccls = new childClass(); //이거 자체로는 생성 불가
		//추상 메소드를 정의한 후에 사용 가능
		ccls.method();
		ccls.abstractMethod();
		
		AbstractClass acls = new AbstractClass() {
			@Override	//잠깐 쓸때 정의
			public void abstractMethod() {
				System.out.println("AbstractClass abstractMethod()");
			}
		};
		//간단하게 사용할 때는 추상 클래스를 추천하는
		
		acls.method();
		acls.abstractMethod();
		
		//목적!
		AbstractClass cls1 = new childClass();
		//부모클래스	   //자식클래스 instance 잡을수 있음
		
		AbstractClass cls2 = new MyClass();
		//추상클래스로 자식들을 묶을 수 있다는 뜻
	
		//상속받아서 정해서 쓰라고 주는 게 추상 클래스
		//오버라이딩해서 써도 되는데 복잡해지기 때문에...
		//메소드는 짧은데 인터페이스를 쓰면 장점이 파악을 위해서
		//협업과 확장 쪽에 쓰인다.
		//추상클래스란 프로토타입으로 변수가 포함 가능한 일반 클래스와 추상 클래스를 둘 다 쓸 수 있다
		//추상클래스 생성만 할 수 없으며 정의를 해준 다음에 사용할 수 있다.
		//상속을 반드시 하게 만들어져 있어서 확장성이 있고 관리를 위해서이다.
		//일반 클래스와 변수도 포함할 수 있다.
	
	}

}

