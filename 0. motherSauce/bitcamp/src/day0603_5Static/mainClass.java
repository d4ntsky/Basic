package day0603_5Static;

public class mainClass {

	public static void main(String[] args) {
//		/*
//			static == 정적 -> 유지상태
//					  메모리의 낭비.
//						 메소드(기억해두기) 변수(잘 안씀) 클래스(거의 안나옴)
//						프로그램의 흐름을 판단할 때 static 변수를 사용한다.
//			
//			stack heap static sys		
//		*/
//		int i; // local 변수 (지역 변수) - 스택에 올라감 
//		{int j; j=12;}	// local 변수 (지역 변수) == auto
//		//j=1; //블록 밖에 나간건 에러.
//		
//		//System.out.println(i); 에러
//		
//		MyClass cls = new MyClass(); //메인 안에 있는 지역 변수
//		//		stack		heap		//동적할당 - 자동으로 초기화
//		
//		//멤버변수가 객체가 되면 초기화가 된다.
//	
//		int m = cls.getMemNum();
//		System.out.println("m = " + m);//자동적으로 초기화가 되어있음
//	
//		//static int stNumber = 0; 사용불가
//		
//		cls.method();//초기화 안해줘도 0으로 시작
//		cls.method();
//		cls.method();
//		
//		MyClass cls2 = new MyClass();//intance가 달라짐
//		
//		cls2.method(); //멤버넘버가 1로 바뀜
//		//객체가 달라지면 메모리영역이 달라지기 때문에 새로이 1이됨
//		//static은 그대로 늘어나는데... 고정변수라 보고 / 객체가 아무리 늘어나도 static변수의 영역은 하나다!!
//		//static은 정적 변수
//		
//		
		
		MyClass.staticMethod();//static method 호출법
		
		Member mem = new Member();//Member Class와 비교
		mem.init();
		mem.random();
		mem.input();
		
		//위에 작업이 한번에 끝남
		Member mem2 = Member.getinstance();
	
	}

}
