package day03;
//강사님
import java.util.Scanner;

public class Ex05PrintStar8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 8번=====");
		System.out.println("출력할 줄 수를 입력해주세요: ");
		int userNumber = scanner.nextInt();
		for (int height = 1; height <= 2 * userNumber - 1; height++) {
			String stars = "";
			if (height < userNumber) {
				// 윗부분
				for (int width = 1; width <= userNumber - height; width++) {
					stars += " ";
				}
				for (int width = 1; width <= height; width++) {
					stars += "*";
				}

			} else {
				// 아랫부분
				int lowerHeight = height - userNumber + 1;
				for (int width = 1; width <= lowerHeight - 1; width++) {
					stars += " ";
				}
				for (int width = lowerHeight; width <= userNumber; width++) {
					stars += "*";
				}
			}

			System.out.println(stars);
		}

		scanner.close();
	}
}