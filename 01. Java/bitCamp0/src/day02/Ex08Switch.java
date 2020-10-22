package day02;
//switch
//if문과는 틀리게 변수를 하나 선택해서
//그 변수의 값이 나오는 각각의 경우에
//따라서 코드가 실행된다.

public class Ex08Switch {
	public static void main(String[] args) {
		int number = 2;
		switch(number) {
		case 1:
			System.out.println("1입니다.");
			break;
			//만나는 순간 코드가 끝나게 되는
			//break가 없어지면 다음 결과도 도출됨.
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default:
			System.out.println("그외입니다.");
			break;
		}
	}
}