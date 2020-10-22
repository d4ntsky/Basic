package day03;
//별찍기 9번
import java.util.Scanner;
public class Ex08PrintStar9 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 9번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		
		for(int height = 1; height <= userNumber; height++) {
			String stars = "";
		if(height<userNumber) {
			for(int width = 1; width <= userNumber - height; width++) {
				stars += " ";
			}
			for(int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			}
			
		}else {
			for(int width = 1; width <= height; width++) {
				stars += " ";
			//그전에 공백을 먼저 넣어야함
			}
			for(int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			//1,3,5로 들어가는 부분
		}
				
		}
			System.out.println(stars);
			
		}
	
		
		scanner.close();
	}
}