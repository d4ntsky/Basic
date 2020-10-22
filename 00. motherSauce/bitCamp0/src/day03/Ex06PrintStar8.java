package day03;

//?
import java.util.Scanner;

public class Ex06PrintStar8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 8번=====");
		System.out.println("출력할 줄 수를 입력해주세요: ");
		int userNumber = scanner.nextInt();

		{
			{
				for (int height = 1; height <= userNumber; height++) {
					String stars = "";
					for (int width = 1; width <= userNumber - height; width++) {
						stars += " ";
					}
					for (int width = 1; width <= height; width++) {
						stars += "*";
					}
					System.out.println(stars);
				}
			}
			{
				for (int height = 1; height <= userNumber; height++) {
					String stars = "";
					for (int width = 1; width <= height; width++) {
						stars += " ";
					}
					for (int width = height + 1; width <= userNumber; width++) {
						stars += "*";
					}
					System.out.println(stars);
				}
			}
			scanner.close();
		}
		// --------------------------------------------------------
		{
			for (int height = 1; height <= userNumber; height++) {
				String stars = "";
				if (height < userNumber) {
					for (int width = 1; width <= userNumber - height; width++) {
						stars += " ";
					}
					for (int width = 1; width <= height; width++) {
						stars += "*";
					}
				} else {
					for (int width = 1; width <= userNumber; width++) {
						stars += "";  //?
					}
					for (int width = 1; width <= height; width++) {
						stars += " ";
					}
					for (int width = 1; width <= userNumber - height; width++) {
						stars += "*";
					}

				}
				System.out.println(stars);
			}

		}
	}
}