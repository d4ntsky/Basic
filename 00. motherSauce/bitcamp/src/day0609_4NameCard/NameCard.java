package day0609_4NameCard;

public class NameCard {

	String name;
	String phone;
	String email;
	
	//class가 아닌 interface로 선언
	PrintNameCard printNameCard;
	
	//돌려보기위한 생성자
	public NameCard(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	//
	
	
	public void setPrintNameCard(PrintNameCard p) {
		this.printNameCard = p;
	}
	
	public void print() {
		printNameCard.print(this);
	}
	
	
}
