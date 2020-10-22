package day0602_1Oop3;
//public을 빼면 외부에서 못 읽
public class MyClass {

	// class member variable		99% - 멤버 변수는 거의 private
	private int number;		//private myClass 내부에서만 접근지정자
	public String name;		//public  myClass 외부에서도 접근 가능!
	
	// class member method  (1,2)		70% - public이 대부분 
	
	// setter와 getter - 은닉성 지정 가능
	//setter 외부에 값을 보내는 것
	
//	public void setNumber(int newNumber) {		//매개변수 다른거 쓰고 쓸 수 있지만 
//		number = newNumber;						//외부에서 들어오는
//	}
//	//getter 외부에 값을 가져오는 것
//	public int getNumber() {
//		return number;
//	}
//	Source -> generate getter setter
	
	//(1)
	public void func() {	//처리
		this.method();// member메소드에도 접근가능.
	}
	
	//this - 자기 자신
	public MyClass getThis() {
		return this;
	}
//getter setter generate-----------------------------------------------------------------
	
	public int getNumber() {			// 매개변수 0번째 존재하고 있는 자기 자신의 참조(주소)
		return number;
	}

	public void setNumber(int number) {	// number/this.number this는 구분자 
										//this가 붙는건 현재 멤버 안에 들어가 있는 것!
		this.number = number;			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//-----------------------------------------------------------------------------
	
	//(2)
	public void method() {
		
	}
	
}


