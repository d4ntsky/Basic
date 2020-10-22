package Task0601_Figure1;

import java.util.Scanner;

public class FigCircle {
	/*
 	userInput (반지름)
 	
 	result (반지름반지름파이)
 	
 */
	int c;
	public void userInput2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름");
		c = sc.nextInt();
	}
	public void result2() {
		userInput2();
	
		double cc = c * c * 3.14;
		System.out.println(cc);
	}
}