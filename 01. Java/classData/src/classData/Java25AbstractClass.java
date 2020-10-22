package classData;

public class Java25AbstractClass {
	public static void main(String[] args) {
	/*	추상 클래스
	클래스를 상속할 때 슈퍼클래스에 정의된 메소드를 서브클래스에서 이를 재정의
	할 수 있지만, 서브클래스에서 반드시 재정의 되야하는 메소드도 있다.
	예를 들어 모든 제품의 기초가 되는 슈퍼클래스를 만들고 각 제품은 반드시
	슈퍼클래스를 상속한 클래스를 작성한다고 하고 모든 서브클래스에는 제품이름을 
	표시하는 dispName 메소드를 정의하기로 한다.
	 */
	//---------------------------------------------------
//	class base {
//		public void dispName() {
//			//특히 아무것도 하지 않고 선언만 한다.
//			System.out.println("Alert : 개별 클래스에서 재정의하십시오.");
//		}
//		
//		public void disCompany() {
//			System.out.println("XYZ사의 생산 제품입니다.");
//			}
//		}
//	
//	class productA extends base{
//		public void dispName() {
//			System.out.println("제품 A입니다.");
//		}
//	}
//	
//	class productB extends base{
//		public void dispName() {
//			System.out.println("제품 B입니다.");
//		}
//	}
	//---------------------------------------------------
	/*
	dispName메소드는 제품의 이름을 표시하는 방법이므로 각 클래스에서 별도의 처리가
	필요하다. 단지 각각의 클래스에 적당한 메소드이름을 사용하면 복잡해질 수도 있으므로
	슈퍼클래스에서 메소드를 제공하여 슈퍼클래스를 상속하는 하위클래스에서 이 메소드이름
	을 사용하도록 권장할 수 있다. 이처럼 서브클래스에서 준비했으면 좋겠다는 방법으로
	슈퍼클래스에서 메소드들을 제공은 하더라도, 슈퍼클래스 자체에서는 아무런 내용을 
	작성하지않고 정의할 수 있다.
	*/
	/*
	보통의 메소드는 아래와 같이 되어있다.
	메소드이름(인수,인수, ...) {메소드의 내용}
	이에 대해 내용이 없는 메소드는 다음과 같이 기입한다.
	abstract 메소드이름(인수,인수, ...);
	일반적으로 메소드의 내용을 설명하는 {}가 업고, 메소드이름 뒤에 바로 세미콜론;을
	붙이고 있다. 즉, 어떤 방법인지만 설명하고 있으며, 내용은 없는 것이다. 이러한
	메소드를 추상메소드라고 한다.
	추상메소드는 메소드이름 앞에 abstract로 구분한다. 추상 메소드를 사용해 방금
	전의 샘픔을 기입하면 다음과 같이 된다. 
	*/
	//---------------------------------------------------
//	abstract class base {
//		abstract public void dispName();
//		public void disCompany() {
//			System.out.println("XYZ사의 생산 제품입니다.");
//			}
//		}
//	
//	class productA extends base{
//		public void dispName() {
//			System.out.println("제품 A입니다.");
//		}
//	}
//	
//	class productB extends base{
//		public void dispName() {
//			System.out.println("제품 B입니다.");
//		}
//	}
	//---------------------------------------------------	
	/*
	base 클래스의 선두에 abstract가 추가되어 있다. 이것은 추상 메소드가 하나라도
	포함된 클래스는 클래스 자체가 추상 클래스가 되는 것이다. 즉, "내용이 없는 메소드가
	하나 포함되어있는 클래스"라는 것이다.
	추상 클래스의 정의하는 경우에는 클래스이름 앞에 abstract를 넣는다. 
	추상메소드란 메소드이름만 정의되므로 이 추상 메소드를 포함하는 추상클래스를 상속받은
	서브클래스에서는 반드시 이 메소드를 재정의하고 실체 내용을 정의해야된다.
	그 결과, 서브클래스에 반드시 같은 이름의 메소드를 다시 정의해야되는 것이다.
	그러면 실제로 추상 클래스를 구체적으로 사용해보면.. 오브젝트 생성부터 하려한다.
	*/
	//---------------------------------------------------
//	class ctest18 {
//		public static void main(String[] args) {
//			base c = new base();
//		}
//	}
//	abstract class base{
//		abstract public void dispName();
//		public void dispCompany() {
//			System.out.println("XYZ사의 생산제품입니다.");
//		}
//	}
		//에러가 난다
	//---------------------------------------------------
	/*
	오류 메시지에 나와있는 것처럼 abstract클래스로는 오브젝트를 생성할 수 없다.
	abstract클래스란 클래스 중 적어도 하나이상 abstract메소드가 포함돼있다.
	abstract메소드는 내용이 정의되어 있지 않은 메소드이므로 불완전한 메소드이다.
	때문에, abstract메소드를 포함해서 abstract클래스에서 오브젝트를 생성할
	수 없다. 
	abstract클래스는 상속해서 사용하는것을 전제로 한 클래스임을 기억. 그러면
	abstract클래스를 상속한 클래스에서 abstract메소드를 구현하지 않는 경우를
	보려한다.
abstract class base {
	abstract public void dispName();
	public void dispCompany() {
		System.out.println("XYZ사의 생상 제품입니다");
	}
}
class productA extends base {
	public void dispVersion() {
		System.out.println("버전은 1.0입니다");
	}
}
class ctest19 {
	public static void main(String[] args) {
		productA c = new productA();
	}
}			//에러가 난다.
	이번에는 abstract 클래스이므로 base 클래스를 상속한 productA클래스의
	오브젝트를 생성하려 하고있다. productA클래스에서 상속된 base 클래스에
	포함되어있는 abstract 메소드의 dispName 메소드를 재정의하지 않았다.
	위의 오류 메시지는 다음을 나타낸다. 추상 클래스를 상속한 클래스에서 상속된 
	추상클래스에 포함되어있는 추상메소드를 재정의하거나 상속한 클래스도 abstract
	클래스를 만들어야한다.
	*/
	/*
	즉 abstract 클래스를 상속한 경우,
	abstract 메소드를 오버라이드(override)하지 않는 경우에는 아직 정의되지
	않은 메소드가 포함된 상태로 남아버리기 때문에 상속된 클래스도 abstract 클래스가
	됩니다. 때문에 오버라이드(override)하지 않는 경우엔 다음과 같이 기술해야한다.
abstract class base {
	abstract public void dispName();
	public void dispCompany() {
		System.out.println("XYZ사의 생산 작품입니다");
		}
	}
abstract class productA extends base {
	public void dispVersion() {
		System.out.println("버전 1.0은  1.0입니다");
	}
}
	당연히 productA 클래스도 추상 클래스이므로 productA 클래스로 오브젝트를
	생성할 수 었다. 그러면 abstract 클래스에 포함된 abstract 메소드를 상속
	한 클래스에서 구현한 예를 살펴보게다.
class ctest20 {
	public static void main (String[] args) {
		productA c = new productA ();
		c.dispName();
	}
}
abstract class base {
	abstract public void dipsName();
	public void dispCompany() {
		System.out.println("XYZ사의 생상 제품입니다");
	}
}
class productA extends base {
	public void dispName() {
		System.out.println("제품 이름은 xxx입니다")
	}
	public void dispVersion() {
		System.out.println("버전은  1.0입니다");
	}
}
	이번에는 abstract 클래스를 상속한 클래스에서 구현해야 하는 메소드를 재정의
	하고있기 때문에 컴파일 오류가 발생하지 않고 잘 실행된다. 실제로 한 결과는
	아래와 같이 된다
	제품 이름은 xxx입니다
	*/	
	
	}
}