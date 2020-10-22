package Task0520;

public class Task0520_Store {

	public static void main(String[] args) {
		/*
		 	편의점
		 	
		 	지불해야할 금액	:  3230원
		 	자신의 금액		: 10000원
		 	
		 	거스름돈		: 출력
		 	5000원		: ?장 1
		 	1000원		: ?장 1
		 	 500원		: ?개 1
		 	 100원		: ?개 2
		 	  50원		: ?개 1
		 	  10원		: ?개 2
		 */
		int myMoney;//내 돈 
		int price;//지불해야될 금액
		int changeMoney; //거스름돈
		
		myMoney = 10000;
		price = 1530; //받는 scan
		changeMoney = myMoney - price;
		
		//5000원
		int m5000 = changeMoney / 5000;
		//1000원
		int m1000 = (changeMoney % 5000) / 1000;
		// 500원
		int m500 = (changeMoney % 1000) / 500;
		// 100원
		int m100 = (changeMoney % 500) / 100;
		//  50원
		int m50 = (changeMoney % 100) / 50;
		//  10원
		int m10 = (changeMoney % 50) / 10;
		
		System.out.println("거스름돈 : " + changeMoney);
		System.out.println("5000: " + m5000);
		System.out.println("1000: " + m1000);
		System.out.println("500: " + m500);
		System.out.println("100: " + m100);
		System.out.println("50: " + m50);
		System.out.println("10: " + m10);

		
	}

}
