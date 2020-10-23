package windowChange2_Singleton;

public class mainClass {

	public static void main(String[] args) {
		//리소스가 커질 가능성이...
		
		//SingletonClass sc = SingletonClass.getInstance();
		
		SingletonClass.getInstance().one.setVisible(true);
	}

}
