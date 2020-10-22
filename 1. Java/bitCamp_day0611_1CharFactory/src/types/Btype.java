package types;

import bomb.Bomb;
import bomb.Dynamite;
import arms.Sword;
import arms.Arms;

public class Btype implements AbstractItem {

	@Override
	public Arms createArms() {
		return new Sword();
	}

	@Override
	public Bomb createBomb() {
		return new Dynamite();
	}

}
