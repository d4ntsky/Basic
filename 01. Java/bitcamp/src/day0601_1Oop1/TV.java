package day0601_1Oop1;

public class TV { //class 설(정의)
	String name; 
	int channel;
	boolean power;
	//int movie;
	
	public void getInput(String n, int c, boolean p) {
		name=n;
		channel=c;
		power = p;
		
	}
	public void setPower(boolean p) {
		power = p;
		
	}
	
	public void method() {
		System.out.println("name = " + name);
		System.out.println("channel = " + channel);
		System.out.println("power = " + power);
	}
}
	
	

