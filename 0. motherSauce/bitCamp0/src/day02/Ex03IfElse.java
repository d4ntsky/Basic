package day02;
//만약에 조건식을 만족하지 않는
//모든 경우에 대해 실행할 코드가 있을 경우
//if-else 구조로 만들어서 처리하면 된다.

public class Ex03IfElse {
	public static void main(String[] args) {
			int age = 15;
			if(age >= 18) {
				System.out.println("성인입니다.");
			}else {
				System.out.println("미성년자입니다.");
		}
	}
}
