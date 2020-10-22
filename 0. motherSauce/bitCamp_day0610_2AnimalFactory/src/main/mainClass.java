package main;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;
import factory.AnimalFactory;

public class mainClass {

	public static void main(String[] args) {
		/*
			Singleton Pattern
				중심이 되는 데이터 관리 template(list, map)을 중심으로
				어느 클래스에서나 접근이 용이하게 하기위한 패턴
				instance가 한 개인 것을 의미.
			
			Factory Pattern 공장 -> Object
				원하는 클래스의 형태를 생성하기 위한 패턴.
				cf) 게임에서는 많이 쓰이는 편

			interface, class 동물
			
			class 고양이, 멍멍이, 황소
			
			Animal ani = new Cat();
		*/
		
		Animal ani1 = AnimalFactory.create("멍멍이");
		Animal ani2 = AnimalFactory.create("야옹이");
		Animal ani3 = AnimalFactory.create("황소");
		
		ani1.printDescript();
		ani2.printDescript();
		ani3.printDescript();
		
		//꺼낼때 cast변환
		((Dog)ani1).dogMethod();
		
		//---------------------------------------
		
		List<Animal> list = new ArrayList<Animal>(); 
								//게임에선 실시간이므로 LinkedList
		Animal ani = null;
		
		//						여기에 따라 바뀐다/외부 계수에 따라 결과가 바뀐다.
		String aname[] = {"황소","황소","야옹이","멍멍이","멍멍이","멍멍이" };
		for (int i = 0; i < aname.length; i++) {
			ani = AnimalFactory.create(aname[i]);
			list.add(ani);
		}
		
		/*
		==
		ani = AnimalFactory.create("황소");
		list.add(ani);
		ani = AnimalFactory.create("황소");
		list.add(ani);
		ani = AnimalFactory.create("야옹이");
		list.add(ani);
		ani = AnimalFactory.create("멍멍이");
		list.add(ani);
		ani = AnimalFactory.create("멍멍이");
		list.add(ani);
		ani = AnimalFactory.create("멍멍이");
		list.add(ani);
		*/	
		
		//출력	- 더 필요한 처리는 없다.
		for (int i = 0; i < list.size(); i++) {
			Animal a = list.get(i);
			a.printDescript();
			
			if(a instanceof Cat) {
				((Cat)a).catMethod();
			}
			else if(a instanceof Dog) {
				((Dog)a).dogMethod();
			}
			else if(a instanceof Cow) {
				((Cow)a).cowMethod();
			}
		}
	}
	//우리가 원하는 것을 상속으로 만들고 instance로 바꾼 다음 animalfactory에서 찍어내는
}