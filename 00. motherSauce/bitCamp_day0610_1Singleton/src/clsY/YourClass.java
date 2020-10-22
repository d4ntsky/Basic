package clsY;

import single.SingletonClass;

public class YourClass {
	private int tag;

	//1)
//	public void setTag(int tag) {
//		this.tag = tag;
//	}

	@Override
	public String toString() {
		return "YourClass [tag=" + tag + "]";
	}
	
	//2)-3
	public void func() {
		SingletonClass sc = SingletonClass.getInstance();
		this.tag = sc.snumber;
	}
	
	
	//4)-1 String 하나 받아서 heClass에 넘겨주는 
	private String yStr;
	
	public YourClass() {
		yStr = "확인";
	}
	public void strMet() {
		SingletonClass sc = SingletonClass.getInstance();
		sc.sStr = this.yStr; 
	}
}