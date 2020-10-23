package day0522;

public class Ex1While {

	public static void main(String[] args) {
		/*
			순환문
			while
			do while
			
			형식:
				변수 선언
				변수 초기화
				while( 조건 ){
					처리
					변수 연산
				}
				조건이 틀릴 때까지 연산
				---------------------------
				변수 선언
				변수 초기화
				do{
					처리
					연산식
				}while( 조건 )
				---------------------------
				for(변수초기화;조건;연산식){
					처리
				}
		*/
		
		//예시 while
		//변수선언
		int w;
		//초기화
		w = 0;
		
		while(w<10) {
			System.out.println("w = " + w);//도는거 보기위한
			w++;
		}
		System.out.println("w = " + w);//탈출될것
		//조건문과 순환문 차이
		
		//예시 do while
		int dw;
		dw = 0;
		do {//do는 무조건 한번 실행됨 ex)dw = 10;
			System.out.println("dw = " + dw);
			dw++;
		}while(dw < 10);
		
		//예시 이중 for문
		for (int i = 0; i<10;i++) {
			System.out.println("i = " + i);
			for(int j = 0; j <5; j++) {
				System.out.println(" 	j = " + j);
			}
		}
		
		//예시 이중 while문 (실수가 자주 나오는편)
		int w1, w2;
		w1 = w2 = 0;		
		while(w1 <10) {
			System.out.println("w1 = " + w1);
			while(w2 < 5) {
				System.out.println(" 	w2 = " + w2);
				w2++;
			}
			w1++;
		}
		//밖에서 초기화가 되기 때문에 w2의 초기화가 어디서 이뤄져야 되는지가 중요
		//w1=0일때만 한번 나오고 그 다음부터 안나옴 w2가 5로 끝났기 때문?
		
		int w3, w4;
		w3 = 0;
		while(w3 <10) {
			System.out.println("w3 = " + w3);
			
			w4 = 0;//여기에 초기화를 해야함
			while(w4 < 5) {
				System.out.println(" 	w4 = " + w4);
				w4++;
			}
			w3++;
		}
		//두개 다시 비교해보기
		
		//while문 무한루프는 조건문이 true일때 
		while(true) {
			System.out.println("w1 = " + w1);
			w1++;
		}
		/*
		 application의 구조
			1.initialize (초기화) -> init
			
			2.loop(순환)
			while(true){
				탈출(종료를 누르면)
				1. 입력
				2. 출력
			}
			
			3.release(해방)
		*/
	}

}