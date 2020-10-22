package day0609_2Interface;

				//상속받은 걸 정의해줘야 사용 가능
public class MyClass implements MyInterface {
				//소스 오버라이드 하던지 에러 부분 클릭해서 정의하던지
	@Override
	public void method() {
		System.out.println("MyClass method()");

	}

}
