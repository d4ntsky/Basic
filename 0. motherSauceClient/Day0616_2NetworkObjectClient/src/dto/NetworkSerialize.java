package dto;
import java.io.Serializable;

public class NetworkSerialize implements Serializable {
	private int number;
	private String name;
	private int play;
	
	public NetworkSerialize() {
	}

	public NetworkSerialize(int number, String name, int play) {
		super();
		this.number = number;
		this.name = name;
		this.play = play;
	}
	
	@Override
	public String toString() {
		return "NetworkSerialize [number=" + number + ", name=" + name + ", play=" + play + "]";
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

	public int getPlay() {
		return play;
	}

	public void setPlay(int play) {
		this.play = play;
	}
	
	
	
	

}
