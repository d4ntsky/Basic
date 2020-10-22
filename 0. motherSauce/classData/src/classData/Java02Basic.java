package classData;

public class Java02Basic {

	public static void main(String[] args) {
		System.out.println("안녕하세요");
		/*
		 * 클래스의 형식 class 클래스이름 { }
		 * 
		 * 예를 들어 사칙연산을 실시 하는 경우 계산기를 정의 하는 것부터 시작된다
		 */
		class Calc {
			int result;

			void plus(int val1, int val2) {
				result = val1 + val2;
			}
		}
		/*
		 * 클래스 내용의 상세한 설명은 중간 계산 결과를 저장하는 result 필드와 덧셈 수행할 + method를 클래스에 정의했다.
		 * 
		 * 예를 들어 계산기를 작성하는 것을 생각 계산기에 필요한 것은 사칙연산 등의 데이터를 처리하는 기능 계산 대상 및 계산 결과 등의 데이터로
		 * 나눌 수 있다 자바에서는 기능을 method라고 하면 data를 필드라 한다. 클래스는 그 클래스의 기능과 데이터를 나열하고 있다.
		 *
		 * class 클래스 이름 { 
		 * 필드1
		 * 필드2
		 * :
		 * 방법1
		 * 방법2
		 * :
		 * }
		 * 
		 * 예를 들어 텔레비전 클래스를 만들었다고 하면
		 * 이 클래스에서 생성하는 것은 텔레비전
		 * tv에 tv를 켜는 기능과 채널을 바꾸는 기능이 있고
		 * 현재의 채널이라는 데이터가 있다. 그리고 텔레비전에 "tv를 켜다"
		 * 라는 메소드를 호출 할 것이다.
		 * 
		 * 메소드 및 필드
		 * 메소드의 형식
		 * 반환 데이터 형식 메소드이름 (인수1, 인수2, ...){
		 * }
		 * 메서드는 호출할 때 단순히 호출만 아니라 값도 지정 가능함
		 * 예를 들어 "채널을 바꿔라"라는 메소드를 호출할 수 있지만
		 * "채널을 '1'로 바꿔라"라고 뭔가 값을 지정하여 호출하는 경우도 있습니다.
		 * 또한 "현재의 채널을 알려줘라"라는 메소드를 호출하면 텔레비전이 가지고있는
		 * 데이터를 참조 호출자에게 값을 반환할 것입니다.
		 * 
		 * void 메소드명 (){
		 * }
		 * 인수도 반환 값도 없는 경우이다.
		 * 클래스의 경우"{"부터 "}"사이에 메소드와 필드를 설명했지만,
		 * 메소드의 경우도 "{"부터 "}" 사이에 메소드가 수행할 작업을 작성합니다.
		 * 
		 * 인사만 하는 간단한 클래스
		 */
		class Robot{
			void hello () {
				System.out.println("안녕하세요");
			}
			void bye () {
				System.out.println("안녕히 가세요");
			}
		}
		/* 
		 * Robot 클래스에서 hello 메소드와 bye 방법을 준비
		 * 이렇게 필요한 기능을 메소드를 추가하는 것으로 그 클래스에서
		 * 여러가지 기능이 추가됩니다.
		 * 
		 * 필드
		 * 필드의 형식
		 * 한정자 데이터 형 변수 이름;
		 * 변수란 값을 임시로 보관하는 장소로 값의 데이터 형식과 이름을 지정
		 * 데이터 유형과 값 형식의 것으로 예를 들어, 숫자든지 문자열 등이 있다.
		 * 이름은 저장 위치를 식별하기 위해 붙여진 이름이다.
		 */
		int old;
		String name;
		/*
		 * 정수 처리 old라는 변수와
		 * 문자열을 다루는 name이라는 변수를 선언
		 * 수치를 계산하는 클래스를 만들자면
		 */
		class Counter{
			int num;
			void init() {
				num=0;
			}
		void count() {
			num = num +1;
		}
		void printNum() {
			System.out.println(num);
		}
	}
		/*counter 클래스에서 하나의 필드와 3가지 메소드를 준비
		 * init 메소드를 호출하면, num 변수에 0을 저장하고
		 * count 메소드를 호출하면, num 변수에 저장되는 값에
		 * 1을 더하고 다시 num 변수에 저장합니다
		 * 그리고 printNum 메소드를 호출하면, num 변수에
		 * 저장되는 값을 출력한다.
		 * 
		 * 제일 먼저 호출되는 클래스의 메소드
		 * 자바의 흐름
		 * class 클래스이름{
		 * 	public static void main(String args[]){
		 * 		System.out.println("안녕하세요");
		 * 	}
		 * }
		 * 예를 들자면
		 * "클래스이름.java"가 파일 이름이다
		 * 컴파일을 할때, 실행 파일은 "클래스이름.class"가 생성됩니다.
		 * 프로그램 실행시 "java 실행파일"로 실행했습니다.
		 * 이 파일 이름은 "클래스이름.class"에서 ".class"를 제외한 
		 * 클래스 이름이다.
		 * 
		 * 이처럼 'java 클래스이름'으로 실행하면 인수에 지정된 클래스에서
		 * 작성된 main 메소드가 호출되도록 되어있다.
		 * public static void main(String args[])의 메소드이다.
		 * 
		 * main 메스드의 형식
		 * public static void main(String args []){
		 * }
		 * 클래스는 설계도이며 어떤 처리하려면 클래스에서 메소드를 작성하고 호출하여
		 * 실행하는 것이 java의 처리방법이었다.
		 * 이번 경우 프로그램 시작시, 지정된 클래스 안의 메소드를 호출할 것이다.
		 * 이엇은 main 메소드가 정적 메소드라는 것 때문이다.
		 * 이 정적 메소드는 자동적으로 호출 할 수 있는 전문적 방법이다.
		 * 정적 메소드는 메소드 이름 앞에 "static"이 추가되어 있다.
		 * 
		 * main 메소드가 없는 경우
		 * 클래스이름과 파일이름이 다른 경우, 지정하는 실행파일이름이 나타내는 
		 * 클래스가 프로그램에 없기 때문에 오류가 발생한다.
		 * 기술한 클래스 이름과 파일 이름이 같아도
		 * main 메소드가 없는 경우를 살펴본다면
		 * class errtest{
		 * 	void hello() {
		 *		System.out.println("안녕하세요");
		 *	}
		 *}
		 *이 프로그램을 "errtest.java"로 저장하고 컴파일을 해보자
		 *메소드가 발견되지 않았던 경우 에러가 난다.
		 *main 메소드가 있는 경우에도 static를 잊는 경우도 같은 오류가 난다.
		 *기본 메소드를 찾을 수 없다고 뜬다.
		 *
		 *하나의 메소드에 여러 문장이 포함되어있다.
		 *java에서는 ;을 붙여 하나의 문장이 어디까지인지 명확하게 해야한다.
		 *예를 들어
		 *class sample {
		 *	public static void main(String args []) {
		 *		System.out.println("안녕하십니까");
		 *		System.out.println("안녕하세요");
		 *		System.out.println("안녕");
		 *	}
		 *}
		 * 문장의 구분은 세미콜론;까지로 되어있다
		 * 
		 * 어디서부터 어디까지가 메소드인지 쉽게 작성하도록한다.
		 * 
		 * 주석문(코멘트)
		 * "//" "*/ /*"를 사용해서 코멘트를 작성한다.
		 * 
		 * 예약어의 종류는 매우 다양하다.
		 * abstract
		 * assert
		 * boolean
		 * break
		 * byte
		 * case
		 * catch
		 * char
		 * class
		 * const
		 * continue
		 * default
		 * do
		 * double
		 * else
		 * enum
		 * extends
		 * final
		 * finally
		 * float
		 * for
		 * goto
		 * if
		 * implements
		 * import
		 * instanceof
		 * int
		 * interface
		 * long
		 * native
		 * new
		 * package
		 * private
		 * protected
		 * public
		 * return
		 * short
		 * static
		 * strictfp
		 * super
		 * switch
		 * synchronized
		 * this
		 * throw
		 * throws
		 * transient
		 * try
		 * void
		 * volatile
		 * while
		 * 
		 * 미리 준비된 정수
		 * true
		 * false
		 * null
		 */
	}
}