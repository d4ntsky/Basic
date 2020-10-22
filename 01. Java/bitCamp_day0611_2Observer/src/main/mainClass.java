package main;

import observer.ObserverA;
import observer.ObserverB;

public class mainClass {

	public static void main(String[] args) {
		/*
			Observer	: 감시, 정찰
						감시자 패턴 => class 감시
		*/
		
		MyClass cls = new MyClass();
		
		// 감시자를 추가- 외부에서는 모름
		cls.addObserver(new ObserverA());
		cls.addObserver(new ObserverB());
		
		cls.setId("abc123");
		cls.setPassword("a1004");
		
		cls.notifyObservers(cls.getPassword());
	 
	}

}
