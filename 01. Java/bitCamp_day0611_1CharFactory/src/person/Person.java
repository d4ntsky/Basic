package person;

import bomb.Bomb;
import bomb.Dynamite;
import types.AbstractItem;
import types.Atype;
import arms.Sword;
import arms.Arms;

public class Person {
	
	public Arms m_Arms;
	public Bomb m_Bomb;
	
	public void create(AbstractItem ai) {
						//여기에 따라 달라짐
		
		m_Arms = ai.createArms();
		m_Bomb = ai.createBomb();
		

////진짜 필요한 부분
//else if(animalName.equals("야옹이")) {
//	return new Cat();
//}
//else if(animalName.equals("멍멍이")) {
//	return new Dog();
//}
//else if(animalName.equals("황소")) {
//	return new Cow();
//}
//return null;
//}
	}
}