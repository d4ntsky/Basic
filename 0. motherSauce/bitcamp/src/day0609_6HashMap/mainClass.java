package day0609_6HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class mainClass {

	public static void main(String[] args) {
		/*
			HashMap	: 사전
						"사과" : "apple"
						key	  :  value  -> 1 pair	== web json이 이렇게 쓰임 key : value
						Tree 구조 		key는 중복되지 않는다
							o
						  o   o
						o  o o  o
						
						List : 선형 구조 o-o-o
						cf) node 연결고리
						cf) insert delete update select - select/search 가 가장 중요
						
						TreeMap = HashMap + Sorting(key)
		
		*/
		
		HashMap<Integer, String > hMap = new HashMap<Integer, String>();
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		TreeMap<Integer,String> tMap = new TreeMap<Integer, String>(map);
		
		//추가-----------------------------------------------------------------
			   //key   value
		hMap.put(111, "백십일");
		hMap.put(222, "이백이십이");
		hMap.put(333, "삼백삽십삼");
		//value 취득
		String value = hMap.get(222);
		System.out.println("value : " + value);
		
/*		//삭제-----------------------------------------------------------------
		//찾아야되는건 key값.
		String val = hMap.remove(222);
		//value 값을 넘기면서 지워지게...
		value = hMap.get(222);
		System.out.println("value : " + value);
*/		
		
		//검색-----------------------------------------------------------------
			// 있다/없다 확인
		boolean b = hMap.containsKey(new Integer(333)); //정석
		System.out.println("b = " + b);	//있기때문에 true
			// 값을 취득
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println("value : " + value);
		}
		
		//수정-----------------------------------------------------------------
		hMap.put(111,"100+10+1");		//수정하는 함수는 아님
		hMap.replace(222, "200 + 22");  //정석
		
		//모두 출력 -------------------------------------------------------------
		//0 ~ n-1가 아님; 순서대로 데이터가 저장되어 있지는 않다.
		//key값을 모두 취득 => iterator 반복자
		Iterator<Integer> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			Integer key = it.next();	//넘어오는 건 key값 
			System.out.println("key : " + key);
			
			String _value = hMap.get(key);
			System.out.println("value: " + _value);
		}//검색할때는 key값이 중복되면 안된다.
		
		System.out.println("=========================================================");	
	//------------------------------------------------------------------
		HashMap<String, String> haMap = new HashMap<String, String>();
		haMap.put(new String("apple"),new String("사과"));	//정석
		haMap.put("pear", "배");
		haMap.put("grape", "포도");
		haMap.put("banana", "바나나");
		
		//취득
		value = haMap.get("grape");
		System.out.println("value: " + value);
		
		//모두 출력
		Iterator<String> sit = haMap.keySet().iterator();
		while(sit.hasNext()) {
			String key = sit.next();
			String _val = haMap.get(key);
			System.out.println("key : " + key + "\t  value: " + _val);
		}
		
		System.out.println("=========================================================");	
	//------------------------------------------------------------------
		// sorting
		// TreeMap <--> HashMap
		TreeMap<String, String> treeMap = new TreeMap<String, String>(haMap);
		
		//오름
//		Iterator<String> itKey = treeMap.keySet().iterator();
		
		//내림
		Iterator<String> itKey = treeMap.descendingKeySet().iterator();
		
			//오름차순 내림차순 확인
		while(itKey.hasNext()) {
			String key  = itKey.next();
			System.out.println("key : " + key + "\t  value: " +treeMap.get(key));
		}
		System.out.println("=========================================================");	
	//------------------------------------------------------------------
		
		HashMap<Integer, MyData> dMap = new HashMap<Integer, MyData>();
		
		
		//추가
		dMap.put(1001, new MyData(1, " 홍길동"));
		
		//삭제
		
		//검색
		
		//수정
		
		//출력
	
	}

}
