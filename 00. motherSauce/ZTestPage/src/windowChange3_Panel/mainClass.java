package windowChange3_Panel;

import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력");
		String i = sc.nextLine();
		char c ;
			for (int j = 0; j < i.length(); j++) {
				c = i.charAt(j);
				if(!('0' <= c && c <= '9')) {
					System.out.println("실패");
				}
			}
	
				
		System.out.println(i);
		sc.close();
		
	}

}