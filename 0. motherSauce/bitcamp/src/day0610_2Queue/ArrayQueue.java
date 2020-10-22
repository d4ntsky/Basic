package day0610_2Queue;

import java.util.LinkedList;
import java.util.List;

public class ArrayQueue {
		
	private List<Object> list = new LinkedList<Object>();
	
	public ArrayQueue() {
	}
	
	public boolean isEmpty() {
		return (list.size() == 0);
	}
	
	//public boolean full() {
	//	return (rear == maxSize - 1);
	//}
	
	// insert == push
	public void push(Object item) {
		list.add(item);
	}
	
	public Object pop() {
		Object item = peek();
		list.remove(item);		
		return item;
	}

	public Object peek() {		
		if(isEmpty()) {
			System.out.println("데이터가 없습니다");
			return null;
		}
		
		return list.get(0);		
	}
	
	

}






