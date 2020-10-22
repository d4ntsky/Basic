package Task0519;

import java.util.Scanner;

public class Test0519 {


	public static void main(String[] args) {
		
		//과제1 println/print 사용
		System.out.println("========================================");
		System.out.println("| 이름    나이        전화번호                           주소   | ");
		System.out.println("========================================");
		System.out.println("| 홍길동  20  010-111-2222          경기도   |");
		System.out.println("| 일지매  18  02-123- 4567           서울    |");
		System.out.println("========================================");
		
		//과제2 print와 escape sequence
		System.out.println("========================================");
		System.out.println("\\name\tage\tphone\t\tadress\\");
		System.out.println("========================================");
		System.out.println("\\\"홍길동\"\t20\t010-111-2222\t\'경기도\'\\");
		System.out.println("\\\"일지매\"\t18\t02-123-4567\t\'서울\'\\");
		System.out.println("========================================");
		
		
		//과제3 변수를 사용하라
		System.out.println("=================================================");
		System.out.println("\\이름\t나이\t남성\t전화번호\t     키\t   주소\\");
		System.out.println("=================================================");
		
			String nameA = ("\"홍길동\"");
			String nameB = ("\"일지매\"");
			String nameC = ("\"장옥정\"");
			int ageA = 20;
			int ageB = 18;
			int ageC = 14;
			boolean a1;
			boolean b2;
			boolean c3;
			a1 = true;
			b2 = true;
			c3 = false;
			String phoneA = ("010-111-2222");
			String phoneB = ("02-123-4567");
			String phoneC = ("02-345-7890");
			double heightA = 175.12;
			double heightB = 180.01;
			double heightC = 155.78;
			String adressA = ("\'경기도\'");
			String adressB = ("\'서울\'");
			String adressC = ("\'부산\'");
			
		System.out.println("\\" + nameA +" "+ageA+"      "+a1+" " +phoneA+" "+heightA+" "+adressA +"\\");
		System.out.println("\\" + nameB +" "+ageB+"      "+b2+" " +phoneB+"  "+heightB+"   "+adressB+"\\");
		System.out.println("\\" + nameC +" "+ageC+"      "+c3+" " +phoneC+" "+heightC+"   "+adressC+"\\");
		
		System.out.println("=================================================");
		
		
		
		
		//과제4
		//표준 입출력을 사용하여 이름, 나이, 전화번호, 주소의 
		//문자열을 입력 받아서 출력하는 프로그램을 작성하라.  (scan, print) 
		// name, age, man, phone, height, address
		
		Scanner scan = new Scanner(System.in);
		
		String name;
		System.out.print("이름 = ");
		name = scan.next();
					System.out.println("이름: "+ name);
					
		int age; 
		System.out.print("나이 = ");
		age = scan.nextInt(); 
					System.out.println("나이: "+age);
		
		boolean b;
		System.out.print("남자? = ");    
		b = scan.nextBoolean();       
					System.out.println("남자: " + b);		
					
		String phonNum;
		System.out.print("전화번호 = ");
		phonNum = scan.next();
					System.out.println("전화번호: "+ phonNum);
		double k;
		System.out.print("키 = ");
		k = scan.nextDouble();
					System.out.println("키: "+k);			
		
		String hom;
		System.out.print("집주소 = ");
		hom = scan.next();
					System.out.println("집주소: "+ hom);
						
			
		//과제5
		//두 개의 정수 값을 입력받고 x,y 변수에 저장한 후에 x,y 값을 바꾸고
		//출력하도록 프로그램을 작성하라.
		//int x,y;
		//x=1
		//y=2
		//출력 x=2 y=1
					
					int x;
					int y;
					System.out.print("X=?");
					x = scan.nextInt();
					System.out.print("y=?");
					y = scan.nextInt(); 
					     System.out.println("x의 값은"+y);
					     System.out.println("y의 값은"+x);
		     
		     
		     
		     
			scan.close(); 
	}

}