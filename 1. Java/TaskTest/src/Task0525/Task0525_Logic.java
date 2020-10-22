package Task0525;

import java.util.Scanner;

public class Task0525_Logic {
	public static void main(String[] args) {
		/*
		 * 입력 : 모두 숫자로 되어있는 지 확인
		 *  -> String "12345" "123e5"
		 *  모두 숫자로 되어 있으면,
		 *  			"모두 숫자로 되어 있습니다 -> 숫자로 변환
		 *  			"숫자로 되어있지 않습니다. 
		 * ASCII 사용
		 * Ascii 코드에는 번호가 있다 
		 */
//		 char c = 'A';
//		 System.out.println("c = " + c +"  c = " + (int)c);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 = ");
		String str = sc.next();
		
		boolean numTrue = true;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
//			System.out.println("c = " + c);
			
			//Ascii code 48<=숫자<=57!! 판정값을 설정
			int asccode = (int)c;
			if(asccode < 48 || asccode > 57) {
				numTrue = false;
				break;
			}
		}
		if(numTrue) {
			System.out.println("숫자입니다");
		}else {
			System.out.println("문자입니다");
		}
		/*
		 * 입력 : 정수, 실수를 판별할 코드를 작성
		 *  -> STRING "123.456" "123456"
		 *  모두 숫자로 되어 있다는 가정하에
		 *  			실수면 "실수입니다."
		 *  			정수면 "정수입니다."
		 *  '.'
		 */
		
		System.out.print("숫자 입력 = ");
		String strNum = sc.next();
		
		boolean floatTrue = false;
		
		for (int i = 0; i < strNum.length(); i++) {
			char c = strNum.charAt(i);
			if((int)c == '.') {//'.' 값을 ascii코드값으로 적어줘도됨
				floatTrue = true;
				break;
			}
		}
		if(floatTrue) {
			System.out.print("실수입니다.");
			
		}else {
			System.out.print("정수입니다.");
		}
		
		// 대문자로 입력 -> 소문자로 변환해서 출력되도록..
		// toLowerCase 사용하지 말고 구현
		// ABC -> abc (+32 ascii코드 기준
		// toLowerCase ABCdef -> abcdef
		// A -> 65
		// a -> 97
		//     +32
		
		System.out.println("문자열 입력 = ");
		String _str = sc.next();
		String result = ""; //String result = new String();
		//빈문자로 초기화된 상태
		
		// 한문자씩 산출
		for (int i = 0; i < _str.length(); i++) {
			char c = _str.charAt(i);//한문자씩 넘어오는//cf charAt <=> indexOf
			if((int)c >= 65 && (int)c <= 90) { 	//대문자인 경우
				int n = (int)c + 32;			//대문자로 변환하는 부분
				result = result + (char)n;
			}else { 							//소문자인 경우
				result = result + (char)c;
			}
			
		}
		System.out.println("원본 문자열 = " + _str);
		System.out.println("변환 문자열 = " + result);
	}
}