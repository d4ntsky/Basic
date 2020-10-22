package day0522;

public class Ex2Break {

	public static void main(String[] args) {
		
		/*
		break : 탈출 (loop: for, while, do while)
			cf) return은 나중에
		단독으로 사용 불가하고 순환문, switch와 같이 사용
		
		ex1)switch와
		switch( num ){
			case 100:
				처리
				break;
		}
		
		ex2)순환문과
		for(int i = 0; i < 10; i++) {
			if(i==5){
				break;
			}
		}
		*/
		//예시1
		for(int i = 0;i < 10; i++) {
			System.out.println("i = " + i);
			if(i == 4) {
				break;
			}
		}
		System.out.println("탈출후 ");
		
		//예시2
		char charArr[] = {'A','B','C','D','E'};
		
		for(int i = 0;i < charArr.length; i++) {
			System.out.println(i + ":" + charArr[i]);
		
			if(charArr[i] == 'C') {
				System.out.println("C문자를 찾았습니다");
				break;
			}
		}
		
		//예시3 이중포문에서의 탈출
		for(int i = 0;i<10;i++) {
			System.out.println("i = " + i);
			
			for(int j = 0;j<5;j++) {
				System.out.println("	j = " + j);
				
				if( i == 4 && j == 3) {
					break;//break 하나당 j for문만 받음 i=4 j=3일때 탈출하고 뒤에 i이후가 따로 나옴
				}
			}
		}		
		
		// 1. 탈출방법 : loop문 갯수에 맞게 break를 설정
		boolean b = false;//false=0
		for(int i = 0;i<10;i++) {
			System.out.println("i = " + i);
			
			for(int j = 0;j<5;j++) {
				System.out.println("	j = " + j);
				
				if( i == 4 && j == 3) {
					b = true;//안에 for문
				}
				if(b == true) {
					break;
				}
			}
			if(b == true) {
				break;//밖에 for문
			}
		}
		// 2. 탈출방법 : 키워드를 사용(goto)
		loopout:for(int i = 0;i<10;i++) { //맨앞 loopout부분 단어선택 가능 - java만있고 c언어는없음
		System.out.println("i = " + i);
		
		for(int j = 0;j<5;j++) {
			System.out.println("	j = " + j);
			
			if( i == 3 && j == 3) {
				break loopout;
				}
			}
		}		
		//break 활용도 높음
		
		
	}
}

