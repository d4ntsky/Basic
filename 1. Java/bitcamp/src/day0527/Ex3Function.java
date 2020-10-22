package day0527;

public class Ex3Function {

	public static void main(String[] args) {
		// 가변인수
		// 매개변수가 유동적이다.
		// 개발
		allocParam(1,2,3,4,5);
		
		allocParam(23,45,39);
		
		func("hello", 'a', 2, 4, 6);
	}
							//가변인수만 쓰지 않아도 된다
	static void allocParam(int...num) {				//(int num[])
		int sum = 0;			//배열?
		for (int i = 0; i < num.length; i++) {
			sum = sum + num[i];
		}
		System.out.println("합계 : " + sum);
	}
							//일반인수들과 가변인수를 섞어서 쓸수 있다
	static void func(String str, char c, int...num) {
		System.out.println("str : " + str);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + " ");
		}
		System.out.println();
	}
	// 규칙: 가변인수는 항상 parameter에 제일 뒷부분에 가야한다
	
}