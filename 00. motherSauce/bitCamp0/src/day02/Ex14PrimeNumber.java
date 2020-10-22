package day02;
// 소수란?
// 1과 자기 자신 외에는 약수가 없는 숫자
// = 약수가 2개인 숫자
// ex) 2,3,5,7,11,13,17 등등

// 약수란?
// 어떤 숫자를 나눠서 나눠떨어지는 숫자
// = 나머지가 0
// ex) 8의 약수는 1,2,4,8

// 어떤 숫자의 가장 큰 약수는?
// 자기자신

// 이 3가지 조건을 이용하여
// 우리는 1부터 100까지의 소수를 출력하는 프로그램을 작성해보자

public class Ex14PrimeNumber {
	public static void main(String[] args) {
		//먼저 검사할 숫자는 i가 된다.
		for(int i = 1; i <= 100; i++) {
			//약수의 갯수를 저장할 변수 count를 만든다.
			int count = 0;
			//for문이 가장 실행되는 부분
			
			//j는  그 수가 약수인지를 검사할 숫자가 된다.
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					//이 수식이 0인 이유는 j가 i에 약수라는 뜻
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i+"는 소수입니다.");
			}
		}
	}
}
