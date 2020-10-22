package day03;
// 무한루프란?
// 반복문의 조건이 항상 참이 나오는 식이 됨으로써
// 해당 반복문이 영원히 반복되는 것을 무한루프라고 한다.
public class Ex13InfiniteWhile {
	public static void main(String[] args) {
		//무한루프를 만드는 첫번째 방법
		//변화식이 없는 조건식을 만들어준다.
//		int number = 3;
//		while(number > 0) {
//			System.out.println("무한루프 1번");
//			System.out.println("변화식이 없는 조건식");
//		}
//이 조건식은 3만 반복 되고 변화는 없기때문
// cf) ctrl + / 는 // 가 생긴다
		
		//무한루프를 만드는 두번째 방법
		//항상 참이 나오는 조건식을 만들어준다.
//		while(1 > 0) {
//			System.out.println("무한루프 2번");
//			System.out.println("항상 참이 나오는 조건식");
//		}
		
		//무한루프를 만드는 마지막 방법
		//그냥 true를 넣어준다.
		while(true) {
			System.out.println("무한루프 3번");
			System.out.println("while(true)");
		}
		//무한루프는 그 다음 줄부터는 모두다 에러가 난다.
		//왜냐하면 무한루프에 들어간 순간
		//그 다음 줄은 영원히 도달할 수 없는 unreachable code가 되기 때문이다.
		//밑에 수식처럼 무한루프 다음에 수식이 있었다면 도달 할 수 없다.
		//int i = 10;
	}
}