package day01;
//증감 연산자
//증감 연산자는
//변수의 값을 1씩 증가하거나 감소시킨다.
//++는 1 증가 --는 1 감소
//하지만 연산자의 위치에 따라 그 의미가 바뀌게 된다.
//++number vs number++
public class Ex03 {
	public static void main(String[] args) {
		int number = 5;
		System.out.println(number);
		System.out.println(number++);
		//System.out.println(number++)는 비록 1줄에 적혀있지만
		//실제론 2단계에 걸쳐서 실행이 된다.
		//1번 : System.out.println(number)
		//2번 : number++;
		System.out.println(number);
		System.out.println(++number);
		//System.out.println(++number)는 number++와 반대로
		//1번 : ++number;
		//2번 : System.out.println(number)
		//순으로 실행된다.
		//이렇게 증감연산자가 변수의 앞에 붙어있을땐
		//전위 증감연산자라고 하고
		//뒤에 붙으면
		//후위 증감연산자라고 한다.
	}
}
