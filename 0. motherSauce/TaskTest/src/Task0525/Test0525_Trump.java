package Task0525;

public class Test0525_Trump {

	public static void main(String[] args) {
		//트럼프(카드) 52장
		//A(1) 2~10 J(11) Q(12) K(13)
		// 00~51 
		// 00~12 -> 스페이드
		// 13~25 -> 다이아
		// 26~38 -> 하트
		// 39~51 -> 클로버
		/*	출력예식
		 *  랜덤숫자 -> 모양번호
		 *  실제값	실제번호
		 * 	숫자 13	다이아1
		 *  숫자 3	스페이드4
		 *  		:
		 *  		:
		 */
		
		int rCard = new int[52];
		boolean shuf = new boolean[52];
		
		for (int i = 0; i < shuf.length; i++) {
			shuf[i] = false;
		}
		int r, w;
		w = 0;
		//swit[0] = true; 제외수 주는..
		
		while (w < 3) {
			r = (int) (Math.random() * 52); // 0~9
			if (shuf[r] == false) {
				shuf[r] = true; // 랜덤 숫자를 켜주는 00100 00000
				rCard[w] = rCard + 1; // 1~10
				w++;
			}
		}
		for (int i = 0; i < rCard.length; i++) {
			System.out.println(i + " : " + rCard[i]);
		}
		//____________________
//		int r;
//		r = rCard;
//		if(r < 13) { 
//			System.out.println();
//		}else if(r<26) {
//			
//		}else if(r<39) {
//			
//		}else {52-r}
//			
//		}
//		
			
	}
}
	