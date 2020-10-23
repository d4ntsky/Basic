package day0603_5Static;

public class Member {
	public Member() {	//생성자
		System.out.println("Member Member()");
	}
	
	public void init() {
		System.out.println("Member init()");
	}
	
	public void random() {
		System.out.println("Member random()");
	}
	
	public void input() {
		System.out.println("Member input()");
	}
	
	public static Member getinstance() { //==staticMethod()
		Member m = new Member();
		m.init();
		m.random();
		m.input();
		
		return m;
		
	}
}
