package day0609_3NameCard;

public class mainClass {

	public static void main(String[] args) {		

		NameCard ncard = new NameCard("홍길동", "123-4567", "hgd@naver.com");
		
		ncard.setPrintNameCard1(new PrintNameCard1());
		ncard.print1();
		
		ncard.setPrintNameCard2(new PrintNameCard2());
		ncard.print2();
	}

}