package day0601_1Oop1;



public class ObjectOrientedProgramming {

	public static void main(String[] args) {
		/*	OOP	객체 지향 프로그래밍
		 Object Oriented Programming <-> 절차지향 속도가 빠름
		절차지향은 유지보수가 힘듦. 각자의 처리를 계속 만들고 그 중 메소드가 여러개가 반복될 수 있다.
		instanceof 변수와 처리가 많아진 것을 하나로 믂아서 활용하게 해주는 ...
		처리 중심 -> 설계중심
		*/
		/*
		//예)TV -> 2대
		String name[] = new String[2];		// 삼성,	LG //2대에서 10대로 바뀌면
		int channel[] = new int[2];			// 채널
		boolean power[] = new boolean[2]; 	// on/off
		int movie[] = new movie[];
		// String title[] = new String[10];
		
		
		name[0] = "삼성";
		name[0] = "LG";
		
		channel[0] = 11;
		channel[1] = 23;
		
		power[0] = true;
		power[1] = false;
		*/
		/*
			class MyClass { //class 설계
				변수(member) - 접근지정(외부, 내부)
					함수(메소드)	- 처리
		}	
		클래스명 변수(instance) = new 클래스명();
		MyClass cls = new myClass();
				stack    heap
				
		MyClass cls = null; -> ()0
		*/
		TV tv1 = new TV();			//tv1 -> instance(주체): 메모리 상에 존재하는 요소
		tv1.getInput("LG", 11, true);
		tv1.method();
		
		TV tv2 = new TV();			//tv2 -> object라고도 한다.
		tv1.getInput("삼성", 23, false);
		tv1.method();
		
		//배열만을 동적할당
		TV arrTv[] = new TV[3];	//arrTv1, arrTv2, arrTv3.
		
		//객체를 동적할당
		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i] = new TV();
		}
		
		arrTv[0].getInput("aaa", 1, true);
		arrTv[1].getInput("bbb", 2, true);
		arrTv[2].getInput("ccc", 3, true);
		
		arrTv[1].setPower(false);
		arrTv[2].setPower(false);
		
		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i].method();
		}
	
	
//	String student1[][] = {
//			{"홍길동", "24", "98", "100" },
//			{"일지매", "24", "98", "100" },
//			{"임꺽정", "24", "98", "100" }
//			//1		   2	 3	   4
//	};
//	
//	Day0601Ex03Student student2 = new Day0601Ex03Student();
//		student2.setName("홍길동");
//		student2.setAge(24);
//		student2.setEng(98);
//		student2.setMath(100);
//		
//	
//	Day0601Ex03Student student3 = new Day0601Ex03Student();
//		student3.setName("홍길동");
//		student2.setAge(24);
//		student3.setEng(98);
//		student3.setMath(100);
//	
	
	}
}
	
