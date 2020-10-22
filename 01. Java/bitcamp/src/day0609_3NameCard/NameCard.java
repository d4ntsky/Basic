package day0609_3NameCard;
				
public class NameCard {
				//명찰
	String name;
	String phone;
	String email;
	
	
	//
	public NameCard(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	//

	//멤버 변수 instance
	PrintNameCard1 printNameCard1;
	

	//명함에 필요한 값을 준비해서			//외부에서 들어오는 값
	public void setPrintNameCard1(PrintNameCard1 p) {
		this.printNameCard1 = p;		//으로 출력
	}
	
	//출력
	public void print1() {
		printNameCard1.print(this);
	}
	
	//----------------------------------------------------------------
	
	//추가 - 이럴때 사용하는게 인터페이스
	PrintNameCard2 printNameCard2;
	
	public void setPrintNameCard2(PrintNameCard2 p) {
		this.printNameCard2 = p;		//으로 출력
	}
	
	//출력
	public void print2() {
		printNameCard2.print(this);
	}
	
	
}