package classData;

public class Java05Operator {
	public static void main(String[] args) {
		/*산술 연산자
			연산자		사용예		의미
			+			a + b		덧셈
			-			a - b		뺄셈
			*			a * b		곱셉
			/			a / b		나눗셈
			%			a % b		나눈 나머지
		*/
		/*부동 소수점에 대한 연산
		double d;
		d = 10	 /	8  ;	= 	d = 1.0  
		d =	10.0 /	8  ;	=	d = 1.25
		d = 10	 /	8.0;	=	d = 1.25
		d = 10.0 /	8.0;	=	d = 1.25
		모두 정수인 경우 결과도 정수다 대신 double형 변수에 대입하고 있어 출력하면 1.0이다
		어느 하나라도 소수점 숫자인 경우, 얻을 수 있는 결과도 소수점 숫자였다 1.25.
		*/
		System.out.println(10+4);
		System.out.println(9-2);
		System.out.println(3*8);
		System.out.println(7/3);
		System.out.println(7%3);
		
		double d;
		d = 10 	 / 8    ;
		System.out.println(d);
		d = 10.0 / 8.0	;
		System.out.println(d);
		/*단항 연산자
		연산자		사용예		의미
		+			+a			a의 값을 그대로
		-			-a			a의 값의 반전
		두 연산자는 산술 연산자에서도 사용되지만 단항 연산자로 사용하는 경우
		연산자의 값의 양수와 음수를 반전시킨다
		*///ex
		int n1, n2;
		n1 = 10;
		n2 = -n1;	
		System.out.println(n2);
		n2 = +n1;
		System.out.println(n2);
		//나누기는 0으로 나눈 것이다.
//		int n;
//		n = 3/0;
//		System.out.println(n); 정수를 0으로 나누면 오류가 난다.
		//입력 받은 숫자로 나눗셈하는 프로그램이나 어떤 수치로 나누게 될지 모르는듯한 프로그램은
		//0으로 나눗셈이 되지 않게 해야한다.
		//부동소수점
		double di;
		di = 3.1 / 0;
		System.out.println(di);
		di = 3 / 0.0;
		System.out.println(di);
		di = -3.1 / 0;
		System.out.println(di);
		//infinity는 double형 무한대의 값을 문자열로 출력 시켰을 때 나타는 겂이다
		//-infinity 음의 무한대
		double de;
		de = 3.1 % 0;
		System.out.println(de);
		de = 3 % 0.0;
		System.out.println(de);
		de = -3.1 % 0;
		System.out.println(de);
		//NaN은 미리 정의 된 상수가 정상적인 수치가 아니다라는 의미
		//NaN = Not a Number 의미 비수
		
		int nb;
		nb = 10+5*4;
		System.out.println(nb);
		/*우선 순위 높은 순으로 정열된 결합 규칙
			(인수) [배열 인덱스] . a++ a--
			! ~ + - (단항 연산자) ++a --a
			new(자료형)
			*  /  %
			+ - (산술)
			<< >> >>>
			> >= < <= intanceof
			== !=
			&
			^
			|
			&&
			||
			?:
			= ope=
			cf) ope=는
	"+=" "-=" "*=""/=" "%=" "<<=" ">>=" ">>>=" "&=" "\=" "^="
		*/
		int n4, n5;
		n4 = 10 * 5 + 4;
		n5 = 4 + 10 * 5;
		System.out.println(n4);
		System.out.println(n5);
		//괄호를 사용한 우선 순위 변경
		int su;
		su = 10 + 8 / 2 * 4;
		System.out.print("10 + 8 / 2 * 4 = ");
		System.out.println(su);
		su = (10 + 8 / 2) * 4;
		System.out.print("(10 + 8 / 2) * 4 = ");
		System.out.println(su);
		su = ((10 + 8) / 2) * 4;
		System.out.print("((10 + 8) / 2) * 4 = ");
		System.out.println(su);
		/*증가/감소 연산자
		연산			사용예				의미
		++			a++ 또는	++a			a의 값을 1 증가
		--			a-- 또는	--a			a의 값을 1 감소
		*/
		int plplmimi;
		plplmimi = 10;
		System.out.println(plplmimi);
		plplmimi++;
		System.out.println(plplmimi);
		plplmimi++;
		System.out.println(plplmimi);
		plplmimi--;
		System.out.println(plplmimi);
		//전, 후배치 - 전치 후치
		int lu = 7;
		lu++;
		System.out.println(lu);
		++lu;
		System.out.println(lu);
		int x = 7;
		int y;
		y = x++;
		System.out.println(x);
		System.out.println(y);
		y = ++x;
		System.out.println(x);
		System.out.println(y);
		
		int ex;
		System.out.println("후치의 경우");
		ex = 10;
		System.out.println(ex++);
		System.out.println(ex);
	
		System.out.println("전치의 경우");
		ex = 10;
		System.out.println(++ex);
		System.out.println(ex);
		
		/*비트 연산자
		연산자 		사용예					의미
		&			a & 0xFF00FF00			a 와 0xFF00FF00 비트 AND
		|			a | 0xFF00FF00			a 와 0xFF00FF00 비트 OR
		^			a ^ 0xFF00FF00			a 와 0xFF00FF00 비트 XOR
		~			~a						a 의 비트 반전 (비트 NOT)
		<<			a << 3					a 를 왼쪽으로 3비트 쉬프트
		>>			a >> 3					a 를 오른쪽으로 3비트 쉬프트 (부호 있음)
		>>>			a >>> 3					a 를 오른쪽으로 3비트 쉬프트 (부호 없음)
		*/
		//비트 연산자
		byte b;
		b = 0x55 & 0x0F;
		System.out.print("0x55 & 0x0F = ");
		System.out.printf("0x%02x \n",b);
		b = 0x55 | 0x0F;
		System.out.print("0x55 | 0x0F = ");
		System.out.printf("0x%02x \n",b);
		b = 0x55 ^ 0x0F;
		System.out.print("0x55 ^ 0x0F = ");
		System.out.printf("0x%02x \n",b);
		b = ~0x55;
		System.out.print("~0x55 = ");
		System.out.printf("0x%02x \n",b);
		
		byte by;
		by = 8 << 3;
		System.out.print("8 << 3 = ");
		System.out.println(by);
		by = -10 << 2;
		System.out.print("-10 << 2 = ");
		System.out.println(by);
		by = 8 >> 1;
		System.out.print("8 >> 1 = ");
		System.out.println(by);
		by = -20 >> 2;
		System.out.print("-20 >> 2 = ");
		System.out.println(by);
		//왼쪽으로 한 번 쉬프트하면 수치가 2배가 되며
		//오른쪽으로 한 번 쉬프트하면 1/2로 되어있다.
		
		/*대입 연산자
		연산자			사용예				의미
		+=				a += b			a = a + b 와 동일
		-=				a -= b			a = a - b 와 동일
		*=				a /= b			a = a * b 와 동일
		/=				a /= b			a = a / b 와 동일
		%=				a %= b			a = a % b 와 동일
		&=				a &= b			a = a & b 와 동일
		|=				a |= b			a = a | b 와 동일
		^=				a ^= b			a = a ^ b 와 동일
		<<=				a <<= b			a = a << b 와 동일
		>>=				a >>= b			a = a >> b 와 동일
		>>>=			a >>>= b		a = a >>> b 와 동일
		*/
		
		/*논리 연산자
		연산자			사용예					의미
		&&				a && b				a와 b가 모두 true일 때 true
		||				a || b				a또는b의 적어도 하나가 true인 경우 true
		!				  !a				a가 true의 경우에 false 
											a가 false인 경우에 true
		*/
		int var = 30;
		System.out.println("var = " + var);
		
		System.out.print("var > 5 && var < 20 -> ");
		System.out.println(var > 5 && var < 2);
		
		System.out.print("var > 20 || var < 10 -> ");
		System.out.println(var > 20 || var < 10);
		
		System.out.print("!(var < 20) -> ");
		System.out.println(!(var < 20));
		
		/*조건 연산자 (삼항 연산자)
		 조건식?식1:식2
		 true인 경우 식1
		 false인 경우 식2 로 처리한다.
		 */
		char ca;
		int in;
		
		in = 20;
		ca = in >= 0? 'Y':'N';
		System.out.print(in +"은 ");
		System.out.println(ca);
		
		in = -4;
		ca = in >= 0? 'Y':'N';
		System.out.print(in +"은 ");
		System.out.println(ca);
	
		/*문자열 연결
		 + 연산자는 산술 연산자의 가산의 및 단항 연산자로도 사용하고 있지만
		 문자열에 사용하면 문자열과 문자열을 연결하는 연산자다.
		 문자열1 + 문자열2
		*/
		System.out.println( 200 + 9 );
		System.out.println( "200" + 9 );
		System.out.println( 200 + "9" );
		System.out.println( "200" + "9" );
		System.out.println( 100 + 80 + "$" );
		System.out.println( "$" + 100 + 80 );
		System.out.println( "$" + (100 + 80) );

	}	

	
}