package dao;

import java.util.ArrayList;
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.FileProc;

// Data Access Object	= model == back end
public class MemberDao {
	
	Scanner sc = new Scanner(System.in);
	
	// 배열
	//private Pitcher pitcher[];
	//private Batter batter[];
	//private Human human[] = new Human[20]; // 변수 20개 생성				//ArrayList 사용하기 위해 
	
//추가			//배열의 갯수를 유동적으로 만들 수 있다.
	private ArrayList<Human> list = new ArrayList<Human>();	
	
	private int memberNumber;
//	private int memberCount;//데이터가 어디까지 들어는지 알려주려고
	
	FileProc fp;
	
	public MemberDao() {
		fp = new FileProc("baseball"); 
		fp.createFile();
		
		// human = new Human[20];	// 변수 20개 생성
		/*
		human[0] = new Pitcher(1000, "홍길동", 24, 172.1, 10, 3, 0.12);
		human[1] = new Batter(2001, "일지매", 21, 182.4, 25, 12, 0.345);
		human[2] = new Batter(2002, "정수동", 26, 174.2, 18, 5, 0.253);
		*/
		// human = new Human();	// 객체 생성
		
		this.loadData();

//주석처리
//		int lastIndexNum = 0;
//		for (int i = 0; i < human.length; i++) {
//			if(human[i] != null) {
//				lastIndexNum = i;
//			}
//		}
	/*	
		if(lastIndexNum > 0) {
			memberNumber = 1000 + (human[lastIndexNum].getNumber() % 1000 + 1);
			memberCount = lastIndexNum + 1;
		}else {
			memberNumber = 1000;
			memberCount = 0;
		}		
	*/
//추가
		//list에서 제일 마지막 선수의 number를 취득 
	//	memberNumber = list.lastIndexOf(o)
		memberNumber = list.get(list.size() - 1).getNumber();
		//이해필요
		if(memberNumber >= 2000) {
			memberNumber = memberNumber - 1000;
			memberNumber = memberNumber + 1;
		}
		
		
	}	
	public void insert() {	
		// 투수/타자 ?
		System.out.print("투수(1)/타자(2) = ");
		int pos = sc.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
//제외		
//		Human h = null;	
		
		// 투수	1000 ~ 
		if(pos == 1) {
			// win
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			// lose
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			// defense
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();

//수정		
			list.add(new Pitcher(memberNumber, name, age, height, win, lose, defence));
			
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
			int batcount = sc.nextInt();
			bat.setBatcount(batcount);
						
			// 안타수
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			bat.setHit(hit);
			
			// 타율
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			bat.setHitAvg(hitAvg);
	
//수정
			list.add(bat);
		}		

//삭제
//		human[memberCount] = h;
//		list.add(h); //h=bat; h=newPitcher가 바뀜
		
		memberNumber++;
//		memberCount++;		
	}	
	
