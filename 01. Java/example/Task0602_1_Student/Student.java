package Task0602_1_Student;

public class Student {
	String name;
	public int ban;
	public int no;
	public int kor, eng, math;
	
	int sum;
	
//	public int getTotal(int k, int e, int m) {
//		return (k+e+m);
//	}

	
	public double getAverage() {
		this.sum = this.kor + this.eng + this.math;
		return (double)sum/3;
	}
	public String getName() {

		return name;
	}
	public int getTotal(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		return (this.kor+this.eng+this.math);
	}

}
