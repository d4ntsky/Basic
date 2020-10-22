package day02;
//중첩 for loop
//for loop 안에 for loop
public class Ex13NestedForLoop {
	public static void main(String[] args) {
		//for loop안에 for loop이 들어간
		//중첩 for loop
		for(int i = 0; i < 4; i++) {
			for(int j = 1000; j < 1002; j++) {
				System.out.println("i의 현재값: "+i+", j의 현재값:"+j);
			}
		}
		
		for(int k = 1000; k < 1002; k++) {
			for(int l = 0; l < 4; l++) {
				System.out.println("k의 현재값: "+k+", j의 현재값:"+l);
			}
		}
	}
}