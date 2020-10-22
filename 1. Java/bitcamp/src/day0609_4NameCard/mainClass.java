package day0609_4NameCard;

public class mainClass {

	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("홍길동", "123-4567", "hgd@naver.com");
//		NameCard ncard2 = new NameCard("일지매", "987-6543", "ijm@naver.com");
		
		ncard.setPrintNameCard(new PrintNameCard1()); //
		ncard.print();
		System.out.println("-----------------------------------------------------");
		
		ncard.setPrintNameCard(new PrintNameCard2()); //
		ncard.print();
		System.out.println("-----------------------------------------------------");
		
		//확장은 여기서만 됨
		//NameCard 부분을 비교하면 전자는 계속 늘어나고 확장 클래스까지 늘어나지만
		//					     후자는 확장 클래스만 늘어난다.
	}
}
