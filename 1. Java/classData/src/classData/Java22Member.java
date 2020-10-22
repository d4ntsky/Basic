package classData;

public class Java22Member {
	public static void main(String[] args) {
	/*	멤버 변수
	여기에선 멤버 변수를 살펴본다. 멤버 변수는 클래스 정의에서 아래의 부분이다.
	class Television {
		int channelNo; //이 부분
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	클래스 안에서 선언되고 사용하는 변수다.
	변수는 변수의 정의가 포함되어있는 부분을 포함하는 {} 내에서만 사용할 수 있다.
	예를 들어 다음과 같은 경우에 생각해보면
	class Television {
		void setChannel(int newChannelNo) {
			int no = 10;
			if(no == 10) {
				String str = "채널"
				System.out.println(str + no + "입니다");
			}
		}
	}
	위에서 변수 no는 setChannel메소드에서 자유롭게 사용할 수 있다. 또한 변수 str은
	if문의 {}에 선언되어있기 때문에, 이 변수는 if문 안에서 자유롭게 사용할 수 있지만,
	if문 밖에서는 이 변수를 사용할 수 없다.
	여기서 처음으로 기술한 클래스 정의를 다시보면,
	class Television {
		int channelNo; //이 부분
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	변수 channelNo는 클래스 내에서 정의되었으며 클래스 안에선 자유롭게 사용할 수 있다.
	이러한 변수를 멤버변수라고 한다. 이 클래스에서 객체를 생성할 때 멤버 변수는 생성된
	객체가 소멸될 때까지 변수에 값이 저장되어있다. 또한 변수의 값을 저장하는 영역은
	오브젝트마다 다르기 때문에, 오브젝트마다 오브젝트가 소멸될 때까지 변수 값을 저장할
	수 있다. 때문에 멤버변수는 객체의 성질이나 상태 등을 저장할 때 사용한다.
	위 클래스의 경우, TV를 나타내는 클래스에서 해당 클래스에서 생성된 객체가 현재 보고
	있는 채널을 저장하는 데 사용된다.
	*/
	
	/*	멤버 변수에 값을 저장
	여기에서는 클래스에서 정의한 멤버변수에 값을 저장하는 방법을 살펴보겠다. 우선 멤버
	변수가 정의되어 같은 클래스에서 값을 저장하는 경우다. 예를 보면
	class Television {
		int channelNo;
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	위의 setChannel메소드 내에서 멤버변수에 값을 저장하고 있다. 이 경우 멤버변수에
	다른 변수의 값을 포함하고있지만, 멤버 변수에 직접 값을 저장하는 경우도 마찬가지이다.
	이렇게 같은 클래스 안에 있다면, 보통의 변수처럼 다룰 수 있다. 또한 더 자세히 기입하는
	경우에는 자신의 클래스의 멤버변수라는 의미를 담아
	this.멤버변수 = 값
	라고 기입한다. this는 자신이라는 의미를 갖는 정의된 값에 this를 붙인 것으로 보통은
	생략하고있다.
	다음이 클래스에서 객체를 만들 그 객체를 사용해 값을 저장하는 방법이다.
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.channelNo = 1;
		}
	}
	class Television {
		int channelNo
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	위의 예에선 클래스를 바탕으로 객체를 만들고 그 객체를 사용하여 멤버변수에 값을 저장하고
	있다. 이 경우 기술 방법은 아래와 같다.
	객체명.멤버변수이름 = 값;
	보통 변수의 경우, 변수이름 = 값 이란 형태로 값을 저장할 수 있지만 멤버변수의 경우 생성
	된 오브젝트마다 변수의 저장 위치가 다르기 때문에, 객체명.멤버변수이름 = 값의 형태로
	어떤 객체의 멤버변수를 사용하여 값을 저장한다.
	다음은 멤버변수가 정의된 클래스의 메소드를 사용하여 값을 저장되는 방법
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(1);
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
	위의 경우, 생성된 객체를 사용하여 클래스에 정의된 메소드를 호출한다. 그 메소드에서
	멤버변수에 값을 저장하고 있다.
	개체변수.멤버변수 = 값의 기술 방법으로 멤버 변수에 값을 저장할 수 있는데 왜 이런 일단
	메소드를 호출하는지를 대해서 살펴볼 것이다.
	*/
		
	/*	메소드를 사용하여 멤버변수를 변경하는 이유
	멤버변수에 직접 값을 저장하는 대신 일단 클래스에서 정의하고 있는 메소드를 호출하여 멤버
	변수에 값을 저장하는 방법도 설명했다. 그럼 왜 이런 처리를 하는가하면, 예를 들어 멤버
	변수에 저장할 수 있는 값의 사전 검사를 하고 멤버 변수와 다른 멤버 변수를 연동하는 경우
	등의 작업을 수행할 수 있기 때문이다.
	예를 들어, TV채널은 1 또는 3만 실제로는 존재하지 않는다고 한다. 이 경우 멤버변수에
	직접 값을 저장하면, 아래와 같이 실제로는 존재하지 않는 값도 저장할 수 있게 된다.
	class ctest {
		public static void main(String[] arg) {
			Television tv1 = new Television();
			tv1.channelNo = 5;
		}
	}
	class Television {
		int channelNo;
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	이를 방지하는 대신 메소드를 호출해서 그 속에서 저장할 수 있는 값 여부를 사전에 확인
	할 수 있다.
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(5);//
		}
	}
	class Television {
		int channelNo;
		void setChannel (int newChannelNo) {
			if((newChennelNo ==1) || (newChannel == 3)) {
				channelNo = newChannelNo;
			}
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	대규모 시스템이면 각 클래스를 별도로 작성하는 것도 있다. 이 경우 멤버변수에 직접값을
	설명할 수 있는 형태로 하고, 클래스를 설계한 사람이 예기치 않은 값을 직접 저장하는 
	위험성도 있다. 그러므로 일단 메소드를 호출하여 그 안에서 멤버변수에 값을 저장하는
	방법을 자주 이용한다. 또 다른 예로는 멤버 변수를 변경했을 때 다른 멤버 변수도 연동하여
	변경하고 싶은 경우를 생각해보자.
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(5);
		}
	}
	class Television {
		int channelNo;
		String Bangsongkook;
		void setChannel(int newChannelNo) {
			if(newChannelNo == 1) {
				channelNo = 1;
				Bangsongkook = "MBC";
			}
			else if(newChannelNo == 3) {
				channelNo = 3;
				Bangsongkook = "KBS";
			}
		}
		void setBangsongkook (String newBangsongkook) {
			if(newBangsongkook.equals("MBC")) {
				channelNo = 1;
				Bangsongkook = "MBC";
			}
			else if(newBangsongkook.equals("KBS")) {
				channelNo = 3;
				Bangsongkook = "KBS";
			}
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	채널 번호를 변경하면 자동으로 다른 멤버변수에 방송국을 나타내는 Bangsongkook의 값도
	변경되어있다. 또 반대로 방송사 값을 변경하면 채널 번호가 변경된다. 이와 같이 멤버변수
	의 값을 변경하여 다른 멤버변수의 값을 동기화하여 변경하고자 하는 경우에 메소드를 호출하는
	형태로 하고있는 것으로 가능하게 된다
	물론
	tv1.channelNo = 1;		라고 한 후
	tv1.Bangsongkook = "MBC"; 		라는
	명령을 동시 수행에 두면 같은 일을 할 수 있지만 복잡하게 연동하는 경우엔 일일이 작성하는
	것도 복잡하고, 작성하는 것을 잊어버리거나 잘못 작성하는 것 같은 문제를 미연에 방지할
	수도 있다. 목적에 따라 직접 멤버변수에 값을 저장할 수 있도록 하거나 메소드를 통해서
	처리하는 등 때와 경우에 따른 판단을 해야한다.
	*/
		
	/*	public 과 private
	현재의 상태로 멤버변수를 변경하기위한 메소드를 제공했다고해도, 직접 멤버변수에 접근해서
	값을 넣으면, 잘 들어간다.
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(5);
		}
	}
	class Television {
		int channelNo;
		void setChannel(int newChannelNo) {
			if((newChannelNo == 1) || (newChannel == 3)) {
				channelNo = newChannelNo;
			}
		}
		...
	}
	멤버 변수에 직접 값을 저장하는 것을 금지하고 반드시 메소드를 통해서만 멤버 변수의 값을
	포함하거나 참조하지 못 하게 하려면 어떻게 하면 좋을까.
	그런 경우는 멤버 변수의 정의를 할 때, 변수 선언의 앞부분에 private를 추가한다.
	class Television {
		private int channelNo;
		void setChannel(int newChannelNo) {
			if((newChannelNo == 1) || (newChannel == 3)) {
				channelNo = newChannelNo;
			}
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	private가 추가된 멤버변수는 멤버변수가 정의된 클래스 내에서만 값을 저장하고 검색할
	수 밖에 없다. 때문에 다른 클래스에서 객체를 생성 객체명.멤버변수이름 = 값처럼 직접
	멤버변수에 값을 저정하는 것을 방지할 수 있다.
	private를 선택한 경우도 동일한 클래스 내의 메소드에서 값을 저장하고 검색할 수 있으므로
	다른 클래스에서 객체를 생성한 경우에도 오브젝트에서 메소드를 호출하여 멤버변수 값의 변경은
	그 메소드에서 수행하도록 작성하면 메소드를 호출하는 것으로 간접적으로 멤버변수를 저장하고
	변경할 수 있다.
	즉 멤버 변수의 직접 변경은 금지하고 메소드를 통해서만 멤버 변수를 수정할 수 있다는 것이다.
	정의할 때 private를 머리에 붙인 멤버변수는 멤버변수를 정의한 클래스 내에서만 멤버변수
	의 값을 변경하거나 참조할 수 없다.
	private 변수의형식 멤버변수이름;
	class ctest2 {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.channelNo = 1;
		}
	}
	class Television {
		private int channelNo;
		void setChannel (int newChannelNo) {
			channelNo = newChannelNo;
			System.out.println("새로운 ChannelNo = " + channelNo);
		}
	}실행시 컴파일 오류
	이에 대해 메소드 경유로 변경하려고하면 메소드는 멤버변수와 같은 클래스이므로 문제없이
	처리될 수 있다.
	class ctest3 {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(1);
		}
	}
	class Television {
		private int channelNo;
		void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
			System.out.println("새로운 ChannelNo = " + channelNo);
		}
	}컴파일 실행시
	새로운 ChannelNo = 1
	private를 지정하지 않은 멤버 변수는 어떻게 접근되어 사용되는가, 아무것도 붙어있지
	않은 경우는 public과 동일하다. 즉, 지금까지는 public이라고 쓰고 생략된 것이었다.
	public을 가진 경우에는 같은 클래스는 물론 클래스의 외부에서도 멤버변수에 값을 수정,
	접근,참조할 수 있다.
	*/
		
	/*	멤버 메소드
	멤버 메소드는 클래스에 정의된 메소드로 그 클래스에서 특정 처리하는 것이다.
	class ctest {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(1);
		}
	}
	class Television {
		int channelNo; 
		void setChannel(int newChannelNo) {
			if((newChannelNo == 1) || (newChannel == 3)) {
				channelNo = newChannelNo;
			}
		}
		void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	메소드를 호출할 때 인수를 지정하고 메소드의 반환값을 설정할 수 있다. 멤버 메소드의 호출
	방법은 멤버 인수의 경우와 마찬가지로, 같은 클래스 내에서 호출하는 경우에는 멤버 메소드
	이름(인수) 또는 this.멤버메소드이름(인수)라고 기술하고 있으며, 멤버 메소드가 정의된
	클래스의 외부에서 객체를 통해 호출하는 경우에는 객체명.멤버메소드이름(인수) 형식으로 
	호출한다.
		public과 private
	또한 멤버 변수와 마찬가지로 private와 public을 붙일 수 있다. 생략했을 경우는 public
	이 기술되어있는 경우와 동일하다. 예를 들면
	class Television {
		int channelNo;
		public void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
		}
		private void dispChannel() {
			System.out.println("현재 채널은 " + channelNo + "입니다");
		}
	}
	멤버 메소드를 객체를 통해 외부에서 호출에는 반드시 public라고 기입하거나 생략한다.
	class ctest5{
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(1);
		}
	}
	class Television {
		private void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
			System.out.println("새로운 ChannelNo = " + channelNo);
		}
	}
	*/
		
	/*	인수가 다른 동일한 이름의 메소드	
	메소드 이름은 같은 클래스에 이미 정의되어있는 다른 메소드 이름과 같은 이름을 붙일 수 없지만
	인수가 다르면 같은 이름의 메소드를 같은 클래스에 정의할 수 있다. (Over Load 기능)
	class ctest6 {
		public static void main(String[] args) {
			Television tv1 = new Television();
			tv1.setChannel(1);
			tv1.setChannel("KBS");
			tv1.setChannel(3, "KBS 종합");
		}
	}
	class Television {
		private int channelNo;
		private String Bangsongkook;
		public void setChannel(int newChannelNo) {
			channelNo = newChannelNo;
			if(newChannel == 1) {
				Bangsongkook = "MBC';
			}
			else if(newChannelNo == 3) {
				Bangsongkook = "KBS";
			}
			System.out.println("채널이 변경되었습니다");
			dispChannelInfo();
		}
		public void setChannel(String newBangsongkook) {
			Bangsongkook = newBangsongkook;
			if(newBangsongkook.equals("MBC")){
				channelNo = 1;
			}
			else if(newBangsongkook.equals("KBS")) {
				channelNo = 3;
			}
			System.out.println("방송국이 변경되었습니다");
			dispChannelInfo();
		}
		public void setChannel(int newChannelNo, String newBangsongkook) {
			channelNo = newChannelNo;
			Bangsongkook = newBangsongkook;
			System.out.println("채널 방송국이 변경되었습니다");
			dispChannelInfo();
		}
		private void dispChannelInfo() {
			System.out.println("채널 No는 " + channelNo);
			System.out.println("방송국은 " + Bangsongkook);
		}
	}실행 결과는
	채널이 변경되었습니다
	채널은 No는 1
	방송국은 MBC
	방송국이 변경되었습니다
	채널은 No는 3
	방송국은 KBS
	채널 방송국이 변경되었습니다
	채널은 No는 3
	방송국은 KBS 종합
	*/	
	}
}