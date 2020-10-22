package classData;

public class Java07If {
	public static void main(String[] args) {
		/*if문
		조건식을 판단한 결과에 따라 처리를 나누고 싶은 경우 사용된다.
		형식
		if(조건식) {
			실행문1;
			실행문2;
			...
		}
		if문에서 조건식을 판단하고 true인 경우에 {} 내에 기술된 문장을 실행
		조건식이 false인 경우 블록의 처리는 아무 처리 하지않고 다음 문장으로 처리가 이동
		*/
		int num = 90;
		if(num > 80) {
			System.out.println("합격입니다.");
		}
		
		for (int i = 0; i < 5; i++) {
			if(i%2 == 0) {
				System.out.println(i + "는 짝수입니다.");
			}
			if(i%2 != 0) {
				System.out.println(i + "는 홀수입니다.");
			}
		}
		/*
		if문은 조건식이 true일때만 수행할 작업을 처리하지만
		조건식이 false일 경우의 처리도 함께 할 수 있다.
		형식
		if(조건식){
			true의 경우 수행할 문장1;
			true의 경우 수행할 문장2;	...
		}else {
			false의 경우 수행할 문장1;
			false의 경우 수행할 문장2;	...
		}
		//둘 중 한쪽은 반드시 처리된다.
		*/
		num = 66;
		if(num > 80) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		for (int i = 0; i < 5; i++) {
			if(i%2 == 0) {
				System.out.println(i + "는 짝수입니다.");
			}
			else {
				System.out.println(i + "는 홀수입니다.");
			}
		}
		/* 조건식을 결합
		if문은 조건식이 true일때만 수행할 작업을 처리하지만
		조건식이 false일 경우의 처리도 함께 할 수 있다.
		형식
		if(조건식1){
			true의 경우 수행할 문장1;
			true의 경우 수행할 문장2;	...
		}else if(조건식2) {
			조건식 1이 false에서 조건식2가 true의 경우 수행할 문장1;
			조건식 1이 false에서 조건식2가 true의 경우 수행할 문장2; ...
		}else if(조건식3) {
		....
		}else{
			모든 조건식이 모두 false 경우 수행할 문장1;
			모든 조건식이 모두 false 경우 수행할 문장2; ...
		}
		여러 조건식이 사용되고 있는 경우는 위의 조건식부터 판단하고 있습니다.
		true인 경우 {}부분을 처리하고 if문 종료
		모든 조건이 false인 경우, else 이후 {}를 실행한ㄷ.
		*/
		int number = 55;
		if (number > 80) {
			System.out.println("합격입니다.");
		}else if (number >70) {
			System.out.println("추가 시험입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		//
		int math, english;
		math = 90;
		english = 75;
		System.out.println("수학 : " + math + " 영어 : " + english);
		if(math > 80 && english > 80) {
			System.out.println("합격입니다.");
		}else if(math > 80 || english > 80) {
			System.out.println("보충 수업을 받으십시오.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		math = 82;
		english = 91;
		System.out.println("수학 : " + math + " 영어 : " + english);
		if(math > 80 && english > 80) {
			System.out.println("합격입니다.");
		}else if(math > 80 || english > 80) {
			System.out.println("보충 수업을 받으십시오.");
		}else {
			System.out.println("불합격입니다.");
		}
		// Switch 문
		//변수의 값을 여러 값과 비교하여 값에 따른 처릴 하는 경우 if문
		int numb = 3;
		if(numb == 1) {
			System.out.println("매우 불만족");
		}else if(numb == 2) {
			System.out.println("조금 불만");
		}else if(numb == 3) {
			System.out.println("중간");
		}else if(numb == 4) {
			System.out.println("약간 만족");
		}else if(numb == 5) {
			System.out.println("매우 만족");
		}
		/*
		switch문 사용
		대상 식을 평가한 결과 값에 따라 값에 일치하는 레이블의 위치에 따른
		처리를 하기 위하여 사용
		조건문과 다른 점은 범위가 아닌 값이 명확해야 한다는 점이다
		형식
		switch(수식) {
			case 상수1 :
				실행문 1;
				실행문 2;
				...
				break;
			case 상수2 :
				실행문 1;
				실행문 2;
				...
				break;
		} */
		int numbe = 3;
		switch(numbe) {
			case 1:
			System.out.println("매우 불만족");
			break;
			case 2:
				System.out.println("조금 불만");
			break;
			case 3:
				System.out.println("중간");
			break;
			case 4:
				System.out.println("약간 만족");
			break;
			case 5:
				System.out.println("매우 만족");
			break;
		}
		/*switch문 - default
		default문
		식의 값과 일치하는 case가 없었을 경우 뭔가 실행시키고 싶을때
		default문을 사용한다.
		switch(수식) {
			case 상수1 :
				실행문 1;
				실행문 2;
				...
				break;
			case 상수2 :
				실행문 1;
				실행문 2;
				...
				break;
			default :
				실행문1;
		} */
		int soo = 1;
		switch (soo) {
		case 1:
			System.out.println("불만이 있다");
		case 2:
			System.out.println("중간이다");
			break;
		case 3:
			System.out.println("만족");
		} 
		// 위와 같이 의도적으로 break 문을 기술하지 않는 것도 가능하다.
		// 그래서 soo는 1이지만
		// 그 다음 break가 있는 case인 2까지 실행되고
		// break 통해 종료된다.
	}
}
