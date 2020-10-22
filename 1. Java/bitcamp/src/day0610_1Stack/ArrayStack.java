package day0610_1Stack;

public class ArrayStack {

	private int top;			//실린더형(스택)에서만 쓰임. 맨위의 값 FILO에서 맨 끝 요소 pop
					    		//Arraylist.get(list.size()-1);
	
	private int maxSize;		//배열의 최대크기
	
	
	private Object stackArray[];	//object는 string,int 많은 값의 대표
									//ArrayList
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize; //밖에서 정해주는 크기로 따라가겠다는 뜻
		stackArray = new Object[maxSize];
		this.top = -1; 			//초기화/ 공이 없기 때문에
	}
	
	// stack 공간이 비어있는 지 확인
	public boolean isEmpty() {
		return (this.top == -1);	//top 멤버변수 cf)this 없어도됨
	}
	
	// stack 공간이 꽉 차있는 지 확인
	public boolean full() {
		return (this.top == maxSize - 1 );
	}	//ex)회원가입 때 한계가 있는 경우
	
	// insert
	public void push(Object item) {
		if(full() == true) { //== true 빼도됨
			System.out.println("스택 공간이 가득 차있습니다");
			return;
		}
		
		top++;
		stackArray[top] = item; //item을 top자리 넣는...
	}
	
	// delete
	public Object pop() {	//return을 해주고 지움
		Object item = peek();
		top--;
		return item;
	}
	
	public Object peek() {	//peek 집어내다
		if(isEmpty()) {
			System.out.println("스택 공간이 비어 있습니다");
			return null;
		}
		return stackArray[top];
	}
	
//------------------------------------------------------stack 클래스 완성
	//기본 생성자 없었음
}

