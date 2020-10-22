package Task0525;

import java.util.Scanner;

public class Test0525_Logic {

	public static void main(String[] args) {
	/*
	 * 입력 : 모두 숫자로 되어있는 지 확인
	 *  -> String "12345" "123e5"
	 *  모두 숫자로 되어 있으면,
	 *  			"모두 숫자로 되어 있습니다 -> 숫자로 변환
	 *  			"숫자로 되어있지 않습니다. 
	 * ASCII 사용
	 */
	
	//문자열을 숫자열과 바꾸고 같은지 비교?

	/* 입력 : 정수, 실수를 판별할 코드를 작성
	 *  -> String "123.456" "123456"
	 *  모두 숫자로 되어 있다는 가정하에
	 *  			실수면 "실수입니다."
	 *  			정수면 "정수입니다."
	 *  '.'
	 */
	
	// charAt		array[2] ->
	// String str = "hello";   ==	charArray[5]
	
	char a = 'A'+ 32;
	System.out.println("a = " + a );	
	
	Scanner sc = new Scanner(System.in);
	
	String word = sc.next();
	
	for (int j = 0; j < word.length(); j++) {
	 char b = word.charAt(j);
	  char c = b + 32;}
	System.out.println("a = " + c);	
	
						
//		//Ascii code 48<=숫자<=57!! 판정값을 설정
//		int asccode = (int)c;
//		if(asccode < 48 || asccode > 57) {
//			numTrue = false;
//			break;
}
	
	
	// 대문자로 입력 -> 소문자로 변환해서 출력되도록..
	// toLowerCase 사용하지 말고 구현
	// ABC -> abc (+32 ascii코드 기준
	
}	

