package TaskSorting1;

import java.util.Scanner;

public class Task0529_Sorting {

	public static void main(String[] args) {
//		//Sorting 정렬 < 하나에 알고리즘
//		//15243
//		//12345 오름차순
//		//54321 내림차순
//		//선택,버블,합병,퀵
//		// 선택
//		//index number 5번지가 있었다 하면 
//		//첫번째 인덱스 자리를 전부 비교해서 바꾸면 첫번째 인덱스가 채워지고
//		//첫번째는 픽스 된 상태고 두번째 부터 다시 비교한다.
//		//번지끼리 비교해서 swap
//		// 버블
//		// 합병
//		// 퀵
//		//반으로 나눠서 
//		
//		//______________________________
//		
//		/*
//			Sorting : 정렬
//						숫자의 크기에 따라서 순번대로 배치하는 처리.
//						오름차순(큰 값이 뒤로 가는) 		ex)입사순위
//						내림차순(제일 큰 값이 앞으로 가는) 	ex)연봉순위
//						정렬이있다.
//					   종류 : 선택, 버블, 합병(병합), 퀵
//		*/
//		//선택정렬 예시
//		int number[] = { 1, 5, 2, 4, 3 };
//		int temp; //swap용 변수
//		
//		for (int i = 0; i < number.length-1; i++) {  			//length = 5
//												//i=0       i=1     i=2   i=3 
// 			for (int j = i + 1 ; j < number.length; j++) {	//length = 5
// 												//j=1 2 3 4 j=2 3 4 j=3 4 j= 4
//				if(number[i] < number[j]) { // > 오름 차순 < 내림차순
//					temp = number[i];
//					number[i] = number[j];
//					number[j] = temp;
//				}
//			}
//		}
//		for (int i = 0; i < number.length; i++) {
//			System.out.println("number ["+ i + "] = " + number[i]);
//		}
//		//=======================================
//		
//	Scanner sc = new Scanner(System.in);
//		//입력
//
//		
//	//  정렬할 갯수?
//		System.out.println("정렬시킬 숫자의 갯수를 입력해주세요");
//		int num = sc.nextInt();
//		//  정렬할 숫자를 동적할당
//		int numArr[] = new int[num];
//		
//		//  정렬할 숫자를 입력
//		for (int i = 0; i < numArr.length; i++) {
//		System.out.println("정렬시킬 숫자를 입력해주세요");
//		int sNum = sc.nextInt();
//		numArr[i] = sNum;
//		}
//		temp = 0;
//	
//		//  오름/내림
//
//		for (int i = 0; i < numArr.length-1; i++) {  		
// 			for (int j = i + 1 ; j < numArr.length; j++) {	
//				if(numArr[i] < numArr[j]) { 
//					temp = numArr[i];
//					numArr[i] = numArr[j];
//					numArr[j] = temp;
//				}
//			}
//		}
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.println("numArr ["+ i + "] = " + numArr[i]);
//		}
//		
//		// 정렬
//		//		 결과
//		
		Scanner sc = new Scanner(System.in);
		int number[] = null;
		int count;
		boolean updown = false;
		
		//정령할 갯수?
		System.out.println("정렬할 갯수는 = ?");
		count = sc.nextInt();
		//1보다 커야 한다
		
		//정렬할 숫자를 동적할당
		number = new int[count];
		
		//정렬할 숫자를 입력
		for (int i = 0; i < number.length; i++) {
			System.out.print((i+1) + "번째 수 =");
			number[i] = sc.nextInt();
		}
		//오름차순1/내림차순2
		System.out.print("오름(1)/내림(2) = ");
		int ud = sc.nextInt();
		//위에 boolean도 됨
		updown = (ud == 1)?true:false;//삼항연산자
		//--------------------------------초기화 + 입력
		//정렬
		int temp;//swap용
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown) {	//오름차순
					//==(updown == true) <-> (!updown)
					if(number[i] > number[j]) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}else {			//내림차순
					if(number[i] < number[j]) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}
			}
		}
		//----------------------------------------processing
		//결과
		String msg = "";
		if(updown) msg = "오름";
		else	   msg = "내림";
		System.out.println(msg + "차순으로 정렬하였으며,");
		for (int i = 0; i < number.length; i++) {
			System.out.println(i+ ":" + number[i]);
		}
		
		
	}
}