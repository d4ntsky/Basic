package view;
import dto.NetworkSerialize;

public class SingletonClass {
	private static SingletonClass singleton = new SingletonClass(); 
	public NetworkSerialize ns;

	//아래와같이 생성자가 private로 두어서 메인에서 생성할 수 없게 합니다. 
	private SingletonClass(){ 
		ns = new NetworkSerialize(1, "id", 1);
	} 

	//클래스 메소드로 딱 하나 만든 클래스변수를 반환하게 합니다. 
	public static SingletonClass getInstance(){ 
		return singleton; 
	}
}
