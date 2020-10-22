package miniProject;
//1. 주차장 관리 프로그램
//1-1. Park 클래스
//1-2. Park 클래스에는
//		차량 번호
//		들어온 시간
//  필드들이 있다.
//2. 주차장은 5칸 짜리 주차장이다. 칸은 ArrayList로 관리하게 된다.
//3. 무한 반복문을 통해서 종료를 누르기 전까지 계속 실행된다.
//4. 프로그램 개요
//		4-1) 차량 입고 선택시
//  1. 주차장 내에 빈 칸이 있는지를 확인한다. 
//  2. 차량이 입고된 기록이 있는지 찾는다. 있으면 잘못된 입력이라고 출력
//  3. 차량이 입고된 기록이 없으면 시간을 기록한다.
//		시간은 int 로 입력을 받으며 잘못된 시간을 입력시 다시 입력하라고 지시한다.
//		예시: 9999는 99시 99분을 의미하게 되고 따라서 잘못된 시간이 된다.
//	         1234는 12시 34분을 의미하게 되고 따라서 올바른 시간이 된다.
//  4. 차량 번호와 시간 모두 사용자가 올바른 값을 입력할때 까지 다시 입력을 받는다.
//	4-2) 차량 출고 선택시
//			주차장에 주차된 차량이 존재하는지 체크한다.
//			차량이 주차 된 기록이 존재하면 사용자로부터 차량 번호를 입력 받는다.
//			일치하는 차량을 찾으면 나가는 시간을 입력을 받는다.
//		2, 3번의 경우 사용자가 올바른 입력을 할때까지 다시 입력을 받는다.
//		시간의 차이를 계산 하여 10분당 1000원의 요금을 적용한다.
//		차량이 나간 칸을 비워준다.
//=================================================================

//객체지향의 5원칙
/* S.O.L.I.D
 * S: Single Responsibility Principle  //이것만 알아두면된다
 *     단일책임원칙
 *     하나의 클래스의 하나의 책임만 져야한다
 * (O: Open-Closed Principle )
 * (L: Liskov Substitution Principle )
 * (I: Interface Principle )
 * (D: Dependency Inversion Principle )
 * 
 * MVC 패턴 (cf 유지보수가 쉬워지는 패턴)
 * Model - View - Controller
 * Model	  : 데이터를 담는 틀,
 * 				사용자가 뷰에서 요청하면 컨트롤러가 
 * 				데이터베이스에서 데이터를 모델에 담아서 다시 뷰로 보내준다.
 * 				모델은 주로 VO 나 DTO라는 접미사가 붙는다.
 * 				VO는 Value Object, DTO는 Data Transfer Object 라는 뜻이다.
 * View 	  : 사용자가 보고있는 화면에 출력되는 UI이다.
 * 				만약 우리가 웹 프로젝트를 하게된다면 뷰는 html, jsp파일이 되고
 * 				지금은 사용자가 콘솔화면을 보기 때문에 콘솔화면에 뜨는 println등이 모여서 하나의
 * 				뷰가 된다.
 * Controller : 사용자가 요청하는 data를 뷰에 모델에 담아서 뷰에 보내주거나 사용자가 보낸 모델을
 * 				데이터베이스로 보내주는 역할은 한다.
 */
public class ParkVO {
	//모델에는 필드, getter/setter. equals(), toString() 등만 들어간다.
	//toString은 없음
	
	//필요한 필드 : 차량번호와 들어온 시간
	private String number;
	private int inTime;

	//차번 getter/setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	//시간 getter/setter
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	
	//equals() 여기선 차번 기준으로 처리함
	public boolean equals(Object o) {
		if(o instanceof ParkVO) {
			ParkVO p = (ParkVO)o;
			if(number.equals(p.number)) {
				return true;
			}
		}
		return false;
	}
}
