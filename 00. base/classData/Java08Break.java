package classData;

public class Java08Break {
	public static void main(String[] args) {
	/*break문
	 break문은 for문, while문, do..while문 switch 구문의 
	 break문이 실행되면 블록을 빠져나가서 다음 처리로 이동합니다. 
	 break문장의 형식
	break; 
	for 문은 조건식이 true 동안 블록 내의 처리를 반복하지만, 
	break 문이 실행되면, for문을 종료하고 다음 작업으로 이동합니다.
	for (초기화식; 조건 식; 연산 식) { 
		... 
		if (조건 식) { 
		break; 
		} 
		... 
	}
	//if문 등과 함께 사용해야 조건에 따라서 탈출하도록 처리할 수 있습니다)
	*/
		int sum = 0; 
		for (int i = 1; i <= 100; i ++) { 
			sum += i; 
			if (sum> 100) { 
				break; 
			} 
		} 
		System.out.println ( "sum ="+ sum); 
		/*
	이 경우 1에서 100까지의 숫자를 순서대로 가산하고 있습니다만, 
	합계가 100을 넘은 시점에서 break 문을 실행되므로 for 문이 종료됩니다.

	while 문의 경우도 기본적으로 동일합니다. 
	루프 도중에 break 문이 실행되면, while 문이 종료됩니다.
	while (조건 식) { 
		... 
		if (조건 식) { 
		break; 
		} 
		... 
	}	 
		*/
		int num = 1; 
		while (true) { 
			System.out.println (num); 
			num ++; 
			if (num> 100) { 
				break; 
			} 
		} 
	//이 경우 while 문의 조건식이 "true"로 되어 있기 때문에 무한 루프됩니다. 
	//그러나 변수 num의 값이 100을 넘어 가면 break 문이 실행 된 while 문이 
	//종료됩니다.
    //do..while 문장의 경우도 기본적으로 동일합니다.

	sum = 0; 
	for (int i = 1; i <= 100; i ++) { 
			sum += i; 
		} 
		System.out.println ( "sum = "+ sum); 
		
	sum = 0; 
	for (int i = 1; i <= 100; i ++) { 
			sum += i; 
			if (sum > 100) { 
				break; 
			} 
		} 
		System.out.println ( "sum = "+ sum); 

		
	//	루프 처리가 다중으로 되있는 경우
	for (int i = 1; i <= 5; i ++) { 
		sum = 0; 
		for (int j = 1; j <= 9; j ++) { 
			if (i * j> 20) { 
				break; 
				} 
				System.out.println (i + "*"+ j + "="+ (i * j)); 
			} 
			// 내부 for 문 블록 내에서 break 문이 실행되면 여기에 처리가 이동  
		} 
		// 외부 for 문 블록 내에서 break 문이 실행되면 여기에 처리가 이동 
	//이중 for문으로 되어 있는 구조이다.
	//break 문이 실행 된 for문 밖에 있는 for문 처리의 흐름에는 영향을 미치지 않는다.
	for (int i = 3; i <= 5; i ++) { 
		sum = 0; 
		System.out.println (i + "라인 시작"); 
		for (int j = 1; j <= 9; j ++) { 
			if (i * j >= 10) { 
				break; 
			} 
			System.out.println (i + " x "+ j + " = "+ (i * j)); 
		} 
		System.out.println (i + "행 종료"); 
	} 
	System.out.println ( "계산 종료"); 
	
	/* 레이블 break문
	break문이 실행되면 break문을 포함하는 루프문만을 탈출하지만
	레이블 된 break문으로 모든 블록을 탈출할 수 있다.
	레이블 break문장의 형식
	break레이블;
	break 다음으로 레이블을 지정하고 실행한다.
	레이블 : {
		...
		break 레이블;
		...
	}
	
	for문이나 while문 앞에 "레이블:" 같은 레이블 지정한다.
		*/
	outside : for (int i = 1; i < 5; i++) {
		for (int j = 1; j < 5; j++) {
			if(i*j > 10) {
				break outside;
		}
		System.out.println(i + " x " + j + " = " + (i*j));
		}
	}
	/*
		레이블이 없는 break문은 가장 안쪽의 블록을 탈출하지만,
		레이블 break문이 실행되면, 지정된 레이블이 붙은 블록을 탈출.
		레이블 break문은 다중 루프를 탈출하는 경우에는 유용,
		너무 많이 사용하면, 프로그램을 이해하기가 힘들어진다.
	*/
	
	/*	continue문
	continue문은 break문장과 같이 for문, while문, do..while 문장 블록서
	사용되며 continue문이 실행되면 실행된 위치에서 블록의 마지막까지 남은 부분을
	생략한다.
	형식
	continue;
	for(int i = 0 ; i < 10 ; i++) {
		if(i == 3) {
			continue;
		}
		System.out.println(i);
	}
	위에서 변수 i의 값이 3이면 continue문이 실행된다.
	continue문이 실행되면, 블록 내에서 그 이후에 작성된 모든 작업을 하지 않고
	다음 반복 조건 판으로 이동한다.
	즉 위의 경우는 변수 i의 값이 3일 때만 "System.out.println(i);"가
	실행되지 않는다.
	 또한, for문의 경우는 연산식이 별도로 준비되어 있기 때문에 괜찮지만,
	while문 등은 조건 식의 값을 변화시키는 처리를 포함하여 생략하게 될 수도 있으므로
	주의가 필요하다.
	 예를 들어 다음과 같이 기술하면 변수 i가 3이 되면 변수 i의 값을 변화시키는 처리도
	생략해버리기 때문에 다음 반복되어도 변수 "i"의 값이 변화하지 않고 무한 루프가 되어
	버린다.
	*/
//	int i = 0;
//	while(i < 10) {
//		if(i == 3) {
//			continue;
//		}
//		i++;
//		System.out.println(i);
//	}
	// 또한 break 문장과 마찬가지로 반복 처리가 다중으로 되어있는 경우에는
	// continue문을 포함한 가장 안쪽의 루프를 생략하고 다음 루프로 넘어간다.
	// 임의의 반복 처리를 생략하려면, 레이블 continue를 사용해라
	for (int j = 0; j < 10; j++) {
		if(j % 2 == 0) {
			continue;
		}
		System.out.println("j = " + j);
	}
	
	/* 레이블 continue문
	continue문이 실행되면, continue문을 포함한 가장 안쪽의 블록 continue
	문 이후의 처리를 생략하고 있지만 레이블의 continue문으로 모든 블록의 끝자리
	처리를 생략할 수 있습니다.
	레이블 break문장의 형식은 다음과 같다.
	continue 레이블;
	레이블:while(조건식) {
		...
		continue레이블;
		...
	}
	for문이나 while문 앞에 "레이블:" 같은 레이블을 붙입니다.
	이 떄 continue문은 레이블 블록 안에 기술되어 있어야한다.
	*/
	outside2 : for (int a = 1; a < 5; a++) {
		for (int b = 1; b < 5; b++) {
			if(a*b > 10) {
				continue outside2;
			}
			System.out.println(a + " x " + b + " = " + (a*b));
		}
	}
	/*	레이블이 없는 continue문은 가장 안쪽 블록의 끝부분까지 스킵하지만,
	 	레이블 continue문이 실행되면, 지정된 레이블이 붙은 블록의 끝까지
	 	처리가 생략되고 다음 반복으로 이동한다.
	 	따라서 위의 경우 if문 조건식이 true이면 바깥쪽 for문이 끝까지 처리가
	 	생략되고 다음 반복에 들어간다.
	 	 또한 break문장과 달리 continue문은 if문이나 블록만을 위한 레이블
	 	 을 지정하여 사용할 수 없다.
	*/
	outside3 : for (int a = 1; a < 5; a++) {
		for (int b = 1; b < 5; b++) {
			if(a*b > 8) {
				continue outside3;
			}
			System.out.println(a + " x " + b + " = " + (a*b));
		}
	}
	
	 
	}
}
