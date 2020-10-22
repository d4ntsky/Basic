package day04;
// 로또 번호 제작기 - ArrayList 버젼

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex04Lotto {
	final static int SIZE = 6;
	static final int MAX = 45; //45개 중 6개를 뽑는다는 중복된 거 제거
	//final이랑 static이랑 자리바뀌는 것 상관 무?
	
	public static void main(String[] args) {
	
		Random random = new Random();
								//import 쉽게 하는법: Random 쓰고 컨트롤+스페이스 맨위에꺼
		
		//ArrayList는 클래스만 template으로 받아들일 수 없다.
		//따라서 int, double등의 기본형 데이터타입은 template으로 들어갈 수 없다.
		//그렇다면 만약 우리가 저런 기본형 데이터타입으로 ArrayList를 만들려면 어떻게 해야할까?
		//-> 우리가 할 걱정이 아니지
		// 자바가 해야할 걱정 -> 그래서 자바는 기본형 데이터타입에 대한
		// 클래스 버젼인 wrapper 클래스를 제공한다
		// int의 wrapper 클래스는 Integer 이다.
		ArrayList<Integer> lottoNumbers = new ArrayList<>();
								//import 쉽게 하는법: ArrayList 쓰고 컨트롤+스페이스 맨위에꺼
		
		//먼저 우리는 이 lottoNumbers의 크기가 6보다 작을 동안
		//랜덤 숫자를 하나 만들어서 그 숫자가 lottoNumbers에 없으면 추가
		//있으면 추가 안한다.
		//즉 아예 중복제거를 할 필요가 없어진다.                     -> 당첨번호를 6개 뽑는것(다시확인
		while(lottoNumbers.size() < SIZE) {
			int randomNumber = random.nextInt(MAX)+1;
			if(!lottoNumbers.contains(randomNumber)) {
			//논리연산자 느낌표!
				lottoNumbers.add(randomNumber);
				
			}
		}
		Collections.sort(lottoNumbers);
		//정렬식                        		//import 쉽게 하는법: Random 쓰고 컨트롤+스페이스 맨위에꺼
		
		for(Integer i : lottoNumbers) {
			System.out.println(i);
		}
	}
}