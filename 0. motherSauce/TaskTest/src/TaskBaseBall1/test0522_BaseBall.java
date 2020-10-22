package TaskBaseBall1;

import java.util.Scanner;

public class test0522_BaseBall {
	public static void main(String[] args) {
		//야구게임
		//랜덤 숫자를 만들고
		//유저가 숫자 3개 적고
		//메세지 출력 볼 스트라이크 아웃
		//기회 10번
		//결론 아웃 나오면 다시하냐 묻는거

		
		int rnum1;
		rnum1 = (int)(Math.random() * 10);
		int rnum2;
		rnum2 = (int)(Math.random() * 10);
		int rnum3;
		rnum3 = (int)(Math.random() * 10);
		//다른 숫자 세개 만드는거
		//for(int i = 0,i < 10;i++) {
		//	if(rnum1 != rnum)
		//}
		
		loopout:for(int i = 0;i<100;i++) { //맨앞 loopout부분 단어선택 가능 - java만있고 c언어는없음
				for(int j = 0;j<100;j++) {
					if( rnum1 != rnum2 && rnum1 != rnum3) {
					}
					if( rnum2 != rnum3 && rnum2 != rnum3) {
						break loopout;
					}
				}
			}		
		
		System.out.println(rnum1 + " "  + rnum2 + " " + rnum3);
		
		
		
		
		
		
	
		System.out.println(rnum1 + " "  + rnum2 + " " + rnum3);
		
		//번호받기 랜덤번호랑 비교하기
		Scanner sc = new Scanner(System.in);
		int num1;
			System.out.println("숫자를 입력해주세요");
			num1 = sc.nextInt();
		int num2;
			System.out.println("숫자를 입력해주세요");
			num2 = sc.nextInt();
		int num3;
			System.out.println("숫자를 입력해주세요");
			num3 = sc.nextInt();
		System.out.println(num1 + " "  + num2 + " " + num3);
					
		
		
		if(num1 == rnum1) {
			System.out.print("스트라이크");
		}else if(num1 == rnum2) {
			System.out.print("볼");
		}else if(num1 == rnum3) {
			System.out.print("볼");
		}else {}
		
		if(num2 == rnum2) {
			System.out.print("스트라이크");
		}else if(num2 == rnum1) {
			System.out.print("볼");
		}else if(num2 == rnum3) {
			System.out.print("볼");
		}else {}
		
		if(num3 == rnum3) {
			System.out.print("스트라이크");
		}else if(num3 == rnum1) {
			System.out.print("볼");
		}else if(num3 == rnum2) {
			System.out.print("볼");
		}else {}
	
		
	}
}		