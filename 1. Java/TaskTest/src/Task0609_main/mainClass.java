package Task0609_main;

import Task0609_cls.Circle;
import Task0609_cls.Point3D;
import Task0609_cls.Rectangle;
import Task0609_cls.Shape;


public class mainClass {
	public static void main(String[] args) {
		
		
		Shape circle = new Circle(3.0);
		System.out.println(circle.calcArea());
		
		Shape rectangle = new Rectangle(23, 34);
		System.out.println(rectangle.calcArea());
		System.out.println("정사각형 = " +((Rectangle)rectangle).isSquare());
		
		System.out.println("=================================================");
		
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1); 
		System.out.println(p2); 
		System.out.println("p1==p2?"+(p1==p2));					// 주소값 	  비교
		System.out.println("p1.equals(p2)?"+(p1.equals(p2)));	// 멤버변수의 값 비교
		
		
		//cf)
		String str1 = "hello";
		String str2 = "hell";
		str2 = str2 + "o";
		
		str1.equals(str2);
	}
}