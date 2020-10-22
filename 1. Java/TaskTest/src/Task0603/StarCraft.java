package Task0603;

public class StarCraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Marine m = new Marine();
		Tank t = new Tank();
		DropShip d = new DropShip();
		*/
		
		Unit unit[] = new Unit[3];
		
		unit[0] = new Marine();
		unit[1] = new DropShip();
		unit[2] = new Tank();
		
		unit[0].move(100, 100);
		unit[1].move(200, 300);
		unit[2].move(250, 400);
		
		unit[0].stop();
		unit[1].stop();
		unit[2].stop();
		
		for (int i = 0; i < unit.length; i++) {
			if(unit[i] instanceof Marine) {
				Marine m = (Marine)unit[i];
				m.stimPack();
			}
			else if(unit[i] instanceof Tank) {
				((Tank)unit[i]).changeMode();
			}
		}
		
		
		
	}

}

class Unit{		// interface
	int x, y;
	void move(int x, int y) {	
		System.out.println("x = " + x + " y = " + y);
	}
	void stop() {
		System.out.println("¸ØÃã");
	}
}

interface uUnit{
	void move(int x, int y);
	void stop();
}


class Marine extends Unit{
	/*
	 * int x, y; void move(int x, int y) { } void stop() { }
	 */
	void stimPack() {	
		System.out.println("Marine stimPack~");
	}	
}
class Tank extends Unit{
	/*
	 * int x, y; void move(int x, int y) { } void stop() { }
	 */
	void changeMode() {
		System.out.println("Tank changeMode!");
	}	
}
class DropShip extends Unit{
	/*
	 * int x, y; void move(int x, int y) { }	 
	void stop() {		
	}*/
	void unload() {
		System.out.println("DropShip unload~");
	}	
}





