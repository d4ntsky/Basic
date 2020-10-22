package day03;
//강사님
import java.util.Scanner;

public class Ex03PrintStar7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 7번=====");
		System.out.println("출력할 줄 수를 입력해주세요: ");
		int userNumber = scanner.nextInt();
		for(int height = 1; height <= 2 * userNumber - 1; height++){
			String stars = "";
			if(height < userNumber) {
				//윗부분
				for(int width = 1; width <= height; width++) {
					stars += "*";
				}
			}else {
				//아랫부분 cf(변수를 새로 추가 해서 바꿀 수 있다.)
				//for(int width = height - userNumber + 1; width <= userNumber; width++) {
				//	stars += "*";
				// =
				int lowerHeight = height - userNumber + 1;
				for(int width = lowerHeight; width <= userNumber; width++) {
					stars += "*";
				//
				}
			}
			System.out.println(stars);
		}
		
			scanner.close();
	}
}