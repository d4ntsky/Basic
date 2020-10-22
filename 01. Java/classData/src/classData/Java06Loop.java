package classData;

public class Java06Loop {
 public static void main(String[] args) {
	//1부터 10까지 숫자를 더한 결과를 구하는 프로그램 작성
 	int sum = 0;
 	sum += 1;
 	sum += 2;
 	sum += 3;
 	sum += 4;
 	sum += 5;
 	sum += 6;
 	sum += 7;
 	sum += 8;
 	sum += 9;
 	sum += 10;
 	System.out.println("총 " + sum + "입니다");
 	//코드가 너무 길어지기 때문에 동일한 작업을 여러번 반복하거나 조건을 바꾸어
 	//지정 횟수만큼 처리를 반복하는 경우 for문이나 while문을 사용하면 간단해진다
 	sum = 0;
 	for (int i = 0; i <= 10; i++) {
		sum += i;
	}
 	System.out.println("총합은 " + sum + "입니다");
 	//i <= 10에 10을 1000으로 바꾸면 1부터 1000까지의 합을 간결하게 표현가능하다.
 	
 	/* for 문은 지정된 횟수만큼 처리를 반복할 때 사용
 	형식은
 	for(초기화식; 조건식; 변화식 {
 		실행문 1;
 		실행문 2; ...
 	}
 		for문에서는 조건식을 판단하고 true인 경우에는 "{}" 블록 내에 기술된 문장을
 		실행한다. 블록의 처리가 끝나면 다시 조건식으로 판단한다.
 		false인 경우 for문을 종료한다.
 	*/
 	sum = 0;
 	for (int i = 0; i < 10; i++) {
		sum += 2;
	}
 	System.out.println(sum);
 	/*
 	 for문은 초기화식, 조건식, 연산식 3식을 사용하지만
 	 초기화식 연산식에는 여러 표현식을 작성할 수 있다.
 	 여러 수식을 작성하는 경우 수식과 수식 사이를 쉼표,로 구분하여 설명
 	 for(초기화식1,초기화식2;조건식;연산식1,연산식2){
 	 } cf) 조건식은 관계 연산자와 논리 연산자 복합한 조건식을 작성할 수 있다.
  	 */
 	int i, j;
 	for (i = 1, j = 9; i < 10; i++, j--) {
 		System.out.println("i = "+ i + ", j = " + j);
 	}
 	//여러 초기화 식을 사용하는 경우, for문 밖에서 변수를 선언하고 작성.
 		
 	//이중 for문
 	for (int a = 0; a < 2; a++) {
		for (int b = 0; b < 2; b++) {
			System.out.println("a = "+ a + ", b = " + b);
		}
	}
 	
 	//구구단 이중 for문
 	for (int c = 1; c <= 9; c++) {
		for (int d = 1; d <= 9; d++) {
			System.out.println(c + " x " + d + " = " + (c*d));
			}
	}
 	
 	/*	while문
		주로 지정된 횟수만큼 반복 목적으로 이용되는 for문이라면 
		조건이 충족되는 동안은 몇 번이라도 반복 목적으로 이용되는 것이 while문
	형식
	while(조건식){
		실행문1;
		실행문2;
		...
	}
	조건식은 관계 연산자와 논리연산자 등을 기입. 블록의 처리가 끝나면 다시 조건식으로
	false가 될 때 while문을 종료합니다.
 	*/
 	i = 0;
 	while (i < 2) {
 		System.out.println("i = " + i);
 		i++;
 	}
 	
 	/* do..while 
 	for문이나 while문은 조건식을 판단 한 후 첫번째 반복을 한다.
 	경우에 따라 한 번도 실행하지 않을 수도 있습니다.
 	 먼저 실행을 한 번 한후 조건식으로 판단하고 싶을 경우에 이용되는 것이 
 	do..while 문이다.
 	형식
 	do{
 		실행문1;
 		실행문2;	...
 	}while(조건 식);
 	실행문을 실행하고 조건식으로 식을 판단한다. false인 경우 종료된다.
 	*/
 	int d = 7;
 	do {
 		System.out.println("d = " + d);
 		d -= 4;
 	}while(d>0);
 		System.out.println("0보다 작아 종료됨");
 	
 	d = -3;
 	do {
 		System.out.println("d = " + d);
 		d -= 4;
 	}while( d > 0);
 		System.out.println("0보다 작아 종료됨");
 	
 	/* 확장 for문 (for-each문)
 	for문이 조금 다른 방법으로 확장된 for-each 식으로도 활용할 수 있게됐다.
 	이것은 배열이나 컬렉션이라는 요소를 가지고 있는 것으로부터 모든 요소에 포함된
 	값을 순서대로 산출하여 처리하는 데 사용된다.
 	형식
 	for(데이터형 변수 이름 : 컬렉션){
 		실행문1;
 		실행문2;
 		...
 	}
 	이전에 설명된 for문과 동일하지만 괄호 안은 전혀 다른 요소로 되어있다.
 	이 형식은 값을 순서대로 제거하려는 배열이나 컬렉션과 꺼낸 값을 저장하는
 	변수의 두 세미콜론(;) 대신 콜론(:)으로 구분하여 기입한다.
 	반복 횟수는 배열이나 컬렉션에 포함되어있는 값으 개수이므로 조건식이 필요하지
 	않고 변화식도 필요없다.
 	*/
 	int data[] = {82,72,89};
 	for(int se : data) {
 		System.out.println(se);
 	}
 	//순서대로 하나씩 출력한 후 모든 값을 꺼내서 종료
 	for (int k = 0; k < data.length; k++) 
 		System.out.println(data[k]);
 	//모든 요소의 합계를 취득하려는 경우, 검색 순서에 관계없이 모든 요소를
 	//한번씩 처리하고 싶은 경우 유용한 제어문이다.
 	//ex
 	int dat[] = {23,27,13,24,11};
 		for (int si : dat) {
 			System.out.println(si);
 		}
	
 } 	
}
