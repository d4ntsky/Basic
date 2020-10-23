package day04;

public class Car {
	//필드를 만들어보자
	 
	//차량 번호 //public 데이터타입""
	private String number;
	//차량 종류	
	private String type;
	//차량 색상
	private String color;
	//차량  가격 //public 숫자타입
	private int price;
	//(public에서 private로 바꿀경우 같은 클래스에서만 쓰겠다는 뜻)
	//(String 앞에 private이 사라진 경우 default값으로 되서 같은 패키지에서 하겠다는 뜻)
	
	//차가 출발한다는 메시지를 출력하는 메소드
	public void start() {
		System.out.println("차를 출발합니다.");
	}
	
	public void setType(String type) {
		this.type = type;
	}
	//값 넣을때
	public String getType() {
		return type;
	}
	//

	public void setColor(String color) {
		this.color = color;
	}
	public String getcolor() {
		return color;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	
	public Car(String number, String type, String color, int price) {
		this.setNumber(number);
		this.type = type;
		this.color = color;
		this.price = price;
	}//<라이프 사이클 끝
	
	public Car() {
		setNumber(new String());
		type = new String();
		color = new String();
		price = 0;
	}
	
	public String toString() {
		String plateInfo = "차량 번호: "+getNumber();
		String typeInfo = "차량 종류: "+type;
		String colorInfo = "차량 색상: "+color;
		String priceInfo = "차량 가격: "+price;
		
		return plateInfo+", "+typeInfo+", "+colorInfo+", "+priceInfo;
		//return "차량 번호: "+number+", "+"차량 종류: "+type+", "+"차량 색상: "+color+", "+"차량 가격: "+price;
		
	}
	
	public boolean equals(Object o) {
		                       //이 객체1
						//Object는 객체 기반 다 들어갈 수 있는 기준은 type/number/color/price이 있는것?
		if(o instanceof Car) {
			         //이 객체2  1=2인가 확인하는
			Car c = (Car)o;
			//그것은 임시c로 확인
			if(number.equals(c.number) && type.equals(c.type) && color.equals(c.color)) {
				return true;
				//return과 과정이 만나면 메소드가 종료
			}
		}
		//cf CarEx.java에 yourCar2 가 Car class가 맞는지 확인하고 맞으면 Car c로 됨
		return false;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}