package classData;

public class Java21Class {
	public static void main(String[] args) {
	/*	클래스
	우선 클래스가 무엇인지 알아보자면
	class test1 {
		...
	}
	다음과 같은 규칙으로 설명되어 있다.
	class 클래스이름 {
		...
	}
	class 뒤에 클래스이름을 지정한다. 그리고 {}사이에 그 클래스에 대해 작성한다.
	
	원래 클래스란 무엇인가 하면 무엇인가를 실행하는 물체의 설계도와 같은 것이다.
	뭔가를 실행한다는 것은 예를 들어 자동차라면 사람을 태우고 달리고 있으며, TV라면
	방송을 수신해 영상과 소리를 낸다는 것이다. 클래스라는 것은 그 설계도와 같다.
	그 때문에, 이미지로는 다음과 같은 느낌이다.
클래스 차 {
		차를 이동{
			...
		}
		차를 정지{
			...
		}
		라이트를 켜다{
			...
		}
}
	*/
		
	/*	오브젝트를 생성	
	클래스는 설계도라고 기입했지만, 자동차 설계도가 사람을 태우고 달리는 것은 아니다.
	실제로 움직이기 위해서는 설계도를 바탕으로 실제 물체를 만들 필요가 있다. 클래스를 
	바탕으로 실제로 만든 물건을 객체라고 부르고 있다. 클래스에서 물체를 만들려면 new
	를 사용한다.
	클래스명 변수명 = new 클래스명(인수);
	위에서 기술한 변수이름이라는 게 만든 객체이다.
	예를 들어 Television이라는 클래스가 있는 경우
	그 클래스에서 오브젝트를 만들려면 아래와 같이 작성한다.(인수가 없는 경우)
	Television tv - new Television();
	또는 다음과 같이도 기입할 수도 있다.
	Television tv;
	tv = new Television();
	클래스에서 객체를 생성하는 기술 방법은 변수 선언과 동시에 초기 값을 설정하는 기술과
	비슷하다.
	예를 들어 String클래스의 변수를 생성하여 초기값을 동시에 대입하면 아래와 같이
	하고 있다.
	String str = "abcde";
	위는 다음과 같이 new를 사용하여 기입할 수 있다.
	String str = new String("abcde");
	이처럼 Java프로그램은 직접 설계한 클래스나 이미 준비되어있는 클래스를 바탕으로
	객체를 만들고 그 객체에 다양한 처리를 하도록 한다. 또한 변수가 얼마든지 만들 수 있는
	것처럼 동일한 클래스를 바탕으로 얼마든지 오브젝트를 생성할 수 있다. 이것은 하나의
	클래스에서 여러 객체를 만드는 것과 같은 것이다. 원래 설계도(클래스)는 동일하더라도
	거기에서 작성된 물체(객체)는 전혀 다른 것이므로, 따로따로 움직일 수 있습니다.
	Television tv1;
	Television tv2;
	tv1 = new Television();
	tv2 = new Television();
	위의 경우 말해서 두 개의 TV를 작성하고있다. 두 대가 독립적이므로 별도로 작동한다.
	다만, 그 바탕으로 하고있는 설계도는 동일하다.
	*/	
		
	/* 클래스를 이용	
	다양한 시도 샘플 프로그램은 기본적으로 다음과 같은 구성을 하고있다.
	class ctest1 {
		public static void main(String[] args) {
			//여기에 다양한 프로그램을 작성
		}
	}
	경우에 따라선 다른 메소드도 정의하고 있었지만, 등장하는 클래스는 하나뿐이다.
class ctest1 {
	public static void main(String[] args) {
		//여기에 다양한 프로그램을 작성
	}
}
class Television {
	int channelNo;
	void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	void dispChannel() {
		System.out.println("현재 채널은 " + channelNo + "입니다");
	}
}
	Television 클래스는 변수 channelNo가 선언되어 있고
	setChannel메소드와 dispChannel메소드가 정의되어있다.
	클래스가 설계도와 같은것이라고 전에 기입했었지만, 이 Television이라는 클래스는
	"채널을 맞춘다"의 동작과 "현재의 채널을 표시" 동작의 두 가지 동작을 나타내는
	방법이 설명되어 있다. 또한, 이 클래스에서 생성된 걕체가 현재의 채널을 기억하기 
	변수가 하나 포함되어있다.
	이처럼 TV를 나타내면 도면인 Television클래스를 정의했으므로 이번에는 그
	설계도를 바탕으로 실제 물체를 만든다.
class ctest1 {
	public static void main(String[] args) {
		Television tv1 = new Television();
	}
}
class Television {
	int channelNo;
	void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	void dispChannel() {
		System.out.println("현재 채널은 " + channelNo + "입니다");
	}
}
	이제 Television클래스를 바탕으로 하나의 물체(오브젝트)가 작성됐다. 이것은 
	굳이 말한다면 TV를 한 대 생산된 것이다.
	TV채널을 "1"로 설정한 다음 현재 설정되어있는 채널을 표시시켜보면
class ctest1 {
	public static void main(String[] args) {
		Television tv1 = new Television();
		tv1.setChannel(1);
		tv1.dispChannel();
	}
}
class Television {
	int channelNo;
	void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	void dispChannel() {
		System.out.println("현재 채널은 " + channelNo + "입니다");
	}
}
	생성된 오브젝트에 그 바탕으로 하고 있는 클래스에 정의된 메소드를 실행하려면 다음과
	같이 기입한다.
	객체명.메소드명(인수);
	앞서의 경우라면 아래 부분이 거기에 해당한다.
	tv1.setChannel(1);
	tv1.dispChannel();
	이것은 생성한 오브젝트에 대해 메소드의 형태로 기술된 동작시키고 있다는 것이다. 또한
	같은 클래스를 바탕으로 여러 오브젝트를 생성할 수도 있다. 각각 전혀 다른 물체가 되기
	때문에, 각각의 오브젝트가 저장된 값도 완전히 독립적이다.
	여기에 TV를 두대 만들어 각 채널을 표시하는 샘플을 작성해보자
class ctest1 {
	public static void main(String[] args) {
		Television tv1 = new Television();
		Television tv2 = new Television();
		tv1.setPlace("거실");
		tv2.setPlace("침실");
		tv1.setChannel(1);
		tv2.setChannel(8);
		tv1.dispChannel();
		tv2.dispChannel();
	}
}
class Television {
	int channelNo;
	String place;
	void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	void setPlace(String newPlace) {
		place = newPlace;
	}
	void dispChannel() {
		System.out.println(place+ "에 있는 텔레비전 현재 채널은 "
							+ channelNo + "입니다");
	}
}컴파일시
거실에 있는 텔레비전의 현재 채널은 1입니다
침실에 있는 텔레비전의 현재 채널은 8입니다
	*/
		
	/*	main메소드와 클래스의 관계
	main메소드와 클래스의 관계에 대해 정리한다. 
	클래스를 사용하는 프로그램의 경우, 클래스는 어디까지나 설계도이므로 어디인가에서
	클래스를 바탕으로 객체를 생성하고 객체 여러가지 지시를 해 둘 필요가 있다.
	클래스의 객체 생성은 다른 클래스 안에서도 기술할 수 있지만, 다른 클래스의 객체를
	생성하는 무엇인가가 결국은 필요하다.
	즉, 먼저 클래스와는 관계없는 요소가 먼저 어떤 클래스의 오브젝트를 만들어 놓을 필요
	가 있는 것이다.
	그래서 사용되는 것이 main메소드이다. main메소드는 프로그램을 실행할 때, 가장
	먼저 호출되는 메소드이다. 이 메소드 내에 다른 클래스의 오브젝트를 만드는 기술을
	두는 것으로 프로그램이 작동하는 것이다.
class ctest1 {
	public static void main(String[] args) {
		Television tv1 = new Television();
		tv1.setChannel(1);
		tv1.dispChannel();
	}
}
class Television {
	int channelNo;
	void setChannel(int newChannelNo) {
		channelNo = newChannelNo;
	}
	void dispChannel() {
		System.out.println("현재 채널은 " +  channelNo + "입니다");
	}
}
	main메소드도 기입되어있다.
	다만 위와 같은 작성 main메소드도 메소드의 일종이므로 메소드는 클래스에 밖에 기입할
	수 없다. 때문에 사용하지 않는 클래스를 하나 준비하고 그 안에 main메소드를 기입하고
	있는 것이다. main메소드가 들어있는 ctest1라는 클래스는 이 클래스를 바탕으로 객체
	를 생성하지 않습니다.
	이렇게 main메소드는 어떤 의미의 특수한 방법이지만, main메소드는 특정 클래스에서 
	기술하면 된다. 
	main메소드는 어느 클래스 안에 기술되어있으면 되고 ctest1라는 클래스는 실제로 
	사용하지 않는 것이기 때문에 Television이라고 클래스만을 사용해서 그 안에 메소드를
	기입해 넣어도되는 것이다.
	
		객체지향과 main메소드이 관계
	덧붙여서 Java프로그램 입문에서는 실행하고자 하는 프로그램의 내용은 main메소드에
	모두 기입되어있다. main메소드는 처음부터 준비되어있는 메소드이므로 누군가가 
	오브젝트를 작성하는 등의 처리를 하지않아도 그 안에 작업을 수행할 수 있다.
	Java는 본래 객체 지향 프로그래밍 언어다. 객체 지향이란 목적에 따라 클래스를 설계
	하고 거기에서 객체를 만들고 그 객체에 동작을 하자라는 기술 방법이다. main메소드는
	객체를 만들고 그 객체에 대해 동작을 하는 것이 본래의 이용 방법인데 간단한 작업으로
	프로그램에서 클래스를 설계할 필요가 없을 때, main메소드에서 하고 싶은 작업을
	모두 처리하면 된다.
		
		static 메소드에 대해
	main 메소드가 처음부터 존재하는 메소드라고 했지만, 프로그램에서 일부러 작성하지
	않아도 사용할 수 있는 것은 아니고 프로그램 시작시에 아무것도 하지 않아도 시스템측이
	작성(생성)해주고 있다는 것이다.
	이와 같이 명시적으로 작성하지 않아도 프로그램 시작시 생성되는 메소드를 
	static메소드라고 한다. main메소드를 보면,
	public static void main(String[] args) {
		Television tv1 = new Television();
		tv1.setChannel(1);
		tv1.dispChannel();
	}
	메소드 정의 시에 메소드이름을 명시하고있는 앞 쪽에 static이라고 기입되어있다. 이
	static이 있는 경우, 시스템 측에서 프로그램 시작시에 준비해주는 것이다. 
	이 static이 붙은 메소드 내에서 다른 메소드를 호출하는 경우에는 그 호출되는 메소드도
	static이 있어야한다. 때문에 Java 프로그램 입문에서 쓰던 방법은 모든 static이
	붙어 있던 것이다.
	반대로 클래스에서 작성된 객체가 생성된 후에 실행되는 메소드는 객체가 생성된 시점에서
	메소드가 생성되어도 되기때문에 프로그램 시작때부터 준비되어 있을 필요는 없다. 때문에
	static을 붙일 필요는 없는 것이다.
	class Television {
		int channelNo;
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	*/
		
	/*	Class Test
public class Car {
	String carName;
	String carColor;
	String maker;
	int speed;
	
	//public Car() {}
	//speed를 10씩 증가
	void speedUp() {
		speed += 10; //==	speed = speed + 10;
	}
	//speed를 10씩 감소
	void speedDown() {
		speed -= 10; //==	speed = speed - 10;		
		if(speed < 0)
		stop();
	}
	//speed를 0
	void stop() {
		speed = 0;
	}
	String carInfo(String cn) {
		return cn + "차이름 : " + carName + 
					"\t색상 : " + carColor +
					"\t제조사 : " + maker;
	}
}
class CarUse {
	public static void main(String[] args) {
		Car car1;
		car1 = new Car();
		//Car car2 = new Car();
		System.out.println("1. " + car1.carInfo("car1"));
		car1.carName 	= "쏘나타";
		car1.carColor	= "흰색";
		car1.maker		= "현대";
		System.out.println("2. " + car1.carInfo("car1"));
		System.out.println("car1 속도 : " + car1.speed);
		System.out.println("car1 3회 가속");
		for(int i = 0; i < 3; i++)
			car1.speedUp();
		System.out.println("car1 5회 감속");
		for(int i = 0; i < 5, i++)
			car1.speedDown();
		System.out.println("car1 속도 : " + car1.speed);
		Car car2 = new Car();
		System.out.println("1. " + car1.carInfo("car2"));
		for(int i = 0; i < 5; i++)
			car2.speedDown();
		System.out.println("car2 속도 : " + car2.speed);
	}
}
	*/ 
	}
}