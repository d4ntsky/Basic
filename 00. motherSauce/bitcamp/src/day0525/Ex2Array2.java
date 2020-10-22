package day0525;

public class Ex2Array2 {
	public static void main(String[] args) {
	
		/*
		 * 1차열 배열
		 * Array :	같은 자료형의 묶음
		 * 			index number로 관리가 된다.
		 * 			0 ~ n-1 (n은 배열의 총수)
		 * 
		 * 다른 자료형의 묶음 : c언어	-> structure(구조체
		 * 				  Java	-> Class
		 * 
		 * int array[] = new int[3];
		 * int array[] = new int[1];
		 * 
		 * MyStruct my = {'a', 24, "홍길동"};
		 * 
		 * String number[] = {"홍길동", "24", "서울시"};
		 * 
		 * int Array 2 = {
		 * {1,2,3,4},
		 * {5,6,7,8},
		 * {9,10,11,12}
		 * };
		 * 
		 * int Array2[][] = new int[3][4];
		 * int []Array2[] = new int[3][4];
		 */
		int Array2[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		//어레이[] length 구별!
		for (int i = 0; i < Array2.length; i++) {		//Array2.length -> 3
			for (int j = 0; j < Array2.length; j++) {	//Array2[0].length -> 4
				System.out.println("Array2[" + i + "][" + j + "] = " + Array2[i][j]);
			}
		}
		
		//1차원 배열
		//정의 : 같은 자료형(변수)의 묶음
		//목적 : 변수를 관리하기 위해서.
		//	변수에 접근을 하기 위해 사용하는 것은 index number(번지)
		//  index number(번지). 0 ~ n-1
		//	동적할당(1 ~ n개) 할당 후 정적으로 사용(접근)
		int array[] = new int[5];		// new -> 동적 할당
		// stack 	메모리 영역은 heap에 있다	// delete array -> 가비지 콜렉터
		int array1, array2, array3, array4, array5;
		// stack (일반변수)
		int arrayTag[] = { 11, 22, 33, 44, 55 };
		//					0	1	2	3	4 = 총 5개
		
		// 배열 참조(포인터) - 주소 할당
		int pArray[] = arrayTag;		//==int []pArray==int[] pArray
		System.out.println(arrayTag);	//참조가 이뤄지는 과정 //=- [I@ 4byte - 16진수
		//포인터는 속도가 빠르지만 주소만 접급하면 모든 데이터에 접근 가능할 수 있어서 보안에 취약하다.
		pArray[1] = 222; //참조 데이터를 바꾼것
		System.out.println(arrayTag[1]);
		// ex)이 포인터는 특정 변수 이름이 이상해서 바꿀 때 실용적 그러나 보안에 취약.
		int arrayNumberPosition[] = { 1, 2, 3};
		int arrNumPos[] = arrayNumberPosition;
		
		
		//2차원 배열 [큰묶음][큰묶음 안 요소수]
		int ArrayTwo[][] = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8, 81},//81이 빠져야한다. 에러는 없지만 사용하지 않는 방법
				{ 9, 10, 11, 12},//, 없어도 되고 있어도 되고
		};
		/*	memory
		 * ArrayTwo[0][0]
		 * ArrayTwo[0][1]
		 * ArrayTwo[0][2]
		 * ArrayTwo[0][3]
		 * ArrayTwo[1][0]
		 * ArrayTwo[1][1]
		 * ....
		 */
		for (int i = 0; i < ArrayTwo.length; i++) {
			for (int j = 0; j < ArrayTwo[0].length; j++) {	//0
				System.out.print(ArrayTwo[i][j] +" ");
			}
			System.out.println();//매줄마다
		}
System.out.println("--------------------------");
		for (int i = 0; i < ArrayTwo.length; i++) {
			for (int j = 0; j < ArrayTwo[i].length; j++) {	//i
				System.out.print(ArrayTwo[i][j] +" ");
			}
			System.out.println();
		}
		
	}	
}