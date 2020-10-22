package classData;

import java.util.Scanner;

public class Java04Variable {

	public static void main(String[] args) {
		/*	변수는 값을 저장할 수 있는 상자 같은 개념이다.
			이 상자는 숫자나 문자열 등의 값을 저장할 수 있다.
			그리고 언제든지 꺼내거나 다른 값을 저장할 수 있다.
			
			순서대로 2배로 연산하고 차례로 결과를 표시하는 프로그램의 경우
			변수를 사용하지 않으면 매번 처음부터 2를 곱해나가야한다	
		 */
		System.out.println(1*2);
		System.out.println(1*2*2);
		System.out.println(1*2*2*2);
		System.out.println(1*2*2*2*2);
		//적은 횟수는 괜찮지만 100번 반복은 비효율적이다.
		//변수에 저장된 값을 산출해서 2를 곱해 나가는 것을 반복한다면
		int num = 1;
		num = num*2;
		System.out.println(num);
		num = num*2;
		System.out.println(num);
		num = num*2;
		System.out.println(num);
		num = num*2;
		System.out.println(num);
		//행 수가 증가된다. 쓸데 없는 계산이 되는 게 아니고 계산 결과를 이용하여 효율적 계산을 수행한다.
		
		/*변수 선언
			변수를 사용하려면 변수를 선언해줘야한다.
			형명 변수이름;
			ex) int count;  	-> 	int라는 형식의 값을 저장하는 count라는 이름의 변수
				double data;	->  double이라는 형식의 값을 저장하는 data라는 변수
			를 선언한 것이다.
			같은 데이터형은 여러 변수를 선언 할 수 있다
			형명 변수이름1, 변수이름2, 변수이름3 ...
			ex) int a;
				int b;
				int c; 는    int a,b,c; 로 표현할 수있다.
		 */
		int number;
		double data;
		int x,y,z;
		
		/* 변수 이름의 붙이는 방법 (식별자)
		 	변수는 프로그램에 여러 개 사용할 수 있다.
		 	하나 하나의 변수를 구별하는 변수는 변수이름을 지정한다.
		 	변수 이름을 지정할 때는 규칙이 있다
		 	1.	사용할 수 있는 문자는 A~Z,a~z,0~9,밑줄(_)
		 		 예) name, old, no32
		 	2.	첫문자는 숫자 0~9를 사용할 수 없다.
		 		 잘못된예) 12point 는 사용할 수 없다.
		 	3.	old와 Old 다른 변수 예약어는 사용할 수 없다.
		 		char나 class와 같은 예약어는 사용할 수 없다.
		 		대소문자는 구별된다. name과 Name은 다른 변수
		 		길이의 제한은 없다.
		*/
		int san;
		int ka;
		san = 80;
		ka = 45;
			System.out.println("수학 점수는" + san);
			System.out.println("과학 점수는" + ka);
	
			/*	기본 데이터 형식
			
			데이터형					값
			boolean					 8비트	true or false	
			char					16비트	Unicod 문자 \u0000 ~ \uffff
			정수 데이터 형식
			byte					 8비트	정수 -128   				~   	 	      127	
			short					16비트	정수 -32768 				~ 			    32767
			int						32비트	정수 -2147483648			~  		   2147483647
			long					64비트	정수 -9223372036854775808 ~ 9223372036854775807
			부동 소수점 데이터 형식
			float					32비트	부동 소수
			double					64비트	부동 소수
			
			큰 값을 저장할 수 있는 데이터 형식을 지정해두면 무엇이든 괜찮을 듯 싶지만
			큰 값을 저장할 수 있는 데이터 형은 컴퓨터 자원을 많이 필요로 한다.
			정말 필요한 데이터 형식을 사용하는 게 중요하다.			
			*/
			int n;
			long l;
			double d;
			char c;
			boolean b;
			
			n = 100;
			l = 45333336854798037L;
			d = 32.45503;
			c = '하';
			b = true;
			
			System.out.println(n);
			System.out.println(l);
			System.out.println(d);
			System.out.println(c);
			System.out.println(b);
			
			//cf)
			System.out.println(c + " " + d);
			
//되지 않는 예제
//			int n1;
//			n1 = 1.43F;
//			boolean bo;
//			bo = 0;
			
		/* 값의 대입
		 변수의 역할은 값을 저장하고 검색하는 것.
		 변수에 값을 저장하는 변수에 값을 할당한다고 한다.
		 변수 = 값;	 
		 "=" 대입 연산자
		 "=" 기준으로 오른쪽은 값 왼쪽은 변수에 할당한다.
		 */
			int numb;
			numb = 10;
			char cA;
			cA = 'A';
			System.out.println(numb);
			System.out.println(cA);
		/*
			변수 1 = 값;
			변수 2 = 값;
			변수 3 = 값;  ==  변수1 = 변수2 = 변수3 = 값;
			
			형명 변수;
			변수 = 값;
			만약 변수를 선언 시점에 대입하는 값이 정해져 있으면 	형명 변수 = 값;
			라고도 할 수 있다.
		*/
		/* 변수를 입력하기
		  키보드로 문자열을 입력하는 System.in을 받아서 처리해주는 Scanner 클래스를 생성한다
		import java.util.Scanner;
		Scanner scan = new Scanner(System.in);
		Scanner는 System.in 외에 다양한 인자를 읽어들여 파싱 및 처리를 한다. 파싱?
		String message;
		message = scan.nextLine();
		Scanner의 nextLine() 메소드는 Scan한 소스의 다음 문자열 라인을 읽어온다.
		다음 문자열 라인을 System.in을 통해 읽어 들이고 message 변수를 입력한다.
		
		int meter;
		meter = scan.nextInt();
		nextInt()는 정수 값을 받아온다.
		double liter;
		liter = scan.nextDouble();
		nextDouble()은 Double 형을 가져온다.
		 */
			String message;
			Scanner scan = new Scanner(System.in);			//문자 입력을 인자로 Scanner 생성
			System.out.println("메세지를 입력하세요");
			message = scan.nextLine();						//키보드 문자 입력
			System.out.println("입력 메시지:\""+message+"\"");	//입력 문자 출력
			
			int kilometer;
			double liter, mpg;
			System.out.println("거리(km)값 정수를 입력하세요");
			kilometer = scan.nextInt();						//키보드 숫자 정수 입력
			System.out.println("리터값을 입력해주세요");
			liter = scan.nextDouble();						//키보드 숫자 Double형 입력
			mpg = kilometer / liter;						//입력 받은 kilometer와 liter 계산
			System.out.println("Kilomete per liter : " + mpg);
			
			
			
	}
	
}
