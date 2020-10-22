package classData;

public class Java24Extend {
	public static void main(String[] args) {
	/*	클래스의 상속
	우선 클래스의 상속이란 무엇인가에 대해 살펴보겠다. 예를 들어 2개의 클래스를 
	생성하는 것을 생각해보자. 두 종류의 자동차에 대한 클래스를 구축하려고한다.
	class carA{
		public void accele() {
			...
		}
		public void brake() {
			...
		}
		public void hybrid() {
			...
		}
	}
	class carB{
		public void accele() {
			...
		}
		public void brake() {
			...
		}
		public void openRoof() {
			...
		}
	}
	carA와 carB는 각각 다른 특징이 있다. 단지 차로의 기본적인 기능은 동일하다.
	2개의 클래스를 개별적으로 설계하면 같은 기능이 있음에도 불구하고 동일한 기능 등을
	구현하지 않으면 안 부분이 있게된다. 그래서 차량으로 기본 설계 부분은 공통적으로
	다른 부분만 산출하여 설계하면 편리하다. 이러한 경우, 기본이 되는 클래스를 슈퍼
	클래스라고 한다. 예를 들어 다음과 같은 슈퍼 클래스를 생성하려 한다.
	class car{
		public void accele() {
			...
		}
		public void brake() {
			...
		}
	}
	carA와 carB가 기본 클래스를 기반으로 필요한 부분을 추가하여 클래스를 설계한다.
	class carA extends car {
		public void hybrid() {
			...
		}
	}
	class carB extends car {
		public void openRoof() {
			...
		}
	}
	위와 같이 한 경우, carA와 carB 모두 car클래스를 상속했다고 한다. 또한 car
	클래스가 슈퍼 클래스라는 것에 대해 carA와  carB는 car클래스의 서브 클래스라고
	한다.
		상속의 기술 방법
	클래스의 상속을 할 경우에는 아래와 같이 작성한다.
	class subclass_name extends superclass_name {
	}
	클래스 정의를 할 때 extends 뒤에 상속하고 싶은 슈퍼 클래스 명을 기술한다. 주의할
	점은 클래스의 상속은 한 번에 하나밖에 할 수 밖에 없는 것이다. 상속하려는 클래스가
	여러개 있었다고 해도, Java에서는 한 번에 하나의 슈퍼 클래스만 상속할 수 있다.
	*/
		
	/*	슈퍼 클래스의 멤버에 액세스	
	여기서는 슈퍼 클래스에 정의된 멤버변수와 멤버메소드에 대한 액세스에 대해 살펴보겠다.
	우선 아래와 같은 클래스를 만든다. Car클래스가 슈퍼 클래스, Sonata클래스는 Car
	클래스를 상속하고 있다.
	class Car {
		int speed = 0;
		public void accele() {
			speed += 5;
		}
		public void brake() {
			speed -= 5;
		}
	}
	class Sonata extends Car {
		boolean roofOpenFlag = false;
		public void openRoof() {
			roofOpenFlag = true;
		}
		public void closeRoof() {
			roofOpenFlag = true;
		}
	}
	다음 Sonata 클래스의 객체를 만든다.
	class ctest11 {
		public static void main (String[] args) {
			Sonata sonata = new Sonata();
		}
	}
	Sonata클래스의 객체는 Sonata클래스 이름에 정의된 메소드를 실행하거나 변수를
	참조할 수 있다.
	class ctest11 {
		public static void main(String[] args) {
			Sonata sonata = new Sonata();
			sonata.openRoof();
			if(sonata.roofOpenFlag) {
				System.out.println("지붕이 열려 있습니다");
			}
			else{
				System.out.println("지붕이 닫혀 있습니다");
			}
		}
	}
	또한 슈퍼클래스인 Car클래스의 메소드를 실행하거나 변수를 참조할 수 있다. 이렇게
	클래스를 상속한 클래스는 자신에 정의된 것 외에	??
	된 슈퍼 클래스의 메소드를 실행하고 멤버변수를 참조할 수 있습니다.
class ctest11 {
	public static void main(String[] args) {
		Sonata sonata = new Sonata();
		sonata.openRoof();
		if(sonata.roofOpenFlag) {
			System.out.println("지붕이 열려 있습니다");
		}
		else{
			System.out.println("지붕이 닫혀 있습니다");
		}
		sonata.accele();
		System.out.println("현재 속도는 " + sonata.speed + "킬로입니다");
	}
	class Car {
		int speed = 0;
		public void accele() {
			speed += 5;
		}
		public void brake() {
			speed -= 5;
		}
	}
	class Sonata extends Car {
		boolean roofOpenFlag = false;
		public void openRoof() {
			roofOpenFlag = true;
		}
		public void closeRoof() {
			roofOpenFlag = false;
		}
	}
}실행시
지붕이 열려있습니다
현재 속도는 5킬로입니다.
	슈퍼 클래스의 메소드를 실행하고 멤버 변수를 참조할 수 있다.
	*/	
		
	/*	상속자 액세스 제어
	멤버변수와 멤버메소드에 대한 액세스 제한에 관해선 public과 private에서도 샬펴
	봤듯이 public을 선택한 경우 (또는 액세스에 대한 한정자를 생략한 경우)는 클래스
	외부에서도 직접 액세스할 수 있다. 또한 private를 지정한 경우, 클래스 내에서만
	액세스할 수 있습니다. 그래서 슈퍼클래스의 멤버 변수나 메소드에 private를 선택한
	경우, 그 슈퍼 클래스를 상속받은 서브 클래스에서 호출할 수 있는지 알아보자.
	다음과 같은 간단한 예제를 만들고 하위 클래스에 정의된 public멤버와 private멤버
	에 각각 서브 클래스 내에서 액세스해보자.
	class ctest12 {
		public static void main(String[] args) {
			B sample = new B ();
		}
	}
	class A {
		public int var = 0;
		private int varErr = 0;
		public int get() {
			return var;
		}
		private int getError() {
			return var;
		}
	}
	class B extends A {
		public void getVar() {
			System.out.println("값 : " + var);
			System.out.println("값 : " + varErr);
			System.out.println("값 : " + get());
			System.out.println("값 : " + getError());
		}
	}컴파일시
	에러
	이처럼 서브클래스 내에서도 private 멤버변수와 멤버메소드는 액세스할 수 없다.
		protected
	액세스 한정자는 또 protected라는 접근자가 있다. protected가 붙은 변수,메소드
	는 동일 패키지내의 클래스 또는 해당 클래스를 상속받은 외부 패키지의 클래스에서 접근이
	가능하다. 예를 들자면
	class ctest13 {
		public static void main(String[] arg) {
			B sample = new B();
			System.out.println("서브 클래스에서 액세스");
			sample.getVar();
			System.out.println("다른 클래스에서 액세스");
			System.out.println("값 : " + sample.get());
		}
	}
	class A {
		protected int var = 0;
		protected int get() {
			return var;
		}
	}
	class B extends A {
		public void getVar() {
			System.out.println("값 : " + var);
			System.out.println("값 : " + get());
		}
	}실행시
	서브 클래스에서 액세스
	값 : 0
	값 : 0
	다른 클래스에서 액세스
	값 : 0
	슈퍼 클래스에 정의된 protected 멤버변수와 멤버메소드는 서브 클래스 내에서 액세스할
	수 있으며, 다른 클래스에서도 접근이 가능하다. 때문에 거의 public과 비슷하다.
	그러나 의미적으로는 상속된 서브 클래스 내에서 액세스되로록 하기 위한 멤버이기 때문에
	public과 protected는 명확하게 구분하여 사용한다.
	또한 패키지 개념을 사용하는 경우에는 public이라고 protected는 전혀 다른 접근을
	하게된다. public 다른 패키지에서도 액세스 가능하지만, protected는 다른 패키지서
	private에 해당된다.
	*/	
		
	/*	슈퍼 클래스의 생성자
	클래스를 생성할 때 생성자를 작성하고 생성자가 호출되지만 다른 클래스를 상속하는 경우에
	슈퍼 클래스의 생성자의 취급이 어떻게 되는 지를 확인한다.
	간단한 샘플을 만든다.
	클래스 B는 클래스 A를 상속	
	클래스 C는 클래스 B를 상속하고 있다.
	각자 생성자를 작성하고 클래스 C의 객체를 작성한다.
	class ctest14 {
		public static void main(String[] args) {
			C sample = new C();
		}
	}
	class A {
		A() {
			System.out.println("클래스 A의 생성자");
		}
	}
	class B extends A {
		B() {
			System.out.println("클래스 B의 생성자");
		}
	}
	class C extends B {
		C() {
			System.out.println("클래스 C의 생성자");
		}
	}출력시
	클래스 A의 생성자
	클래스 B의 생성자
	클래스 C의 생성자
	클래스를 상속한 경우는 별도의 기입 없이 생성자의 선두에 super()라고 한다. 때문에
	방금 전의 샘플은 다음과 같이 기술한 것과 동일하다.
	class ctest14 {
		public static void main(String[] args) {
			C sample = new C();
		}
	}
	class A {
		A() {
			super ();
			System.out.println("클래스 A의 생성자")
		}
	}
	class B extends A {
		B() {
			super ();
			System.out.println("클래스 B의 생성자");
		}
	}
	class C extends B {
		C() {
			super ();
			System.out.println("클래스 C의 생성자");
		}		
	}
	클래스 A는 명시적으로 다른 클래스를 상속하지 않지만 클래스는 기본적으로 상속받은
	java.lang.Object 서브 클래스가 있다. 따라서 모든 클래스는 java.lang.
	Object의 생성자가 반드시 호출된다.
		인수가 있는 슈퍼 클래스의 생성자
	super()가 호출되는 슈퍼 클래스의 인수 없는 생성자가 호출된다만, 슈퍼 클래스
	인수가 있는 생성자가 정의되어있는 경우에 그 생성자를 호출할 수도 있다.
	인수가 있는 슈퍼 클래스의 생성자를 호출하려면
	super(인수)
	의 형태로 호출한다.
	class ctest15 {
		public static void main(String[] args) {
			B sample = new B();
		}
	}
	class A {
		A() {
			System.out.println("클래스 A의 생성자");
		}
		A(int num) {
			System.out.println("클래스 A의 인수 있는 생성자");
		}
	}
	class B extends A {
		B() {
			super(10);
			System.out.println("클래스 B의 생성자");
		}
	} 실행시
	클래스 A의 인수 있는 생성자
	클래스 B의 생성자
	*/	
		
	/*	메소드 재정의 ( Over Ride )
	클래스를 상속할 때 원래 슈퍼 클래스에 정의된 메소드를 상속한 서브 클래스에서 같은
	메소드이름(같은 인수)에 삽입될 수 있다. 즉, 덮어쓰기가 된다. 이 메소드의
	재정의를 의미한다. 
	구체적인 예로 보면, 슈퍼 클래스로 클래스 A를 준비하고, 클래스 A를 상속한 클래스
	B1과 클래스 B2가 있다. 슈퍼 클래스인 클래스 A에는 disp라는 메소드가 정의되어
	있다. 여기에서 클래스 B1에서 disp라는 메소드를 재정의하려고 한다.
	class A {
		public void disp() {
			System.out.println("가전 제품");
		}
	}
	class B1 extends A {
		public void disp() {
			System.out.println("에어컨입니다");
		}
	}
	class B2 extends A {
	}
	클래스 B2 오브젝트를 만들고 disp메소드를 호출한 경우, 클래스 B2 자신은 disp
	메소드가 정의되어 있지않으므로 슈퍼클래스인 클래스 A에 정의되어있는 disp메소드를
	호출하므로 "가전 제품"으로 표시된다. 이에 대해 클래스 B1의 오브젝트를 만들고
	disp메소드를 호출한 경우는 클래스B1 자체에 disp메소드가 정의되어있기 때문에
	클래스B1의 disp메소드가 호출되어 "에어컨입니다"로 표시된다. 왜 이런 처리를
	하는가 하면, 슈퍼 클래스에서 disp메소드를 정의하여 슈퍼클래스를 상속하는 모든
	서브 클래스에서는 공통된 메소드이름인 disp메소드를 사용할 수 있다. 다만 서브 
	클래스에 따라선 그 메소드의 정의를 자체 내용에 다시 정의할 수 있다. 이런 경우에 
	같은 메소드이름과 인수를 사용해 재정의하는 것으로 메소드이름은 동일하지만 내용은
	정의하는 클래스 맞춘 내용으로 변경할 수 있는 것이다. 서브 클래스 모두에 공통적인
	메소드이름으로 내용은 원하는 처리대로 바꿔쓸 수 있다는 것이다.
	class A {
		public void disp() {
			System.out.println("가전 제품");
		}
	}
	class B1 extends A {
		public void disp() {
			System.out.println("에어컨입니다");
		}
	}
	class B2 extends A {
	}
	class ctest16 {
		public static void main(String[] args) {
			B1 b1 = new B1 ();
			b1.disp();
			B2 b2 = new B2 ();
			b2.disp();
		}
	} 컴파일 실행시
	에어컨입니다
	가전 제품
		
		슈퍼 클래스의 메소드를 호출
	오버라이드(override)하는 경우에도 명시적으로 슈퍼클래스에 정의된 메소드 쪽을
	호출할 수 있습니다. 그 경우에는 super를 사용하여 아래와 같이 호출한다.
	class A {
		public void disp() {
			System.out.println("가전 제품");
		}
	}
	class B extends A {
		public void disp() {
			System.out.println("에어컨입니다");
			super.disp(); //이 부분
		}
	}
	super를 통해서 호출한 경우에는 자신의 클래스에 정의된 메소드는 아니고 슈퍼클래스에
	정의된 메소드를 호출한다.
	class ctest17 {
		public static void main(String[] args) {
			C c = new C();
			c.disp();
		}
	}
	class A {
		public void disp() {
			System.out.println("가전 제품")
		}
	}
	class B extends A {
		public void disp() {
			System.out.println("에어컨입니다");
			super.disp();
		}
	}
	class C extends B {
		public void dis() {
			System.out.println("삼성입니다");
			super.disp();
		}
	}
	*/
		
	/*	슈퍼클래스의 인스턴스를 사용
	상속된 클래스의 객체를 다룰 때 일반적으로 아래와 같이 이용하고 있다.
	class test {
		public static void main(String[] args) {
			subClass obj = new subClass();
		}
	}
	class superClass{
	}
	class subClass extends superClass {
	}
	위와 같이 객체를 생성하는 클래스의 변수를 사용하지만 클래스를 상속한 경우, 슈퍼
	클래스의 변수에 대해 서브 클래스의 객체를 할당할 수 있다.
	슈퍼클래스 변수명 = new 서브클래스();
	구체적으로는 아래와 같이 된다.
	class test {
		public static void main(String[] args) {
			superClass obj = new subClass();
			obj.dispName();
		}
	}
	class superClass {
		public void dispName() {
		}
	}
	class subClass extends superClass {
		public void dispName() {
		}
		public void dispVersion() {
		}
	}
	슈퍼클래스의 변수에 서브클래스의 객체를 확보하는 경우, 이 오브젝트를 통해서 호출
	할 수 있는 메소드는 슈퍼클래스에 정의되어있는 것만이다. 만약 하위 클래스에서 
	재정의되는 메소드라면, 서브클래스로 메소드가 호출된다. 예를 들어 방금 전의 샘플
	에서 보면, 서브클래스에서 새롭게 추가된 dispVersion메소드는 슈퍼 클래스의
	변수에 저장된 객체에서 호출할 수 없지만, 슈퍼 클래스에 정의되고 하위 클래스에서 
	재정의 되는 dispNmae메소드는 호출할 수 있다. 실제로 사용해보면
	class ctest18 {
		public static void main(String[] args) {
			superClass obj = new subClass();
			obj.dispName();
		}
	}
	class superClass {
		public void dispName() {
			System.out.println("정의되지 않습니다");
		}
	}
	class subClass extends superClass {
		public void dispName() {
			System.out.println("정의했으면 제품 이름은 XXX입니다");
		}
		public void dispVersion() {
			System.out.println("버전 1.0");
		}
	}실행시
	정의했으며 제품 이름은 XXX입니다
	위와 같이 재정의된 메소드를 호출하는 경우, 서브클래스 쪽에서 정의된 메소드가 호출된다.
		슈퍼클래스의 인스턴스를 사용하는 이유
	그럼 왜 이런 처리를 하는가, 같은 슈퍼 클래스에서 여러 종류의 서브 클래스를 작성한 경우,
	슈퍼 클래스의 변수를 사용하면, 어떤 서브 클래스의 객체에서도 동일하게 취급할 수 있기
	때문이다. 예를 들어 서브클래스의 변수 이름을 각각 사용한 경우의 서브클래스의 변수에
	다른 서브클래스의 객체를 포함할 수 없기 때문에 별도로 취급해야한다.
	class test {
		public static void main(String[] args) {
			subClassA obj1 = new subClassA();
			subClassB obj2 = new subClassB();
			subClassC obj3 = new subClassC();
			obj1.dispName();
			obj2.dispName();
			obj3.dispName();
		}
	}
	class superClass {
		public void dispName(){
		System.out.println("정의되지 않습니다");
		}
	}
	class subClassA extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 XXX입니다");
		}
	}
	class subClassB extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 YYY입니다");
		}
	}
	class subClassC extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 ZZZ입니다");
		}
	}
	이에 대해서 슈퍼 클래스의 변수를 사용하는 경우는 슈퍼클래스의 변수는 어떤 서브클래스의
	객체도 저장할 수 있기 때문에 통인된 형태로 처리할 수 있게된다.
	class test {
		public static void main(String[] args) {
			superClass obj[] = new superClass[3];
			obj[0] = new subClassA();
			obj[1] = new subClassB();
			obj[2] = new subClassC();
			for(int i = 0; i < 3; i++) {
				obj[i].dispName();
			}
		}
	}
	class superClass {
		public void dispName() {
			System.out.println("정의되지 않습니다)
		}
	}
	class subClassA extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 XXX입니다");
		}
	}
	class subClassB extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 YYY입니다");
		}
	}
	class subClassC extends superClass {
		public void dispName(){
		System.out.println("제품 이름은 ZZZ입니다");
		}
	}
	이와 같이 동일한 형식의 변수에 다양한 서브클래스의 객체를 포함하는 것으로, 서브
	클래스의 차이를 신경쓸 일 없이 프로그램을 작성할 수 있다. 또한 슈퍼 클래스의 변수에
	저장한 객체에서 사용할 수 있는 것은 슈퍼 클래스에 정의된 메소드(및 하위 클래스에서
	재정의 된 메소드)뿐이므로 어떤 서브클래스에서도 같은 메소드이름을 사용할 수 있는 
	것입니다. 이렇게 처러할 수 있는 것이 상속을 사용한 프로그래밍의 장점 중 하나이다.
	*/
		superClass obj[] = new superClass[3];
		obj[0] = new subClassA();
		obj[1] = new subClassB();
		obj[2] = new subClassC();
		for (int i = 0; i < 3; i++) {
			obj[i].dispName();
		}
	}
}
class superClass{
	public void dispName() {
		System.out.println("정의되지 않습니다");
	}
}
class subClassA extends superClass{
	public void dispName() {
		System.out.println("제품의 이름은 XXX입니다");
	}
}
class subClassB extends superClass{
	public void dispName() {
		System.out.println("제품의 이름은 YYY입니다");
	}
}
class subClassC extends superClass{
	public void dispName() {
		System.out.println("제품의 이름은 ZZZ입니다");
	}
}			