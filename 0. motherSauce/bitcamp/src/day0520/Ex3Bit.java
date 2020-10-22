package day0520;

public class Ex3Bit {

	public static void main(String[] args) {
		// bit Operator
		// 고급
		// 처리 속도가 빠르다. cf)솔루션 쪽
		/*
			bit : 0, 1
			
			&	AND
			|	OR
			^	XOR				-> 보안쪽에서 중요도 높음 
			<<	left shift
			>>	right shift
			~	반전
		*/
		
		int result;
		
		// AND
		//ex)
		//	1010 1100
		//	A	 C
		//	1111 0000
		//	F	 0		
		//	1010 0000
		//	A	 0
		result = 0xAC & 0xf0;//대,소문자 상관 없음
		System.out.println("result = " + result);
		System.out.printf("%x", result);
		System.out.println();
		System.out.printf("0x%x\n", result);//16진수표현
		
		// OR
		result = 0x48 | 0xB4;
		System.out.printf("0x%x\n", result);
		
		// XOR 다를 때만 참 //암호화,복호화
		result = 0xC4 ^ 0x78;
		System.out.printf("0x%x\n", result);
		
		// 반전(~) 0->1  1->0  NOT !
		byte by = 0x55; // 0101 0101  ~-> 1010 1010
		System.out.printf("0x%x\n", by);
		byte by1 = ~0x55;
		System.out.printf("0x%x\n", by1);
		
		//left shift(*2) 연산처리 속도 관련해서 있는// 2를 곱하는 것보다 2진법으로 활용해서?
		/*
				0000 0001	-> 1
				0000 0010	-> 2
				0000 0100   -> 4
		*/
		byte by2;
		by2 = 0x1 << 1;
		System.out.println("by2 = " + by2);
		by2 <<= 1;
		System.out.println("by2 = " + by2);
		by2 <<= 1;
		System.out.println("by2 = " + by2);
		
		//right shift(/2)
		by2 >>= 1;
		System.out.println("by2 = " + by2);
		
		// num1 = 0x12
		// num2 = 0x34
		// number = ~(num1 & ~num2)
//		int result2;
//		byte num1 = 0x12; //
//		byte num2 = 0x34; //
//		num2 = ~0x34;
//		num1 
//		result2 = ~(num1 & ~num2);
//		System.out.printf("%x\n", result2); //0xbc
	}

}
