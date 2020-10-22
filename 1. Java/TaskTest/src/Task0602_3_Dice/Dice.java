package Task0602_3_Dice;

public class Dice {

	private int number;
	
	public void diceRandom() {
		
		number = (int)(Math.random()*6) + 1; //1~6
	}
//넘버의 게터만 필요함
	public int getNumber() {
		return number;
	}
}
