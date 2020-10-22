package day06;

import java.util.Scanner;

public class ParkingLotViewer {
	private final int SIZE = 5;
	private ParkingLotController controller;
	private Scanner scanner;

	public ParkingLotViewer() {
		controller = new ParkingLotController();
		scanner = new Scanner(System.in); 
		showMenu();
	}
	
	private void showMenu() {
	
		while(true) {
			System.out.println("=====비트 주차 프로그램=====");
			System.out.println("1. 입차	2. 출차	3. 종료");
			System.out.println("> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if(choice == 1) {
				//입차 UI 출력 메소드 실행
				insertParkingLotVO();   			//밑의 주차공간 체크 메소드가 시작시키는)
			}else if(choice == 2) {
				//출차 UI 출력 메소드 실행
				exitParkingLotVO();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		scanner.close();
	}
	
	private void insertParkingLotVO() {
		if(controller.size() < SIZE) {
			ParkingLotVO p = new ParkingLotVO();
			p.setNumber(setInsertNumber());
			p.setInTime(setInTime());
			controller.add(p);
		}else {
			System.out.println("주차 공간이 없습니다.");
		}
	}
	
	private String setInsertNumber() {
		System.out.print("입차할 차량의 번호를 입력하세요: ");
		ParkingLotVO p = new ParkingLotVO();
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
	//=================================2번시작
	private void exitParkingLotVO() {
		while(true) {
			System.out.println("출차하시겠습니까");
			System.out.println("1. 예	2. 아니오");
			System.out.println("> ");
			int choice2 = scanner.nextInt();
			scanner.nextLine();
			if(choice2 == 1) {
				System.out.println("출차할 차량번호를 입력해주세요");
				//새로운 출차입력란 차량번호해제
					exitNumber();
			}else if(choice2 == 2) {//차량번호가 없는다른경우
				System.out.println("종료하겠습니다");
				break;
			}
		}
		scanner.close();
	}
	//차량번호 입력
	private void exitNumber() {
		System.out.println("차량번호 입력받고 맞으면 시간으로 넘어가고 다르면 처음으로/"
				+ "출차 시간 받는 거로 넘어가는 수식/"
				+ "입력되있던 값과 적은 값이 같으면 시간으로/");
		}
	
}