package day0609_2Interface;

									//다중 상속 받아서 정의만 해주면
public class ZomClass implements MyInterface, YourInterface {

//정의 부분
	@Override
	public void func() { // 					yourinterface 소속
		System.out.println("ZomClass func()");
	}

	@Override
	public void method() {
		System.out.println("ZomClass method()");
	}

//일반 함수 추가
	public void zomMethod() {
		System.out.println("ZomClass zomMethod()");
	}

}
