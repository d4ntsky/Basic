package day03;

//??
import java.util.Scanner;

public class Ex10PrintStar10 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 10번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();

		for (int height = 1; height <= 2 * userNumber - 1; height++) {
			String stars = "";
			if (height < userNumber) {

				for (int width = 1; width <= userNumber - height; width++) {
					stars += "*";
				}
				for (int width = 1; width <= 2 * height - 1; width++) {
					stars += " ";
				}
				for (int width = 1; width <= userNumber - height; width++) {
					stars += "*";
				}

			} else {

				int lowerHeight = 2 * userNumber - height;
				for (int width = 1; width <= userNumber - lowerHeight; width++) {
					stars += "*";
				}
				for (int width = 1; width <= 2 * lowerHeight - 1; width++) {
					stars += " ";
				}
				for (int width = 1; width <= userNumber - lowerHeight; width++) {
					stars += "*";
				}
			}

			System.out.println(stars);
			scanner.close();
		}
	}
}
