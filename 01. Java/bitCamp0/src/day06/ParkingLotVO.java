package day06;

import day06.ParkingLotVO;

public class ParkingLotVO {
	
	private String number;
	private int inTime;

	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	
	
	public boolean equals(Object o) {
		if(o instanceof ParkingLotVO) {
			ParkingLotVO p = (ParkingLotVO)o;
			if(number.equals(p.number)) {
				return true;
			}
		}
		return false;
	}
}
