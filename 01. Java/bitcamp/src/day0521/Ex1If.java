package day0521;

public class Ex1If {

	public static void main(String[] args) {
		/*
	제어문 
		- 조건문
			if		
				if
				else
				else if
			논리 연산자와 자주 같이쓰임 논리연산자 		&&(AND), ||(OR), !(NOT)
			범위를 표시할 수 있는 부등호와 많이 쓰인다 	> < >= <= == !=
				
			switch
				case
				break(규칙이 있음)
				
		- 순환문(loop)
		- 제어절
				break
			
			
			형식:
				조건(조건성립 공식 == (true/false)){
					처리
				}
		ex)
				if(number > 0){
					처리 (true면 처리 false면 넘어간다)
				} //순환문과 같이쓰임
	 
				if(number > 0 && number <= 10 && number != 5){
					조건은 여러개 붙을 수 있다
					처리 
				}
				----------------------------------------------
				if(number < 5){
					처리A
				}
				if(number > 10){
					처리A
				}
		==		if(number < 5 || number > 10){
					처리A
				}
				-----------------------------------------------
				if(조건1){
					처리B(조건1 == true)
				}
				else{
					처리C(조건1 == false)
				} 
				둘중에 하나는 반드시 처리/
				------------------------------------------------
				조건 분기 n개만큼의 조건
				if(조건1){
					처리1 true면 여기서 처리 false면 다음으로 넘어감
				}
				else if(조건2){
					처리2  두 조건 다 안 맞을 수 있음
				}
				else if(조건3){
					처리3
				}
				else{조건1,2,3 = false면
					마지막 처리
				}
				cf) else문만은 못 쓰고 조건문에서는 else문은 생략이 가능하다
				
				flow chart
		*/
		int number = 6;
		
		if(number > 5) {
			System.out.println("number는 5보다 크다");
		}
		if(number >= 6) {
			System.out.println("number는 6보다 크거나 같다");
		}
		if(number == 6) {
			System.out.println("number는 6이다");
		}
		if(number != 5) {
			System.out.println("number는 5가 아닌다");
		}		
		
		//if(number = 5) {
		//실무에서 오류나는 경우 number는 5이다로 가기때문에 java는 에러 c언어는 가능	
		//}
		//----------------------------------
		if(number >= 0 && number < 10) {
			System.out.println("number는 0부터 9까지의 수입니다");
		}
		if(number < 5 || number > 10) {
			System.out.println("number는 5보다 작거나 10보다 크다");
			//둘중에 하나만 true거나 둘다 ture면 가능
		}
		//----------------------------------
		if(number > 10) {
			System.out.println("number는 10보다 크다");
		}
		else {
			System.out.println("number는 10보다 작거나 같다");
		}
		//----------------------------------
		if(number > 10) 
			System.out.println("number는 10보다 크다");
		else 
			System.out.println("number는 10보다 작거나 같다");
		//{}가 없다.
		if(number > 10) System.out.println("number는 10보다 크다");
		else 			System.out.println("number는 10보다 작거나 같다");
		//간결하게
		
		//삼항연산자 String=(조건)?"값1":"값2";
		String str;
		str = (number > 10)?"number는 10보다 크다":"number는 10보다 작거나 같다";
		System.out.println(str);
		//선언 안한 삼항연산자
		System.out.println(str = (number > 10)?"number는 10보다 크다":"number는 10보다 작거나 같다");
		//알아보기 쉬운 코드가 좋은
		//----------------------------------
		
		// 조건 분기
		number = 75;
		
		if(number == 100) {
			System.out.println("100점입니다.");
		}
		else if(number >= 90 && number < 100) {
			System.out.println("90점 이상입니다.");
		}
		else if(number >= 80 && number < 90) {
			System.out.println("80점 이상입니다.");
		}
		else if(number >= 70 && number < 80) {
			System.out.println("70점 이상입니다.");
		}
		else {System.out.println("70점 미만입니다.");
		}
		//-----------------------
		if(number == 100) 		System.out.println("100점입니다.");
		else if(number >= 90) 	System.out.println("90점 이상입니다.");
		else if(number >= 80) 	System.out.println("80점 이상입니다.");
		else if(number >= 70) 	System.out.println("70점 이상입니다.");
		else 					System.out.println("70점 미만입니다.");
		
		number = 95;
		if(number >= 70) 		System.out.println("70점 이상입니다.");
		else if(number == 100) 	System.out.println("100점입니다.");
		else if(number >= 90) 	System.out.println("90점 이상입니다.");
		else if(number >= 80) 	System.out.println("80점 이상입니다.");
		else 					System.out.println("70점 미만입니다.");
		//높은 점수부터 순서대로 나오게 해야됨

		// 조건문 안에 조건
		number = 86;
		if(number >= 80 && number < 90) {
			if(number >=85) {
				System.out.println("합격입니다");
		}
			else {
				System.out.println("불합격입니다");
			}
		}
		//==
		if(number >= 85 && number < 90) {			
		}
		if(number >= 80 && number < 85) {			
		}
		//---------------------------------------------------
		boolean b;
		b = false;
		
		if(b == false) {//앞에 조건은 참
			System.out.println("b == false입니다.");
		}
		if(!b) {
			System.out.println("b == false입니다.");
			}//실무자용
		//-----------------------------------
		if(b) {
			System.out.println("b == true입니다.");
		}
		if(true) {
			//무조건 실행/무의미한 코드
		}
	}

}