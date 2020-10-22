package dto;

public class Pitcher extends Human {

	//상속받은 멤버변수도 포함되어있음
	
	//순서 기본생성자, constructor ,세터게터, 투스트링
	
	private int win;
	private int lose;
	private double defence; //방어율 0.0 ~ 10.0 사이
	
	public Pitcher() {
		
	}
					//앞부분 human에서 가져옴
	public Pitcher(int number, String name, int age, double height, int win, int lose, double defence) {
		super(number, name, age, height);//()면 기본 생성자만 호출하게 된다.//지금 껄로 바뀌어야함
		this.win = win;
		this.lose = lose;
		this.defence = defence;
		//super 안쓸꺼면
		//this.setNumber(number);
		//this.setName(name); 
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + win + "-" + lose + "-" + defence;
				//super.toString()을 붙여줘야 부모클래스에 있는걸 main에 보여줌
	}	
	
	
	
}