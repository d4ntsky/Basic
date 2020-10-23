package day01;
// 논리연산자
// 논리연산자는 특이하게도
// boolean에 대한 연산을 한다.
// && || !
// && = shift+7 
//     2개의 boolean 값이 모두 true일 때만 true
// || = shift+원화
//     2개중 1개 이상이 true면 true
// ! = shift+1
//     true는 false로 false는 true로
// cf) 우리가 쓰는 키보드는 한글 자판 배열이라 원화 표시
//     일본           키보드는                            엔화
//     영어           키보드는                            shift+백슬러시
//     수업 시간에 원화표시가 아닌 백슬러시라고 명명

public class Ex05 {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = true;
		boolean b3 = false;
		boolean b4 = false;
		System.out.println(b1 && b2);
		System.out.println(b1 && b3);
		
		System.out.println(b2 || b4);
		System.out.println(b3 || b4);
		
		System.out.println(!b1);
		System.out.println(!b3);
		
		//하지만 우리가 논리연산자를 쓸 때에는
		//boolean변수에 직접 쓰지 않는다.
		
		//그렇다면 어떻게 쓸까?
		int number = -5;
		System.out.println(number >= 0 && number <=10);
		
		//비트 연산자는 생략
	}
}
	
