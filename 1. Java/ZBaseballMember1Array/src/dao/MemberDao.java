package dao;
//필기한거
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.FileProc;

// Data Access Object = model == back end
public class MemberDao {
	
	// 배열 (담아둘 부분)
	//준비할것 상속 받았을 때 부모 클래스로 묶에서 나갈
//	private Pitcher pitcher[];
//	private Batter	batter[];
	private Human human[] = new Human[20];; 					//저장할 데이터
	
	private int memberNumber;
	private int memberCount;
	
	FileProc fp;
		
	public MemberDao() {
		fp = new FileProc("baseball");
		fp.createFile();
		
		//human = new Human();	//객체 생성		//배열 생성
	//	human = new Human[20]; // 변수 20개를 		//변수 생성		
		/*
		//계속 기입하기 힘드니 예
		human[0] = new Pitcher(1001, "홍길동", 24, 177.7, 10, 3, 0.12);
		human[1] = new Batter(2001, "일지매", 22, 182.6, 25, 12, 0.123);
		human[2] = new Batter(2002, "이지매", 27, 174.2, 18, 5, 0.345);
		*/
		
		
		memberNumber = 1000; //시작
		memberCount  = 0;												//데이터를 추가하면 나중에 들어가게 하는법
	}
	
	Scanner sc = new Scanner(System.in); //외부에 갖게 ,,,
	
	//1.----------------------------------------------------------------------
	public void insert() {
		
		//투수/타자?를 등록
		System.out.print("투수(1)/타자(2) = ");
		int pos = sc.nextInt();
		
		//human 데이터 입력받기
		//넘버는 지정해주는 번호로 받는다.
		System.out.print("이름 = ");
		String name = sc.next();
		System.out.print("나이 = ");
		int age = sc.nextInt();
		System.out.print("신장 = ");
		double height = sc.nextDouble();				//공통분모
		
		Human h = null;	//취지? 초기화..배열만 잡아줬기 때문에
		
		
		//두가지로 나뉜다 투수 or 타자
				//두가지 방법 다르게 취함
		//투수	1000번부터 시작 - 구분을 위해      cf)문자열로 포지션을 주면됨
		if(pos == 1) {
			//win
			System.out.print("승 = ");
			int win = sc.nextInt();
			//lose
			System.out.print("패 = ");
			int lose = sc.nextInt();
			//defence
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			h = new Pitcher(memberNumber, name, age, height, win, lose, defence);
		
		}
		//타자	2000번부터 시작 - 구분을 위해 타수안타수타율
		else if(pos == 2) {
			
			Batter bat = new Batter();
			
			//선수 등록번호
			bat.setNumber(memberNumber+1000);
			bat.setName(name);
			bat.setAge(age);
			bat.setHeight(height);
			
			//타수
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			bat.setBatcount(batcount);
			//안타수
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			bat.setHit(hit);
			//타율
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			bat.setHitAvg(hitAvg);
			
			h = bat;
			
		}
				
		human[memberCount] = h;//대입 //계속 증가시켜줘야함..
		
		memberNumber++;//선수의 sequence
		memberCount++; //배열 넘버 증가
		
		
	}
	
	// delete select update 공통분모 search 
	
	//2.----------------------------------------------------------------------
	public void delete() {
		System.out.print("삭제하고 싶은 선수명 입력 = ");
		String name = sc.next();
				
		if(name.equals("")) { //빈문자일때 조건
			System.out.println("이름을 정확히 입력해주십시오.");
			return;
		}
		
		int findIndex = search(name);
		if(findIndex == -1) {		//못찾았을 경우
			System.out.println("선수 명단에 없습니다. 삭제할 수 없습니다.");
			return;
		}
		
		//삭제 이 부분부터
		if(human[findIndex] instanceof Pitcher) {
			Pitcher p = (Pitcher)human[findIndex];
			p.setNumber(0);
			p.setName("");
			p.setAge(0);
			p.setHeight(0.0);
			p.setWin(0);
			p.setLose(0);
			p.setDefence(0);
			
		}else if(human[findIndex] instanceof Batter) {
			Batter b = (Batter)human[findIndex];
			b.allClean();
		}
	}
	
