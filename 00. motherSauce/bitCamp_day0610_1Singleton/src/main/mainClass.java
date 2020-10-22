package main;

import clsZ.ZomClass;
import clsM.MyClass;
import single.SingletonClass;
import clsY.YourClass;

public class mainClass {

public static void main(String[] args) {
	//디자인 패턴 28가지 중 싱글턴은 필수, 팩토리 패턴은 선택, 옵저버 패턴은 재밌어서 배움, 스트레티지는 게임용
		/*	
		Singleton : 하나밖에 없는 
			mainClass											여기로 게터세터받기			일로보낸다
			MyClass		int data: data=15 게터만들기
			YourClass 							int num을 세터만들기
			3가지 클래스 있다. 근데 heClass 등장
			Heclass															int tag가 등장
			
			이 과정을 singleton에
			변수를 하나 만들어서  data num tag 를 다 접근할 수 있게
			my your he가 다 singleton에서 찾아가고 
			main은 모르고 다른 class끼리 데이터가 자유롭게 싱글턴을 통해 넘겨주고 넘겨받을 수 있게 설정하는
		*/
/*
	Singleton : 하나의 instance에 접근하여 데이터를 송수신할 수 있는 Pattern
		장점은 언제 어디서든지 접근할 수 있다.
*/


	
	MyClass mcls = new MyClass();
	YourClass ycls = new YourClass();
	
	//1)
	/*
	int n = mcls.getNumber();
	ycls.setTag(n);
	*/
	
	//2)-4
	mcls.method();
	ycls.func();	
	
	System.out.println(ycls.toString());
	
	//싱글턴 안 쓰고 static 변수를 바꾸면 되는데 은닉성이 보장 안된다.
	
	//계속 같은 주소를 받아오는 것 확인
	/* 
	SingletonClass sc = SingletonClass.getInstance();
	System.out.println("sc: " + sc);
	
	SingletonClass sc1 = SingletonClass.getInstance();
	System.out.println("sc1: " + sc1);

	SingletonClass sc2 = SingletonClass.getInstance();
	System.out.println("sc2: " + sc2);
	*/
	
	//4)-4
	ZomClass zcls = new ZomClass();
	ycls.strMet();
	zcls.strFunc();
	System.out.println(zcls.toString());
	}
}
