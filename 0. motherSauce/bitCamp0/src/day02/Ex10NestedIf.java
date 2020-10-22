package day02;
//중첩 if
//if문 안에 if문이 들어간 형태
//사용자의 정보를 입력 받아서
//현역, 공인, 미필을 출력하는 프로그램 (이름/성별/나이) (남자이고 18세이상)
import java.util.Scanner;
public class Ex10NestedIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요: ");
		String name = scanner.nextLine();
		
		System.out.println("성별을 입력하세요:  (1:남자 2:여자)");
		int sungbyul = scanner.nextInt();
		
		if(sungbyul == 1) {
			//남자이므로 나이를 입력받는다.
			System.out.println("나이를 입력하세요: ");
			int age = scanner.nextInt();
			if(age >= 18) {
				//성인 남성이므로 신체등급을 입력받는다.
				System.out.println("신체등급을 입력하세요: ");
				int category = scanner.nextInt();
				switch(category) {
				case 1:
				case 2:
				case 3:
					System.out.println(name+"님은 현역입니다.");
					//("축하합니다"+name+"님은 현역입니다.") 이런식으로 됨
					break;
				case 4:
					System.out.println(name+"님은 공익입니다.");
					break;
				default:
					System.out.println(name+"님은 면제입니다.");
					break;
				}
			}else {
				//미성년이므로 메세지만 출력
				System.out.println(name+"님은 아직 미성년자입니다.");
			}
		}else {
			//여자이므로 메시지만 출력
			System.out.println(name+"님은 여성이므로 국방의 의무가 없습니다");
		}
		scanner.close();
		
		
//cf class명을 바꿀 때에는 클래스를 선택하고 f2버튼을 눌러 바꾼다
	}
}

