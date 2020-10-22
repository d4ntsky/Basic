package day0529;

public class Ex1OverLoad {

	public static void main(String[] args) {
		/*
			Over Load : 함수(메소드)명은 같고				cf)Override?
						매개변수(인수, 인자)의 자료형이나 
						인수의 갯수가 다른 것을 의미
			ex)
			image drawing ->알파(투명/반투명)				RGBA 
							불투명(배경) - 처리가 가벼움		RGB
			imageDraw(int x, int y, int a) 
			imageDraw(int x, int y)
			목적이 동일, 구분해서 남겨 놓는것 imageDrawA(int x, int y, int a)라 하면 자료명이 너무 많아진다.
		*/
		int num1 = Integer.parseInt("123");
		int num2 = Integer.parseInt("3E8", 16);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		/*cf)
			unsigned byte = 0 ~ 255 부호비트 사용하는 (마이너스 사용 안하는)
			signed byte = -128 ~ 127
		*/
		
		funcName();
		funcName('A');
		funcName(123);
		funcName('B', 234);
		funcName(345, 'C');
	}
	
	static void funcName( ) {
		System.out.println("funcName() 호출");
	}
	
	static void funcName(char c) {
		System.out.println("funcName(char c) 호출");
	}	

	static void funcName(int i) {
		System.out.println("funcName(int i) 호출");
	}
	
	static void funcName(char c, int i) {					//getter
		System.out.println("funcName(char c, int i) 호출");
	}
	
	static void funcName(int i, char c) {					//getter
		System.out.println("funcName(int i, char c) 호출");
	}

//	static int funcName(int i, char c) {					//getter
//		System.out.println("funcName(int i, char c) 호출");
//		result 1;
//	}
	
//						//가인수가 다르다고 오버로드 되지 않음
//	static int funcName(int a, char c) {					//getter
//		System.out.println("funcName(int, char c) 호출");
//	}
}
