package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import person.Person;
import types.Atype;
import types.Btype;

public class mainClass {

	public static void main(String[] args) {
		
		Person char1 = new Person();
		char1.create(new Atype()); // <-- 핵심 부분
							//여기서 정해짐
		//처리 부분
		char1.m_Arms.drawArms();
		char1.m_Bomb.drawBomb();
		
		Person char2 = new Person();
		char2.create(new Btype());
		
		//List<E> 리스트에 넣어보기
	}
	

}