package day0522;
import java.util.Scanner;
public class Ex3Continue {
	public static void main(String[] args) {
		/*
			continue :	skip(생략)
						그 다음 처리 생략
						for, while
		
			loop{
				처리1
				처리2
				if continue
				처리3 <- 처리하지 않고 생략된다
			}
		
		*/
		
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			System.out.println("for start");
			if(i > 5) {//6,7,8,9 처리가 되지않고 skip
				continue;
			}//5는 계속하고 그 다음 밑의 처리가 생략된다는 뜻 (for end가 출력안됨)
			System.out.println("for end");
		}
		
		//실제 예시
		Scanner sc = new Scanner(System.in);
		
		//=========================================
		int numArr[] = new int[3];
		int n;
		
		for(int i = 0 ; i < numArr.length; i++) {
			System.out.print((i + 1) + "번째 수 = ");
			n = sc.nextInt();
			if(n < 0) {
				System.out.println("음수입니다.");
				continue;
			}
			numArr[i] = n;
		}
		for(int i = 0 ; i < numArr.length; i++) {
			System.out.println("numArr[" + i + "] = " + numArr[i]);
		}
		//---------------다 똑같고 for문과 while의 차
		int w = 0;
		int arrNum[] = new int[3];
		while(w < 3) {
			System.out.print((w + 1) + "번째 수 = ");
			n = sc.nextInt();
			if(n < 0) {
				System.out.println("음수입니다");
				continue;
			}
			arrNum[w] = n;//이 둘 때문에
			w++;//루프가 빠져나가지 못함 제대로 적을때까지 
		}
		for(int i = 0 ; i < arrNum.length; i++) {
			System.out.println("arrNum[" + i + "] = " + arrNum[i]);
		}
		
		//for문과 while문이 continue 사용이 달리되고 
		//기입시 while if 문을 더 사용한다.
	sc.close();
	}
	

}