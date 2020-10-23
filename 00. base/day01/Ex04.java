package day01;

// 비교연산자
// > >= < <= == !=
// 비교연산자는 두 개의 값을 비교한다.
// 크냐, 크거나 같냐, 작냐, 작거나 같냐, 같냐, 다르냐 6개의 연산자가 있다.
// 또한 비교 연산자는 결과값이 항상 true/false의 boolean이 나오게 된다.
public class Ex04 {
	public static void main(String[] args) {
		int number1 = 10;
		int number2 = 12;
		System.out.println(number1 > number2);
		System.out.println(number1 < number2);
		System.out.println(number1 == number2);
		System.out.println(number1 != number2);
		
		//하지만 클래스 변수(=객체)에 대해 비교연산자를 쓰면 우리가 원하는 값을
		//얻지 못할 수도 있다
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = str1;
		System.out.println("세 String의 값: ");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("str1 vs str2: "+(str1==str2));
		System.out.println("str1 vs str3: "+(str1==str3));
		System.out.println("str2 vs str3: "+(str2==str3));
		// str1~3까지 모두 "abc"가 들어가 있지만,
		// 비교연산자를 통해서 비교를 하면
		// str2를 비교할때는 무조건 false가 나오게 된다.
		
		// 이런 일이 발생하는 이유는
		// 이 참조형 변수의 경우 비교 연산자가
		// 주소값만 비교하기 때문에 발생한다.
		// 좀 더 자세히 말하자면,
		// 참조형 변수는 스택 영역에 메모리 주소값만 가지고 있다.
		// 실제 값은 그 메모리 주소를 "참조"해서 힙 영역에 해당하는 공간으로
		// 들어가야지만 볼수가 있다.
		// 하지만, 비교 연산자는 참조를 안한다.
		// 즉 실제 값을 비교하는게 아니라
		// 스택 영역에 저장되어있는 메모리 주소값만 보고 비교한다.
		
		// str3는 str1의 주소값으로 초기화했기 때문에
		// 2개의 이름은 다르지만 실제 메모리주소값은 같다.
		// 그에 반해 str2는 다른 방법으로 초기화했기 때문에
		// 메모리 주소값이 틀리다.
		// 그러므로 str1과 str3의 비교연산은 true가 나오지만
		// 그 외에는 false가 나오게 된다.
		
		// 따라서 참조형 변수를 비교할 때에는 실제 힙 영역에 들어있는 값을 비교해야하므로
		// 연산자가 아닌 메소드를 실행 시켜서 비교해야 한다.
		// 해당 변수의 메소드는 변수.메소드() 로 실행할 수 있다.
		
		System.out.println("method로 비교한 결과");
		System.out.println("str1 vs str2: "+(str1.equals(str2)));
		System.out.println("str1 vs str3: "+(str1.equals(str3)));
		System.out.println("str2 vs str3: "+(str2.equals(str3)));
	}
}
