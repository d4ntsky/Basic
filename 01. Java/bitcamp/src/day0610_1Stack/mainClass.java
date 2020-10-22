package day0610_1Stack;

public class mainClass {

	public static void main(String[] args) {
		/*
			Stack	-	First In Last Out	(FILO)선입후출	- 자료구조의 일종 
			 		쌓여있는 접시쓰는 느낌
			 		 in  -> Push
			 		 out -> Pop
				
			Queue	-	First In First Out	(FIFO)선입선출
					 in  -> Push
			 		 out -> Pop
					냉장고 안 재료소진 느낌
					
			cf) 들어가는 값	push	
				나오는 값	pop
		*/

		ArrayStack stack = new ArrayStack(10);
		
		//값 넣고
		String str = "AAA";
		stack.push(str);
		
		//확인
		String peekStr = (String)stack.peek();
		System.out.println("top Object = " + peekStr);
		
		//insert 후
		str = "BBB";
		stack.push(str);
		
		//확인
		peekStr = (String)stack.peek();
		System.out.println("top Object = " + peekStr);
		
		//꺼내기
		String popStr = (String)stack.pop();//확인용 리턴값 안받아도 된다.
		System.out.println("pop Object = " + popStr);
		
		//확인
		peekStr = (String)stack.peek();
		System.out.println("top Object = " + peekStr);
		
		//object로 했기때문에 int도 가능
		Integer in = 123;
		stack.push(in);
		
		//확인
		int topInt = (Integer)stack.peek();
		System.out.println("topInt = " + topInt);
		
		//스택에 들어가있는 object들 확인은??
		System.out.println(stack);
		//array로 하랬나...hashmap이랬나...
	}

}
