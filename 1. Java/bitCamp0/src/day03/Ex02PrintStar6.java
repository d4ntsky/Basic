package day03;
//별찍기 6번
import java.util.Scanner;
public class Ex02PrintStar6 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 6번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		//----------------------------------------------
		
		//for(int height = 1; height <= userNumber; height++) {
		//	String stars = "";
				//유저 넘버보다 작거나 같을때부터 해라
				// height 9/7/5/3/1로 줄어듬
		//	for(int width = 1; width <= height; width++) {
		//		stars += " ";
				//그전에 공백을 먼저 넣어야함
		//	}
		//	for(int width = userNumber*2-1 ; width <= userNumber*2-1; width++) {
		//		stars += "*";
				//9,7,5 로 들어가는 부분
		//	}
		//	System.out.println(stars);
				//출력시키는 부분
		//}
		//----------------------------------------------
		
		for(int height = userNumber; height >= 1; height--) {
			String stars = "";
			for(int width = 1; width <= userNumber - height; width++) {
				stars += " ";
			}
			for(int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			}
			System.out.println(stars);

		scanner.close();
		}
	}
}