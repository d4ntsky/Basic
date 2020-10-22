package day02;
//반복문
//반복문은 조건이 만족되면(=true가 나오면)
//해당 코드블락을 반복한다.
//반복하다가 조건이 만족하지 않으면(=false가 나오면)
//반복을 종료한다.

//반복문에는 while과 for이 있고
//while은 어떤 조건을 만족하는 동안
//for은 특정 횟수동안 반복된다.
public class Ex11ForLoop {
	public static void main(String[] args) {
		//for loop은 주로
		//for(int i = 얼마; i < 숫자; i++) {
		//     반복할 코드   cf) i 말고 다른게 들어가도 된다
		//}
		//이렇게 생겼다!
		for(int i = 0; i < 4; i++) {
			System.out.println("i의 현재값: "+i);
		}
		
		//위의 3줄의 순서를 한번 알아보자
		// int i = 0                           -> 1번 코드
		// i < 4                               -> 2번 코드
		// System.out.println("i의 현재값: "+i);  -> 3번 코드
		// i++                                  -> 4번 코드
		
		// i:1>2>
		// 실행 되는 순서 1 > 2 > 3 > 4 > 2 > 3 > 4 > 2 > 3 > 4 - 여기서 4가 되고
		// > 3 > 4 > 2 확인하고 종료
		
		for(int i = 5; i < 3; i++) {
			System.out.println("i의 현재값: "+i);
		//결과값이 나오지 않음	
		}
		
	}
}