package day02;

import java.util.Scanner;
public class Ex18PrintStar4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 4번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		//내가 한거
		for(int height = 1; height <= userNumber; height++) {
			String stars = "";
			for(int width = 1; width <= height - 1; width++) {
				stars += " ";
			}
			for(int width = height; width <= userNumber; width++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		System.out.println("---------------------------------------------------------");
		//선생님이 가르쳐주신거

		for(int height = 0; height <= userNumber; height++) {
			String stars = "";
			for(int width = 1; width <= height; width++) {
				stars += " ";
			}
			for(int width = 1; width <= userNumber - height; width++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		
		scanner.close();
	}
}