package miniProject;

import java.util.Scanner;

public class ParkViewer {
	//기본단위 상수로 표현
	private final int SIZE = 5;
	private final int UNIT_PRICE = 1000;
	private final int UNIT_MINUTE = 10;
	
	private ParkController controller;
	private Scanner scanner;
	//생성자만들기
	public ParkViewer() {
		controller = new ParkController();
		scanner = new Scanner(System.in); //초기화 부분
		showMenu();
	}
	
	private void showMenu() {
		//이 쇼메뉴 메소드가 private으로 잡았는데 그 말은 외부에서 실행시키지 않겠다는 뜻
		while(true) {
			System.out.println("=====비트 주차관리 프로그램=====");
			System.out.println("1. 입차	2. 출차	3. 종료");
			System.out.println("> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if(choice == 1) {
				//입차 UI 출력 메소드 실행
				insertParkVO();   			//밑의 주차공간 체크 메소드가 시작시키는)
			}else if(choice == 2) {
				//출차 UI 출력 메소드 실행
				deleteParkVO();
				
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		scanner.close();
	}
	
	//------출차
	private void deleteParkVO() {
		//------먼저주차된 차량이 존재하는지부터 체크
		if(controller.size() !=0) {
			//------주차된 차량이 존재한다는 의미니까 주차 시작
			ParkVO p = new ParkVO();
			//------p에 차량번호를 넣는 메소드를 실행한다!!
			p.setNumber(getDeleteNumber());
			//-----p.setInTime은 안함 
			p = controller.get(p);//inTime까지 다 씌워버리는
			int outTime = setOutTime(p);
			calculateRate(p,outTime);
			
			
		}else {
			System.out.println("아직 입차된 차량이 없습니다.");
		}
	}
	//------출차(차번)
	private String getDeleteNumber() {
		ParkVO p = new ParkVO();
		System.out.print("출력할 차량의 번호를 입력하세요: ");
		p.setNumber(scanner.nextLine());
		while(!controller.contains(p)) {
			System.out.println("입고된 기록이 없는 차량입니다.");
			System.out.print("출력할 차량의 번호를 입력하세요: ");
			p.setNumber(scanner.nextLine());
		}
		return p.getNumber();
	}
	//------출차(시간)
	private int setOutTime(ParkVO p) {
		//------나가는 시간
		//나가는 시간은 들어온 시간보다 늦은 시간이다. 나가는 시간은 list에서 가져와야함 
		System.out.print("출차 시간을 입력해주세요: ");
		int outTime = scanner.nextInt();
		while(!controller.validateTime(outTime)
				|| p.getInTime() > outTime) {
			System.out.println("잘못된 형식입니다");
			System.out.print("출차 시간을 입력해주세요: ");
			outTime = scanner.nextInt();
		}
		return outTime;
	}
	
	//------돈계산 부분 //상수는 맨위에 몰아둔 상태
	private void calculateRate(ParkVO p, int outTime) {
		//p.getInTime과 outTime의 시간의 차이
		//분의 차이를 구한다.
		int hourDifference = outTime / 100 - p.getInTime() / 100;
		int minuteDifference = outTime % 100 - p.getInTime() % 100;
		int totalDifference = hourDifference * 60 + minuteDifference;
		//요금계산
		int rate = totalDifference / UNIT_MINUTE * UNIT_PRICE;
		System.out.println("총 요금은"+rate+"원입니다.");
		controller.remove(p);
	}
	
	
	//private final int SIZE = 5; //상수는 맨위에 몰아두는게 좋음
	private void insertParkVO() {//이게 실행되는것은 1다음임 
		//주차장에 빈칸이 있는지 체크한다.
		if(controller.size() < SIZE) {
			ParkVO p = new ParkVO();
			p.setNumber(setInsertNumber());//setInsetNumber의 값을 불러오는
			p.setInTime(setInTime());
			controller.add(p);
		}else {
			System.out.println("주차 공간이 없습니다.");
		}
	}
	
	private String setInsertNumber() {
					// cf) 이름부분은 예민한편
		System.out.print("입차할 차량의 번호를 입력하세요: ");
		ParkVO p = new ParkVO();
		p.setNumber(scanner.nextLine());
		while(controller.contains(p)) {//입차기록이 있다는 뜻
			System.out.println("이미 입차된 차량의 번호입니다.");
			System.out.print("입차할 차량의 번호를 입력하세요: ");
			p.setNumber(scanner.nextLine());
		}
		
		return p.getNumber();
	}
	
	private int setInTime() {
		System.out.print("입차 시간을 입력하세요: ");
		int inTime = scanner.nextInt();
		while(controller.validateTime(inTime) == false) {
			System.out.println("잘못된 시간형식입니다.");
			System.out.print("입차 시간을 입력하세요: ");
			inTime = scanner.nextInt();
		}
		scanner.nextLine();
		return inTime;
	}
	
	
	
	//출차관련
	
}

