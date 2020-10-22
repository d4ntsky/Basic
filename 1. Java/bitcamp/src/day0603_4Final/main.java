package day0603_4Final;

public class main {
	
	public static void main(String[] args) {
		// final :제약
		/*
			변수, 메소드, 클래스 final이 붙으면 고쳐 기입 불가.
		*/
		final int number = 10;			//변수 -> 상수(대입용) (final을 붙이는 순간 상수가 된다)
//		final int MEMBER_NUMBER = 100;	
		final int MAX = 100;	//대문자로 해놓는데 고정된거라고 알리기 위해
		int num;
		num = number;
//		num = Max;
		//number = 2;//에러남 (10이 벌써 상수로)
	}
}

final class superClass{				//상속금지 class 앞에 final
	int	number;
	public superClass() {
		
	}
	public final void method() { 	//final를 void 앞에 넣으면 에러난다. over ride 금지 method 앞에 final
		
	}
	
// class thisClass extends superClass{
	
//	public void method() {	}		//over ride



}



