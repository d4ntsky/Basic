package day06;

import java.util.ArrayList;

public class ParkingLotController {
	private ArrayList<ParkingLotVO> list;
	public ParkingLotController() {
		list = new ArrayList<>(); //원래는 데이터베이스가 있어야 된다 하지만 사용을 위해
	}
	//4-1) 1
	public int size() {
		return list.size();
	}
	//4-1) 2
	public boolean contains(ParkingLotVO p) {
		return list.contains(p);
	}
	//4-1) 3 
	public boolean validateTime(int time) {
		//1234를 12와 34 2개로 분리할려면
		//1234 / 100 = 12
		//1234 % 100 = 34
		int hour = time / 100;
		int minute = time % 100;
		
		//유효한 시간을 비교/논리 연산자를 사용하여
		return hour >= 0 && hour <= 23 && minute >= 0 && minute <=59;
		//시간은 0시부터 23시 분은 0분부터 59분 안에 있어야 하기 때문에
	}
	
	public void add(ParkingLotVO p) {
		list.add(p);
	}
	//입차는 관련은 여기서 끝. 
	
	public void remove(ParkingLotVO p) {
		list.remove(p);
}
}