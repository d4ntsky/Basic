package day0520;

public class Ex5Random {

	public static void main(String[] args) {
		/*
			random : 난수, 무작위 <ㅡ> pattern
			1 ~ 5 ex)로또
		*/
		
		int rnum;
		rnum = (int)(Math.random() * 5); //0 ~ 4
		System.out.println("rnum = " + rnum);
		
		rnum = (int)(Math.random() * 10); //0 ~ 9
		System.out.println("rnum = " + rnum);
		
		rnum = (int)(Math.random() * 11) + 10; //10~20
		System.out.println("rnum = " + rnum);
		
		rnum = ((int)(Math.random() * 5) + 1) * 10; //10/20/30/40/50
		System.out.println("rnum = " + rnum);
		
		rnum = (int)(Math.random() * 3) - 1; // -1 0 1
		System.out.println("rnum = " + rnum);
		
		//cf)
		//실시간에서 x,y값을 받으면 계속 움직이는 //게임쪽 랜덤 프로그램 코드
		//실무용 게임 로직 //몬스터가 움직이는 //
		int x = (int)(Math.random() * 3) - 1; // -1 0 1
		int y = (int)(Math.random() * 3) - 1; // -1 0 1
		System.out.println(x+y);
	}
}
