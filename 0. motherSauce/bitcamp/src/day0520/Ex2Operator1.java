package day0520;

public class Ex2Operator1 {

	public static void main(String[] args) {
		/*
			Operator
			+, -, *, /, %
			/ : 몫
			% : 나눈 나머지
		*/
		
		int num1, num2;
		int result;		//결과
		
		num1 = 25;
		num2 = 7;
		
		//a = b; //오른편 값이 왼편으로 들어감
		//num1 + num2 = result xxxxxx 아니다 결과값이 왼쪽으로
		result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		
		result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
		
		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
		
		result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
		
		result = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + result);
		
		//cf
		//나눈값이 0일때 num2 = 0인 경우 에러가 납니다
		//메세지를 띄우는 코드가 들어가야함!!! ex)"다시 입력해주세요"
		
		int number = 0;
		
		number = number +1; //자기 자신의 값을 갱신
		number += 1;		//위에꺼와 같은 표현(나중에 나온 방식)
		//밑에꺼 보단 위에가 많이 쓰이는 편 명시적이여야하기 때문에
		
		//increment (증가연산자) ++
		//decrement (감소연산자) --
		number++; // number = number + 1;
		++number;
		//++의 앞뒤는 표현방법의 차이 딱히 상관없음 그러나 연산과 함께하면 값이 달라진다!!
		number--;
		--number;
		//++을 더 많이씀 -- xx
		
		System.out.println("number = " + number);
		
		int tag;
		
		tag = ++number; // number = 3 tag = 3 
		System.out.println("number = " + number);
		System.out.println("tag = " + tag);
		
		tag = number++; // number = 4 tag = 3   
		System.out.println("number = " + number);
		System.out.println("tag = " + tag);
		//number++이 결과 처리가 달라짐
		
		tag = (number++);   // number = 5 tag = 4    
		System.out.println("number = " + number);
		System.out.println("tag = " + tag);
		//number는 4인상태 ()쳐도 소용없음
		
	}

}