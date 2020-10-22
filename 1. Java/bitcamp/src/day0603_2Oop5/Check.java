package day0603_2Oop5;

public class Check {
	
	public static void main(String[] args) {
		
//		Child c = new Child();
//		
//		c.method();
		
		Parent p = new Child(); //부모클래스의 instance 자식클래스의 영역 전체 
		//쓰임새 : 여러개의 자식클래스를 부모클래스에서 관리하기 위한..
		
		p.method(); // over riding을 했을때 부모클래스메소드가 아닌 자식클래스메소드로로 실행된다.
		
		//p.func(); // 되지않는다 부모클래스에서 존재하지 않는다 == intance 값이 parent로 되어있기 때문에
	}
}
//override 목적 - 관리 용이/하나의 instance로 관리하기 위해..
//override 규칙
//메소드의 완전하게 사양이 같아야함 public 이름() 완전 같아야...