package day0525;

public class Ex1Wrapper {

	public static void main(String[] args) {
		/*
		 * Wrapper Class
		 * 일반 자료형(int, char)를 클래스화 한 것
		 * Collection : list, map
		 * 
		 * 일반 자료형			class
		 * boolean			Boolean
		 * 
		 * byte				Byte
		 * short			Short
		 * int				Integer (사용빈도가 높은편)
		 * long				Long
		 * 
		 * float			Float
		 * double 			Double 	(꽤 사용함)
		 * 
		 * char				Character
		 * char[]			String  (가장 중요)
		 */
		
		/* 숫자 -> 문자열
		 * valueOf
		 * 			123 + ""; 123.456 + "" ==> "123.456"
		 *
		 * 문자열 -> 숫자
		 */
		String strNum = "234";
		int cnum = Integer.parseInt(strNum);
		System.out.println("cnum = " + (cnum+1));
		
		String dstrNum = "123.456";
		double dnum = Double.parseDouble(dstrNum);
		System.out.println("dnum = " + (dnum+1.1));
		
		//toString(); -> 문자열로 변경해준다. -> valueOf()
		Double dou = 235.678;
		Double dou1 = new Double(345.678);
		
		dou.toString();
		
		//	10진수 -> 2진수
		int n10 = 12;
		String n2 = Integer.toBinaryString(n10);
		System.out.println("n2 : " + n2);
		
		// 2진수 -> 10진수
		n2 = "11001010";
		n10 = Integer.parseInt(n2, 2);
		System.out.println("n10 : " + n10);
		
		// 10진수 -> 16진수
		System.out.println("10 -> " +Integer.toHexString(10));
		
		// 16진수 -> 10진수
		System.out.println("A -> " +Integer.parseInt("a", 16));
		
	}
}

