package day02;

import java.util.Scanner;
public class Ex17PrintStar3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 3번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		
		for(int height = 1; height <= userNumber; height++) {
			String stars = "";
			
			for(int width = 1; width <= userNumber - height; width++) {
												//여기서 -가 가능
				stars += " ";
				//공백을 넣는 for문
			}
			for(int width = 1; width <= height; width++) {
				stars += "*";
				//*  를 넣는 for문
			}
			System.out.println(stars);
		}
		
		
		scanner.close();
	}
}