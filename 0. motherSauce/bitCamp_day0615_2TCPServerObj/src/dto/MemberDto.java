package dto;

import java.io.Serializable;

public class MemberDto implements Serializable{
/**
	 * 
	 */									//시리얼버젼 지정 - 암호화/직렬화
//	private static final long serialVersionUID = 7159726773562029167L;
	//java.io.NotSerializableException
// Serialize(직렬화) 전송 -> 순서를 정해줘야함. 직렬할 부분으로 설정
	//Network, Web 송수신 시 적어줘야되는 부분
	private int number;
	private String name;
	
	public MemberDto() {
		
	}

	public MemberDto(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberDto [number=" + number + ", name=" + name + "]";
	}

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
}
