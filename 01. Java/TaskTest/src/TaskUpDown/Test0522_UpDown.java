package TaskUpDown;

import java.util.Scanner;

public class Test0522_UpDown {
	public static void main(String[] args) {
		//random 넘버 뽑기
		//user로부터 값 받아서
		//값에 따라 작다 크다
		//10번 기회에 못맞추면 실패
		//맞추면 축하하고 리플레이?
		
		int rnum;
		rnum = (int)(Math.random() * 100) + 1;

		Scanner sc = new Scanner(System.in);
		int inNum;
			System.out.println("숫자를 입력해주세요");
			inNum = sc.nextInt();
		
	for(int i = 0; i < 9; i++) {
				if(inNum > rnum) {
					System.out.println("down 다시 입력해주세요");
					inNum = sc.nextInt();
					
				}else if(inNum < rnum){
					System.out.println("up	  다시 입력해주세요");
					inNum = sc.nextInt();
					
				}else
					System.out.println("정답");
							
			}
		System.out.println("숫자는 " + rnum + "였습니다.");
		System.out.println("다시 도전 하시겠습니까?");
		
	}
}