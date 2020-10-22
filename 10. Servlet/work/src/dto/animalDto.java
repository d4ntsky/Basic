package dto;

public class animalDto {

	private String name;
	private String age;
	private String mood;
	
	public animalDto() {
		
	}

	public animalDto(String name, String age, String mood) {
		super();
		this.name = name;
		this.age = age;
		this.mood = mood;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	@Override
	public String toString() {
		return "animalDto [name=" + name + ", age=" + age + ", mood=" + mood + "]";
	}
		
	
}
