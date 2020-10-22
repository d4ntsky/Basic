package day0521;

public class Ex3For {

	public static void main(String[] args) {
		/*
		loop문, 순환문
		지정한 회수만큼 반복을 하는 제어문
		for, 
		while, 
		do while(많이 안 쓰이는편)
		형태:		for(초기화;조건;연산식){ 
					처리
				}
		for + if도 자주 쓰임
		
		int num = 0;
		num = num + 1;     
	==	num++; //++되는 값이 달라질수 있기 때문에 for문
		num++;
		num++;
		   :
		   :
		
		for문 돌아가는 순서
		for(초기화(1);조건(4)(7)(10);연산식(3)(6)(9)) { 
			처리(2)(5)(8)       10이 false면 루프 탈출
		}
		(11)
		*/
		//루프확인
//		int i;
//		for(i = 0; i < 10; i++) {
//			        //10번의 루프가 돌게 됨 0부터 9까지 10이 false가 되기때문에 탈출
//			System.out.println("i = " + i);
//		}
//		System.out.println("loop out i = " + i); //루프 탈출된 값
//		
//				//1부터 10까지 더하십시오
//		int number = 0;
//		number = number + 1;
//		number = number + 2;
//		number = number + 3;
//		number = number + 4;
//		number = number + 5;
//		number = number + 6;
//		number = number + 7;
//		number = number + 8;
//		number = number + 9;
//		number = number + 10;
//		System.out.println("number = " + number);
//						//==
//		int j;
//		int num = 0;
//		for(j = 1; j <= 10; j++) {
//			num = num + j;
//		}
//		System.out.println("num = " + num);
			//100까지라면 j <= 100으로 바꾸면 끝...
			//연산을 간결히 하면서 긴 연산을 줄여서 사용할 수 있다.
		
		int i;
		for( i = 0; i < 10; i++) {
			System.out.println("i = " + i);}
		
		for(int n = 0; n < 10; n++) {//루프용 변수 n은 밖에서 선언하면?
			System.out.println("n = " + n);}
			//외부에서 선언하는
			//루프용 변수는 루프에서만 쓰인다!!!!!!!!!
			//루프도 자동완성이 있지만 자주 안쓰임
		
		//decrement
		for(int j = 10; j > 0; j--) {
			System.out.println("j =" + j);
		}
		//2씩 increment
		for(int k = 0;k <10; k = k + 2) {
			System.out.println("k = " + k);
		}
		//잘 사용하지 않는다 
		int count = 0;
		for( ; count < 10 ;) {
			System.out.println("count = " + count);
			count++; //이게 없어지면 무한 루프가 되버림 
		}
		//조건문 갯수는 1개
		for(int m = 0, n= 0; m <10; m++,n++) {
								//, n<5	//하나만 조건문으로 되면 가능 루프수가 다르기 때문에
			System.out.println("m= " + m);
			System.out.println("n= " + n);
		}
		
		// for 안에 for
		//구구단 2단의 모든 합을 구하라.
		int sum = 0;
		for(int o = 2; o <= 20; o = o + 2) {
		//2단 for(int o = 2; o <= 20; o = o + 2) 
		//	System.out.println("o = " + o);
			sum = sum + o;
		}
		System.out.println("합 = " + sum);
		//== 값은 같음 
	//--------------------------------------------------------다시확인
		sum = 0;
		int num2 = 2;
		for(int p = 0; p < 10; p++) {
			sum = sum + num2;
			num2 = num2 + 2;
		}//for문 내용이 관계된건가?
		System.out.println("합 = " + sum);
	//---------------------------------------------------------다시확인
		
		//이중 for문
		for(int q = 0; q < 10; q++) {//loop 10
			System.out.println("\t q = " + q);
			for(int r = 0; r < 5; r++) {//loop 5
				System.out.println("\t\t r = " + r);
			}
			//q가 한번 실행될 때 안에 있는 r은 5번 다 돈다
			//q 1번당 r 5번씩 q가 10번까지 돌면 총 50번 도는 루프
			}
		//이건 이중 for문이 아니다!!!!!!!
//		for(int m = 0, n= 0; m <10; m++,n++) {
//		System.out.println("m= " + m);
//		System.out.println("n= " + n);

		//cf) 루프용 변수는 간단히 적는편

	}
}
