package day0520;

public class Ex7Array {

	public static void main(String[] args) {
		/* 왜배우는지? 
		              //cf) 코드 확인할때
		               	주성분을 빼놓고 보면  남은 왜 필요했었는지 파악 가능 
			Array : 배열 (접근과 관리를 위한)
					변수의 확장 기능
					관리를 용이하게 하기위한 목적.
					정의 : 같은 자료형의 변수의 묶음
					관리 : index 번호//인덱스번호는 0부터 시작 ~ (n-1) 여기서 n는 갯수
					형식:
				자료형 배열명(=변수명)[] = new 자료형[배열갯수]; //cf)[]배열괄호
				int num1, num2, num3.... num10... num100;
				==// int Array[] = new int[100]; //동적 할당 
					할당 된 후부터는 정적으로 쓰임 101번째는 없음
					//int = num1~100 이뜻 100개의 변수 선언
					num1 = 1;
					Array[0] = 1; 
					Array[1] = 2; 
					Array[2] = 3; 
					   :
					Array[99] = 100; 
					
					배열은 동적으로 생성해서 정적으로 사용한다
					     	여기서 동적이란말은 배열 갯수
					     		정적이란말은 쓰임새
		*/
		int array[] = new int[3]; //제일 많이쓰는 방식
		//int []array = new int[3];
		//int[] array = new int[3];
		
		//int *array = new int[3];
		//int* array = new int[3];
		//c언어에서는 [] = *
		
		int num1, num2, num3;
		
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;
		//[] 안에있는 인덱스 넘버로 관리 한다는게 편하다는점
				
		// 변수 초기화
		int tag = 1;
		
		int arr[] = { 1, 2, 3 };
		//arr[0] = 1
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);
		System.out.println("arr[2] = " + arr[2]);
		//System.out.println("arr[3] = " + arr[3]);//인덱스 범위를 벗어났다
		
		char charArr[] = { 'H','e','l','l','o'};
		System.out.println(charArr);//Hello
		System.out.println(charArr[0]);//H
		System.out.println((int)charArr[0]);//72 
		//cast 선언 > 나오는 숫자 72는 ASCII코드값
		
		char charArr2[] = new char[5];
		charArr2[0] = 'H';
		charArr2[1] = 'e';
		charArr2[2] = 'l';
		charArr2[3] = 'l';
		charArr2[4] = 'o';
		System.out.println(charArr2);
		//System.out.println((int)charArr2);//원래는 heap의 주소값이 나온다
		
		
	}//{}블록괄호
}
