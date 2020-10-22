package main;

public class testClass {

	public static void main(String[] args) {
		/*
		String str1 = "String1";
		String str2 = "String2";
		StringBuffer str3 = new StringBuffer("String1");

		boolean  result = str1.contentEquals( str3 );
		System.out.println(result);
		  
		result = str2.contentEquals( str3 );
		System.out.println(result);
		*/
		String[] month = new String[11];
		/*
		for (int i = 0; i < month.length; i++) {
			month[i] = i;
			i++;
		}
		
		System.out.println(month);
		*/
		int[] month2 = new int[12];
		for(int i = 0; i < month2.length; i++) {
			month2[i] = i;
			System.out.println(i + ": " +month2[i]);
		}
		
	
	}
}
/*
 회원 가입; 로그인
 로그인 하고 나면
 커피 가게 이름
 
 커피 선택 choice < jcombox? 
 가격표는 가격표 보기 창이 새로 띄워지고 전창은 안닫히게
 size라디오버튼 선택 
 시럽     라디오버튼
 	 체크박스 샷추가 휘핑크림
 	 
 	 주문 버튼 클릭 시
 	 추가된 내역이 뜨면
 	 주문화면 누르면 주문 화면 종료 하면 종료
 	 
 	 테이블 만들기
 	 커피 	
 	panel 
 	 사이즈	grid layout 4칸
 	 시럽 				4칸
 	 the other		3칸
 	 		
 	 
 	 rkrur
 	 가격 차이 일정 500
 	 서류 제출용
 */
