package Task0601_SandCastle;

public class mainClass {

//	1. random			-> 30~100
//	2. userInput		-> 1 ~ 15
//	3. random number - user number
//	4. game over
	public static void main(String[] args) {
		
	SandCastle game = new SandCastle();
	game.init();
	game.gamePlay();
	game.result();
	
}

}
