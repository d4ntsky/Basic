package types;


import bomb.Bomb;
import arms.Arms;

public interface AbstractItem {

	public Arms createArms();
	public Bomb	createBomb();

	

}
