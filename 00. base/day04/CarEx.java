package day04;

public class CarEx {
	public static void main(String[] args) {
		Car myCar = new Car();
							
		//우리가 맨처음 아무것도 안하고
		System.out.println(myCar.getcolor());
		System.out.println(myCar.getNumber());
		System.out.println(myCar.getPrice());
		
		//System.out.println(myCar.getcolor().equals("00가0000")); 입력시
								 //getcolor가 변수의 이름처럼쓰임
											 //equals                     >  에러
		
		myCar.setNumber("00가 0000");
		myCar.setColor("파랑색");
		//.의 의미 myCar가 setColor부분 메소드를 불렀다는 얘기
		myCar.setType("소나타");
		myCar.setPrice(2000);
		
		myCar.start();

		Car yourCar = new Car();
		yourCar.setNumber("99하 9999");
		yourCar.setColor("흰색");
		yourCar.setType("SM5");
		yourCar.setPrice(3000);
		
		yourCar.start();

		System.out.println(myCar.getNumber());
		System.out.println(yourCar.getNumber());
		System.out.println(myCar.getType());
		System.out.println(yourCar.getType());
		System.out.println(yourCar.getPrice());
		
		//System.out.println에 우리가 객체를 파라미터로 주면
		//System.out.println은 해당 객체의 toString() 메소드를 실행시킨
		//결과값을 화면에 출력한다.
		
		System.out.println(myCar);
		System.out.println(yourCar);
		
		Car yourCar2 = new Car();
		yourCar2.setNumber("99하 9999");
		yourCar2.setColor("흰색");
		yourCar2.setType("SM5");
		yourCar2.setPrice(3000);
		
		System.out.println(yourCar2);
		
		System.out.println(yourCar.equals(yourCar2));
		//false 비교연산자나 .equals 같지만 overriding 하면 달라짐 
		
		
		}
}