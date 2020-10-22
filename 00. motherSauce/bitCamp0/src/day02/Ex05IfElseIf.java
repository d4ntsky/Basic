package day02;
//만약 한 개의 조건식이 false가 나오면
//다른 조건식으로 다시 테스트
//다시 테스트...... 해하하는 경우
//if-else if-else if....-else 구조가 나오게 된다. 
public class Ex05IfElseIf {
	public static void main(String[] args) {
		//00~05 : 유아
		//06~13 : 어린이
		//14~18 : 청소년
		//19~   : 성인
		int age = 13;
		if(age >= 0 && age <= 5) {
			System.out.println("유아입니다.");
		}else if(age >= 6 && age <= 13) {
			System.out.println("어린이입니다.");
		}else if(age >= 14 && age <= 18) {
			System.out.println("청소년입니다.");
		}else {
			System.out.println("성인입니다.");
		}
	}
}
