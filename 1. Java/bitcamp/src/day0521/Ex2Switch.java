package day0521;

public class Ex2Switch {

	public static void main(String[] args) {
		/*
		switch : 조건문이지만, 값이 명확해야 한다.
				//사용 빈도가 낮음 그러나 큰 타이틀로 나눌때 많이 쓰임
		switch(변수){
			case 변수값1:
				처리1
				break;	//걸린다면 이 제어문을 탈출
			case 변수값2:
				처리2
				break;
			default:	//if문에서 else라 보면됨
				break;
		}
		*/
		int number = 1;
		
		switch(number) {
			case 1:
				System.out.println("number = 1");
			//	break;
			case 2:
				System.out.println("number = 2");
			//	break;
			default: //default 생략가능
				System.out.println("number != 1 and number != 2");
				break;//default를 위에다 두는 경우도 있음
		}
		//		break; 빠지면 원하지 않는 값도 보인다
		
		//범위 > < >= <= != 못 쓴다
		
		char c = '가';
		
		switch(c) {
			case '가':
				System.out.println("c = 가");
				break;
		}	
		
//		double d = 123.1;
//		
//		switch(d) {
//			case 123.1:
//				System.out.println("d = 가");
//				break;
		//소숫점은 사용할 수 없다.

		String str = "ABC"; //원래 안되던거였음 C언어는 아직도 안됨. 지금은 되긴함
		switch(str) {
			case "ABC":
				System.out.println("str = "+ str);
				break;
	}	
//		switch(number) {
//		case number > 2:
//			break;
//		}//안된다,,,
		
//		switch(process) {
//			case CREATE:
//				break;
//			case PRINT:
//				break;
//			case RELEASE:
//				break;
//		}
		//되지않음 그러나 쓰이긴 함 
		//char c = '+';
		//
		//switch(c){
		//	case '+':
		//
		//	break;
		//}   //깔끔하다는 게 장점
	}

}
