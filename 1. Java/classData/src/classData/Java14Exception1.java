package classData;

public class Java14Exception1 {
	public static void main(String[] args) {
	/* 예외처리의 예
	NullPointerException
	-구체적인 문자열이 설정되지 않은 상태에서 null일때 메소드를 호출하는 경우
	-객체의 name 필드의 문자를 표시하는 것
	FileNotFoundException
	ArrayIndexOutOfBoundsException
	-배열에 없는 index를 찾는것
	StringIndexOutOfBoundsException
	-문자열이 4글자라면 5번째를 표시하려고 하는 경우
	NumberFormatException
	 */
		
	/* 예외처리
	여기서 말하는 예외라는 것은 쉽게 말하자면 프로그램의 오류 처리이다.
	오류 및 프로그램을 만들어보면
	int[] i = new int[1];
	i[0] = 0;
	i[1] = 1; //여기서 에러가 난다
	배열 요소 번호 1은 없다.
	ArrayIndexOutOfBoundsException라는 오류다.
	선언된 배열요소를 보다 큰 배열을 사용할 때 발생한다. 오류 처리부분 추가를 하면
	try {
		int[] i = new int[1];
		i[0] = 0;
		i[1] = 1; 
				//System.out.println("try블록 종료) - 실행되지 않음
	}catch(ArrayIndexOutOfBoundsException e){
		//ArrayIndexOutOfBoundsException가 발생하면 이곳으로
		System.out.println("에러가 발생함");
	} //finally {
		System.out.println("사후 처리") - 반드시 실행됨
	}
	그러나 일부 오류가 발생하더라도 finally를 통해반드시 처리를 수행할 수 있다.
	try{
		일반적으로 처리
	}catch (예외 변수) {
		예외가 발생한 경우의 처리
	}finally {
		마지막으로 반드시 실행되는 처리
	}
	finally 블록에 기술된 처리 오류가 발생해도 하지 않아도 반드시 실행된다.
	그래서 반드시 실시해야하는 처리를 기술하기에 적합하다.
	
	이와 같이 기술하면
	System.out.println("메소드 시작");
	> try 블록 안
	> catch 블록 중 (Exception이 발생한 경우만)
	> finally 블록 안
	> System.out.println("메소드 종료");
	순으로 실행되면 try블록안에 또 다른 try블록과 같이 중첩하여 작성가능하다.
	
	try {
		int [] i = new int [2]; // 오류가 발생하지 않도록 변경 
		i [0] = 0; 
		i [1] = 1; 
		System.out.println (i [1] / i [0]); // 여기에서 에러 
		System.out.println ( "try 블록 종료"); //이 행은 실행되지 않는다 
	} catch (ArrayIndexOutOfBoundsException e) {
		//ArrayIndexOutOfBoundsException가 발생하면 여기에 
			System.out.println ( "오류가 발생했습니다");
	} finally {
		System.out.println ( "사후 처리"); //이 행 마지막에 반드시 실행
	}
	배열의 수를 정확히 수정해서 ArrayIndexOutOfBoundsException를 해결했지만
	System.out.println (i [1] / i [0]); 부분에서 오류가 나게된다
	i[0]의 값이 0이며, 0으로 나누는 것은 불가능한 ArithmeticException 오류다.
	
	try { 
		// int [] i = new int [1]; 
		int [] i = new int [2]; // 오류가 발생하지 않도록 변경 
		i [0] = 0; 
		i [1] = 1; 
		System.out.println (i [1] / i [0]); // 여기에서 에러
		System.out.println ( "try 블록 종료"); //이 행은 실행되지 않습니다.
	} 
	catch (ArrayIndexOutOfBoundsException e) { 
		// ArrayIndexOutOfBoundsException가 발생하면 여기에 
		System.out.println ( "ArrayIndexOutOfBoundsException가 
			발생했습니다"); 
	}catch (ArithmeticException e) { 
		// ArithmeticException이 발생하면 여기에  
		System.out.println ( "ArithmeticException이 발생했습니다."); 
	} 
	finally { 
		System.out.println ( "처리"); //이 행은 마지막에 반드시 실행
	} 
	*/
	}
}
