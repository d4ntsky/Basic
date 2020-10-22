package Task0601_Figure1;

import java.util.Scanner;

public class FigRectangle {
	/*
 	userInput (가로/세로)
 	
 	result (가로x세로)
 	
 */
int a, b;

public void userInput1() {
	Scanner sc = new Scanner(System.in);
	System.out.println("가로");
	a = sc.nextInt();
	System.out.println("세로");
	b = sc.nextInt();
}
public void result1() {
	userInput1();

	int ab = a * b;
	System.out.println(ab);
}
}
