package day0520;

public class Ex1Restudy {
	public static void main(String[] args) {
		/*
			상수, 변수
			상수 : 2진수, 8진수, 10진수,16진수
					   012		0xab
			변수 : 특정공간 -> 작명
			맨앞글자 대문자는 불편해보이더라/모든대문자도 이상->다대문자로 쓰면 선언같이 보임
			
			수치형 
				정수
					byte			1byte
					short			2byte
					int				4byte
					long			8byte
				실수
					float			4byte
					double			8byte
			문자형
				문자
					char			2byte 'a' 'A' '가'		cf)c언어 1byte
									ASCII코드 (1byte)-> Unicode -> cf)multibyte 
				문자열	
					String(class)	동적임	"hello" "하이"
					Array(배열)		정적임 하지만 동적으로 할당?
			판정형(논리형) 
					boolean			1byte true(1)/false(0)
						
		*/
		
		int number; //선언 	//memory -> 4byte가 확보된 상태
		number = 1;	//대입
		System.out.println(number);
		
		int num = 2;//도 가능 (선언과 대입을 동시에) 
			//경우에 따라 다름
		System.out.println(num);
		
		String str = "Hello World"; //문자열은 큰 따옴표 cf)자바/파이썬은 ''가능
		char c = 'A'; //한문자는 작은 따옴표
		System.out.println(str + c);
		
		//cf)
		//파이썬 방법 
		//charNum = 'Hello'(컴파일러가 ;도 찍어줌)
	}
}

