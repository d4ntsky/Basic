package day0527;

import java.util.function.Function;

public class Ex2Function {
	public static void main(String[] args) {
		
		// value에 의한 할당
		// address에 의한 할당

		//--------------------------------------// value에 의한 할당
		int num1, num2, num3;
		num1 = 1;
		num2 = 2;
		num3 = 3;
		func1(num1, num2, num3); //==func1(1, 2, 3);이 넘어간것
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		//위에 값만 대입해준거고
		
		//--------------------------------------// address에 의한 할당
		int arrNum[] = { 1, 2, 3 };
		
		func2(arrNum);
		for (int i = 0; i < arrNum.length; i++) {
			System.out.println("arrNum[" + i + "] = " + arrNum[i]);
		}
		//return 값이 없는것
		//자기 자신이 가서 대입된거
		//int arr1[] = arrNum;
		int arr1[] = func3(arrNum);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		//return 받은 다음 다시 출력한것
	} 	//굳이 적어줄 필요 없는것
	
	
		//--------------------------------------// value에 의한 할당
	static void func1(int n1, int n2, int n3) { 
		n1 = n1 * 2;
		n2 = n2 * 2;
		n3 = n3 * 2;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
	}
		//--------------------------------------// address에 의한 할당
	static void func2(int arr[]) { 				
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}
	
	static int[] func3(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] *3;
			
		}
		return arr;
	}//배열로 들어갔다 배열로 나갈수 있음
}