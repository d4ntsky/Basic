package Task0522;

import java.util.Scanner;

//합계 평균 프로그램
public class Task0522_SumAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//과제9
		//유저로부터 입력 받은 수들의 합계와 평균을 구하는 프로그램을 작성하라.\ 
		//연산하고 싶은 숫자의 개수를 입력>> 
		//배열 동적 할당>> 
		//개수에 맞게 숫자를 입력 받음>> 
		//합계를 연산 
		//평균을 연산 
		//출력
		
		//지금은 절차지향 > 나중에 객체지향
		
		//1. 변수 선언
		//int num1, num2, num3;
		//몇개 할 건 지 모르는 상황이기 때문에 변수를 알 수 없음
		int numArr[] = null;//기본 개념이기 때문에 꼭 확인해보자.// 
		//.배열하고 포인터 비교 int *numArr -> 참조(Reference) = null cf) nul(빈문자)
		//.heap stack > null (0) (아무 주소도 안 갖고 있는 상태)
		//.0xffffffff = 32bit 저장할 수 있는 주소의 크기
		//.1111 -> f -> 4bit
		int sum; 	//합계 변수
		double avg; //평균 변수
		int count; 	//몇 개인지 모를 숫자 변수
		
		//2 초기화
		sum = 0;
		
		//3 연산 하고 싶은 숫자의 갯수를 입력
		System.out.print("연산하고 싶은 숫자의 갯수 = ");
		count = sc.nextInt();
		
		//4 그 갯수에 맞게 배열 확보(동적할당=참조)
		numArr = new int[count];//continue 배운뒤: -값 넣으면 제대로 기입하라고 빠져나가지 못하게 루프 더해줘라!!
		//배열의 길이값 length
		
		//5 합계를 사출할 숫자들 입력
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(( i + 1 ) + "번째 수 = ");
				numArr[i] = sc.nextInt();//배열은 index number로 관리받는다
				//sum += numArr[i]; 같이 해도되지만 권장하지 않음(작업별로 구분짓기 위해)
		}
		
		//6 합계를 산출
		for(int i = 0; i < numArr.length; i++) {
			sum = sum + numArr[i];
		}
		
		//7 평균을 산출
		avg = (double)sum / numArr.length;
		 				  //==count;
		//int > double
		
		//8 결과 출력
		for(int i = 0; i < numArr.length; i++) {
			System.out.print("숫자들: " + numArr[i] + " ");
		}
		System.out.println();
		
		System.out.println("합계: " + sum);
		System.out.println("평균: " + avg);
	}
}