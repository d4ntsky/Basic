package day0610_2Queue;

import java.util.Stack;

public class mainClass {

	public static void main(String[] args) {
		
		
		ArrayQueue queue = new ArrayQueue();
		
		// queue == FIFO
		// stack == FILO
		
		String str = "Tigers";
		queue.push(str);
		
		str = "Lions";
		queue.push(str);
		
		String s = (String)queue.peek();
		System.out.println("front = " + s);
		
		str = "Twins";
		queue.push(str);
		
		s = (String)queue.peek();
		System.out.println("front = " + s);
		
		s = (String)queue.pop();
		System.out.println("pop = " + s);		
		
		s = (String)queue.peek();
		System.out.println("front = " + s);
		
		
	}

}