	//3.----------------------------------------------------------------------
	public void select() {
		System.out.print("검색하고 싶은 선수명 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
		}
		else {
			System.out.println("번호: " + human[findIndex].getNumber());
			System.out.println("이름: " + human[findIndex].getName());
			System.out.println("나이: " + human[findIndex].getAge());
			System.out.println("신장: " + human[findIndex].getHeight());
			
			if(human[findIndex] instanceof Pitcher) {
				System.out.println("승리: " + ((Pitcher)human[findIndex]).getWin());
				System.out.println("패전: " + ((Pitcher)human[findIndex]).getLose());
				System.out.println("방어율: " + ((Pitcher)human[findIndex]).getDefence());
				
			}else if(human[findIndex] instanceof Batter){
				System.out.println("타수: " + ((Batter)human[findIndex]).getBatcount());
				System.out.println("안타수: " + ((Batter)human[findIndex]).getHit());
				System.out.println("타율: " + ((Batter)human[findIndex]).getHitAvg());
			}
		}
	}
	
	//4.----------------------------------------------------------------------
	public void update() {
		System.out.print("수정하고 싶은 선수명 = ");
		String name = sc.next();
		
		int findIndex = search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다.");
			return;
		}
		
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
			
		}
			
	}
	
	//5.----------------------------------------------------------------------
	public void allprint() {
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				System.out.println(human[i].toString());
				//(human[i].toString()); pitcher class에 있는 게 출력된다. 
				//pitcher batter override에 super.toString()추가 
			}
		}
	}
	//234 공통분모 함수----------------------------------------------------------------------
	public int search(String name) {
		int index = -1;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				if(name.equals(human[i].getName())) {
					index = i; 
					break;		//한명만 찾을때  cf)여러명을 찾을때는 break를 걸면 안되고 함수 돌려야함
				}
			}
		}
		return index;
	}
	//6.----------------------------------------------------------------------
	public void saveData() {
		// 1001-이름-나이-신장-승-패-승률
		int len = 0;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null) {
				len++;
			}
		}
		
		String datas[] = new String[len]; //20개로 잡힘
		
		for (int i = 0; i < datas.length; i++) {
			datas[i] = human[i].toString();
		}
		
		fp.saveData(datas);
		
	}
	//로드----------------------------------------------------------------------
	//로드데이터를 하기전에 배열이 만들어져있지 않으면 에러
	public void loadData() {
		String datas[] = fp.loadData();
		/*
			datas : Pitcher, Batter 섞여서 들어가 있다  -> Human[] 휴먼 배열에 넣는 작업
			하지만 선수 번호로 구분 가능
					객체 생성(투수냐 타자냐)
					값을 저장
		*/
			//하나씩 부르기
		for (int i = 0; i < datas.length; i++) {
			//datas[0 ~ n-1]
			//datas[0] = 1000-이름-나이-신장-ㅁ-ㅁ-ㅁ
			
			String data[] = datas[i].split("-");
			
			//투수/타자 구분
			int title = Integer.parseInt(data[0]);
			if(title < 2000) {		//투수
				human[i] = new Pitcher(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]));
			}
			else {					//타자
				human[i] = new Batter(	Integer.parseInt(data[0]), 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]));
			}
		}
		
		
	}
	
	//7.----------------------------------------------------------------------
	public void pitcherDefenceRank() {
	//방어률 순위 출력 1 ~ n
		//투수만을 수집한 배율
		//올림차순 정렬
		//출력
	}
	//8.----------------------------------------------------------------------
	//타율 순위 출력 1 ~ n
	public void batterHitAvgRank() {
		//타자만을 수집한 배율
		//내림차순 정렬
		//출력
	}
}


