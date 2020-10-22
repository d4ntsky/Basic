package day0608_1ArrayList;
//Data Transfer Object == VO
public class MemberDto {
	//1)멤버변수
	private int number;
	private String name;
	//2)기본생성자
	public MemberDto() {
		
	}
	//3)constructor
	public MemberDto(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	//4)getter - setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//5)toString
	@Override
	public String toString() {
		return "MemberDto [number=" + number + ", name=" + name + "]";
	}
	
}
