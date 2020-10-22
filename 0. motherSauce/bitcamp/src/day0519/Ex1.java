package day0519;

public class Ex1 {

	public static void main(String[] args) {
		//int  i;                          
		//   > 경고 (노란색 /프로그램은 됨)
		//System.ou.println("test 입니다");  
		//   > 에러 (빨간색 /수행 안됨)
		// 메뉴 > project > build automatically (기계어 검사)
				
		// test
		System.out.println("test 입니다"); 
		// hello world
		System.out.println("Hello World");
		
		// = 한줄 주석문 용도 (compile(기계어로 번역)에 되지 않음)
		// 그 문장의 설명 등을 기입할 경우
		// 프로그램 실행 시 선택 실행을 하고 싶을 경우
		// cf) 좋은 프로그래머는 주석문을 붙인다
		
		/* = 범위 주석문 (하나치고 주석문 닫기)
		 cf) HTML       <!-- -->
			 Oracle     --
			 JSP        <%-- --%>
			 JavaScript (==) -> Web
		*/
		
		/*
		   Java : class + function     
		   객체지향 (골격) -> 설계
		   C언어  : function (함수 형태)	      
		   절차지향            -> 순서
		 */
		
		/* 출력문 -> 콘솔(문자, 숫자)     AWT, swing -> Web
		   
		 	System.out.print("문자열(한문자 이상)"); 
		 	세미콜론;문장이 끝이라는 뜻
				 	
		   	printf < c언어 방식
		 */
		
		System.out.println("헬로우 Java");
		System.out.print("Hello Java");
		//개행이 되지않는 게 print
		//println 출력 뒤 개행하라 ln=line
		
		System.out.println(); // 행만 바꾼거
		
		System.out.println("문자열"); //문자열
		System.out.println('한');    //문자
		//c언어는 한글은 두개의 문자로 취급함 
		System.out.println('A');
		System.out.println('1');     //우리가 보기엔 숫자 하지만 문자
		
		System.out.println(123 + 1);	 //숫자가 문자로 변형된것
		//연산된 다음 변형된 문자
		System.out.println("123" + 1);
		//문자와 숫자의 합

		//여기서 printf의 f == format
		System.out.printf("%d", 123); 
		System.out.printf("%c",'B');     
		System.out.printf("%s", "world");
		System.out.printf("%f", 12.34);  
		
		//c언어의 주된거 printf
	//cf)
//	%d: 10진수(정수형)
//	%f: 실수형
//	%e: 지수형
//	%o: 8진수
//	%x: 16진수
//	%u: 부호없는 10진수
//	%g: 실수형 자동출력
//	%p: 포인터의 주소
//	%c: 하나의 문자로 출력
//	%s: 문자열
		
		System.out.println();
		
		System.out.printf("%d %s %c %f \n", 23, "문자열", 'C', 345.678);
		
		// escape sequence 탈출용 지리어 = 제어 시퀀스
		// \n(개행) \b(백스페이스) \t(텝)
		System.out.printf("%d\n", 123);
		System.out.printf("%c\n",'B');
		System.out.printf("%s\n", "world");
		System.out.printf("%f\n", 12.34); 
		
		System.out.printf("\t %d", 777);
		// \t는 콘솔에서 꾸미는 것으로 효용성이 낮음
		
		
	}
}