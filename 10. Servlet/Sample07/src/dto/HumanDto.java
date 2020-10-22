package dto;

import java.io.Serializable;

public class HumanDto implements Serializable {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public HumanDto() {
	}


	@Override
	public String toString() {
		return "HumanDto [name=" + name + ", age=" + age + "]";
	}


	public HumanDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}