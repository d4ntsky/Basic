package Task0526;

public class Task0526 {
	public static void main(String[] args) {	
		 /*
			int arr2[][] = )
			{1,2,3},
			{4,5,6}
			}
			int array[] = new int[];
		 */
		
		char array2[][] = {
				{'A','B','C','D'}, //[0][0] [0][1] [0][2] [0][3]
				{'E','F','G','H'},
				{'I','J','K','L'},
				{'M','N','O','P'}
		};
		
		char array1[] = new char[array2.length * array2[0].length];
		/*
			array2[0][0]  4 * 0 + 0		->array1[0]
			array2[0][1]  4 * 0 + 1		->array1[1]
			array2[0][2]  4 * 0 + 2		->array1[2]
			array2[0][3] 				->array1[3]
			
			array2[1][0]  4 * 1 + 0		->array1[4]
			array2[1][1]  4 * 1 + 1		->array1[5]
			array2[1][2] 				->array1[6]
			array2[1][3] 				->array1[7]
		*/
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
				array1[array2[0].length*i+j] = array2[i][j];
			}//위식이 계산하기 싫을시
		}
		for (int i = 0; i < array1.length; i++) {
			System.out.println(i+ ":" 
		+array1[i]);
		}
		//-----------------------------------------------------
		
		int count = 0;
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[0].length; j++) {
			
				array1[count] = array2[i][j];
			count++;
			}
		}//밑에 방법이 효율적이지 못한게 배열이 바뀌면[][] 뒤에것이 바뀌면 못쓰는 방법
		
		for (int i = 0; i < array1.length; i++) {
			System.out.println(i+ ":" 
		+array1[i]);
		}
		
		
		
		//-----------------------------------------------------
		/*
			fibonnaci 피보나치 수열 // cf 
			소라게
			0 1 1 2 3 5 8 13 21 34//증권/선물에서 많이 쓰임
		 */	
		//0 1 로 시작 1 2 3 5 8 13 21 34 55 89 
		//a	b      c
		//	a      b c
		//loop 30회 integer 값 넘음
		long a, b, c;
		long arrNum[] = new long[30];
		int w = 0;
		//초기값
		a = 0;
		b = 1;
		
		arrNum[0] = a;
		arrNum[1] = b;
		
		//값을 갱신
//		c = a + b;
//		arrNum[2] = c;
//		a = b;
//		b = c;
		
		while(w < 28) {
			c = a + b;
			arrNum[w + 2] = c;
			a = b;
			b = c;
			w++;
		}
		for (int i = 0; i < arrNum.length; i++) {
			System.out.print(arrNum[i] +" ");
		}
		System.out.println();
		
	}
}