package day02;
//조건문 01
//if
//if문은 ()에 우리가 true/false가 나올수 있는 조건식을
//적어주고 그 조건식이 true가 나오면 해당 if코드블록을 실행한다.

//1. 코드블록:
// 코드블록이란 {} 사이를 코드블록이라고 한다.
// 예를 들어 메인 메소드의 코드 블록은
// public static void main(String[] args) {
// 여기 제일 오른쪽에 {부터
// }가 닫히는 위치까지를 한개의 코드블록이라고 한다.
// 코드블록 안에는 여러개의 코드블록이 들어갈 수도 있다.

// 코드블록이 중요한 이유는
// 변수의 유효범위(scope)가 정해지기 때문이다.
// 어떤 변수의 유효범위는 그 변수가 선언되고 나서부터 그 변수가 속한
// 코드 블록이 끝날때까지 이다.
public class Ex01If {
	public static void main(String[] args) {
		int age = 15;
		//cf) age가 18 미만이여야 결과가 run에 뜸
		
		//if(조건식){
		//   조건이 맞으면 실행할 코드
		//}
		if(age < 18) {
			System.out.println("미성년자입니다.");
			//변수의 유효범위를 테스트해보자
			String name = "조재영";
			System.out.println(name);
			//변수의 유효범위가 존재할 때에는
			//해당이름과 같은 변수를 또 만들 수 없다!
			//String name = "조재영2";
		}
		//이미 name의 유효범위가 끝나기 때문에
		//아래코드는 에러가 난다.
		//System.out.println(name);
		//이 것은 유효범위에서 벗어난 변수 - } 안에 있어야함
		
		System.out.println("프로그램의 마지막 줄!");
	}
}
