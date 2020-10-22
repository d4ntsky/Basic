package Task0603;
//다음 코드의 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오. 
public class Check {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child(); 
		
		System.out.println("x="+c.getX()); 
	}

}

class Parent {  
	int x=100;  
	
	Parent() {   		
		this(200);  
		System.out.println("Parent Parent() 2");	// 2
	}  
	Parent(int x){  	
		this.x = x;  
		System.out.println("Parent Parent(int x) 1");	// 1 
	}  
	int getX() {   
		return x;  
	} 
} 

class Child extends Parent {  
	int x = 3000;  
	Child() {   
	//	System.out.println("Child");
		this(1000);		
		System.out.println("Child Child() 4");		// 4
	}  
	Child(int x) {   
		this.x = x;  
		System.out.println("Child Child(int x) 3");	// 3
	} 
		
} 