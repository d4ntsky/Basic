package day03;
//강사님
//여기서 역다이아몬드는 맨 윗줄과 밑 줄은 패턴에 포함되지 않는다!!
import java.util.Scanner;
public class Ex09PrintStar10 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====별찍기 10번=====");
		System.out.println("출력할 줄 수: ");
		int userNumber = scanner.nextInt();
		
		for(int height = 1; height <= 2 * userNumber - 1 ; height++) {
			String stars = "";
			//1번째 줄 혹은 마지막 줄이면 무조건 길다란 별을 만들어준다.
			//첫번째줄은 1이고 마지막줄은 대입값*2-1
			if(height == 1 || height == 2 * userNumber - 1) {
				for(int width = 1; width <= 2 * userNumber - 1; width++) {
					stars += "*";
				}
			}else if(height < userNumber) {
				//윗부분
				//별은 감소, 공백은 증가
				int upperHeight = height - 1;
				for(int width = 1; width <= userNumber - upperHeight; width++) {
					stars+= "*";
				}
				for(int width = 1; width <= 2 * upperHeight - 1; width++) {
					stars+= " "; 
				}
				for(int width = 1; width <= userNumber - upperHeight; width++) {
					stars+= "*";
				}
			}else {
				//아랫부분
				//별은 증가, 공백은 감소
				int lowerHeight = height - userNumber + 1;
				for(int width = 1; width <= lowerHeight; width++) {
					stars += "*";
				}
				//2 * userNumber - 2 * lowerHeight - 1;
				//2 * (userNumber - lowerHeight) - 1;
				int spaceWidth = 2 * (userNumber -lowerHeight) - 1;
				for(int width = 1; width <= spaceWidth; width++) {
					stars += " ";
				}
				for(int width = 1; width <= lowerHeight; width++) {
					stars += "*";
				}
			}
			
			
		System.out.println(stars);
		}
		
		scanner.close();
	}
}