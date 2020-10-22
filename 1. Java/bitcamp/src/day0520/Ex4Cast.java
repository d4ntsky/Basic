package day0520;

public class Ex4Cast {

	public static void main(String[] args) {
		/*
			(자료형)변환
			boolean		1
			
			byte		1
			short		2
			int			4
			long		8
			
			float		4
			double		8
			
			(자동(auto) 형 변환, 강제(cast) 형 변환) transform
			//소수점형이 더 변환작업에 있어서 상태...우선순위 높음
		*/
		
		// 자동 형 변환
		short sh = 10;
		int num;
		
		num = sh; //자동 형 변환
		System.out.println("num = " + num);
		//작은 그릇에서 큰 그릇으로 변환
		
		// 강제 형 변환
		num = 20;
		//sh = num; //int 값은 short 값에 넣을수 없다 하지만 (명시)하면됨
		sh = (short)num;
		System.out.println("sh = " + sh);
		// 명시하는 것을 강제 형 변환이라 한다.
		
		num = 128;
		byte by = (byte)num;//강제형변환
		System.out.println("by = " + by);
		//이렇게 사용하는건 드물다
		
		float f1;
		
		f1 = 3 / 2;
		System.out.println("f1 = " + f1);
		
		f1 = (float)3 / 2;
		System.out.println("f1 = " + f1);
		
		// 우선순위
		long lo = 12121231311L;
		float fl;
		fl = lo;
		
		double d; //do는 예약어
		d = lo;
		
		System.out.println("fl = " + fl);
		System.out.println("d = " + d);
		
		//1.21212314E10
		//			*10의 10승
		//1.2121231311E10
		// E3 = * 10 * 10 * 10
		// E-2 = = *(1/10)*(1/10)
		// double이 float보다 정확!
	
		//소숫점 자리는 버림
		double value = 123.6567; // > 123
		int n;
		n = (int)value;
		System.out.println("n = " + n);
		
		//cf)계산기는 숫자로 받아 문자로 바꿔 계산후 숫자로 변환에서 내보냄	
	}

}