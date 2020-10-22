package Task0527;

public class Task0527_Function {
	/* 과제1
	 //// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.  
	   		//static double getDistance(int x, int y, int x1, int y1) {
	  ////(1) 알맞은 코드를 넣어 완성하시오.      
       }
       System.out.println(getDistance(1,1,2,2)); 
		
		공식
		(x,y) (x1,y1)
		루트{ (y1-y)제곱 + (x1-x)제곱 }
		루트 함수				승수함수
	*/
	
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
	/* 과제5
		(1) 배열의 값에 *2배의 연산된 값이 산출되도록 메소드를 작성하시오. 
		{   
		int num1[] = {1, 2, 3, 4, 5};   
		getDouble(...       // 결과 출력  }
	 */	
	public static void main(String[] args) {
		
		
		
//과제1===================================================================

		//두 점 (x,y)와 (x1,y1)간의 거리를 구한다.  
		//System.out.println(getDistance(1,1,2,2)); 
		double dis = getDistance(1, 1, 2, 2);
			System.out.println("거리: "+ dis);
			
//과제2===================================================================
		
		//shuffle
		int original[] = {1,2,3,4,5,6,7,8,9};   
		System.out.println(java.util.Arrays.toString(original)); 
											//의미:결과보기위한/기능:배열안에 요소들을 다 출력하라
		int[] result = shuffle(original);   
		System.out.println(java.util.Arrays.toString(result));  
	
//과제3===================================================================

		//max 
		int[] data = {3,2,9,4,7};   
		System.out.println(java.util.Arrays.toString(data));   
		int r = max(data);
		System.out.println("최대값: " + r);
		
//과제4===================================================================
		
		//숫자로만 되어 있는지
		String str = "12345";  
		boolean b = isNumber(str);
			System.out.println(str+"는 숫자입니까? " + b);
			
		str = "1234o";   
		b = isNumber(str);
			System.out.println(str+"는 숫자입니까? " + b);  

//과제5===================================================================
		
		//
		int num1[] = {1, 2, 3, 4, 5};
	
		getDouble(num1);
		for (int i = 0; i < num1.length; i++) {
			System.out.println("num1[" + i + "] = " + num1[i]);
		}

		
	}
	
//과제1===================================================================
	
	static double getDistance(int x, int y, int x1, int y1) {
			double dx, dy;
			double result;
			// 루트{ (y1-y)제곱 + (x1-x)제곱 
			// 루트:sqrt	승수:pow
			dx = Math.pow(y1-y, 2);
			dy = Math.pow(x1-x, 2);
			
			result = Math.sqrt(dy + dx);
			
			return result;
//== 한번에	static double getDistance(int x, int y, int x1, int y1) {
//			return Math.sqrt(Math.pow(y1-y, 2) + Math.pow(x1-x, 2), 2)
//			}
			}
//과제2===================================================================
	
	static int[] shuffle(int[] original) {						//9
		//void return값 없는
		int temp;//swap용 변수
		
		for (int i = 0; i < 100; i++) {		//랜덤 수행하기 위한 loop문
			int r1 = (int)(Math.random() * original.length);	//0~8
			int r2 = (int)(Math.random() * original.length);	//0~8
			//지정되있는 숫자가 일률적이지 않을 때 이 코드가 좋다
			//이 코드는 100회 한정이기때문에 1~9사이에서 안나올 확률도 존재한다.
			temp = original[r1];
			original[r1] = original[r2];
			original[r2] = temp;			
		}
		return original;
	}
//과제3===================================================================
	
	static int max(int data[]) {
		int max_num = data[0];//-가 안나오게 초기화//0으로 초기화 하면 적을수도 있어서
		
		for (int i = 0; i < data.length; i++) {
			if(max_num < data[i]) {
				max_num = data[i];
			}
		}
		return max_num;
	}
//과제4===================================================================
	
	static boolean isNumber(String num) {
	//	boolean b = true;
		
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			int n = (int)c;
			if(n < 48 || n > 57) {
			//	b = false;
			//	break;
				return false;
			}
		}
		//return b;
		return true;
	}
//과제5===================================================================
		
	static int[] getDouble(int num1[]) {
		for (int i = 0; i < num1.length; i++) {
			num1[i] = num1[i] * 2;
		}
		for (int i = 0; i < num1.length; i++) {
			System.out.println("num1[" + i + "] = " + num1[i]);
		}
		return num1;
	}

	
}