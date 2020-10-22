package clsZ;

import single.SingletonClass;

public class ZomClass {
	//3) 어디서든지 접근 할 수 있는 지 확인
	private int num;
	public void function() {
		SingletonClass sc = SingletonClass.getInstance();
		num = sc.snumber;
	}
	
	//4)-3
	private String zStr;
	public void strFunc() {
		SingletonClass sc = SingletonClass.getInstance();
		zStr = sc.sStr;
	}
	@Override
	public String toString() {
		return "ZomClass [zStr=" + zStr + "]";
	}
	
}
