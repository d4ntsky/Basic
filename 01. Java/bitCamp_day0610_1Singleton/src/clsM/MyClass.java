package clsM;

import single.SingletonClass;

public class MyClass {
	private int number;
	
	public MyClass() {
		number = 12;
	}

	//1)
//	public int getNumber() {	//your에 보내기 위한
//		return number;
//	}
	
	//2)-1
	public void method() {
		SingletonClass sc = SingletonClass.getInstance();
		sc.snumber = this.number;		//number 값을 싱글턴 클래스에 넘김
	}
	
}