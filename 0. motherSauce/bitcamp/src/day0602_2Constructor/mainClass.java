package day0602_2Constructor;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
	
//		MyClass cls = new MyClass();
//		
//		MyClass cls1 = new MyClass(123);
		
		MyClass cls2 = new MyClass(234, "abc");
		
		Scanner sc = new Scanner(System.in);
		sc.next();
		
		String str = "hello";
		String str1 = "world";
		str1 = str + str1;
		
		String _str = new String();
		String _str1 = new String("world");
		Integer in = new Integer(123);
		
}

}
