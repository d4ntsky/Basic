package TaskSorting1;

import java.util.Scanner;

public class Task0529_SortingFuction2 {
	/*
	1. 입력(숫자들, 오름/내림차순

	2. 정렬처리
		swap()
		
	3. 출력

	*/
	public static void main(String[] args) {
	
	int number[] = null;
	// int count;
	boolean updown[] = new boolean[1]; // address에 의한 할당
		
// 1. 입력==============================================================
	number = userInput(updown);
	
// 2. 정렬처리===========================================================
	sorting(number, updown[0]);
	
// 3. 결과==============================================================
	result(number, updown[0]);
	
	
	
	
	
	
	}
	
//1. 입력==============================================================
	
	//함수의 prototype //소스코드는 process 안에
	static int[] userInput(boolean ud[]) {
		Scanner sc = new Scanner(System.in);
		
		//정령할 갯수?
		System.out.print("정렬할 갯수는 = ?");
		int count = sc.nextInt();
		
		//정렬할 숫자를 동적할당
		int number[] = new int[count];
		
		//정렬할 숫자를 입력
		for (int i = 0; i < number.length; i++) {
			System.out.print((i + 1) + "번째 수 =");
			number[i] = sc.nextInt();
		}
		//오름차순1/내림차순2
			System.out.print("오름(1)/내림(2) = ");
			int updown = sc.nextInt();
			//위에 boolean도 됨
			ud[0] = (updown == 1)?true:false;
		
		return number;
	}
	
//2. 정렬처리==============================================================
	static void sorting(int number[], boolean updown) { //리턴 값은 없어도됨 배열 할당
		//swap용
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown) {	
					if(number[i] > number[j]) {
							swap(number, i, j);
					}
				}else {			
					if(number[i] < number[j]) {
							swap(number, i, j);
					}
				}
			}
		}	
	}
//2-1 정렬처리 안 swap====================================================
	static void swap(int number[], int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
// 3. 결과==============================================================
	static void result(int number[], boolean updown) {
		String msg = "";
		if(updown) msg = "오름";
		else	   msg = "내림";
		System.out.println(msg + "차순으로 정렬하였으며,");
		for (int i = 0; i < number.length; i++) {
			System.out.println(i+ ":" + number[i]);
		}
	}
	
}
