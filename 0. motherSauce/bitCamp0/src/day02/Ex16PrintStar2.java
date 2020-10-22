package day02;

import java.util.Scanner;
public class Ex16PrintStar2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 2번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		for(int height = 1; height <= userNumber; height++) {
			String stars = "";
			for(int width = height; width <= userNumber; width++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		
		scanner.close();
	}
}
