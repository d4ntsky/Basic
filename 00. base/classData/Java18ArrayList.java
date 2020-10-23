package classData;

public class Java18ArrayList {
	public static void main(String[] args) {
	/*	ArrayList 클래스	
	ArrayList 클래스는 크기가 정해지지 않은 배열로 생각하면 된다. ArrayList 클래스는
	"java.util.ArrayList"와 같이 java.util 클래스에 정의되어있다. ArrayList
	를 사용하려면 먼저 ArrayList 클래스의 객체를 만든다. ArrayList 클래스는 생성자
	중 하나는 아래와 같이 돼있다.
	ArrayList
	public ArrayList ()
	초기에는 10으로 빈 리스트를 작성한다. 크기는 변경이 가능하지만 일단 초기 크기로 10개의
	요소를 포함할 수 있는 ArrayList를 만들어준다. 이 크기가 부족해지면 자동으로 확장된다.
	객체의 생성은 new 연산자를 사용하여 생성하지만 이전 버전의 Java에서는 아래와 같이 
	만들었다.
	ArrayList 변수이름 = new ArrayList();
	J2SE5.0 이후는 아래와 같이 작성한다.
	ArrayList<형식>변수이름 = new ArrayList<형태>();
	클래스 뒤에 <>로 둘러싸여 형식을 지정하는 부분이 있다. J2SE5.0에서 새로 도입된
	Generics 기능으로 이 ArrayList에 어떤 형식의 값을 저장할지 여부를 지정한다.
		Generics
	이 형태의 부분에는 클래스를 지정한다. 그리고 요소로 저장할 수 있는 값이 여기에 지정된
	클래스의 객체이다. 주의해야할 점은 String은 되지만 int나 float는 지정할 수 없다.
	String은 클래스지만 int나 float클래스는 아니고 기본자료형이기 때문이다. 그래서
	int형과 float형 등의 기본형을 취급하고 싶은 경우에는 각 기본형에 대한 클래서 (래퍼
	클래스)가 준비돼있기 때문에 그것을 이용한다.
	Boolean,Character,Byte,Short,Integer,Long,Float,Double
	예를 들어 정수를 저장할 ArrayList와 String을 포함한 ArrayList를 만들려면
	다음과 같이한다.
	ArrayList<Integer>array = new ArrayList<Integer>();
	ArrayList<String>array = new ArrayList<String>();
		값 저장
	ArrayList 클래스의 객체를 생성한 후 실제로 요소를 추가한다.
	ArrayList 클래스에서 제공되는 add 메소드를 사용한다.
	add
	public boolean add (E o)
	리스트의 마지막에 지정된 요소를 추가한다.
	파라미터:
	o-리스트에 추가되는 요소
	반환값:
	true(Collection.add의 범용 규약대로)
	이 메소드를 사용하면 목록의 맨 마지막에 데이터가 추가된다. 예를 들어 문자열을
	포함하는 ArrayList를 만들고 요소를 포함하는 경우, 아래와 같이 된다.
	ArrayList<String>array = new ArrayList<String>();
	array.add("대한민국");
	array.add("브라질");
	array.add("잉글랜드");
	위의 생략한 기술이며, 다음과 같이 기입한 것과 동일하다.
	ArrayList<String>array = new ArrayList<String>();
	array.add(new String("대한민국"));
	array.add(new String("브라질"));
	array.add(new String("영국"));
	이렇게 지정된 클래스의 객체를 계속해서 추가된다. 배열의 경우는 정해진 수의 크기만큼
	요소를 포함할 수 있었지만 컬렉션의 경우 크기를 자동으로 확장해주기 때문에, 포함하는
	요소의 수를 걱정하지않고 추가할 수 있다. 또한 포함 된 요소는 지정된 순서대로 0부터
	시작하는 인덱스가 지정된다. 다음 기본 형식을 사용하는 경우이다.
	기본 형식은 그대로는 사용할 수 없으므로 기본형에 해당하는 래퍼 클래스를 사용한다.
	ArrayList<Integer>array = new ArrayList<Integer>();
	array.add(10);
	array.add(8);
	array.add(12);
	String의 경우와 비슷하지만 의미가 다르다. 래퍼 클래스와 기본 형식을 사용하는 경우에
	더 단순화해서 사용할 수 있게 해준 것이다.
		요소의 산출
	다음 저장된 요소를 산출한다. ArrayList클래스에서 제공되는 get메소드를 사용한다.
	get
	public E get(int index)
	목록에서 지정된 위치에 있는 요소를 리턴한다.
	파라미터:
	index - 요소의 인덱스
	반환값:
	목록에서 지정된 위치에 있는 요소
	예외:
	IndexOutOfBoundsException
	- 인덱스가 범위 외의 경우 (index < 0 || index >= size())
	인덱스 번호를 지정하여 그 번호에 해당하는 요소를 꺼낸다. ArrayList 클래스의 기본
	기능은 이러한 요소를 저장하고 인덱스 번호를 지정하여 요소를 검색할 수 있다.
import java.util.ArrayList;
class collectionTest1 {
	public static void main(String[] args) {
		ArrayList<String>array = new ArrayList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("영국");		
		array.add("포르투갈");
		array.add("프랑스");
		String country = array.get(2);
		System.out.println(country);
	}
}
컴파일 하고 실행하면 영국
	*/
		
	/*	저장되는 요소 수
	ArrayList 클래스의 객체를 사용하는 경우에 현재 저장되어있는 요소 수를 확인하려면
	ArrayList 클래스에서 제공되는 size 메소드를 사용한다.
	size
	public int size()
	리스트 내에 있는 요소의 수를 리턴한다.
	반환값:
	리스트 내의 요소 수
	배열과 달리 ArrayList 클래스의 객체는 여러 요소가 포함되어 있는지 정해져 있지않기
	때문에 이 메소드를 이용하여 등록되어있는 요소 수를 확인한다.
import java.util.ArrayList;
class collectionTest2 {
	public static void main(String[] args) {
		ArrayList<String>array = new ArrayList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("영국");		
		array.add("포르투갈");
		array.add("프랑스");	
		System.out.println("등록 데이터 개수 : " + array.size());
		for(int i = 0; i < array.size(); i++ ) {
			String country = array.get(i);
			System.out.println(country);
		}
	}
} 결과는
등록 데이터 개수 : 5
대한민국
브라질
영국
포르투갈
프랑스
	*/
		
	/*	요소의 수정
	이미 저장돼있는 요소를 다른 요소로 수정한다. ArrayList 클래스에서 제공되는 
	set 메소드를 사용한다.
	set
	public E set(int index, E element)
	목록의 지정된 위치에 있는 요소를 새로 지정한 요소로 수정한다.
	파라미터:
	index	- 치환되는 요소의 인덱스
	element - 지정된 위치에 저장된 요소
	반환값:
	지정된 위치에 이전 있던 요소
	예외:
	IndexOutOfBoundsException - 인덱스가 범위 외의 경우
import java.util.ArrayList;
class collectionTest3 {
	public static void main(String[] args) {
		ArrayList<String>array = new ArrayList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("영국");		
		array.add("포르투갈");
		array.add("프랑스");	
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		System.out.println("\r\n 3번째 요소에 이탈리아로 수정합니다 \r\n");
		array.set(2, "이탈리아");\
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
	}
} 컴파일 하면
대한민국
브라질
영국
포르투갈
프랑스

3번째 요소에 이탈리아로 수정합니다.

대한민국
브라질
이탈리아
포르투갈
프랑스
	*/
		
	/*	요소 검색	
	ArrayList 클래스에 등록돼있는 요소 중에서 지정한 요소가 있는지 검색한다.
	ArrayList 클래스에 제공되는 indexOf 메소드를 사용한다.
	indexOf
	public int indexOf(Object elem)
	equals 메소드를 사용해서 동일한 지를 판정하면서, 지정된 인수와 같은 내용의 요소를
	선두로부터 검색한다.
	파라미터:
	elem - 객체
	반환값:
	목록에서 인수가 최초로 나타나는 인덱스. 객체가 없는 경우 -1 찾고 요소를 인수로 지정하면
	ArrayList 클래스의 객체 내에 포함되는 요소의 처음부터 검색을 실시 먼저 찾은 요소의
	인덱스를 반환해준다. 또한 indexOf는 처음부터 검색하지만 마지막부터 검색하기 위한
	lastIndexOf 메소드도 준비돼있다.
	lastIndexOf
	public int lastIndexOf(Object elem)
	지정된 오브젝트가 리스트 내에서 마지막에 나타나는 인덱스를 리턴한다.
	파라미터:
	elem - 목적의 요소
	반환값:
	목록에 지정된 오브젝트와 일치하는 오브젝트의 인덱스. 객체가 없는 경우 -1
	ArrayList<String>array = new ArrayList<String>();
	array.add("서울");
	array.add("부산");		
	array.add("대구");
	array.add("광주");
	System.out.println(array.indexOf("서울"));		//0
	System.out.println(array.lastIndexOf("서울"));	//0
import java.util.ArrayList;
class collectionTest4 {
	public static void main(String[] args) {
		ArrayList<String>array = new ArrayList<String>();
		array.add("서울");
		array.add("부산");		
		array.add("대구");
		array.add("광주");
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		String word = "서울";
		int first = array.indexOf(word);
		System.out.println(word + "에 대해 검색합니다");
		if(first != -1) {
			System.out.println("인덱스 번호는 " + first);
		}
		int last = array.lastIndexOf("서울");
		if(last != -1) {
			System.out.println("인덱스 번호는 " + last);
		}
	}
}컴파일 실행 결과
서울
부산
대구
광주
서울을 검색합니다
인덱스 번호는 0
인덱스 번호는 0
	*/
		
	/*	요소 삭제
	다음 ArrayList 클래스에 등록되어있는 요소 중에서 지정한 인덱스 번호의 요소를
	삭제해본다. ArrayList 클래스에서 제공되는 remove 메소드를 이용한다.
	remove
	public E remove (int index)
	목록에서 지정된 위치로부터 요소를 삭제합니다. 그리고 후속의 요소를 이동시켜서
	각각 인덱스로부터 1씩 뺀다.
	파라미터:
	index - 삭제되는 요소의 인덱스
	반환값:
	목록에서 삭제한 요소
	예외:
	IndexOutOfBoundsException - 인덱스가 범위 외의 경우 
	(index < 0 || index >= size())
	삭제하려는 요소의 인덱스 번호를 지정하여 요소를 제거한다. 삭제된 요소 다음에 저장
	되어있던 요소는 자동으로 인덱스 변호는 1씩 줄어든다.(항목이 제거될 때마다 처음부터
	채워 다시 배치된다. 그러므로 ArrayList는 항목을 추가하거나 제거 속도가 느려진다)
	또한 모든 요소를 삭제하고 싶은 경우엔 clear 메소드를 사용한다.
	clear
	public void clear()
	목록에서 모든 요소를 제거한다. 호출하면 리스트는 0이 된다.
	ArrayList<String>array = new ArrayList<String>();
	array.add("서울");
	array.add("부산");
	array.add("대구");
	array.add("광주");
	array.remove(1);
	array.clear();
import java.util.ArrayList;
class collectionTest5 {
	public static void main(String[] args) {
		ArrayList<String>array = new ArrayList<String>();
		array.add("서울");
		array.add("부산");
		array.add("대구");
		array.add("광주");	
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		System.out.println("두번째 항목을 제거합니다.");
		array.remove(1);
		for(int i = 0; i < array.size(); i++) {
			String country = array get(i);
			System.out.println(country);
		}
		System.out.println("대구의 항목을 제거합니다.");
		array.remove(array.indexOf("대구"));
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		System.out.println("모든 항목을 제거합니다.");
		array.clear();
		System.out.println("현재 항목 수는 " + array.size() + "입니다.");
	}
}컴파일 결과는
서울
부산
대구
광주
두번째 항목을 제거합니다.
서울
대구
광주
대구의 항목을 제거합니다.
서울
광주
모든 항목을 제거합니다.
현재 항목 수는 0입니다.
	 */
		
	/*
package com.dbs.jcf.test;
public class TVProgramDto {
	private String title;
	private String broadcast;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBroadcast() {
		return broadcast;
	}
	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}
	@Override
	public String toString() {
		return title + "(" + broadcast + ")\n";
	}
}
package com.dbs.jcf.test;
public clss DramaDto extends TVprogramDto {
	private String director;
	private String actor;
	private String actress;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	@Override
	public String toString() {
		String str = super.toString() + "-감독:" + director + "\n";
		if(actor != null)
			str += "-남자배우:" + actor + "\n";
		if(actress != null)
			str += "-여자배우:" + actress + "\n";
		return str;
	}
}
package com.dbs.jcf.test;
import java.util.ArrayList;
import java.util.List;
public class DramaListTest {
	public static void main(String[] args) {
		List<DramaDto>list = new ArrayList<DramaDto>();
		DramaDto d1 = new DramaDto();
		d1.setTitle("그겨울");
		d1.setBroadcast("SBS");
		d1.setDirector("남규태");
		d1.setActor("조인성");
		d1.setActress("송혜교");
		DramaDto d2 = new DramaDto();
		d2.setTitle("백년");
		d2.setBroadcast("MBC");
		d2.setDirector("조성우");	
		DramaDto d3 = new DramaDto();
		d3.setTitle("아이리스");
		d3.setBroadcast("KBS");
		d3.setDirector("표민수");
		d3.setActor("장혁");
		d3.setActress("이다혜");
		DramaDto d4 = new DramaDto();
		d4.setTitle("최고다");
		d4.setBroadcast("KBS");
		d4.setDirector("윤성식");
		d4.setActress("아이유");
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		int size = list.size();
		for(int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
}
	*/
		
	}
}
