package DaoClass;

import java.util.List;
import java.util.Scanner;

import DaoInterface.DaoImpl;
import dto.Batter;
import dto.Pitcher;
import singleton.SingletonCls;

public class InsertClass implements DaoImpl {
	Scanner scan = new Scanner(System.in);
	
	private int memberNumber;
	
	public InsertClass() {
		SingletonCls sc = SingletonCls.getInstance();		
		memberNumber = sc.list.get( sc.list.size() - 1 ).getNumber();
		
		if(memberNumber >= 2000) {
			memberNumber = memberNumber - 1000;
		}
		memberNumber = memberNumber + 1;
	}
	
	@Override
	public void process() {		
		SingletonCls sc = SingletonCls.getInstance();
		
		// 투수/타자 ?
		System.out.print("투수(1)/타자(2) = ");
		int pos = scan.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = scan.next();
		
		System.out.print("나이 = ");
		int age = scan.nextInt();
		
		System.out.print("신장 = ");
		double height = scan.nextDouble();
		
		if(pos == 1) {
			// win
			System.out.print("승 = ");
			int win = scan.nextInt();
			
			// lose
			System.out.print("패 = ");
			int lose = scan.nextInt();
			
			// defense
			System.out.print("방어율 = ");
			double defence = scan.nextDouble();
			
			sc.list.add(new Pitcher(memberNumber, name, age, height, win, lose, defence));
			
		}		
		// 타자  2000 ~ 
		else if(pos == 2) {
			
			Batter bat = new Batter();
			
			// 선수 등록 번호
			bat.setNumber(memberNumber + 1000);
			bat.setName(name);
			bat.setAge(age);
			bat.setHeight(height);			
						
			// 타수
			System.out.print("타수 = ");
			int batcount = scan.nextInt();
			bat.setBatcount(batcount);
						
			// 안타수
			System.out.print("안타수 = ");
			int hit = scan.nextInt();
			bat.setHit(hit);
			
			// 타율
			System.out.print("타율 = ");
			double hitAvg = scan.nextDouble();
			bat.setHitAvg(hitAvg);
			
			sc.list.add(bat);
		}
	}

}