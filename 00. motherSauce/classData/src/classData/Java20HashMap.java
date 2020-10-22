package classData;

public class Java20HashMap {
	public static void main(String[] args) {
	/*	HashMap
	지금까지 요소는 인덱스 번호로 연결되어있었지만, HashMap의 경우, 핵심 문자열과
	요소가 쌍(pair)을 이루고있다. 예를 들어 "사과" 키에 해당하는 요소가 "Apple"
	이 된다. 이러한 요소를 등록할 때, 그에 대한 키를 문자열 드에 따라 지정 요소를 검색
	하거나 제거할 때, 키를 사용하여 요소를 지정한다.
	HashMap은 요소를 포함할 때, 요소에 대응하는 키를 등록한다. 예를 들어, 제품에
	대한 가격을 등록하는 경우, 상품의 가격을 요소로 등록함과 동시에 상품명을 키로
	등록하여 상품명을 사용하여 제품 가격을 검색할 수 있게 된다.
	
	HashMap을 사용하려면, 먼저 HashMap클래스의 객체를 만든다. HashMap클래스의
	생성자 중 하나는 아래와 같이 되어있다.
	HashMap
	public HashMap()
	디폴트의 초기 용량(16)과 디폴트의 부하 계수(0.75)로 하늘의 HashMap을 작성한다.
	초기 용량은 초기에 많은 요소를 포함한 공간을 확보하는 것이다. 공간이 부족해지면
	자동으로 확장된다. 또한 부하 계숙와 용량을 어느 타이밍에 확장할 지 여부를 나타내는
	것이다. 부하 계수가 0.75의 경우, 전체 용량의 75%까지 요소로 가득하면, 공간을
	확대한다는 것이다.
	
	다음 new 연산자를 사용하여 HashMap 객체를 만든다.
	HashMap<유형1,유형2>변수이름 = new HashMap<유형1,유형>();
	HashMap의 경우는 자료형을 2개 지정한다. 첫번째는 키, 두번째는 요소이다.
	예를 들어 키를 Integer형, 요소를 String형으로 한 경우는 아래와 같다.
	HashMap<Integer,String> map = new HashMap<Integer,String>();
	키			요소
------------------------
	1000		텔레비전
	1001		비디오
	2000		에어컨
	
	또한 키를 String형, 요소를 String형으로 한 경우는 아래와 같게된다.
	HashMap<String,String> map = new HashMap<String,String>();
	키			요소
---------------------------
	텔레비전		Television
	비디오		Video
	시계			Watch
	*/
	
	/*	요소의 추가, 산출
	요소를 포함하려면, HashMap클래스에서 제공되는 put메소드를 사용한다.
	put
	public V put (K key, V value)
	지정된 값과 지정된 키를 맵에 추가한다. 맵이 이전에 같은 키의 값을 보관하고 있었을 경우
	에는 대체한다. 그러니까 키의 중복을 받아들이지 않는다.
	파라미터:
	key   - 지정되는 값을 관련된 키
	value - 지정되는 키에 관련된 값
	반환값:
	지정된 키에 관련한 값
	요소와 해당키로 맵에 등록한다. 이미 키가 등록되어 있었을 경우 그 키에 해당하는 요소가
	이 메소드에 지정된 요소로 수정된다.
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("사과","apple");
	map.put("포도","grapes");
	
	요소를 산출한다. 요소를 제거하려면 키를 지정해서 그 키에 해당하는 요소를 검색할 수 있다.
	HashMap 클래스에서 제공되는 get메소드를 사용한다.
	get
	public V get(Object	key)
	해시맵에서 지정된 키에 해당하는 요소를 리턴한다. 맵이 해당키의 값을 보관하지 않는 경우는
	null을 리턴한다.
	파라미터:
	key - 관련 지을 수 있었던 값이 반환되는 키
	반환값:
	맵이 지정된 키에 맵핑되어 있는 값. 
	이 키에 대한 요소가 맵에 없는 경우는 null. 예를 들면
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("사과","apple");
	map.put("포도","grapes");
	System.out.println(map.get("사과"));
	또한 요소를 검색하기 전에 요소를 지정하는 키가 맵에 등록되어있는지를 먼저 확인하는 
	것도 가능하다. HashMap 클래스에서 제공되는 containsKey메소드를 사용한다.
	containsKey
	public boolean containsKey(Object key)
	맵이 지정된 키의 맵핑을 보관, 유지하는 경우에 true에 리턴한다.
	파라미터:
	key - 맵에 있을지 판정되는 키
	반환값:
	맵이 지정된 키의 맵핑을 보관 유지하는 경우는 true
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("사과","apple");
	map.put("포도","grapes");
	if(map.containsKey("사과")) {
		System.out.println(map.get("사과"));
	}
	else {
		System.out.println("지정된 키가 존재하지 않습니다");
	}
import java.util.HashMap;
class hashmapTest1 {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("사과","apple");
		map.put("포도","grapes");
		if(map.containsKey("사과")) {
			System.out.print("사과를 영어로 하면");
			System.out.println(map.get("사과"));
		}
		else {
			System.out.println("지정된 키가 존재하지 않습니다");
		}
	}
}컴파일시
사과를 영어로 하면 apple
	*/
		
	/*	요소의 제거
	여기에서는 요소의 삭제에 대해서 살펴보겠다. 맵에서 요소를 제거하려면, HashMap
	클래스에서 제공되는 remove 메소드를 사용한다.
	remove
	public V remove(Object key)
	키에 대한 맵핑이 있으면, 그 키를 맵으로부터 삭제한다.
	파라미터:
	key - 맵핑이 맵으로부터 삭제되는 키
	반환값:
	지정된 키에 관련한 값 또는 키의 맵핑이 없었던 경우는 null
	
	또한 모든 요소를 한꺼번에 삭제하는 경우에는 HashMap클래스에서 제공되는 
	clear 메소드를 사용한다.
	clear
	public void clear()
	모든 매핑을 맵으로부터 삭제한다. 메소드를 실행하면 모든 요소가 제거된다.
import java.util.HashMap;
class hashmapTest2 {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("사과","apple");
		map.put("포도","grapes");
		if(map.containsKey("사과")) {
			System.out.print("사과를 영어로 하면 ");
			System.out.println(map.get("사과"));
		}
		else {
			System.out.println("지정한 키가 존재하지 않습니다");
		}
		map.remove("포도");
		if(map.containsKey("포도")) {
			System.out.print("포도를 영어로 하면 ");
			System.out.println(map.get("포도"));
		}
		else {
			System.out.println("지정한 키가 존재하지 않습니다");
		}
	}
}컴파일시
사과를 영어로 하면 apple
지정한 키가 존재하지 않습니다
	*/	
	
	/*	MapTest
package com.dbs.jcf.collection;
import java.util.HashMap;
import java.util.Map;
public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(31, "정수빈");
		map.put(50, "김현수");
		map.put(17, "오재원");
		int num = 31;
		System.out.println("등번호 " + num + "인 선수는??");
		String name = map.get(num);
		System.out.println(num + "인 선수는 " + name + "입니다.");
		MapTest mt = new MapTest();
		mt.sales();
	}
	public void sales() {
		System.out.println("------판매 현황------");
		System.out.println("가격\t\t상품명\t\t크기");
		System.out.println("------------------");
	}
}
	*/
		
	/*	PizzaMap
import java.util.*;
public class PizzaMap {
	Map<String,PizzaDto> map = new HashMap<String, PizzaDto>();
	public static void main(String[] args) {
		PizzaMap pm = new PizzaMap();
		
		PizzaDto p1 = new PizzaDto(); //p1r
		p1.setPrice(18000);
		p1.setName("고르곤졸라");
		p1.setSize(0);
		PizzaDto p2 = new PizzaDto(); //p2l
		p2.setPrice(17000);
		p2.setName("포테이토");
		p2.setSize(1);
		PizzaDto p3 = new PizzaDto(); //p3l
		p3.setPrice(21000);
		p3.setName("슈퍼슈프림");
		p3.setSize(1);
		PizzaDto p4 = new PizzaDto(); //p4r
		p4.setPrice(20000);
		p4.setName("콤비네이션");
		p4.setSize(0);
		
		pm.map.put("p1r",p1);
		pm.map.put("p2l",p2);
		pm.map.put("p3l",p3);
		pm.map.put("p4r",p4);
		
		String code - "p2l";
		System.out.println(code + " 상품정보??");
		PizzaDto dto = pm.map.get(code);
		System.out.println("상품코드: " + code + 
						 "\t상품이름: " + dto.getName() +
						 "\t상품가격: " + dto.getPrice() +
						 "\t사이즈: "   + dto.getSize());
		pm.sales();
	}
	public void sales() {
		System.out.println("------판매 현황------");
		System.out.println("가격\t\t상품명\t\t크기");
		System.out.println("------------------");
		Set<String> set = map.keySet();
		int size = set.size();
		String key[] = set.toArray(new String[0]);
		for(int i = 0; i < size; i++) {
			PizzaDto dto = map.get(key[i]);
			System.out.println(dto);
		}
	}
}
	*/
	}
}
