package day04;
//얼레이리스트를 이용한 차량 관리 프로그램

import java.util.ArrayList;
import java.util.Scanner;

public class CarEx2 {
	public static void main(String[] args) {
		ArrayList<Car> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("비트 차량 관리 프로그램");
			System.out.println("1.등록	2.출력	3.삭제");
			System.out.print("> ");
			int choice = scanner.nextInt();
			if (choice == 1) {
				// 이제 우리가 ArrayList로 관리 하기 때문에
				// 리스트에 추가할때만 객체를 생성시켜서 거기에 값을 넣고
				// 리스트에 넣어주면 된다.
				Car c = new Car();

				scanner.nextLine();
				System.out.println("차량 번호: ");
				c.setNumber(scanner.nextLine());
				System.out.println("차량 종류: ");
				c.setType(scanner.nextLine());
				list.add(c);

			} else if (choice == 2) {
				if (list.size() == 0) {
					System.out.println("추가된 차량이 없습니다.");
				} else {
					System.out.println("====번호\t\t종류====");
					for (Car c : list) {
						System.out.println(c.getNumber() + "\t" + c.getType());
					}
				}

			} else if (choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}

		scanner.close();
	}
}
