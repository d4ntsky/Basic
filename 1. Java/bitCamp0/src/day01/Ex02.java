package day01;

// 연산자
// 연산자란 특정 기호에 특정 기능을 미리 입력해 둔 것을 연산자라고 한다.
// 연사자는 크게
// 산술, 증감, 비교, 논리, 비트 5가지 연산자가 존재한다.
// 1. 산술연산자
// + - * / %
// + : 더하기
// - : 빼기
// * : 곱하기
// / : 나누기
// % : 나머지
public class Ex02 {
	public static void main(String[] args) {
		// 자바에서 같은 데이터타입끼리 연산할 경우 해당 데이터타입의 결과값이 나오게 된다.
		// 만약 다른 데이터타입이라면, 같은 형(정수형, 실수형)의 경우 더 큰 데이터타입이
		// 결과값으로 나오게 된다.
		// 만약, 정수와 실수를 연산할 경우에는 실수가 결과값으로 나오게 된다.
		// 즉 정수끼리의 나눗셈에서는 여러분들이 한가지 문제를 발견하게 된다.
		int number1 = 5;
		int number2 = 3;
		System.out.println(number1 + number2);
		System.out.println(number1 - number2);
		System.out.println(number1 * number2);
		System.out.println(number1 / number2);
		// 5/3 을 하면 실수는 무시되고
		// 온전한 몫인 1만 나오게 된다.

		// 나머지연산자는 나눗셈의 나머지 부분을 구해준다.
		System.out.println(number1 % number2);
		// cf)컨트롤 시프트 F > 자동정렬 (이클립스기능)
		// 정렬이 안될시 중가로 문제
		
		// String이란 여러 문자가 모여있는 클래스를 뜻한다.
		String str;
		
		// String에 문자열을 초기화할때에는
		// "넣을 문자열" 로 초기화한다.
		str = "abcdefg";
		//그렇다면 아래는 각각 무슨 결과가 나올까?
		System.out.println("123"+456);
		//"123"+456은 숫자들의 합이 아니라
		//123이라는 글자 뒤에 456을 이어붙이라는 의미가 된다.
		//즉 String에 +가 붙으면
		//뒤의 내용을 앞의 내용에 글자로 이어붙여라 라는 의미가 된다.
		System.out.println(123+456);
		//123+456은 두 정수의 합을 뜻한다.
		
	}
}
