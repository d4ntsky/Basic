package single;

public class SingletonClass {
//2)
	
	private static SingletonClass sc = null;	//cf)sc는 스캐너랑 겹침
	
	private SingletonClass() {	//기본생성자를 생성하면
								//private로 잡으면 mainClass에서 외부에서 접근 불가하고 생성 불가 
		
	}
	
	public static SingletonClass getInstance() {
		if(sc == null) {
			sc = new SingletonClass();
		}
		return sc;//처음 null이였을 때 한번 생성 시 한 번만 해주고 그 다음은 계속 같은 것만 던져줌
	}
	
	
	//2) 마이클래스에서 값 넘겨받기-2
	public int snumber;
	
	/*
		Singleton : 하나의 instance에 접근하여 데이터를 송수신할 수 있는 Pattern
				장점은 언제 어디서든지 접근할 수 있다.
	*/
	
	//4)-2
	public String sStr;
	
}