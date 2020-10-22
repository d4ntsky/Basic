package day03;
//별찍기 5번
import java.util.Scanner;
public class Ex01PrintStar5 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 5번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		//----------------------------------------------
		
		for(int height = 1; height <= userNumber; height++) {
			String stars = "";
			//유저 넘버보다 작거나 같을때부터 해라
			// height 1/3/5/7/9로 늘어남
			for(int width = 1; width <= userNumber - height; width++) {
				stars += " ";
			//그전에 공백을 먼저 넣어야함
			}
			for(int width = 1; width <= 2 * height - 1; width++) {
				stars += "*";
			//1,3,5로 들어가는 부분
			}
			System.out.println(stars);
			//출력시키는 부분
		}
		//----------------------------------------------
		
		
		scanner.close();
		}
}