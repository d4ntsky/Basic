package day0609_1Abstract;

		//추상이라 부르고 앞에 붙는다
public abstract class AbstractClass {

	private int number;

	public void method() { 					// 일반 메소드
		System.out.println("AbstractClass method()");
	}

	public abstract void abstractMethod(); 	// 매개 변수 거의 안준다 그 이유는 협업하기 때문에

}
