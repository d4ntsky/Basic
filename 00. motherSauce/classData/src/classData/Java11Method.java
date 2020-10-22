package classData;

public class Java11Method {
	public static void main(String[] args) {
		
		int english = 78;
		int math = 90;
		System.out.print("영어 시험 결과는 ");
			if(english > 80) {
				System.out.println("합격입니다.");
			}else {
				System.out.println("불합격입니다.");
			}
		System.out.print("수학 시험 결과는 ");
			if(math > 80) {
				System.out.println("합격입니다.");
			}else {
				System.out.println("불합격입니다.");
			}
		/*	메소드
		if문이 두번 사용되고 있지만 조건식에서 사용되는 변수를 제외하고는 동일
		만약 2개의 if문이 있다면 배열과 루프를 사용하여 다음과 같이 기입 가능하다.
		*/
			int count[] = {78,90};
			String title[] = {"영어","수학"};
			for (int i = 0; i < 2; i++) {
				System.out.print(title[i] + " 시험 결과는 ");
				if(count[i] > 80) {
					System.out.println("합격입니다.");
				}else {
					System.out.println("불합격입니다.");
				}
			}
		/*
		단, 같은 처리를 할 여러 문장이 프로그램에서 여러 곳에 기술된 경우는
		사용할 수 없다. 이런 때에 메소드를 사용하면 편리하다.
		*/
//		int eng = 78;
//		int mat = 90;
//			check("영어",eng);
//			check("수학",mat);
//	}
//	private static void check(String title, int count) {
//		System.out.print(title + " 시험 결과는 ");
//			if(count > 80) {
//			System.out.println("합격입니다.");
//			}else {
//			System.out.println("불합격입니다.");
//			}
//		
		/*
		check라는 메소드를 하나 준비했었다. 이 메소드는 if문을 사용한
		화면 출력 처리가 기입되어 있습니다. 프로그램 본체에서 필요할 때,
		이 메소드를 호출하면 메소드에 기술된 일련의 작업을 수행할 수 있다.
		이처럼 메소드를 사용하여 여러번 실행되는 일련의 처리를 한 곳에 모아둬
		필요에 따라 호출하여 실행 가능하다.
		*/
			
		/*	메소드의 정의
		메소드는 인스턴스 메소드와 클래스 메소드라는 것이 있다.
		여기에서는 클래스 메소드의 이용 방법을 말하자면
		모든 서식 동일하며, 형식은
		   접근자 [반환 데이터 형식] 메소드이름(인수1,인수2,...){
		}
		예외를 사용하는 경우에는 다른 형식이 되지만 예외는 따로 설명한다.
		접근자는 메소드만이 아니라 필드와 클래스에 지정하는 것으로 그 메소드가
		어디에서 접근이 가능한지를 나타내는 액세스 접근자라고 하며, 다른 접근자도
		존재한다.
		여기선 private stataic을 설정하였다.	
		 반환값의 데이터형은 메소드가 호출되었을 때, 값을 하나만 리턴할 수 있다.
		그 반환 값의 데이터 형식을 지정한다. 아무 것도 값을 반환하지 않으면
		void 형을 지정한다. 메소드명은 변수이름과 같은 식별자를 사용한다.
		 메소드 호출자가 메소드에 값을 전달하려면 인수를 사용한다. 반환 값은 
		하나뿐이였지만, 인수는 복수로 지정할 수 있다. 이 경우 쉼표(,)로 구분
		인수가 필요없는 경우는 아무것은 기입할 필요는 없습니다.
		 이상을 근거로 메소드의 형식은 보통
		private static void test () {
			메소드 내에서 실행하는 처리
		}
		메소드가 호출되었을때, 수행할 작업은 {}에 작성
		    메소드 호출 형식
		변수 = 메소드이름 (값, 값2,...);
		정의되는 메소드이름을 지정하여 호출한다. 메소드에 값을 전달한 경우에
		괄호 안에 쉼표(,)로 구분하여 기입한다. 값을 전달할 필요가 없는 경우는
		괄호 안을 비워도 괜찮다.(괄호는 항시 필요)
		메소드에서 반환값이 설정되어있는 경우, 호출 자체가 반환하므로 변수 등에
		대해서 할당할 수 있다.
		   메소드의 기입 위치
		메소드는 클래스 안에 기술한다. 프로그램이 실행될 때 호출되는 
		첫번째 메소드인 main메소드가 클래스에 이미 기술되어있지만, 새롭게 
		정의하는 메소드도 클래스{}안에서 작성한다. 이 때 메소드의 기입 순서는
		중요하지 않다. 
		*/	
			
		/*	인수를 사용하여 메소드에 값을 전달
		  인수가 있는 메소드 호출 방법
		  인수가 있는 메소드의 기본 형식은
		  public static void main(String[] arg) {
		  	메소드 이름 (값1,값2....);
		  	}
		  	수식 반환 형식 메소드이름(데이터형 변수명1,...) {
		  		메소드 내에서 실행하는 처리
			}
		메소드를 호출할 때 메소드에서 전달하려는 값을 괄호 사이에 작성합니다.
		여러 값을 전달하려면 쉼표(,)로 구분해서 작성합니다.
		메소드 측에서 전달되어 온 값을 저장하는 변수를 메소드이름 뒤에 괄호 안에
		기술합니다. 이 변수를 인수라고 합니다
		인수 전달되어 오는 값의 수만큼 작성해야 전달할 수 있는 값과 같은 데이터형이
		선언되어 있어야합니다.
		public static void main(String[] args) {
		test (16, 'A', 7);
		test (9, 'd', 24);
		}
		private static void test (int n1, char a, int n2) {
			System.out.println("n1 = "+n1);
		}
		메소드를 호출할 때 3개의 값을 지정합니다.
		메소드 측면에서 3개의 값이 전달되어지기 때문에 인수도 3개를 기입합니다.
		메소드부터 전달되어 오는 값은 작성된 순서대로 인수에 대입된다.
		*/
		
		/*	인수 배열이나 클래스 객체를 전달
		메스드에 전달된 값이 기본 유형인 경우에는 값이 복사되어 값 자체가 인수에
		대입된다. 기본 데이터형의 값을 다른 변수에 할당하는 경우와 동일하다.
		  public static void main (String[] args) {
		  	test(10);
		  }
		  private static void test(int num) {
		  	System.out.println(num);
		  }
		데이터형뿐만 아니라 클래스에서 만든 객체나 배열도 메소드에 전달할 수 있다.
		    public static void main (String[] args) {
		  	int num[] = {10, 4};
		  	test(num);
		  }
		  private static void test(int num[]) {
		  	System.out.println(num[0]);
		  	System.out.println(num[1]);
		  }
		메소드에서 배열의 요소에 저장되어 있는 값을 변경하면, 메소드 호출 측의
		배열과 같은 요소에 저장되어있는 값이 변경된다.
		 public static void main (String[] args) {
		  	int num = 8;
		  	int array[] = {10,4};
		  	System.out.println(num);
		  	System.out.println(array[0]);
		  	
		  	test(num,array);
		  	System.out.println(num);
		  	System.out.println(array[0]);
	 	}	
		private static void test(int num, int array[]) {
		  	int num = 5;
		  	int array[0] = 12;
		위의 경우 기본 데이터형의 변수인 num은 값이 복사되서 인수에 대입되는 
		것으로 메소드 쪽에서 변수의 값을 변경해도 호출자의 변수 값에는 아무런 
		영향이 없다.
		이에 대해 배열 변수 array는 배열 위치가 인수에 대입되므로
		메스드 측에서 배열 요소의 값을 변경하면 호출자의 배열요소의 값도 변경된다.
		   String클래스의 객체의 경우
		문자열 인수로 전달하는 경우, 문자열은 String클래스의 객체이므로 배열처럼
		객체의 위치만 전달되지만 기본 데이터형과 같이 처리할 수 있습니다.
		 public static void main (String[] args) {
		  	String str = "abc";
		  	test(str);
		}	
		private static void test(String str) {
		 	str = "def";
		}
		String클래스의 객체를 메소드에 넘겨준 경우,
		메소드측의 인수는 같은 오브젝트의 위치가 전달되는 배열과 동일하지만
		문자열 변수에 새로운 문자열을 대입하면,
		전혀 다른 우치에 객체가 새롭게 만들어 그 새 위치의 위치가 메소드의 변수에
		할당됩니다.
		때문에 원래 위치에 원래의 문자열이 포함된 상태이므로 메소드 호출 문자열엔
		아무런 영향을 주지 않습니다.
		*/	
			
		/*	메소드에서 값을 리턴
		메소드를 호출할 때 인수를 사용하여 호출에서 메소드에 값을 전달할 수 
		있었습니다만, 이번엔 메소드의 처리가 종료 메소드 호출로 처리가 되돌아올때,
		호출한 곳에 어떤 값을 반환하는 방법을 확인합니다.
		메소드호출에 반환값을 리턴값이라고 합니다.
		반환값이 있는 경우 형식은 다음과 같다.
		public static void main (String[] args) {
			반환 값의 데이터형 변수 = 메소드명();
		}
		수식반환 값의 데이터형식 메소드이름() {
			메소드 내에서 실행하는 처림
			return 반환값;
		}
		반환값으로 메소드를 호출한 곳에 값을 돌려주는 경우, 우선 메소드를 정의시
		메소드이름 앞에 반환값의 데이터형식을 설명합니다.
		에를 들어 int 등 기본 데이터형과 String등의 클래스명을 기술한다.
		반환값이 없는 경우는 데이터형식은 void로 작성합니다.
		반환 값이 int형의 경우:
		private static int test() {
			메소드 내에서 실행하는 처리
		}
		반환값을 돌려주지 않는 경우:
		private static void test() {
			메소드 내에서 실행하는 처리
		}	
		*/
			
		/*	메소드에서 값을 리턴
		return문의 형식
		return;
		return 연산식;
		return문이 실행된 시점에서 메소드를 종료 호출한 곳으로 값이 리턴된다.
		return문은 메소드의 임의의 위치에 쓸 수 있지만 return문이 실행되면,
		이후 메소드에 가입되어진 처리는 실행되지 않는다.
		 그리고 반환값으로 메소드를 호출한 곳에 값을 반환하는 경우에는 return
		문장 뒤에 식으로 반환값을 기입한다.
		식은 단순히 값이나 변수를 기술한 경우에는 그 값을 계산식 등으로 기술한
		경우엔 그 식 결과가 반환값으로 호출한 곳으로 리턴된다. 
		return 10; / 반환 값은 10 /
		return 4*5 / 반환 값은 20 /
		반환 값으로 return문 다음에 지정된 값의 데이터형은 메소드 이름 앞에
		기술한 데이터형식이어야 한다.
		또한 return문으로 값은 하나뿐이므로 반환값으로 호출한 곳에 반환할 수 
		있는 값도 하나뿐이다.
		    리턴된 값의 처리
		반환값으로 값이 호출된 곳에 반환되면 메소드를 호출한 문장에서 반환값을
		넘겨받습니다. 따라서 출력하거나 변수에 할당할 수 있다.
		public static void main(String[] args) {
			반환 값을 직접 출력한 경우
			System.out.println(test());
			반환 값을 변수에 할당한 경우
			int num = test();
		}
		private static int test() {
			return10;
		}
		메소드 반환값의 데이터형식으로 void 이외를 지정하고 있음에도 불구하고
		return문을 사용하여 값을 반환하지 않으면 컴파일 에러가 된다.
		*/
			
		/*	반환 값으로 배열을 반환	
		반환값은 기본 데이터형의 값뿐만 아니라 클래스객체나 배열을 반환할 수 있다.
		반환값에 사용할 수 있는 값은 하나뿐이지만 반환에 여러 요소를 가진 배열을
		지정하면 결과적으로 여러값을 호출한 곳에 반환 가능하다.
		public static void main(String[] args) {
			int data[];
			data = test();
			System.out.println(data[0]);
			System.out.println(data[1]);
		}
		private static int[] test() {
			int data[] = new int[2];
			data[0] = 10;
			data[1] = 19;
			return data;
		}
		   이 예에서 메소드에서 새배열을 만들고 배열 요소에 값을 할당하고 반환값으로
		호출한 곳으로 반환한다. 반환값으로 지정한 변수는 배열위치의 위치가 저장되어
		있다. 호출한 곳으로 배열위치가 리턴되기 때문에 이를 대입한 배열은 메소드에
		정의된 배열과 같은 위치를 호출한 곳에서도 배열요소를 검색할 수 있다.
		  java배열에서 각 요소는 같은 데이터형의 값밖에 저장할 수 없지만, 여러 값을
		여러 요소에 포함된 배열을 반환값으로 호출한 곳에 반환하여 여러값을 반환할 수
		있다.
		*/	
			
		/*	return문	
		   메소드에서 호출한 곳으로 값을 반환하는 경우엔 return문을 사용하여 반환값을
		지정하지만, return문은 값을 반환하기 위해서만 사용하는 것은 아니다.
		return문이 메소드에서 실행되면 그 이후의 처리를 실행하지 않고 호출한 곳으로
		처리가 이동할 수 있다.
		public static void main(String[] args) {
			int data[];
			test (15, 4);
			test ( 7, 0);
		}
		private static void test(int n1, int n2) {
			if(n2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				return;
			}
			System.out.println(n1+" / "+n2+" = " + (n1/n2));
			return;
		}
		  이 메소드에서는 두 곳에서 return문을 사용하고 있습니다.
		첫번째는 if문에서 사용되고 있고, 인수로 전달되어 온 두번째 값이 만약 0인 경,
		메세지를 화면에 표시한 후, return문으로 메소드를 종료 호출 처치를 리턴한다.
		두번째는 메소드의 마지막에서 사용되고있으며, 처리가 모두 끝나면 return문으로
		메소드를 종료하고 처리를 리턴한다.
		  이와 같인 return문을 사용하여 메소드 안에서 처리의 흐름을 임의의 위치에서
		종료하고 처리를 반환할 수 있습니다.
		또한 메소드는 블록의 마지막 문장이 실행 "}"에 도달하면 메소드의 호출 처리가
		리턴된다.
		때문에 반환값이 없는 경우엔 메소드의 마지막 return문은 일반적으로 기술할
		필요는 없다. 반환값으로 반환값을 지정하는 경우에만 사용한다.
		*/
		
		/*	메소드의 오버로드
		  메소드를 인수로 호출할 때, 인수 값의 데이터형은 메소드에서 정해서 지정할 수
		밖에 없다. 때문에, 유사한 기능을 가지는 메소드도 인수의 데이터형식이 다르면
		별도의 메소드를 제공해야한다.
		public static void main(String[] args) {
			int n = plusInt (10, 7);
			System.out.println(n);
			double d = plusDouble (3.14, 7.4);
			System.out.println(d);
		}
		private static int plusInt(int n1, int n2) {
			return n1 + n2;
		}
		private static double plusDouble (double d1, double d2) {
			return d1 + d2;
		}
		  이 예에서는 int형의 값을 가산하는 메소드와 double값을 가산하는 메소드를 두개
		준비하고 있다. 이 것은 실수가 아니다.
		단, 유사한 기능을 가지는 메소드면 인수의 데이터형이 다른 경우에도 같은 메소드 이름을
		사용하여 호출할 때 유용하다. 그래서 Java에서는 메소드의 오버로드하는 구조를 이용
		한다. Java에서는 인수의 데이터형과 인수의 수가 일치하지 않으면 같은 메소드
		이름으로 사용할 수 있다.
		public static void main(String[] args) {
			int n = plus(10,7);
			System.out.println(n);
			double d = plus(3.14,7.4);
			System.out.println(d);
		}
		private static int plus(int n1, int n2) {
			return n1 + n2;
		}
		private static double plust(double d1, double d2) {
			return d1 + d2;
		}	
		plus 메소드는 같은 클래스에 두 번 정의되어 있지만 인수의 수는 같아도
		인수의 데이터형식이 다르기때문에 구별할 수 있습니다.
		메소드를 호출측에서 plus메소드를 호출할 때, 지정한 인수의 데이터형식에
		따라 어느 메소드가 호출되는지가 정해지게 된다.
		메소드이름으로 명확하게 구분하는 것이 유용할 수도 있지만, 메소드 이름을
		같게 해두면 인수의 데이터형식을 의식하지않고 사용할 수 있다.
		  예를 들어 샘플에서도 자주 이용하는 "System.out.println(인수);"는
		인수에 정수를 넣어도 문자열을 넣어도 마찬가지로 화면에 출력되는 것은 이
		오버로드 구조를 갖고있기 때문입니다.
			오버로드가 가능한 경우
		같은 메소드이름으로 복수의 메소드를 정의하려면, 인수의 수가 다른가?
		인수의 데이터형이 다르게 해야한다.
		  	+ 인수의 수가 다른 경우
		private static void test (int n1) {//...}
		private static void test (int n1, int n2) {//...}
		  	+ 인수의 종류가 다른 경우
		private static void test (int n1) {//...}
		private static void test (double d1 ) {//...}
		  	+ 인수의 데이터형과 수는 같아도 순서가 다른 경우
		private static void test (int n1, double d1) {//...}
		private static void test (double d1, int n1) {//...}
			오버로드 할 수 없는 경우
			- 인수의 변수이름만 다른 경우
		private static void test (int a) {//...}
		private static void test (int b) {//...}
			- 반환값만 다른 경우
		private static void test (int n) {//...}
		private static int test (int n) {// return n;}
		  이와 같이 변수이름만 다른 경우나 반환 값만 다른 메소드를 기술한 경우
		컴파일 에러가 발생 "(메소드이름)은 (클래스명)으로 정의되어있습니다."와
		같은 오류 메세지가 표시된다.
		*/
			
		/*	가변 인수
		  Java에서는 J2SE5.0 버전 이후로 새롭게 가변인자를 가지는 메소드를
		정의 할 수 있게 됐다. 형식은 다음과 같다.
		public static void main(String[] args) {
			메소드이름(값1);
			메소드이름(값1,값2);
			메소드이름(값1,값2,갑3);
		{
		수식반환형식 메소드이름(데이터형...변수명) {
			메소드 내에서 실행하는 처리
		}
		   메소드 정의의 인수를 작성할 곳에 적혀있는 "..."는 생략을 의미하는 것이
		아니라 도트'.'를 3개를 차례로 작성한다. 이 메소드의 경우, 메소드를 호출할
		때, 인수를 임의의 수만큼 기입할 수 있다. 메소드에서 인수 부분에 기술한 변수
		이름을 가진 배열을 넘겨받은 것처럼 처리된다.
		예를 들면,
		public static void main(String[] args) {
			disp(10,7,8);
		}
		private static void disp(int...num) {
			for(int i = 0; i<num.length; i++) {
				System.out.println(num[i]);
			}
		}
		   메소드를 호출할 때 3개의 인수를 지정하고 있다. 메소드 쪽에선 배열 요소에
		순서대로 인수를 포함한 것처럼 받아들이기 때문에 메소드 내에서 요소를 참조하여
		인수를 사용할 수 있게 된다.
		이것은 다음과 같이 기술했을 경우와 거의 동일하다.
		public static void main(String[] args) {
			int num[] = {10,7,8};
			disp(num);
		}
		private static void disp(int num[]) {
			for(int i = 0; i<num.length; i++) {
				System.out.println(num[i]);
			}
		}
		인수의 수는 선택사항이지만 인수의 데이터형식(자료형)은 동일해야 한다. 또한
		인수는 몇 개 전달되는 지는 메소드를 호출하기 전까지 모르기 때문에 인수의 개수를
		알기위해선 배열변수명.length를 사용해서 배열의 길이를 취득해야한다.
		또한 가변 인수의 경우, 인수는 0이여도 상관없다.	
		*/
			
		/*	고정인수와 가변인수의 조합
		   가변 인수를 사용하여 메소드를 정의한 경우, 일반적 인수 (가변인수에 고정인수
		라고 부르기도 한다)와 결합이 가능하다.
		public static void main(String[] args) {
			disp("[","]",10,7,8);
		}
		private static void disp(String sb, String sa, int ...num) {
			for(int i = 0; i < nums.length; i++) {
				System.out.println(sb+num[i]+sa);
			}
		}
		이 예에서는 String클래스의 인수 두 개와 int형의 가변인수를 조합하고 있습니다.
		고정인수와 가변인수를 조합하는 경우, 주의 사항은 반드시 고정인수부터 기술해야한다.
		가변인수는 하나의 메소드에서 하나밖에 기입하지 못하고, 그리고 마지막 부분에 기입
		해야한다.
		*/	
			
	}
}