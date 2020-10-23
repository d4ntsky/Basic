package factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class AnimalFactory {
	
	// Factory로 원하는 형태의 클래스를 생성하는 게 목적 
	public static Animal create(String animalName) {
				  //부모 interface
		//안 달아놓아도됨
		if(animalName.equals("")) {
			System.out.println("생성할 클래스가 없습니다");
		}
		//진짜 필요한 부분
		else if(animalName.equals("야옹이")) {
			return new Cat();
		}
		else if(animalName.equals("멍멍이")) {
			return new Dog();
		}
		else if(animalName.equals("황소")) {
			return new Cow();
		}
		return null;
	}
}
