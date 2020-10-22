package day0603_3Oop6;

public class Check {
	public static void main(String[] args) {
		//(1)다른 instance -> 따로 관리됨
//		ChildOne one = new ChildOne();
//		ChildTwo two = new ChildTwo();
//		
//		one.method();
//		two.method();
//==
//		//(2)같은 instance -> 함께 관리됨
//		Parent pone = new ChildOne();
//		Parent ptwo = new ChildTwo();
//		
//		pone.method();
//		ptwo.method();
//----------------------------------------------------
//		//cf 10마리 관리해야되는데 Cat 관리한다.
//		//다른 인스턴스
//			//lady
//				ChildOne lady[] =  new ChildOne[10];
//			//gent
//				ChildTwo gent[] =  new ChildTwo[10];
//			
//				lady[0] = new ChildOne(); 
//				gent[0] = new ChildTwo(); 
//				gent[1] = new ChildTwo(); 
//				lady[1] = new ChildOne();
//				
//		//관리자 human
//			Parent human[] = new Parent[4];	
//				human[0] = new ChildOne();
//				human[1] = new ChildTwo(); 
//				human[2] = new ChildTwo(); 
//				human[3] = new ChildOne(); 
//				
//			for (int i = 0; i < human.length; i++) {
//				human[i].method(); //over ride 메소드
//			}
//			
			Parent p1 = new ChildOne();
			Parent p2 = new ChildTwo();
			
			p1.method(); //cf)하나의 메소드 func을 추가해뒀다
			p2.method();
			
			//Cast변환!!
			ChildOne co = (ChildOne)p1; //()부분이 캐스트변환되고 생성되고 가능하게 함
			co.func();
			//==
			((ChildOne)p1).func(); 		//()안에서 cast변환뒤 나와서 부르는
	
			
	}
}