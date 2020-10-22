package TaskBaseBall2;

import java.util.Scanner;

public class oopBaseball1 {
	/*
	1. random
	
	2. userInput
			
	3. finding
	
	4. message
					//234 loop
	5. result
	
	 */
	
	int r_num[] = new int[3]; 
	int u_num[] = new int[3]; 
	boolean clear = false;
	
	public void random() {
		
		boolean swit[] = new boolean[10];

		for (int i = 0; i < swit.length; i++) {
			swit[i] = false; // 00000 00000
		}

		int r, w;
		w = 0;
		
		while (w < 3) {
			r = (int) (Math.random() * 10); // 0~9
			if (swit[r] == false) {
				swit[r] = true; // 랜덤 숫자를 켜주는 00100 00000
				r_num[w] = r + 1; // 1~10
				w++;
			}
		}
		for (int i = 0; i < r_num.length; i++) {
			System.out.println(i + " : " + r_num[i]);//확인 출력
		}
		
		
		
	}
	
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		//user input u1 != u2 != u3
		boolean check;
		int w1;
		while(true) {
			check = false;
			w1 = 0;
			while(w1 < 3) {
				System.out.print((w1+1) + "번째수=");
				u_num[w1]= sc.nextInt();
				w1++;
			}
			//같은 숫자가 있는지 체크
			out:for (int i = 0; i < u_num.length; i++) {
				for (int j = 0; j < u_num.length; j++) {
					if(u_num[i] == u_num[j] && i != j) {
						check = true; //입력한 같은 숫자가 있음
						break out;
					}
				}
			}
			if(check == false) {
				break;
			}
			System.out.println("입력한 숫자 중에 중복되는 숫자가 있습니다. 다시 입력해 주십시오");
		}
	}
	
	
	public void finding() {
		int strike, ball;
		boolean clear = false;
		strike = ball = 0;
		
		// ball //자리가 다르고 
		for (int i = 0; i < u_num.length; i++) {
			for (int j = 0; j < r_num.length; j++) {
				if(u_num[i] == r_num[j] && i != j) {
					ball++;
				}
			}
		}
		// strike
		for (int i = 0; i < u_num.length; i++) {
			if(u_num[i] == r_num[i]) {
				strike++;
			}
		}
		// 탈출
		if(strike > 2) {
			
			
		}
		System.out.println(strike+ "스트라이크   "+ ball +"볼");
		
		
	}
	
	
	public void message() {
	
	}
	public void result() {
		 {
			if(clear) {
				System.out.println("게임 클리어");
			}else {
				System.out.println("게임 오버");
			}
		}
	}
	
}

