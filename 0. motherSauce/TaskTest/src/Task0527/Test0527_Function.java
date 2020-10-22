package Task0527;

import java.util.Scanner;

public class Test0527_Function {

	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		/* 과제1
		 //// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.  
		   //static double getDistance(int x, int y, int x1, int y1) 
		     {
		  ////(1) 알맞은 코드를 넣어 완성하시오.      
	         }
	         System.out.println(getDistance(1,1,2,2)); 
			
			공식
			(x,y) (x1,y1)
			루트{ (y1-y)제곱 + (x1-x)제곱 }
			루트 함수				승수함수
		System.out.println(Math.sqrt(16));		-> 루트 씌우는		4
		System.out.println(Math.pow(16, 2));	-> (값, 승)	16의 2승
		*/
//		int x, y = 1; 
//		int x1 =2;
//		int y1 =2;
//		int xNum = x1-x;
//		int yNum = y1-y;
//		int x2Num, y2Num;
//		x2Num = Math.pow(xNum, 2);
//		y2Num = Math.pow(yNum, 2);
//		int result = Math.sqrt(y2Num+x2Num);
//	//1.414 ?
		
//-----------------------------------------------------------------
		/* 과제2
			 메소드명	: shuffle
			 기능 	  	: 주어주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. 
			 처리한 배열을 반환한다. 반환타입 : int[] 
			 매개변수	: int[] arr – 정수 값이 담긴 배열 
			 (1)shuffle메소드를 작성하시오
			{
			int[] original = {1,2,3,4,5,6,7,8,9};   
			System.out.println(java.util.Arrays.toString(original));   
			int[] result = shuffle(original);   
			System.out.println(java.util.Arrays.toString(result));  
			}
		*/
//		int[] original = {1,2,3,4,5,6,7,8,9}; 
//		shuffle(original);
//		
//-----------------------------------------------------------------
		/* 과제3
			메소드명 	: max 
			기 능 		: 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다. 
			만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다. 
			반환타입 : int 
			매개변수 : int[] arr - 최대값을 구할 배열 
			(1) max메소드를 작성하시오.  
			{   
			int[] data = {3,2,9,4,7};   
			System.out.println(java.util.Arrays.toString(data));   
			System.out.println("최대값:"+max(data));  
			}
		 */		
//		int[] data = {3,2,9,4,7}; 
//		int temp;
//		for (int i = 0; i < data.length - 1; i++) {
//			for (int j = i+1; j < data.length; j++) {
//					if(data[i] > data[j]) {
//						temp = data[i];
//						data[i] = data[j];
//						data[j] = temp;
//				}		
//			}
//		}
//		for (int i = 0; i < data.length; i++) {
//				System.out.println(i+1 + " 은 " + data[i]);
//						}
//-----------------------------------------------------------------
		
		/* 과제4
			메소드명	: 	isNumber 
			기능 		: 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다. 
			모두 숫자로만 이루어져 있으면 true를 반환하고, 그렇지 않으면 false를 반환한다. 
			만일 주어진 문자열이 null이거나 빈 문자열“”이라면 false를 반환한다. 
			반환타입 	: boolean 
			매개변수 	: String str - 검사할 문자열 
 			[Hint] String클래스의 charAt(int i)메소드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다. 
			(1) isNumber메소드를 작성하시오.
 			{   
 			String str = "123";   
 			System.out.println(str+"는 숫자입니까? "+isNumber(str));   
 			str = "1234o";   
 			System.out.println(str+"는 숫자입니까? "+isNumber(str));  
			}
		 */	
//
//		String str = "123";   

//-----------------------------------------------------------------
		/* 과제5
			(1) 배열의 값에 *2배의 연산된 값이 산출되도록 메소드를 작성하시오. 
			{   
			int num1[] = {1, 2, 3, 4, 5};   
			getDouble(...       // 결과 출력  }
		 */	
		int num1[] = { 1, 2, 3, 4, 5 };
		
		getDouble(num1);
		for (int i = 0; i < num1.length; i++) {
			System.out.println("num1[" + i + "] = " + num1[i]);
		}
		
//-----------------------------------------------------------------
		/* 과제6
		다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다. 
		(1)에 알맞은 코드를 넣어서 완성하시오. 
 		a b c d e f g h i j k l m n o p q r s t u v w x y z 
 		` ~ ! @ # $ % ^ & * ( ) - _ + = | [ ] { } ; : , . / 
 		0 1 2 3 4 5 6 7 8 9 
 		q w e r t y u i o p 
		char[] abcCode =   
			{  
			'`','~','!','@','#','$','%','^','&','*',  
			'(',')','-','_','+','=','|','[',']','{',    
			'}',';',':',',','.','/'}; 
 
    	0 1 2 3 4 5 6 7 8 9  
    	char[] numCode = {'q','w','e','r','t','y','u','i','o','p'}; 
			암호화/복호화
		 */
//		char[] abcCode = { '`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'}; 
//		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'}; 
	
	}
//과제1----------------------------------------------------------
	
//	static double getDistance(int x, int y, int x1, int y1) {
//	System.out.println(getDistance(1,1,2,2));  
//	}  

//과제2----------------------------------------------------------
//	static int shuffle(int[] arr) {   	
//		
//	}
//과제3----------------------------------------------------------
//	static int[] max() {   
//	System.out.println("최대값:"+max(data)); 
//	}
//과제4----------------------------------------------------------
//	static String {
//	System.out.println(str+"는 숫자입니까? "+isNumber(str));   
//	str = "1234o";   
//	System.out.println(str+"는 숫자입니까? "+isNumber(str)); 
// 	}
//과제5----------------------------------------------------------
 	static void getDouble(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2;
		}
		for (int i = 0; i < arr.length; i++) {
		}
 	}
//과제6----------------------------------------------------------
//	static char {
// 	// abcdefghijklmnopqrstuvwxyz  
//	
//	 
//	// 0 1 2 3 4 5 6 7 8 9  
//	
//	}
	
}

