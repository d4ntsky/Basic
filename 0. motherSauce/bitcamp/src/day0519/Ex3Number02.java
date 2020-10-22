package day0519;

public class Ex3Number02 {

	public static void main(String[] args) {
		
		int i; // 변수 선언 부분
		i = 1;
		i = 2;
		
	//변수(그릇)의 종류
		
		// 1.수치형
		
			//1)정수
			byte by; //정수 by // 1 byte == 8 bit -> 0~255 ->256개
			// 1111 1111 맨 앞은 부호비트 0->'+' 1->'-'
			by = 127; // -128~127(그릇) 그릇안에 들어감
			System.out.println(by); //127 그릇안 결과 나옴
									//128 에러 난다
			short sh; //2byte
			sh = 1234;
			System.out.println(sh); //1234       결과나옴
									//1234567  결과 안나옴
			int in;   //4byte -> 32 bit
			in = 123456789;
			//정수형에서 int가 가장 많이쓰임
			System.out.println(in);
			
			long lo;  //8byte
			lo = 3243244214144L; //여기 맨뒤에 대문자 L 주의할 것
			System.out.println(lo);
		
		//short int/long int는 
			
			//2)실수
			float f;  //4byte
			f = 123.4567f; //f를 맨뒤에 넣어야 float라고 알리는것
			System.out.println(f);
			
			double d; //8byte
			d = 234.567891234;
			System.out.println(d);
			//실무에서 double 가 더 많이 쓰인다
			
 		// 2.문자형
			char c;	  //2byte cf)c에서는 1byte // character
					  //취급 a ~ z A ~ Z ASCII cod / 두글자 이상 unicode
			c = 'A';
			c = 'a';
			c = '+';
			c = '한';
			System.out.println(c);
			// c = 'ab';  는 에러남
			// 문자열(String)
				// String(class)
				// Array(배열)
			String str;
			str = "Hello";
			System.out.println(str);
			
			str = "World";
			System.out.println(str);
			
			System.out.println("abc" + 1 + 2);
			System.out.println(1 + "abc" + 2);
			System.out.println(1 + 2 + "abc");
		
			//cf) linux > unix > c > java
		// 3.판정형(참/거짓) BOOL bool
			boolean b; //1byte (true(1)/false(0))
			b = true;
			System.out.println(b);
			b = false;
			System.out.println(b); 
			
			
			
		//escape sequence
			// \n == 개행
			
			// \b == backspace
			System.out.println("Hello\bWorld"); 
			// \t == 띄어쓰기
			
			// \' == '표현
			System.out.println("\'얍\'"); 
			// \" == "표현
			System.out.println("\"안녕하세요\""); 
			// \\ == \표현
			System.out.println("\\반갑습니다\\");
			
			
			
	//cf
	System.out.println(Math.sqrt(16));		//-> 루트 씌우는		4
	System.out.println(Math.pow(16, 2));	//-> (값, 승)	16의 2승
		
	}

}