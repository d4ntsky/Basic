package day0608;

public class Ex1Generic {

	public static void main(String[] args) {
	/* 
		Generic == template(형태)
				: 자료형의 변수
				: 같은 클래스에서 다양한 자료형을 사용하고 싶은 경우의 사용하는 요소
	*/
//		Box<int> box = new Box<>(123);
		Box<Integer> box = new Box<Integer>(111);
		System.out.println(box.getTemp() + 1);	
	
		Box<String> sBox = new Box<String>("My World");
		System.out.println(sBox.getTemp());	
		
		//하나의 클래스로 여러개의 자료형으로 쓰려고 할 경우 (계산기 int,double)
		
		Box<Object> xBox = new Box<Object>("데이터");
		System.out.println(xBox.getTemp());	
		//어떠한 오브젝트도 들어갈 수 있다. 
		
		Box<Character>  yBox = new Box<Character>('a');
		System.out.println(yBox.getTemp());	
//--------------------------------------------------------------
		
		BoxMap<Integer, String> bmap = new BoxMap<Integer, String>(1234,"Hello");
		System.out.println(bmap.getKey());	
		System.out.println(bmap.getValue());	
	

	}

}

//--------------------------------------------------------------

			//template의 약자
class Box<T>{ //<T> : Generic 형태로 표현
	
	T temp;
	
	public Box(T temp) {
		this.temp = temp;
	}
	
	public T getTemp() {
		return temp;
	}
	
	public void setTemp(T temp) {
		this.temp = temp;
	}
}	//T에 자료형 적던 자리 String //사용자지정 커스터마징

//--------------------------------------------------------------

class BoxMap <Key, Value> {
	Key key;
	Value value;
	
	//constructor 이용해서
	public BoxMap(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}	
}