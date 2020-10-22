package main;

import java.util.Observable;

public class MyClass extends Observable{		//Human
					 //여기 이후로 붙힘
	
	//스트링 변수
	private String preArg = null;
	
	private String id;
	private String password;
	//일반 메소드
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override	//여기 패턴만 추가된거
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		
		// 변화가 없는 경우 -> 통지 안함.
		if(str.equals(preArg)) return;
		
		// 변화가 생긴 경우
		preArg = str;
				
		setChanged();//reset시켜주는 상속받는 함수
					
		super.notifyObservers(arg);
		
		clearChanged(); //여기도 쳤음
	}
	
}