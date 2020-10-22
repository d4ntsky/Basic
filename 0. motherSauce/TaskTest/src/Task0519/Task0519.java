package Task0519;

import java.util.Scanner;

public class Task0519 {
	public static void main(String[] args) {
		// 과제3
		String name;
		int age;
		boolean lady;
		String phone;
		double height;
		String adress;
		System.out.println("===========================================================");
		System.out.println("\\\tname\tage\tlady\tphone\theight\tadress\t\\");
		System.out.println("===========================================================");

		name = "홍길동";
		age = 24;
		lady = false;
		phone = "010-111-2222";
		height = 175.12;
		adress = "경기도";
		System.out.println(
				"\\\t\"" + name + "\"\t" + age + "\t" + lady + "\t" + phone + "\t" + height + "\t" + adress + "\t\\");

		name = "홍길동";
		age = 24;
		lady = false;
		phone = "010-111-2222";
		height = 175.12;
		adress = "경기도";
		System.out.println(
				"\\\t\"" + name + "\"\t" + age + "\t" + lady + "\t" + phone + "\t" + height + "\t" + adress + "\t\\");

		name = "홍길동";
		age = 24;
		lady = false;
		phone = "010-111-2222";
		height = 175.12;
		adress = "경기도";
		System.out.println(
				"\\\t\"" + name + "\"\t" + age + "\t" + lady + "\t" + phone + "\t" + height + "\t" + adress + "\t\\");

		System.out.println("===========================================================");

		// 과제4
		Scanner scan = new Scanner(System.in);

		System.out.print("이름:");
		name = scan.next();

		System.out.print("나이:");
		age = scan.nextInt();

		System.out.print("키:");
		height = scan.nextDouble();

		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("height:" + height);

//======================================================================		
		
		// 과제5
		// swap == 교환
		int x, y;
		int a, b;
		// 이건 효율적이지 못함
		// System.out.println("x = " + y);
		// System.out.println("y = " + x);
		x = 111;
		y = 222;
		a = x;
		b = y;
		x = b;
		y = a;
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		
//======================================================================
		
		int x1, y1;
		int temp;
		x1 = 333;
		y1 = 444;

		temp = x1;
		x1 = y1;
		y1 = temp;
		System.out.println("x1 = " + x1 + "\r\n" + "y1 =" + y1);
	}
}