package day03;
// 반복문 - while
// for 반복문에서는 우리가 int 변수에 값으로
// 몇 번 반복이 될 지를 결정했었다.
// 하지만 while은 조건식이 true인 동안 계속 반복이 된다.

public class Ex11While {
	public static void main(String[] args) {
		int number = 3;
		while(number > 0) {
			System.out.println("while 반복문 실행.");
			
			number--;
		}
	}
	
}
