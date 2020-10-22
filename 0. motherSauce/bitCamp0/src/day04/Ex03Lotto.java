package day04;
// 로또 번호 제작기 배열 버젼
import java.util.Random;
public class Ex03Lotto {
	private static final int SIZE = 6;
	private static final int MAX = 45;
	public static void main(String[] args) {
		Random random = new Random();
		int[] lottoNumbers = new int[SIZE];
		for(int i = 0; i < lottoNumbers.length; i++) {
												//+1을 더함으로써 0이 나오는 문제해결
			lottoNumbers[i] = random.nextInt(MAX) + 1;
			                                      
		}
		
		System.out.println("=============난수 입력 직후=============");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//중복제거
		//i 번째 인덱스 : 검사할 대상
		//j 루프로 배열 전체로 다니면서
		//인덱스가 틀리지만 값이 같으면 중복이니
		//i 번째 인덱스에 random.nextInt(MAX)+1를 재 실행한다.
		//재실행한 후에 j의 위치를 맨처음으로 돌려보내서 처음부터 다시 검사한다.
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < lottoNumbers.length; j++) {
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX)+1;
					j = -1; //j++로 루프도는데 -1로 돌려보내서 0으로 i 재검사 시작
				}
			}
		}
		System.out.println("=============중복 제거 이후=============");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//정렬은 i번째와 i+1번째를 비교해서
		//만약 i번째가 더 크면 2개의 위치를 바꾸고
		//i를 처음으로 돌려보내서 다시 검사한다.
		for(int i = 0; i < lottoNumbers.length - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
            //	lottoNumbers[i] = lottoNumbers[i+1];
            //	lottoNumbers[i+1] = lottoNumbers[i];
            //  이렇게 할 경우 값이 사라진 상태가 되기 때문에
				int temp = lottoNumbers[i];
			    lottoNumbers[i] = lottoNumbers[i+1];
	            lottoNumbers[i+1] = temp;
	            i = -1;
			}
		}
		
		System.out.println("================정렬후================");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		//이 모든 과정이 복잡하고 비효율적임 정렬 알고리즘이 따로 있음 ?
		//youtube > sorting algorithm
		//15 sorting algorithms in 6 minutes
	}
}