package Task0609_cls;

public class Point3D {
	
	int x,y,z; 
	//public 추가
	public Point3D(int x, int y, int z) {
		this.x=x; 
		this.y=y; 
		this.z=z; 
		} 
	Point3D() {
		this(0,0,0); 
		}
	
	public boolean equals(Object obj) {
		/* (1) 인스턴스변수 x, y, z를 비교하도록 오버라이딩하시오. */ 
		Point3D pos = (Point3D)obj;
		if(this.x == pos.x && this.y == pos.y && this.z == pos.z) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
//	public String toString() {
//		/* (2) 인스턴스변수 x, y, z의 내용을 출력하도록 오버라이딩하시오. */ 
//		
//	}
	
	
}