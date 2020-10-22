package types;

import bomb.Bomb;
import bomb.C4;
import arms.Gun;
import arms.Arms;

public class Atype implements AbstractItem {

	@Override
	public Arms createArms() {
		return new Gun();
	}

	@Override
	public Bomb createBomb() {
		return new C4();
	}

}
