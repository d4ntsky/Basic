package day04;
// 그래서 자바에서는
// 배열을 클래스화시킨 ArrayList라는 클래스가 있다.
// 기존 배열을 기본형이면 값을 직접 가지고 있고
// 크기도 고정되어있었지만
// 이 ArrayList는 크기도 고정되어있지않고 참조형만 모아둔다.
// 주소값을 사용해서 컨트롤 하기 때문에
// 훨씬 더 쓰기 편하다.

import java.util.ArrayList;
public class Ex04ArrayList {
	public static void main(String[] args) {
		ArrayList<Car> list = new ArrayList<>();
		//배열과 마찬가지로 어레이리스트는 1개의 데이터타입만 모아둘 수 있다!
		//어레이리스트 옆에 붙은 <>를 template이라고 부르며
		//해당 클래스가 무엇의 collection인지를 자바에 등록하는 것이다.
		
		//리스트에 값을 추가할때에는
		//리스트의 add 메소드에 파라미터로 값을 넣어주면 된다.
		Car c1 = new Car("1", "1", "1", 1);
		Car c2 = new Car("2", "2", "2", 2);
		Car c3 = new Car("3", "3", "3", 3);
		Car c4 = new Car("4", "4", "4", 4);
		Car c5 = new Car("5", "5", "5", 5);
		Car c6 = new Car("6", "6", "6", 6);
		list.add(c1);
		//리스트의 크기는 유동적이며
		//추가/삭제할때마다 크기가 변하게 된다.
		//리스트의 크기는 list.size()로 볼 수 있다.
		System.out.println("list의 현재 크기: "+list.size());
		list.add(c2);
		System.out.println("list의 현재 크기: "+list.size());
		list.add(c3);
		System.out.println("list의 현재 크기: "+list.size());
		list.add(c4);
		//또한 특정 위치에 값을 추가하고 싶다면
		//list.add(index, object)로 추가할 수 있다.
		//만약 해당 위치에 값이 이미 존재하면 원래 있던 값부터 1개씩 밀려난다.
		list.add(c5);
		list.add(4, c6);
		        //순서가 바뀌는 부분
		
		for(int i = 0; i < list.size(); i++) {
			//list에 해당 인덱스에 존재하는 객체를 꺼내올때에는
			//list.get(index)로 꺼내온다.
			System.out.println(list.get(i));
		
		}
		
		//ArrayList는 객체의 equals()메소드를 적극 활용해서
		//그 객체가 list에 존재하는지, 몇번째 index에 있는 등을
		//메소드로 자기가 알아봐준다!
		
		//해당 객체가 list에 존재하는지 확인할 때에는
		//list.contains(객체)를 실행하면
		//boolean값이 리턴된다.
		
		//똑같은 객체를 넣어서 확인할 수도 있고
		//객체를 새로만들어 그 객체의 값으로도 확인 가능하다.
		System.out.println(list.contains(c1));
		Car c7 = new Car("7","7","7",7);
		System.out.println(list.contains(c7));
		
		Car c1Duplicated = new Car("1","1","1",1);
		System.out.println(list.contains(c1Duplicated));
		
		//해당 객체의 인덱스를 찾을때에는
		//list.indexOf(객체) 로 실행한다.
		System.out.println(list.indexOf(c5));
		System.out.println(list.indexOf(c1Duplicated));
		//만약 해당 객체가 리스트에 존재하지 않을때
		//indexOf를 실행하면 무엇이 나올까?
		System.out.println(list.indexOf(c7));
		//가장 작은 인덱스는 0이므로 인덱스가 -1이면 존재하지 않는다는 뜻
		
		//list에서 객체를 삭제할 때는 2가지 방법을 삭제할 수 있다.
		//1. index로 삭제
		System.out.println("리스트의 현재크기 : "+list.size());
		list.remove(3);
		System.out.println("리스트의 현재크기 : "+list.size());
		//2. 객체    로 삭제
		System.out.println("리스트의 현재크기 : "+list.size());
		list.remove(c1Duplicated);
		System.out.println("리스트의 현재크기 : "+list.size());
		
		
		//추가팁
		//이렇게 모여있는 collection을 !!!출력!!!만 할 때에는
		//for문을 좀더 간단하게 쓸 수 있다!
		//!!!!!대신!!!!!
		//입력/삭제를 하면 에러
		//수정을 하면 반영안됨 이라는 단점이 있다
		
		//ArrayList나 배열이 무엇이 되었던간에
		//결국 특정 데이터타입 1개가 모여있는 형태이다.
		//그러면 임시로 하나하나를 변수 a 이렇게 부르면 되지 않을까...?
		for(Car c : list) {
			System.out.println(c); //출력용
		}
	}
}