package Task0602_3_Dice;

import java.util.Scanner;

public class DicePlay {
	/*
	두개의 주사위 합을 맞히는 게임 제작 
	코인: 20개 
	합을 맞추면 제시한 숫자에 따라서 배당금이 달라집니다. 
	 
	2, 12 : 제시할 수없음 
	3, 11 : 18 배 
	4, 10 : 12 배 
	5, 9   : 9 배 
	6, 8   : 7 배 
	7      : 6 배 
	 
	배팅할 코인 수는? 				입력 
	입력 두 주사위의 합은? 			입력 (2, 12를 입력하면 다시 입력) 
	두 주사위의 합은? 				6
	주사위 번호 출력 				결과 출력
	 */	
	
	private int coin;
	private int batting;
	private int inputNumber;
	
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	
	public DicePlay() {
		dicePlay();
	}//3단계
	
	// 주사위 2개 (random)
	public void init() {
		coin = 20;
		dice1.diceRandom();
		dice2.diceRandom();
		System.out.println("주사위 1 : " + dice1.getNumber());
		System.out.println("주사위 2 : " + dice2.getNumber());
	}
	
	// 사용자 입력
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		
		//배팅금액 묻기
		System.out.println("batting money = ");
		batting = sc.nextInt();
		
		coin = coin - batting;
		
		System.out.println("두 개의 주사위의 합 = ");
		inputNumber = sc.nextInt();
	}
	
	// 판정
	public void finding() {
		//로컬 변수로
		int d_num1 = dice1.getNumber();
		int d_num2 = dice2.getNumber();
		
		int diceSum = d_num1 + d_num2;
		
		if(inputNumber == diceSum) {
			if(diceSum == 3 || diceSum == 11) {
				batting = batting * 18;
			}else if(diceSum == 4 || diceSum == 10) {
				batting = batting * 12;
			}else if(diceSum == 5 || diceSum == 9) {
				batting = batting * 9;
			}else if(diceSum == 6 || diceSum == 8) {
				batting = batting * 7;
			}else if(diceSum == 7) {
				batting = batting * 6;
			}
			System.out.println("축하합니다");
			coin = coin + batting;
		}else {
			System.out.println("아쉽습니다. 다시 도전 하십시오");
		}
		
	}

	// 결과 출력
	public void result() {
		System.out.println("주사위1 : " + dice1.getNumber());
		System.out.println("주사위2 : " + dice2.getNumber());
		
		System.out.println("합계 : " + dice1.getNumber() + dice2.getNumber());
		System.out.println("현재 Coin : " + coin);
	}
	
	//실무에서
	public void dicePlay() {
		init();
		userInput();
		finding();
		result();
	}//2단계
}