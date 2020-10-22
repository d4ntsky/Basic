package day0603_1Oop4;

public class Check {

	public static void main(String[] args) {
		/*
			은닉성 : 접근 지정자를 통해서 외부로부터 접근을 차단, 허용해주는 것을 의미
					private(차단) - variable , public(허용) - method
					protected(자식클래스는 접근 가능) - 쓸 일이 많지는 않음
			상속성 : 부모 클래스에서 기능을 상속한다는 개념
					variable	method
					추가로 기능을 확장하는 경우
			다형성 : 상속 후에 여러 형태로 자식 클래스가 구현되는 것을 의미. 다른 형태를 의미
					부모가 직사각형이면 자식클래스는 정사각형 마름모 삼각형 원 ??
			super 
			Over Ride (받은 재산을 수정해서 확장해 사용 == 고쳐 기입) - 관리의 목적
		*/
		
		Child c = new Child(); //()에서 생성자가 호출된다. 부모클래스부터 생성자 챙기고 그다음 자식클래스
	
//		c.name = "일지매"; //protected 접근지정자 자식클래스에서 접근을 허용 하지만 외부에서 접근은 차단.
							//protected는 getter setter로 접근 가능하기 때문에 사용하지 않는다.
		
		c.Parent_method(); //상속을 받아서 사용 가능
		
		//@@ 세팅하고 싶다. 자식클래스에서 main까지
		Child cls = new Child(123);//(1)매개변수가 생성자
		cls.Parent_method();
		
		//extends
		//부모챙기고 자식한테 감 
		//super는 항 맨 위에 super를 통해 생성자 선택?
	}

}
