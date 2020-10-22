package classData;

public class Java23Constructor {
	
	public static void main(String[] args) {
	/*	생성자란?
	생성자는 클래스에서 객체를 생성할 때 자동으로 실행되는 메소드로 멤버 변수의 초기화
	등을 주로 한다.
class ctest7 {
	public static void main(String[] args) {
		Television tv1 = new Television();
		tv1.dispChannel();
		}
	}
class Television {
	private int channelNo;
	private String Bangsongkook;
	public void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
		if(channelNo == 1) {
			Bangsongkook = "MBC";
		}
		else if(channelNo == 3) {
			Bangsongkook = "KBS";
		}
	}
	public void dispChannel() {
		System.out.println("현재 채널은 " + Bangsongkook + "입니다");
		}
	}
보기에는 문제가 없는 것처럼 보이지만 실행해보면, 현재 채널은 null입니다 라 뜬다.
	채널은 null로 표시된다. 이것은 멤버 변수의 초기화를 하지 않고, 또 한 번도 값을 저장하지 
	않고 멤버 변수의 값을 표시하려고 했기 때문이다. 이처럼 클래스에서 객체를 생성할 때, 먼저
	멤버 변수의 초기화를 실시해두지 않으면 안 되는 경우가 많다. 멤부 변수 정의 시에 맞추어
	초기 값을 대입해두는 것으로도 해결할 수 있지만, 주로 생성자를 사용한다.
	생성자는 클래스에서 개체가 만들어진때, 무조건 한번만 실행되는 메소드이다. 
	클래스이름(){...} 일반 메소드의 반환 형식은 없다. 또한 메소드이름은 클래스이름과 동일하다.
class ctest8 {
	public static void main(String[] args) {
		Television tv1 = new Television();
		tv.dispChannel();
	}
}
class Television {
	private int channelNo;
	private String Bangsongkook;
	Television() {  //생성자
		channelNo = 1;
		Bangsongkook = "MBC"'
	}
	public void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
		if(channel == 1) {
			Bangsongkook = "MBC";
		}
		else if(channelNo == 3) {
			Bangsongkook = "KBS";
		}
	}
	public void dispChannel() {
		System.out.println("현재 채널은 " + Bangsongkook + "입니다");
	}
}
현재 채널은 MBC입니다
	*/	
		
	/*	인수가 있는 생성자
	생성자는 메소드와 마찬가지로 인수를 지정할 수 있다. 인수가 있는 생성자를 사용한 경우, 그 클래스로부터
	객체를 생성할 때 다음과 같이 작성한다.
	클래스이름 객체이름 = new 클래스명(인수);
class ctest9 {
	public static void main(String[] args) {
		Television tv1 = new Television("거실");
		tv1.dispChannel();
		Television tv2 = new Television("부엌");
		tv2.dispChannel();
	}
}
class Television {
	public int channelNo;
	private String place;
	Television(String newPlace) { //인수가 있는 생성자
		channelNo = 1;
		place = newPlace;
	}
	public void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	public void dispChannel() {
		System.out.println("현재 채널은 " + channelNo + "입니다");
		System.out.println("설치되어있는 장소는 " + place + "입니다");
	}
}
	위에서는 기본값을 설정하려는 채널은 생성자에게 고정값을 설정하고 오브젝트마다 다른값을
	객체 생성시에 설정하고 싶은 위치는 생성자의 인수로 지정하고 생성자에서 기입한다.
	*/
	
	/*	인수가 다른 생성자
	메소드의 경우와 마찬가지로 인수의 수와 형태가 다른 것이라면 하나의 클래스에 여러 생성자를
	작성할 수 있다. 또한 생성자를 선택해서 호출할 수 있다.
	클래스 이름() {
		클래스 이름(인수) {
			...
		}
		클래스 이름(인수) {
			...
		}
	}
	여기서 인수는 호출하고 싶은 생성자에게 지정되어있는 인수를 설명한다.
class ctest10 {
	public static void main(String[] args) {
		Television tv1 = new Television("거실");
		tv1.dispChannel();
		Television tv2 = new Television();
		tv2.dispChannel();
	}
}
class Television {
	private int channelNo;
	private String place;
	Television() {
		this("미정");
	}
	Television(String newPlace) {
		channelNo = 1;
		place = newPlace;
	}
	public void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	public void dispChannel() {
		System.out.println("현재 채널은 " + channelNo + "입니다");
		System.out.println("설치되어있는 장소는 " + place + "입니다");
	}
}
	*/
	
	/*	기본 생성자
	생성자를 하나도 정의하지 않는 경우, 자동으로 기본 생성자라는 생성자가 생성된다.
	클래스 이름(){
	}
	인수가 없는 빈 생성자가 생성된다. 내용이 비어있다 때문에 아무것도 하지 않는다. 그럼 왜 이런 빈
	생성자가 의미를 가지는 지라고 하면, 생성자는 실행되기 전에 먼저 자신의 부모클래스의 생성자를 
	호출하게 되어있습니다. 자세한 내용은 클래스의 상속 부분에서 볼 것이지만, 생성자의 첫번째 줄에는
	super()라는 부모클래스의 생성자를 호출하고 동작한다.
	이것은 디폴트의 생성자에서도 동일하기 때문에 실제로는 아래와 같다.
	클래스 이름 () {
		super();
	}
	아무것도 없는 기본 생성자이지만, 부모클래스의 생성자를 호출하는 동작을 하고있기 때문에 의미가
	있는 것이다.
		기본 생성자의 주의점
	명시적으로 생성자를 하나라도 작성하는 경우, 기본생성자가 생성되지 않는다. 인수 없는 생성자를 
	기술한 것이라면 문제 없지만, 인수 없는 생성자를 정의하지않고 인수가 있는 생성자만 작성한 경우에도
	기본생성자가 생성되지 않기 때문에 인수 없는 그 클래스의 객체를 생성할 수 없게 되므로 주의한다.
	예를 들어 다음과 같은 프로그램은 문제가 되지 않는다.
class ctest11_1 {
	public static void main(String[] args) {
		Test test = new Test();
		}
	}
	class Test {
	}
	이 프로그램이 컴파일 에러가 되지 않는 것은 기본 생성자가 자동으로 생성되어있기 때문이다.
class ctest11_1 {
	public static void main(String[] args) {
		Test test = new Test();
		}
	}
	class Test {
		Test() {
		}
	}
	Test 클래스의 객체를 생성할 때 인수 없이 작성하고 있지만, 인수 없는 생성자는 자동으로 
	생성되기 때문에 문제가 되지 않는다.
	다음 인수가 같은 생성자를 하나만 정의하는 경우이다. 이것은 예를 들어 인수 없음과 인수 있음의
	경우가 인수 있음의 경우에만 뭔가 처리하고 하는 경우 등이다.
class ctest11_2 {
	public static void main(String[] args) {
		Test test = new Test();
		}
	}
	class Test {
		Test(int num) {
		}
	}
	이것은 컴파일 오류가 난다. 이런 오류가 나오지 않기 위해서라도 인수 있는 생성자를 정의하는 경우,
	인수 없는 생성자도 (내용이 비었다고 해도) 기술두도록 해라.
class ctest11_3 {
	public static void main(String[] args) {
		Test test = new Test();
		}
	}
	class Test {
		Test() {
		}
		Test(int num) {
		}
	}
	위 경우 컴파일 에러도 없고 실행도 가능하다.
	*/
		
		
	}
}