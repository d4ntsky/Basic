package day03;
// 콘솔에 출력하는 3가지 방법
public class Ex15Printf {
	public static void main(String[] args) {
		//우리가 콘솔에 무언가를 출력할때 지금까지는
		//System.out.println(""); 을 썼다.
		//하지만 자바에서는 기본적으로 3가지 방법을 제공하고있다.
		
		//1. print()
		//print는 괄호안의 내용을 출력한다.
		//하지만 커서의 위치이동이라든지는 없다.
		System.out.print("abc");
		System.out.print("123");
		//줄바꿈이 되지 않는다. 
		
		//2. println()
		//println은 괄호 안의 내용을 출력하고
		//다음 출력 위치를 다음 줄로 바꿔준다.
		//ln은 라인에 약자?
		System.out.println("abc");
		System.out.println("123");
		
		//3. printf()
		//괄호 안의 내용을 출력하되 특정 문자에 맞추어 형식을 만들어 줄 수 있다.
		//단 다음 출력 위치는 이동되지 않는다.
		System.out.printf("abc");
		System.out.printf("123");
		
		//printf의 가장 큰 특징은
		//우리가 % 문자를 사용하여
		//필요한 변수나 값을 할당하여 형식에 맞출수 있다는 것이다.
		System.out.printf("\n %s학생의 성적\n 국어: %03d점 영어: %03d점 수학: %03d점 평균: %.2f점","조재영", 80, 81, 81, (80+81+81)/3.0);
		System.out.println();//그냥 줄바꿔서 결과보려고
		// 공백 문자의 종류를 알아보자
		// \n : 줄바꿈
		// \t ; 텝공백 
	
		// printf에서 쓰이는 %문자의 종류를 아아보자
		// 1. 10진법 숫자
		// 1-A. 10진법 숫자를 그대로 출력해라
		System.out.printf("1-A. %d\n", 150);
		// 1-B. 10진법 숫자를 6자리 오른쪽 정렬해라. 단, 6자리가 넘으면 무시해라.
		System.out.printf("1-B. %6d\n", 1234);
		System.out.printf("1-B. %6d\n", 12345678);
		// 1-C. 10진법 숫자를 6자리 왼   쪽 정렬해라. 단, 6자리가 넘으면 무시해라.
		System.out.printf("1-C. %-6d!%-6d!\n", 1234, 12345678);
		// 1-D. 10진법 숫자를 6자리 오른쪽 정렬하고 왼  쪽 빈자리는 0으로 채워라.
		System.out.printf("1-D. %06d\n", 1234);
		
		// 2. 16진법 숫자
		//cf)16진법 1~9 10a~15f 쓰임새는 메모리주소나 색깔코드
		//   ex)색깔코드RGB #000000흰색 #FFFFFF검은색 #FF0000빨간색
		// 2-A. 16진법 숫자를 그대로 출력하고 알파벳이 있으면 소문자로 출력해라.
		System.out.printf("2-A. %x\n", 242);
		// 2-B. 16진법 숫자를 그대로 출력하고 알파벳이 있으면 대문자로 출력해라.
		System.out.printf("2-B. %X\n", 242);
		// 2-C. 16진법 숫자를 6자리 오른쪽 정렬해서 출력하되
		//      알파벳이 있으면 소문자로 출력해라.
		System.out.printf("2-C. %6x\n", 242);
		// 2-D. 16진법 숫자를 6자리 왼  쪽 정렬해서 출력하되
		//      알파벳이 있으면 소문자로 출력해라.
		System.out.printf("2-D. %-6x!\n", 242);
		// 2-E. 16진법 숫자를 6자리 오른쪽 정렬해서 출력하되
		//      왼  쪽 빈자리는 0으로 채워라
		System.out.printf("2-E. %06x\n", 242);
		
		// 3. 실수
		// 3-A. 실수를 그대로 출력해라.
		System.out.printf("3-A. %f\n", 3.141592);
		// 3-B. 실수를 소숫점 3번째 자리까지 출력해라. 
		System.out.printf("3-B. %.3f\n", 3.141592);    //(반올림까지 된 상태)
		// 3-C. 실수를 소숫점 3번째 자리까지 출력하고 총 8자리 출력해라.
		System.out.printf("3-C. %8.3f\n", 123.456789);  //(점도 자리에 포함된 상태/소숫점 3자리까지 부탁한 상태)
		// 3-D. 과학표기법으로 표시해라.
		System.out.printf("3-D. %.2e\n", 123.45678); //(+02는 제곱? 확인필)
		
		// 4. 스트링
		// 4-A. 스트링을 그대로 출력해라
		System.out.printf("4-A. %s\n", "abcDEF");
		// 4-B. 스트링을 모두 대문자로 출력해라
		System.out.printf("4-B. %S\n", "abcDEF");   //(%s가 위에 것과 비교)
		
		
	}
}
