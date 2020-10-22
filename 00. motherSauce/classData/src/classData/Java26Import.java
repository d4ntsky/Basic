package classData;

import java.util.Calendar;

public class Java26Import {
	public static void main(String[] args) {
	/*	import 구문
	클래스 라이브러리를 프로그램에서 사용하는데 알아야할 것이 있다. 예를 들어 Calendar
	클래스를 프로그램에서 사용하는 경우를 생각해 보면 Calendar클래스는 그 이름과 같이
	날짜 관계를 취급하기 위한 클래스에서 아래와 같이 정의되어있다.
	java.lang.Object
		|
		+ - java.util.Calendar
	간단한 샘플로 현재의 날짜를 표시하는 프로그램을 작성하려고 한다.
	*/
		java.util.Calendar cal1 = java.util.Calendar.getInstance();
		int month1 = cal1.get(java.util.Calendar.MONTH) + 1;
		int day1 = cal1.get(java.util.Calendar.DATE);
		System.out.println("오늘은 " + month1 + "월 " + day1 + "일입니다");
	/*
	클래스의 라이브러리로 제공되는 클래스를 프로그램에서 사용하는 경우에는 위와 같이
	"java.util.Calendar"과 같이 정의대로 작성해야한다. 단지 프로그램에서 
	반복 작성하는 경우에는 클래스 이름만으로 작성할 때 유용하다.
	   이러한 경우에는 import구문을 사용한다.
	import 패키지명.클래스명;
	java.util.Calendar 클래스의 경우 패키지 이름이 java.util이며,
	클래스 이름이 Calendar이다.
	import java.util.Calendar 라고 프로그램의 선두에 기술하는 것으로 
	프로그램에서 Calendar라고 작성하는 것만으로도 이용할 수 있다.
	*/
		Calendar cal2 = Calendar.getInstance();
		int month2 = cal2.get(java.util.Calendar.MONTH) + 1;
		int day2 = cal2.get(java.util.Calendar.DATE);
		System.out.println("오늘은 " + month2 + "월 " + day2 + "일입니다");
	
		
	/*	import의 예외
	모든 클래스 라이브러리를 import로 기술하지 않으면 작성할 수 없는 것은 아니라 java.lang
	패키지에 포함된 클래스는 import하지 않아도 클래스이름만 표기해서 사용할 수 있다.
	String클래스 정의는 아래와 같다.
	java.lang.Object
		|
		+ - java.lang.String
	  String클래스는 java.lang 패키지에 포함된 클래스이기 때문에 프로그램에서는
	java.lang.String str = new java.lang.String ("Hello");
	등과 같이 기술하지 않고
	String str = new String("Hello");
	라고만 작성하면 사용할 수 있었던 것이다.
	*/
		
	}
}
