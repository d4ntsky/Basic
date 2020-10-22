package day0527;

public class Ex1Function {
	public static void main(String[] args) {
		/*
			함수 function
			value가 처리(코드에서)가 이뤄지고 새로운 value가 나온다 
		 	들어가는 걸 매개변수,parameter,인수,인자
		 	나오는 것을 return (나오는 값은 항상 하나 아니면 없음)
		 	
		 	function 종류
		 	들어가거나 안들어가거나		처리		나올때는 한개거나 안나오거나
		 	
		 	지금까지는 절차지향 logic으로 순번처리로 배웠다면 
		 	같은 처리를 해야되는 부분을 계속 사용했다면
		 	코드를 하나로 묶어서 처리가 필요한 인수를 넣는것
		 	
		 	cf) 솔루션 = 해결책
		 	개발 회사 - 함수만 만드는....
		 --------------------------------
		 
			function : 함수, 독립적인 프로세스
			method	 : 함수, class에 포함되어있는 함수 (종속적임)
			의미적 차이는 크게 없는편?
				C언어		: function
				Java	: class
				
			    목적    :	코드의 간략화.
					동일한(같은 처리) 코드를 집약적으로 설정
		 	
		 	    가독성 :	이해하기 쉽게 작성하는 성질 cf) 게임은 java로 힘듦
		 	    
		 	    형식				인수, 인자, 매개변수, parameter
				return 값(자료형) 함수명(자료형 가상인수,....) {
					처리
					return 값; <- 없을 수도 있음
				}
				
				return 값(자료형)	: 
				char int double int[] String void(return값이 없음)
		 	
		 	ex)
		 	int funcName(char c, double d) {
		 		처리
		 		return 값; <- 정수(int)-맨앞값
		 	}
		 	
		 	함수의 형태 예시
		 	1. 들어오는 값 0	나오는 값 0 //가장 많이 사용 //class에서 가장많이 사용
		 	2. 들어오는 값 1	나오는 값 0
		 	3. 들어오는 값 2	나오는 값 0
		 	4. 들어오는 값 1 	나오는 값 1
		 	5. 들어오는 값 0	나오는 값 1
		 	
		 	 */
			function1();							//1
			
			function2(12);							//2
			
			function3("My World", 123.456);			//3
			function3("Your World", 123);
			
			int returnValue = function4(333.444);	//4 	//value에 의한 할당
			System.out.println("main() returnValue = " + returnValue);
			//메인 안 returnValue
			int asc= getASCIIcode('A');
			System.out.println("asc = " + asc);
			System.out.println(getASCIIcode('a'));
			
			int num = function5();					//5
			System.out.println("num = " + num);
			//random 함수가 5형태임
			int r = (int)(Math.random() * 10);
								//매개변수 없고 나가는 값만 double
			//.length도 5형태였음. 들어가는 값은 없고 나가는 값만 integer
			String str = "hello";
			int len = str.length();
			// toUpperCase
			String aaa = "ABCdef";
			String result = aaa.toUpperCase();
			
			
			
			//---------------------------------------
			//배열을 넘겨서 설정
			int arrNum[] = { 1,2,3,4,5 };
			arrProcess(arrNum); //프로세스 넘겨주는 것					//위에 value할당 비교
															//address에 의한 할당
		}
	//---------------------------------------------------------------
			static void function1() {							//1
				System.out.println("function1() 호출");
				
			}
			static void function2(int n) {						//2
				System.out.println("function2(int n) 호출");		
				System.out.println("매개변수를 통한 가인수 n = " + n);
			}
			static void function3(String str, double d) {		//3
				System.out.println("function3(String str, double d) 호출");
				System.out.println("str = " + str);
				System.out.println("d = " + d);
			}//여러번 호출 가능
			static int function4(double d) {					//4
				System.out.println("function4(double d) 호출");
				System.out.println("d = " + d);
				return (int)d; //(int)가 없을시 확인
			}
			static int function5() {							//5
				System.out.println("function5() 호출");
				return 12;
			}
			
			//-------------------------in값1 out값1 //3번 예시
			static int getASCIIcode(char c) {
				return (int)c;
			}
			//---배열 넘기는			넘겨받는 값 가인수는 같을 필요 없음
			static void arrProcess(int[] arr) {
				for (int i = 0; i < arr.length; i++) {
					System.out.println("arr[" + i + "] = " + arr[i]);
				}
			}
}