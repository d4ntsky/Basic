package TaskSorting2;

import java.util.Scanner;

public class oopSorting {
	//멤버 변수(두 가지 이상 처리(method)해서 접근해야 하는 경우)
	int number[];
	//오름차순 내림차순
	boolean updown;
	
	// 처리
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정렬할 갯 수 = ");
		int count = sc.nextInt();
		
		number = new int[count];
		
		for (int i = 0; i < number.length; i++) {
			System.out.print((i+1) + "번째 수 = ");
			number[i] = sc.nextInt();
		}
		System.out.print("오름(1), 내림(2) = ");
		int ud = sc.nextInt();
		if(ud == 1)  updown = true;
		else		 updown = false;
	}

	public void Sorting() {
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i + 1 ; j < number.length; j++) {
				if(updown) {
					if(number[i] > number[j]) {
						swap(i, j);
					}
				}else {
					if(number[j] > number[i]) {
						swap(i, j);
					}
				}
			}
		}
	}

//	public void swap(int number[], int i, int j) { 절차지향에서 함수로
	public void swap(int i, int j) {
		int temp = number[i];
		number[i]= number[j];
		number[j] = temp;
	}

	public void result() {
		for (int i = 0; i < number.length; i++) {
			System.out.println(i + ":" + number[i]);
		}
	}
}