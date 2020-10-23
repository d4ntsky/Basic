package Task0525;

public class Task0525_Trump {
	public static void main(String[] args) {
		// 트럼프(카드) 52장
		// A(1) 2~10 J(11) Q(12) K(13)
		// 00~51
		// 00~12 -> 스페이드
		// 13~25 -> 다이아
		// 26~38 -> 하트
		// 39~51 -> 클로버
		/*
		 * 출력예식 랜덤숫자 -> 모양번호 실제값 실제번호 숫자 13 다이아1 숫자 3 스페이드4 : :
		 */
		int number[] = new int[52]; // 실제 랜덤 변수
		boolean swit[] = new boolean[52]; // 중복을 체크
		int r, w;

		// initialize - init
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		w = 0;

		// 0~51 -> 1~52
		// 알고리즘 4대요소
		// 셔플(shuffle), 정렬(효율), 트리, 탐색(속도)
		while (w < 52) {
			r = (int) (Math.random() * 52); // 0~51
			if (swit[r] == false) {// switch가 꺼져있을때
				swit[r] = true;
				number[w] = r + 1;
				w++;
			}
		}
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}

		int cardNum; // 1~13
		int cardPic; // 0~3 0:스페이드 1:다이아 2:하트 3:클로버

		// 숫자
		for (int i = 0; i < number.length; i++) {
			cardNum = (number[i] % 13) + 1; // 1~13

			if (cardNum == 1) { // A
				System.out.print("Card number : " + number[i] + ", " + "A");
			} else if (cardNum == 11) { // J
				System.out.print("Card number : " + number[i] + ", " + "J");
			} else if (cardNum == 12) { // Q
				System.out.print("Card number : " + number[i] + ", " + "K");
			} else if (cardNum == 13) { // K
				System.out.print("Card number : " + number[i] + ", " + "Q");
			} else {
				System.out.print("Card number : " + number[i] + ", " + cardNum);
			}

			// 그림
			cardPic = number[i] / 13; // -~3

			switch (cardPic) {
			case 0:
				System.out.println(", 스페이드");
				break;
			case 1:
				System.out.println(", 다이아");
				break;
			case 2:
				System.out.println(", 하트");
				break;
			case 3:
				System.out.println(", 클로버");
				break;
			}
		}
	}
}