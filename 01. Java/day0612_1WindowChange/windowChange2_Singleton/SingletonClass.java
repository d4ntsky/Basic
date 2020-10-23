package windowChange2_Singleton;

public class SingletonClass {	//delegate
	
	private static SingletonClass sc = null;
	
	WindowOne one;
	WindowTwo two;
	
	private SingletonClass() {
		one = new WindowOne();
		two = new WindowTwo();
	}
	
	public static SingletonClass getInstance() {
		if(sc == null) {
			sc = new SingletonClass();
		}
		return sc;
	}
}
