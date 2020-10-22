package classData;

public class Java10StringClass {
	public static void main(String[] args) {
		/*	표준 클래스 사용
		정수의 경우면 int형, 문자라면 char형 등 java에서는 기본적인 값을
		취급하기 위한 데이터형이 준비되어있다.
		단지 문자열을 취급하기 위한 기본 데이터형은 준비되 있지 않다.
		대신 표준 클래스로 String 클래스가 준비되어있다.
		표준 클래스란 효율적으로 프로그램을 만들수있도록 미리 정의된 클래스다.
		대표적으로, String 클래스는 캐릭터(char)의 집합인 문자열을 취급
		하기위한 클래스다.
		   오브젝트 생성
		클래스에서 오브젝트를 만드는 형식은
		클래스명 변수이름;
		변수이름 = new 클래스이름(인수, 인수, ...);
		오브젝트를 만들려면 배열의 경우와 같이 new 연산자를 사용
		생성된 오브젝트 변수에 할당된다.
		클래스의 오브젝트 할당된 변수의 형명은 int 등 기본 데이터 형식이 아닌
		클래스 이름을 지정 가능하다.
		클래스 이름을 지정하여 변수를 선언한 경우, 그 변수는 지정된 클래스에서
		생성된 객체가 할당된다.
		예를 들자면
		String name;
		name = new String();
		Stirng클래스의 객체를 생성하고 변수 name에 대입하고 있다.
		따라서 표준 클래스도 기본 데이터형과 마찬가지로 변수에 할당하고
		검색하여 이용 가능하다.
		*/
		
		/*	String클래스의 객체 생성 및 초기화
		표준 클래스에서 String클래스의 객체를 생성하고 변수에 할당하는 방법을
		확인하고 있습니다.
		문자열은 여러 문자를 하나의 덩어리로 취급하는 것이다.
		문자열은 "abc" 또는 "안녕하세요" 와 같이 큰 따옴표"로 묶어 표현한다.
		문자열이 String클래스의 객체로 구현되는 것이다.
		문자열로 표현하고 하는 문자집합을 지정하고 String클래스의 객체를 생성하나
		이들을 모두 함께 "문자열"라고 구현할 수 있도록 되어있다.
		*/
		String str;
		char data[] = {'문','자','열'};
		str = new String(data);
		/*
		이 기술 방법은 몇 종류나 준비되있는 String클래스의 객체를 만드는 방법중
		하나다. 우선 클래스의 변수를 선언하고 있다.
		문자열을 구성하는 문자를 모은 char형의 배여을 준비 String클래스의 인수
		로 지정하고 String클래스의 객체를 생성하고 변수에 할당하고 초기화한다.
		이것은 다음과 같이 기술했을 경우다.		
		*/
		String str1;
		str1 = "문자열";
		/*
		단순히 "문자열"등과 같이 기술하는 것만으로 String클래스의 객체의 생성된다.
		이 기술방법이 준비되어 있는 덕분에 화면에 문자열을 표시하고 싶은 경우등에는
		일일이 String클래스의 객체를 new 연산자를 사용하여 작성하지 않아도 여러 
		문자를 큰따옴표""로 묶기만 하면 됩니다.
			참조형 변수
		기본 데이터형의 값을 변수에 대입할 때 변수 자체가 값을 저장하는 용기로 되어
		있었습니다. 또한 배열을 변수에 대입한 때에는 용기는 다른 곳에서 제공 변수는
		용기의 위치가 포함되어 있었습니다.
		클래스의 객체를 변수에 할당하는 경우는 배열의 경우와 같이 참조 변수이다.
		따라서 String클래스의 객체를 생성하여 변수에 대입하면 먼저 용기가 따로
		준비되어 String클래스의 객체가 포함된 변수는 용기의 위치가 포함됩니다.
		문자열은 문자의 경우도 있고 긴 문자열의 경우도 있다. 문자수에 따라 필요한
		용기의 크기는 달라질 것이지만 String클래스의 변수는 용기의 위치만 저장되어
		있기 때문에 문자열이 어떤 문자도 동일하게 취급할 수 있다.
		*/
		/*	문자열 처리
		클래스의 객체를 변수에 할당하는 경우는 배열의 경우와 같이 참조변수이다.
		따라서 String클래스의 객체를 생성하여 변수에 대입하면 먼저 용기가 따로
		준비되어 String클래스의 객체가 포함된 변수는 용기의 위치가 포함된다.
		문자열은 한 개의 문자의 경우도 있고 긴문자열의 경우도 있숩니다.
		문자 수에 따라 필요한 용기의 크기는 달라질 것입니다만 String클래스의 
		변수는 용기의 위치만 저장되어 있기 때문에 문자열이 무엇이든지 동일하게 
		취급할 수 있다. "문자열 연결은 "+"연산자로 연결 할수있다.
		*/
		/*	문자열과 문자열 비교
		변수에 저장되는 값이 정수로 동일한 지 어떤지는 "==" 연산자를 사용하면된다.
		
		str1 = "abc";
		str2 = "abc"; 는 같다
		
		str1 = "abc";
		str2 = "ab";
		str2 = str2 + "c"; 는 같지 않다.
		
		이 경우에 필요한 게 
		equals 메소드
		오브젝트가 동일한 지를 검사하는 것이 아니라 객체에 저장되어있는 문자열이 
		단순히 동일한 지 String클래스에서 제공되는 equals메소드를 사용합니다.
		문자열객체1.equals(문자열객체2)
		이 경우 두 개의 문자열이 같을 경우 결과는 true가 된다.
		*/
		String st1 = "abc";
		String st2 = "abc";
		String st3 = "ab";
		System.out.println("st1 = " + st1);
		System.out.println("st2 = " + st2);
			if(st1 == st2) {
				System.out.println("같다");
			}else {
				System.out.println("같지 않음");
			}
		st3 = st3 + "c";
		System.out.println("st1 = " + st1);
		System.out.println("st3 = " + st3);
			if(st1 == st3) {
				System.out.println("같다");
			}else {
				System.out.println("같지 않음");
			}
		
		System.out.println("equals 메소드로 비교");
			if(st1.equals(st3)) {
				System.out.println("같다");
			}else {
				System.out.println("같지 않음");
				
			}
		/*	지정된 위치의 문자를 반환	
		문자열의 지정된 위치에 있는 문자를 취득할 수 있다.
		String에서 제공되는 charAt 메소드를 사용합니다.
		문자열.charAt(인덱스) 인덱스에 문자열에 포함된 문자마다
		순서대로 할당 된 번호이다	
		*/	
		String watch = "손목시계";
		char c1 = watch.charAt(0);
		char c2 = watch.charAt(1);
		char c3 = watch.charAt(2);
		char c4 = watch.charAt(3);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		/*
		문자열의 길이는 문자의 수이다.
		String클래스에서 제공되는 length메소드를 사용한다.
		문자열.length()
		문자열의 길이를 int형의 값으로 얻을 수 있다.
		*/
		System.out.println("문자열의 길이는 " + watch.length());
		for (int i = 0; i < watch.length(); i++) {
			char c = watch.charAt(i);
			System.out.println(c);
		}
			
			
	}
}
