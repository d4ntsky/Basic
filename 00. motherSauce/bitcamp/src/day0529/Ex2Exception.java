package day0529;

public class Ex2Exception {

	public static void main(String[] args) {
		/*
			Exception : 예외			!= 에러
			
			baseball -> 1 2 3 ~ 10 -> 'A' (컴퓨터는 Ascii코드 65로 처리함)
		
		ex) 대표 예
			1.
			number -> format 1~ 3 -> (int)'A' 
			2.
			array -> index number [3] ->  array[3] (0,1,2)
			3.
			class -> Scanner 못 찾는 경우
			4.
			file -> 없을 경우
		
			예외 try catch 형식
			try{
				예외1가 나올 수 있는 소스
				 예외2가 나올 수 있는 소스
			}catch(예외클래스1 e){
				메세지
			}catch(예외클래스2 e){
				메세지
			}catch(예외클래스3 e){
				메세지
			}finally{	// 생략이 가능
				// 무조건 실핼
				// 뒤처리
				 	파일 close
				 	Database 원상복구 roll back -> undo
			}
		*/
		/*
		int array[] = { 1, 2, 3 };
		System.out.println("프로그램 시작");
		
		try {					//프로그램이 멈추는 게 아니고 메세지를 주고 계속 진행된다.
		for (int i = 0; i < 4; i++) {
			System.out.println(array[i]);
		}
		}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("배열 범위 초과");
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		return;									//return이 여기 있을 경우...
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally 무조건 실행"); //값변경?
		}
		
		System.out.println("프로그램 끝");
		*/
		
		func1();
		func2();
	}
	//function에 exception을 두는 법
	static void func1()  {
	
		try {
		int array[] = { 1, 2, 3 };
		
		for (int i = 0; i < 4; i++) {
			System.out.println(array[i]);
		}
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
		
	static void func2() throws ArrayIndexOutOfBoundsException {		//가장 많이씀
				
		int array[] = { 1, 2, 3 };
		for (int i = 0; i < 4; i++) {
			System.out.println(array[i]);
			}
		}
	// 위 두개는 같은 처리
}