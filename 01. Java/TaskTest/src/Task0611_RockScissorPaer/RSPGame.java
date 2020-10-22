package Task0611_RockScissorPaer;

public class RSPGame {
	//기능을 넣어놓는
	private int ursNum;
	private int comNum;
	private int win, lose, draw;
	private int result;
	
	public RSPGame() {
		win = lose = draw = 0;	// 초기화 밖에 두면 계속 초기화된다.
	}
	
	public void init() {		// initialize
			this.comNum = (int)(Math.random()*3); // 0,1,2
	}
	
	public String play() {		// win, lose, draw 값이 나가는 
		String msg = "";
		
		//판정
/*
0 == 가위 1 == 바위 2 == 보
		//win의 경우									   P:C
		if	   (userNum == 0 && comNum == 2) {		}//02
		else if(userNum == 1 && comNum == 0) {		}//10
		else if(userNum == 2 && comNum == 1) {		}//21
		//lose의 경우
		if	   (userNum == 2 && comNum == 0) {		}//20
		else if(userNum == 0 && comNum == 1) {		}//01
		else if(userNum == 1 && comNum == 2) {		}//12
		//draw
		if	   (userNum == 0 && comNum == 0) {		}//00
		else if(userNum == 1 && comNum == 1) {		}//11
		else if(userNum == 2 && comNum == 2) {		}//22

//	com	- player
//	win								1
//	2	-	0		+ 2	= 4	%3 -> 1
//	0	-	1		+ 2	= 1 %3 -> 1
//	1	-	2		+ 2	= 1 %3 -> 1
//	lose							0
//	0	-	2		+ 2	= 0 %3 -> 0
//	1	-	0		+ 2	= 3 %3 -> 0
//	2	-	1		+ 2	= 3 %3 -> 0
//	draw							2
//	0	-	0		+ 2	= 2 %3 -> 2
//	1	-	1		+ 2	= 2 %3 -> 2
//	2	-	2		+ 2	= 2 %3 -> 2
*/
		//공식화
		result = (comNum - ursNum + 2) % 3;
		switch (result) {
		case 1:
			win++;
			msg = "승리";
			break;
		case 0:
			lose++;
			msg = "패배";
			break;
		case 2:
			draw++;
			msg = "무승부";
			break;
		}
		return msg;
	}
	
	//get만 필요
	public int getWin() {
		return win;
	}

	public int getLose() {
		return lose;
	}

	public int getDraw() {
		return draw;
	}
	
	//밖에서 버튼을 눌렀을 경우 - urs넘버는 들어와야한다.
	public void setUrsNum(int ursNum) {
		this.ursNum = ursNum;
	}
	
	public String getUrs() {
		String ursChoice =  "";	//초기화
		switch (ursNum) {
		case 0:
			ursChoice = "가위";
			break;
		case 1:
			ursChoice = "바위";
			break;
		case 2:
			ursChoice = "보";
			break;
		}
		return ursChoice;
	}

	public String getCom() {
	String comChoice = "";		//초기화
	switch(comNum) {
		case 0:
			comChoice = "가위";
			break;
		case 1:
			comChoice = "바위";
			break;
		case 2:
			comChoice = "보";
			break;
		}
		return comChoice;
	}
	
		
}

