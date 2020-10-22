package day0609_5LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Linkedlist {

	public static void main(String[] args) {
		/*
			ArrayList	: 검색, 대입 		==	 	Vector

			LinkedList	: 실시간 추가/삭제의 처리가 빠르다 
		*/
		
		/*
		ArrayList<String> list = new ArrayList<String>();			//class
		
		List<String> elist = new ArrayList<String>();				//interface
		//L 누르고 java.util
		
		List<String> alist = new LinkedList<String>();//자식클래스?
		*/
		
		//검색시 사용하다.
		ArrayList<String> alist = new ArrayList<String>();
		
		alist.add("tigers");
		alist.add("rions");
		alist.add("twins");
		
		//alist.add - first last 기능 없음 
		
		//추가, 삭제시 사용하다 > 다시 arraylist로
		LinkedList<String> blist = new LinkedList<String>( alist );
		
		for (String str : blist) {
			System.out.println(str);
		}
		
		//비어있나 묻는 
		if(blist.isEmpty()) { // blist.size() == 0 
		}
		
		//맨 앞에 element를 추가 - arraylist엔 없음
		blist.addFirst("giants");
		
		//맨 뒤에 element를 추가 - arraylist엔 없음
		blist.addLast("bears");
		
		for (int i = 0; i < blist.size(); i++) {
			String str = blist.get(i);
			System.out.println(i + " : " + str);
		}
		
		//iterator : 반복자 == 포인터(주소) 0x10 -> 0x14 -> 0x18 - 속도가 더 빠르긴 함
		
		Iterator<String> it; 
		
		it = blist.iterator();
				  
				  //다음게 있냐
		while(it.hasNext()) {
			String value = it.next();
			System.out.println("it : " + value);
		}
	}

}
