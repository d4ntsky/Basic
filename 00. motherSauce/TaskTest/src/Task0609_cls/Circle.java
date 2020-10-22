package Task0609_cls;

public class Circle extends Shape {
	
	double r;
	
	public Circle() {
		
	}
	
	public Circle(double r) {
		super();
		this.r = r;
	}
	
	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return (r * r * Math.PI);
	}

}