	public void delete() {
		
		System.out.print("삭제하고 싶은 선수명 입력 = ");
		String name = sc.next();
		
		if(name.equals("")) {
			System.out.println("이름을 정확히 입력해 주십시오.");
			return;		// continue
		}
		
		int findIndex = search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다. 삭제할 수 없습니다");
			return;
		}
		// 삭제
		//바뀜
		list.remove(findIndex);
		/*
		if(human[findIndex] instanceof Pitcher) {
			Pitcher p = (Pitcher)human[findIndex];
			p.setNumber(0);
			p.setName("");
			p.setAge(0);
			p.setHeight(0.0);
			p.setWin(0);
			p.setLose(0);
			p.setDefence(0.0);
		}
		else if(human[findIndex] instanceof Batter) {
			Batter b = (Batter)human[findIndex];
			b.allClean();
		}	
		*/	
	}	
		
	public void select() {		
		System.out.print("검색하고 싶은 선수명 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
		}
		
		else {
//추가
			Human human = list.get(findIndex);
//수정		
			System.out.println("번호:" + list.get(findIndex).getNumber());
			System.out.println("이름:" + human.getName());
			System.out.println("나이:" + human.getAge());
			System.out.println("신장:" + human.getHeight());
			
			if(human instanceof Pitcher) {
				System.out.println("승리:" + ((Pitcher)human).getWin() );
				System.out.println("패전:" + ((Pitcher)human).getLose() );
				System.out.println("방어율:" + ((Pitcher)human).getDefence() );
			}
			else if(human instanceof Batter) {
				System.out.println("타수:" + ((Batter)human).getBatcount() );
				System.out.println("안타수:" + ((Batter)human).getHit() );
				System.out.println("타율:" + ((Batter)human).getHitAvg() );
			}
		/*
			System.out.println("번호:" + human[findIndex].getNumber());
			System.out.println("이름:" + human[findIndex].getName());
			System.out.println("나이:" + human[findIndex].getAge());
			System.out.println("신장:" + human[findIndex].getHeight());
			
			if(human[findIndex] instanceof Pitcher) {
				System.out.println("승리:" + ((Pitcher)human[findIndex]).getWin() );
				System.out.println("패전:" + ((Pitcher)human[findIndex]).getLose() );
				System.out.println("방어율:" + ((Pitcher)human[findIndex]).getDefence() );
			}
			else if(human[findIndex] instanceof Batter) {
				System.out.println("타수:" + ((Batter)human[findIndex]).getBatcount() );
				System.out.println("안타수:" + ((Batter)human[findIndex]).getHit() );
				System.out.println("타율:" + ((Batter)human[findIndex]).getHitAvg() );
			}
			*/
		}		
	}	
	
	public void update() {		
		System.out.print("수정하고 싶은 선수명 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
			return;
		}
		//추가
		Human human = list.get(findIndex);
		//형식 변경
		if(human instanceof Pitcher) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			Pitcher pit = (Pitcher)human;
			pit.setWin(win);
			pit.setLose(lose);
			pit.setDefence(defence);			
		}
		else if(human instanceof Batter) {
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			Batter bat = (Batter)human;
			bat.setBatcount(batcount);
			bat.setHit(hit);
			bat.setHitAvg(hitAvg);			
		}	
		
		/*
		if(human[findIndex] instanceof Pitcher) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			Pitcher pit = (Pitcher)human[findIndex];
			pit.setWin(win);
			pit.setLose(lose);
			pit.setDefence(defence);			
		}
		else if(human[findIndex] instanceof Batter) {
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			Batter bat = (Batter)human[findIndex];
			bat.setBatcount(batcount);
			bat.setHit(hit);
			bat.setHitAvg(hitAvg);			
		}	*/
	}
	
	
	
	public void allprint() {	
		/*삭제
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				System.out.println(human[i].toString());				
			}
		}
		*/
		//변경
		for (int i = 0; i < list.size(); i++) {
			Human human = list.get(i);
			System.out.println(human.toString());
		}	
	}	
	
	
	
	
	public int search(String name) {
		int index = -1;
	/*	제외
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				if(name.equals(human[i].getName())) {
					index = i;
					break;
				}
			}
		}
	*/
		//추가
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);//휴먼값 꺼내주는
			if(name.equals(h.getName())) {
				index = i;
				break;
			}
		}
		//
		return index;
	}
	
	
	
	//문자열만 배열로 넘겨주기 arraylist
	public void saveData() {
		// 1001-홍길동-24-178.1-10-3-0.12
		/*
		int len = 0;		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				len++;
			}
		}		
		
		String datas[] = new String[len];		
		for (int i = 0; i < datas.length; i++) {
			datas[i] = human[i].toString();
		}
		*/
		String datas[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Human human = list.get(i);
			datas[i] = human.toString();
		}
		
		//
		fp.saveData(datas);		
	}
	
	public void loadData() {
		
	
		String datas[] = fp.loadData();
		
		/*
			datas : Pitcher, Batter		-> Human[]
					객체 생성
					값을 저장
		*/
		
		for (int i = 0; i < datas.length; i++) {
			// datas[0 ~ n-1]	
			// datas[0] => 1000-홍길동-24-178.1-10-2-0.12
			// datas[1] => 2001-일지매-21-181.1-21-11-0.34
			// datas[2] => 1002-정수동-26-182.4-11-4-0.24
			
			String data[] = datas[i].split("-");
			int title = Integer.parseInt(data[0]);
			
			//추가
			Human human = null;
			/*
			if(title < 2000) {		// 투수				
				human[i] = new Pitcher(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]) );
			}
			else {
				human[i] = new Batter(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]) );
			}
			
			
		}	*///for end
			if(title < 2000) {		// 투수				
				human = new Pitcher(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]) );
			}
			else {
				human = new Batter(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]) );
			}
			list.add(human); //추가
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// 타율 순위 출력 1 ~ n
	public void batterHitRanking() {
		// 타자만을 수집한 배열
//삭제		Human chuman[] = positionSelect(2); //여기부터 고쳐짐 
		ArrayList<Human> sortList = positionSelect(2);
		
		
		// 확인용
		System.out.println("타자만으로 출력용 -----");
		/*
		for (int i = 0; i < chuman.length; i++) {
			System.out.println(chuman[i].toString());
		}
		*/
		for (int i = 0; i < sortList.size(); i++) {
			System.out.println(sortList.get(i).toString());
		}
		
		/*
		// 내림차순 정렬
		Human obj = null;
		for (int i = 0; i < chuman.length - 1; i++) {
			for (int j = i + 1; j < chuman.length; j++) {
				Batter b1 = (Batter)chuman[i];
				Batter b2 = (Batter)chuman[j];
				if(b1.getHitAvg() < b2.getHitAvg()) {
					obj = chuman[i];
					chuman[i] = chuman[j];
					chuman[j] = obj;
				}
			}
		}
		*/
		//여기서 달라지는 건
		
		Human obj = null;
		for (int i = 0; i < sortList.size() - 1; i++) {
			for (int j = i + 1; j < sortList.size(); j++) {
				Batter b1 = (Batter)sortList.get(i);
				Batter b2 = (Batter)sortList.get(j);
				//타율로 sorting
				if(b1.getHitAvg() < b2.getHitAvg()) {
					obj = sortList.get(i);
					//!!!
					sortList.set(i, sortList.get(j));
					sortList.set(j, obj);
				}
			}
		}
		
		
		
		
		
		
		// 결과 출력
		System.out.println("정렬 후 타자만으로 결과 출력용 -----");
	/*	for (int i = 0; i < chuman.length; i++) {
			System.out.println(chuman[i].toString());
		}*/
		
		
		/*보기
		for (Human h : chuman) {	// foreach 문
			System.out.println(h.toString());
		}
		*/
		//확인!!!!!!!!!!
		for (Human human : sortList) {
			System.out.println(human.toString());
		}
	}
	
	
	
	
	
	
	
	
	/*
	// 방어율 순위 출력 1 ~ n
	public void pitcherDefenseRanking() {
		// 투수만을 수집한 배열 
		Human chuman[] = positionSelect(1);//(1)로바뀐 
		// 올림차순 정렬
		
		// 출력
	}	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 타자/투수 만을 산출할 수 있는 함수. 1:투수 2:타자   

	/*public Human[] positionSelect(int num) {
		int count = 0;
		
		//리스트로 처리하면
		
		// 우선 몇명인지 카운터
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				if(num == 1) {
					if(human[i].getNumber() < 2000) {
						count++;
					}
				}
				else {
					if(human[i].getNumber() >= 2000) {
						count++;
					}					
				}
			}
		}
				
		// 명수에 맞게 할당
		Human choiceHuman[] = new Human[count];
		
		// 데이터의 수집
		int m = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				if(num == 1) {
					if(human[i].getNumber() < 2000) {
						choiceHuman[m] = human[i];
						m++;
					}
				}
				else {
					if(human[i].getNumber() >= 2000) {
						choiceHuman[m] = human[i];
						m++;
					}					
				}
			}
		}
		
		return choiceHuman;
	}
		*/
	
	
	//새로짬
	public ArrayList<Human> positionSelect(int num){
		//리턴해줄 어레이리스트 잡기
		ArrayList<Human> reList = new ArrayList<Human>();
		
		for (int i = 0; i < list.size(); i++) {
			Human human = list.get(i);
			if(num == 1) {			//pitcher
				if(human.getNumber() < 2000) {
					reList.add(human);
				}
			}else if(num == 2) {	//batter
				if(human.getNumber() >= 2000) {
					reList.add(human);
				}
			}
		}
		return reList;
	}
	

}