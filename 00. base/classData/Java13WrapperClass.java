package classData;

public class Java13WrapperClass {
	public static void main(String[] args) {
	/*	Wrapper 클래스
	Java에서는 기본데이터형이 준비되어있으며, 숫자나 문자를 저장하고 연산자와 연산하는
	경우라면 기본데이터형을 사용하면 충분합니다. 단지, 기본데이터형은 클래스처럼 메소드는
	포함되어 있지 않아서 기본데이터형에 대한 작업을 수행할 수 없습니다. 그래서 기본데이터형의
	값을 가질 수 있는 다양하고 편리한 방법을 제공하는 클래스가 준비되어있다.
	그것이 래퍼(Wrapper) 클래스의 객체를 생성하고 그 객체에 포함된 메소드의 이용이 
	가능합니다. 예를 들면, 숫자를 문자열로 변환하는 처리가 가능하다.
	기본데이터형과 해당 wrapper클래스의 목록을 살펴보면,

	기본데이터형		래퍼클래스
	boolean			Boolean
	char			Character
	byte			Byte
	short			Short
	int				Integer
	long			Long
	float			Float
	double			Double
	
	int형의 래퍼클래스는 Integer클래스 float형의 래퍼클래스는 Float클래스입니다.
	기본적으로 기본데이터형의 첫글자를 대문자로 한 것이 래퍼클래스의 이름이지만, 
	char형과 int형만 다르므로 주의하십시오. 또한 각 클래스는 다음과 같이 정의되어있다.
	각각의 정의에서 Boolean클래스와 Character클래스를 제외한 모든 클래스의 Number
	클래스라는 클래스의 자식클래스가 있다. 
	Number클래스의 자식클래스에는 다른 BigDecimal클래스나 BigInteger클래스가
	있고, Number클래스는 수치를 취급하기위한 기본 클래스이다.
	각 클래스에는 다양한 메소드가 준비되어 있지만, 다음 장에서는 래퍼클래스 중에서도 수치를
	취급하는 Byte,Short,Integer,Long,Float,Double 클래스의 기본적인
	사용법과 프로그래밍에서 가장 많이 사용되는 숫자와 문자열 변환에 대해 다뤄보겠다.
	*/
		
	/*	객체의 생성과 값의 설정	
	기본데이터형의 값에 대해 다양한 작업을 수행하려면 기본데이터형의 값을 가지는 래퍼클래스의
	객체를 생성한다. 그리고 생성된 객체에 대한 래퍼클래스로 준비된 다양한 방법을 사용하고있다.
	예를 들어 int형의 값을 가지는 Integer클래스의 객체를 만든다.
	new 연산자를 사용해 다음과 같이 기입한다.
	new Integer(int형의 값)
	인수는 int형의 값을 지정한다. 예를 들어 다음과 같이 기입한다.
	int i = 84;
	Integer oi = new Integer(i);
	다른 래퍼클랫도 마찬가지로 기본데이터형식의 객체를 만들 수 있다.
	byte b = 12;
	Byte ob = new Byte(b);
	short s = 32;
	Short os = new Short(s);
	long l = 153L;
	Long ol = new Long(l);
	float f = 3.24F;
	Float of = new Float(f);
	double d = 7.6;
	Double od = new Double(d);
	객체를 만들려면 그 밖에도 valueOf 메소드를 사용하는 방법도 있다.
		오토 복싱
	J2SE5.0 이상에선 오토복싱(Autoboxing)이라 하는 기능을 제공한다. 간단히
	말하면 본래 래퍼클래스의 객체를 기입해야할 때, 래퍼클래스를 지원하는 기본데이터형의
	값을 작성하면, 자동으로 변환해준다는 의미다.
	int i = 84;
	Integer oi = i;
	이것은 다음과 같이 기입했을 경우와 같다.
	int i = 84;
	Integer oi = new Integer(i);
	객체를 생성하지않고 단순히 기본데이터형의 값을 기입하는 것으로 되기때문에 프로그램을
	간결하게 기입할 수 있다. 자동 변환이 된다.
	*/
		int in = 84;
		Integer oin = new Integer(in);
		System.out.println(oin.intValue());
		//오토복싱을 이용
		Long olo = 153L;
		System.out.println(olo.longValue());
	/*
	이 샘플에서는 래퍼클래스의 값을 얻기 위해 intValue메소드와 longValue메소드를
	사용하고 있다.
	*/	
		
	/*	값의 취득
	래퍼클래스의 객체를 생성하면 해당 객체에 대응하는 기본데이터형의 값을 유지하고있다.
	여기에서는 객체가 가진 값을 얻는 방법을 확인한다. 값을 얻으려면 각 클래스에 정의 된
	메소드를 사용한다. 예를 들어 Integer클래스의 객체에서 값을 검색하려면 Integer
	클래스에서 제공되는 intValue메소드를 사용한다.
	int i = 84;
	Integer oi = new Integer(i);
	int val = oi.intValue();
	intValue메소드는 객체가 가지는 값을 int형의 값으로 반환한다. 또한 Integer
	클래스에는 값을 long값으로 반환 longValue메소드나 double형의 값으로 반환
	doubleValue메소드 등도 준비돼있다.
	Byte 클래스			byte byteValue()
	Short 클래스			short shortValue()
	Integer 클래스		int	intValue()
	Long 클래스			long longValue()
	Float 클래스			float floatValue()
	Double 클래스			double doubleValue()
	그러면 예로 Short클래스와 Double클래스의 객체에서 각각 short형의 값을 산출할
	경우와 double형의 값을 산출하는 방법을 살펴보겠다.
	short s = 32;
	Short os = new Short(s);
	int sval = os.shortValue();
	double d = 7.6;
	Double od = new Double(d);
	double oval = od.doubleValue();
		오토 복싱
	값을 취득하는 경우에도 오토 복싱을 사용할 수 있다. 예를 들면
	int i = 84;
	Integer oi = i;
	int val = oi;
	이것은 다음과 같은 경우다.
	int i = 84;
	Integer oi = new Integer(i);
	int val = oi.intValue();
	오토 복싱을 사용하여 래퍼클래스의 객체를 마치 기본데이터형과 같이 처리할 수 있습니다.
	오토 복싱 기능에 의해 자동으로 변환된다.
	*/
	
	/*	숫자를 문자열로 변환	
	int형의 값이나 float형 값을 문자열(String클래스의 객체)로 변환하는 방법을
	봅니다. 단순히 출력만하고 싶으면 문자열로 변환할 필요는 없지만 문자열로 변환하여
	처리하고 싶은 경우, String클래스에서 제공되는 메소드를 사용할 수 있습니다.
	변환하는 방법은 3가지가 있다.
	(1)toString 메소드를 사용
	기본데이터형을 래퍼클래스의 객체로 변환한 후, 각 래퍼클래스에서 제공되는 toString
	메소드를 사용하여 문자열로 변환하는 방법이다. toString메소드는 객체의 문자열
	표현을 반환한다.
	int i = 84;
	Integer oi = new Integer(i);
	String str = oi.toString();
	(2)valueOf 메소드를 사용
	valueOf메소드는 대상이 되는 값의 종류마다 다음과 같은 메소드가 준비되어있다.
	static String valueOf (boolean b)
	static String valueOf (char c)
	static String valueOf (double d)
	static String valueOf (float f)
	static String valueOf (int i)
	static String valueOf (long l)
	valueOf메소드는 인수에 지정된 값의 문자열 표현을 반환한다. 예를 들어
	int i = 84;
	String str = String.valueOf(i);
	이 경우 인수는 래퍼클래스의 객체가 아니라 기본데이터형의 값을 직접 지정한다. 또한
	short형과 byte형의 인수가 있는 메소드는 없지만, 두 데이터형의 값을 valueOf
	메소드의 인수로 지정해도 문자열을 얻을 수 있습니다. 아마도 자동으로 int형으로 
	변환되어 메소드가 실행된다.
	(3)+연산자를 사용
	"+" 연산자는 문자열과 숫자가 대상인 경우에는 숫자를 문자열로 변환하고 연결한다.
	때문에, 기본데이터형의 값과 빈 ""를 "+"연산자로 연결하여 숫자를 문자열로 변환할
	수 있다. 예를 들어
	int i = 84;
	String str = ""+i;
	"+" 연산자의 대상값 중 하나가 문자열이기 때문에 다른 값인 숫자를 문자열로 변환하고
	연결한다. 연결하는 왼쪽 문자열은 빈 문자열이므로 결과적으로 숫자를 문자열로 변환한
	것이 대입된다.
	*/	
		
	/*	문자열에서 숫자로 변환
	숫자 형식 문자열을 숫자로 변환하는 방법은 3가지가 있다.
	(1)parsexxx메소드를 사용
	xxx부분은 래퍼클래스마다 다르다.
	Byte클래스: 		static byte parseByte (String s)
	Short클래스: 		static short parseShort (String s)
	Integer클래스:	static int parseInt (String s)
	Long클래스: 		static long parseLong (String s)
	Float클래스: 		static float parseFloat (String s)
	Double클래스: 	static double parseDouble (String s)
	예를 들어 Integer클래스에서 제공되는 parseInt메소드는 인수에 지정된 문자열을
	정수 값으로 해석하고 int형의 값으로 반환한다. 실제로는 다음과 같이 기입한다.
	String str ="124";
	int i = Integer.parseInt(str);
	또한 정수가 아닌 숫자의 문자열을 parseInt메소드를 사용해서 변환하려고 하거나
	원래 수치 형식이 아닌 문자열로 변환하려고 하면 컴파일 에러는 없지만 실행 시
	"java.lang.NumberFormatException:For input string" 
	오류가 발생한다. 이 경우다.
	String str = "124.567";
	int i = Integer.parsesInt(str);
	또한 범위를 초과한 숫자의 문자열을 변환하려고 하면, 컴파일 에러는 없지만 실행시에
	"java.lang.NumberFormatException:Value out of range"
	오류가 발생한다. 이 경우다.
	String str = "198667234";
	byte b = Byte.parseByte(str);
	두 경우 모두 컴파일시에는 오류가 발생하지 않는다.
	(2)valueOf메소드를 사용
	각 클래스마다 반환 값이 다른 메소드가 준비되어있다.
	Byte클래스: 		static Byte valueOf (String s)
	Short클래스: 		static Short valueOf (String s)
	Integer클래스:	static Integer valueOf (String s)
	Long클래스: 		static Long valueOf (String s)
	Float클래스: 		static Float valueOf (String s)
	Double클래스: 	static Double valueOf (String s)
	예를 들어 Integer클래스에서 제공되는 valueOf메소드는 인수에 지정된 문자열이
	나타내는 정수값을 가지는 Integer클래스의 객체를 반환한다.
	실제로는 다음과 같이 작성한다.
	String str = "124";
	Integer oi = Integer.valueOf(str);
	이 또한 기본데이터형의 값이 아닌 대응하는 래퍼클래스의 객체를 반환한다는 점을 주의
	해야한다. 지정한 경우에는 앞에서와 같이 런타임 오류가 발생한다.
	(3)생성자를 사용
	래퍼클래스의 생성자의 인수에 문자열을 지정하는 방법이다.
	Byte클래스: 		Byte (String s)
	Short클래스: 		Short (String s)
	Integer클래스:	Integer (String s)
	Long클래스: 		Long (String s)
	Float클래스: 		Float (String s)
	Double클래스: 	Double (String s)	
	예를 들어, Integer클래스의 객체를 생성할 때 문자열을 지정하면, 인수에 지정된
	문자열이 나타내는 정수값을 가지는 Integer클래스의 객체를 만든다.
	String str = "124";
	Integer oi = new Integer(str);
	수치 형식이 아닌 문자열을 지정하거나 범위를 초과하는 숫자 형식 문자열을 지정한 경우
	에는 앞에서와 같이 런타임 오류가 발생한다.	
	*/
		String str1 = "124";
		String str2 = "73";
		String str3 = "4.987";
		
		int i = Integer.parseInt(str1);
		Byte ob = new Byte(str2);
		Double od = Double.valueOf(str3);
		System.out.println(i);
		System.out.println(ob.byteValue());
		System.out.println(od.doubleValue());
	}
}

