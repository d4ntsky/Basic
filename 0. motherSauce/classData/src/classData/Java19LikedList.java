package classData;

public class Java19LikedList {
	public static void main(String[] args) {
	/*	LinkedList 클래스
	ArrayList와 비슷하지만, 안에 포함되는 요소를 별도로 관리하고 있기 때문에 요소를
	추가하거나 제거할 때, ArrayList에 비해 고속으로 동작한다. 반대로 요소를 검색을
	하려는 경우, 처음부터 순서대로 링크를 따라 검색하기 때문에 ArrayList에 속도가
	느리다. 때문에 빈번하게 요소를 추가하거나 제거할 경우에 적합한 클래스다.
	LinkedList를 사용하려면 먼저 LinkedList클래스의 객체를 만든다. LinkedList
	클래스의 생성자 중 하나는 아래와 같다.
	LinkedList
	public LinkedList()
	빈 리스트를 작성한다.
	
	다음 new 연산자를 사용해 LinkedList 객체를 만든다.
	LinkedList<형식>변수이름 = new LinkedList<형태>();
	ArrayList 클래스와 동일하게 저장하는 LinkedList와 String을 저장하는
	LinkedList를 만들려면 다음과 같이 한다.
	LinkedList<Integer>array = new LinkedList<Integer>();
	LinkedList<String>array = new LinkedList<Strng>();
	*/
		
	/*	요소의 추가, 산출
	요소의 추가는 LinkedList클래스에서 제공되는 add 메소드를 사용한다.
	add
	public boolean add(E o)
	목록의 뒤에 지정된 요소를 추가한다.
	파라미터:
	o - 리스트에 추가되는 요소
	반환값:
	true(Collection.add의 일반 규약에 따른다)
	add를 사용하면 마지막에 추가된다. 이것은 ArrayList클래스의 경우와 동일하다.
	
	다음 추가할 위치를 지정하여 요소를 추가하는 방법이 있다.
	같은 add메소드에서 인수가 다른 메소드가 준비되어있으면
	add
	public void add(int index, E element)
	리스트의 지정된 요소를 삽입한다. 현재 그 위치에 있는 요소와 후속의 요소는 다음
	인덱스로 이동한다. (인덱스 값에 1을 가산)
	파라미터:
	index - 지정된 요소가 삽입되는 인덱스
	element - 삽입되는 요소
	예외:
	IndexOutOfBoundsException - 지정된 인덱스가 범위 외의 경우
	(index < 0 || index > size())
	
	지정된 인덱스 번호에 요소를 추가한다. 해당 인덱스 번호에 원래있던 요소와 그 이후의
	요소의 인덱스는 +1씩 가산되어 그 다음 노드로 이동하게 된다. 또한 리스트의 처음과
	마지막에 요소를 추가하는 메소드가 준비돼있다.
	addFirst메소드 
	addFirst
	public void addFirst(E o)
	리스트의 선두에 지정 된 요소를 삽입합니다.
	파라미터:
	o-리스트의 선두에 삽입되는 요소
	addLast메소드
	addLast
	public void addLast(E o)
	리스트의 마지막에 지정 된 요소를 추가합니다.
	add메소드와 같은 기능이다.
	파라미터:
	o-리스트의 마지막에 삽입되는 요소
	
	다음 저장된 요소를 산출한다. 지정된 인덱스 번호 위치에 있는 요소를 가져온다. 
	LinkedList 클래스에서 제공되는 get 메소드를 이용한다.
	get
	public E get(int index)
	리스트에서 지정된 위치에 있는 요소를 리턴한다.
	파라미터:
	index - 변환되는 요소의 인덱스
	반환값:
	목록에서 지정된 위치에 있는 요소
	예외:
	IndexOutOfBoundsException - 지정된 인덱스가 범위 외의 경우
	(index < 0 || index > size())
	
	LinkedList<String>array = new LinkedList<String>();
	array.add("대한민국");
	array.add("브라질");
	array.add("잉글랜드");
	array.add(1, "포르투갈");
	String country = array.get(2);
import java.util.LinkedList;
class collectionTest6 {
	public static void main(String[] args) {
		LinkedList<String>array = new LinkedList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("잉글랜드");
		array.add(1, "포르투갈");
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
	}
}컴파일하면
대한민국
포르투갈
브라질
잉글랜드
	*/	
		
	/*	요소의 수정 및 삭제
	다음 이미 저장되어있는 요소의 수정(Updat)이다. 지정한 인덱스 번호에 저장되어있는
	요소를 새 요소로 바꿉니다. 	LinkedList 클래스에서 제공되는 set 메소드를 사용
	합니다.
	set
	public E set(int index, E element)
	리스트의 지정한 위치에 요소를 수정한다.
	파라미터:
	index - 치환되는 요소의 인덱스
	element - 지정된 위치에 저장되는 요소
	반환값:
	지정된 위치에 이전 있던 요소
	예외:
	IndexOutOfBoundsException - 지정된 인덱스가 범위 외의 경우
	(index < 0 || index >= size())
	
	다음 요소를 삭제하는 방법은 다음과 같다.
	LinkedList 클래스에서 제공되는 remove 메소드를 사용한다.
	remove
	public E remove(int index)
	리스트의 지정된 위치에 있는 요소를 삭제한다.
	연결된 요소가 앞으로 1씩 이동한다.(인덱스 값으로부터 1을 감산)
	파라미터:
	index - 삭제되는 요소의 인덱스
	반환값:
	지정된 위치에 이전 있던 요소
	예외:
	IndexOutOfBoundsException - 지정된 인덱스가 범위 외의 경우
	(index < 0 || index >= size())
	삭제하려는 요소의 인덱스 번호를 지정하여 요소를 제거한다. 삭제된 요소 다음에 저장되어
	있던 요소는 자동으로 인덱스 넘버는 1씩 줄어든다.(ArrayList와 달리 요소의 재배치
	하지 않기때문에 비교적 고속으로 처리된다.) 또한 모든 요소를 삭제하고 싶은 경우에는
	clear 메소드를 사용한다.
	clear
	public void clear()
	리스트에서 모든 요소를 삭제한다.
	
	LinkedList<String>array = new LinkedList<String>();
	array.add("대한민국");
	array.add("브라질");
	array.add("잉글랜드");
	array.set(1, "이탈리아");
	array.remove(0);	
import java.util.LinkedList;
class collectionTest7 {
	public static void main(String[] args) {
		LinkedList<String>array = new LinkedList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("잉글랜드");
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		System.out.println("\r\n 두번째 나라로 이탈리아로 업데이트합니다\r\n");
		array.set(1, "이탈리아");
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		System.out.println("\r\n 선두 국가를 삭제합니다 \r\n");
		array.remove(0);
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
	}
}컴파일 후
대한민국
브라질
잉글랜드
 
 두번째 나라로 이탈리아로 업데이트합니다
 
대한민국
이탈리아
잉글랜드

 선두 국가를 삭제합니다
 
이탈리아
잉글랜드
	*/	
		
	/*	요소 검색
	여기에서 LinkedList에 등록되어있는 요소 중에서 지정한 요소가 있는지를 검색한다.
	기본적으로 ArrayList와 동일하다. LinkedList클래스에서 제공되는 indexOf
	메소드를 사용한다.
	indexOf
	public int indexOf(Object o)
	리스트에서 지정한 요소의 검출된 위치의 인덱스를 리턴한다. List에 이 요소가 없는
	경우는 -1을 리턴한다. 인덱스가 없는 경우는 -1을 리턴한다.
	파라미터:
	o-검색하는 요소
	반환값:
	리스트에서 지정된 요소가 최초로 검출된 위치의 인덱스. 또한 indexOf는 처음부터
	검색하지만 마지막부터 검색하기위한 lastIndexOf메소드도 준비되어 있다.
	lastIndexOf
	public int lastIndexOf(Object o)
	리스트에서 지정된 요소를 마지막부터 검출된 위치의 인덱스를 리턴한다. 리스트에 이
	요소가 없는 경우는 -1을 돌려준다.
	파라미터:
	o-검색하는 요소
	반환값:
	목록에서 지정된 요소가 마지막에 검출된 위치의 인덱스
	리스트에 요소가 없는 경우는 -1
	LinkedList<String>array = new LinkedList<String>();
	array.add("대한민국");
	array.add("브라질");
	array.add("대한민국");
	array.add("잉글랜드");	
	System.out.println(array.indexOf("대한민국"));		//0
	System.out.println(array.lastIndexOf("대한민국"));	//2
import java.util.LinkedList;
class collectionTest8 {
	public static void main(String[] args) {
		LinkedList<String>array = new LinkedList<String>();
		array.add("대한민국");
		array.add("브라질");
		array.add("대한민국");
		array.add("잉글랜드");	
		for(int i = 0; i < array.size(); i++) {
			String country = array.get(i);
			System.out.println(country);
		}
		String word = "대한민국";
		int first = array.indexOf(word);
		System.out.println(word+9"을 검색합니다");
		if(first != -1) {
			System.out.println("첫번째 인덱스 번호는 " + first);
		}
		int last = array.lastIndexOf(word);
		if(last != -1) {
			System.out.println("마지막 인덱스 번호는 " + last);
		}
	}
}컴파일 시
대한민국
브라질
대한민국
잉글랜드
대한민국을 검색합니다
첫번째 인덱스 번호는 0
마지막 인덱스 번호는 2
	*/	
		
	/*	행렬처럼 이용
	LinkedList는 가변 길이의 배열로서 알고리즘은 큐로 되어 있다. 큐이란 선입선출
	(FIFO)라는 방식의 하나로 먼저 추가된 데이터가 먼저 처리된다는 것이다. 예를들어
	불만접수센터 같은 곳의 업무를 생각해보면, 불만 전화가 자꾸 걸려오므로 처리해야 
	목록에 추가하게 되며, 그 다음으로 불만이 온 순서대로 처리해 나갈 것이다. 이 경우
	새로 걸려온 불만은 리스트의 마지막에 추가하고 처리할 때 목록의 맨 선두에 있는 불만
	부터 처리한다. 이러한 방식을 선입선출이라고 한다.
	지금까지 본 적이 메소드에서도 요소를 추가할 때는 리스트의 마지막에 추가하고 처리할
	때는 인덱스 번호가 0번째 용소를 제거하거나 처리해 나갔지만, 선입선출을 사용하는 
	경우, 일반적인 메소드이름이 같은 기능에도 다른 메소드 이름이 포함되어 있는 것이다.
	
	새로운 요소를 리스트의 마지막에 추가하려면 LinkedList클래스에서 제공되는
	offer메소드를 사용한다.
	offer
	public boolean offer(E o)
	지정된 요소를 리스트의 끝(마지막 요소)에 추가한다.
	파라미터:
	o-추가하는 요소
	반환값:
	true(Queue.offer의 일반 규약에 따른다)
	
	다음 산출하는 방법이다. 목록의 맨 앞에 있는 원소를 꺼내려면 LinkedList 클래스에서
	제공되는 peek메소드를 사용한다.
	peek
	public E peek()
	이 리스트의 선두(최초의 요소)를 가져오지만 삭제는 하지 않는다.
	반환값:
	큐의 선두, 큐가 빈 경우는 null
	
	또한 element메소드도 peek과 같은 기능이다. 단지 요소가 없는데 산출하려고 하면, 이
	쪽은 예외를 리턴한다.
	element
	public E element()
	이 리스트의 선두(최초의 요소)를 가져오지만 삭제는 하지 않는다.
	반환값:
	큐의 선두
	예외
	NoSuchElementException - 큐가 비어있는 경우
	
	또한 유사한 기능이지만, 선두의 요소를 산출하면서 동시에 선두의 요소를 삭제하는 메소드도
	준비되어 있다. poll메소드와 remove지만, poll의 경우 요소가 없는 경우는 NULL을
	리턴하지만, remove메소드의 경우는 예외를 리턴한다.
	
	poll메소드
	poll
	public E poll()
	이 리스트의 선두(최초의 요소)를 취득하고 삭제한다.
	반환값:
	큐의 선두, 큐가 빈 경우는 null
	
	remove메소드
	remove
	public E remove()
	이 리스트의 선두(최초의 요소)를 취득하고 삭제한다.
	반환값:
	큐의 선두
	예외:
	NoSuchElementException - 큐가 비어있는 경우
	
	LinkedList<String>array = new LinkedList<String>();
	array.offer("색상이 다르다")
	array.offer("사이즈가 맞지 않는")
	array.offer("깨진")
	System.out.println(array.poll());
	System.out.println(array.poll());
	array.offer("상품이 다르다")
	System.out.println(array.poll());
	System.out.println(array.poll());
import java.util.LinkedList;
	class collectionTest9 {
		public static void main(String[] args) {
			LinkedList<String>array = new LinkedList<String>();
			array.offer("색상이 다르다")
			array.offer("사이즈가 맞지 않는")
			array.offer("깨진")
			System.out.println(array.poll());
			System.out.println(array.poll());
			array.offer("상품이 다르다")
			System.out.println(array.poll());
			System.out.println(array.poll());
	}
}컴파일시
색상이 다르다
사이즈가 맞지 않는
깨진
상품이 다르다
	*/	
		
	/*	PizzeDto
public class PizzaDto {
	private int price;
	private String name;
	privata int size;			// 0 : re // 1 : la
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return price + "\t\t" + name + "\t\t" + (size==0?"regular":"large"); 
	}
}
	*/
	/*	PizzaList
import java.util.ArrayList;
import java.util.List;
public class PizzaList {
	List<PizzaDto>list;
	public PizzaList() {
		list = new ArrayList<PizzaDto>();
	}
	public static void main(String[] args) {
		PizzaDto p1 = new PizzaDto();
		p1.setPrice(18000);
		p1.setName("고르곤졸라");
		p1.setSize(0);
		PizzaDto p2 = new PizzaDto();
		p2.setPrice(17000);
		p2.setName("포테이토");
		p2.setSize(1);
		PizzaDto p3 = new PizzaDto();
		p3.setPrice(21000);
		p3.setName("슈퍼슈프림");
		p3.setSize(1);
		PizzaDto p4 = new PizzaDto();
		p4.setPrice(20000);
		p4.setName("콤비네이션");
		p4.setSize(0);
		PizzaList pl = new PizzaList();
		pl.list.add(p1);
		pl.list.add(p2);
		pl.list.add(p3);
		pl.list.add(p4);
		pl.sales();
		System.out.println("왕새우감자 25000 large 주문!!!!");
		PizzaDto p5 = new PizzaDto();
		p5.setPrice(25000);
		p5.setName("왕새우감자");
		p5.setSize(1);
		pl.list.add(p5);
		pl.sales();
		System.out.println("포테이토 피자의 가격이 19000원으로 변동!!!");
		int size = pl.list.size();
		for(int i = 0; i < size; i++) {
			PizzaDto dto = pl.list.get(i);
			if("포테이토".equals(dto.getName())) {
				dto.setPrice(19000);
				break;
			}
		}
		pl.sales();
	}
	public void sales() {
		System.out.println("------판매 현황------");
		System.out.println("가격\t\t상품명\t\t크기");
		System.out.println("------------------");
		int size = list.size();
		for(int i = 0; i < size; i++) {
			System.out.println(System.out.println(list.get(i)));
		}
	}
}
	*/
	}
}