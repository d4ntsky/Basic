package Task0601_SandCastle;

import java.util.Scanner;

public class SandCastle {
	
	int rand_num;
	int user_num;
	boolean gameOver;
	
	public void init() {
		gameOver = false;
		setRandom();
	}
	
	public void setRandom() {
		rand_num = (int)(Math.random()*71) + 30;
		System.out.println("rand_num = " + rand_num);
	}
	
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//숫자 입력
			System.out.println("숫자를 입력해주세요(1 ~ 15)");
			user_num = sc.nextInt();
			//숫자 범위 체크
			if(user_num < 1 || user_num > 15) {
				System.out.println("범위를 벗어났습니다. 다시 입력해주십시오");
				continue;	//범위 벗어날시 다음 작업(break)를 실행하지 않도록
			}
			break;
		}
	}
	
	public void gamePlay() { 	//loop - 입력 받아서 빼주는
		while(true) {
			userInput();
			
			rand_num = rand_num - user_num; //처리 
			if(rand_num <= 0) {
				gameOver = true;
				break;
			}
			System.out.println("continue please...");
		}
	}
	
	public void result() {
		System.out.println("축하합니다. 당신이 걸렸습니다!!");
	}
}