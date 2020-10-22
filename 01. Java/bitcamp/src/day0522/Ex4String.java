package day0522;

public class Ex4String {
	//자주사용되는 함수들
		public static void main(String[] args) {
			/*
				String :	wrapper class
						 	문자열 저장, 편집, 정보 취득		
			*/
			
			String str;
			//class명 ; String
			// str : Object(객체), intance(주체) == class를 변수
			
			str = "안녕하세요";
			System.out.println("str = " + str);

			char strChar[] = {'안','녕','하','세','요'};
			strChar[0] = '건';
			strChar[2] = '강';
			
			str = "건강하세요";
			//str이 없었다면 strChar처럼 써야됐다
			
			String str1 = new String("하이, ");
	 //==	String str1 = "하이";
			
			String str2 = "반갑습니다";
				
			//문자열을 결합
			String str3;
			str3 = str1 +str2;
			System.out.println("str3 = " + str3);
			
			String str4;
			str4 = str1.concat(str2);//connection catch
			System.out.println("str4 = " + str4);
			//지금은 잘 안 쓰는 concat 다른 언어는 많이쓴다
			
			// 비교 함수 equals
			String str5 = "hello";
			String str6 = "hell";
			
			str6 = str6 + "o";
			
			if(str5 == str6) {
				System.out.println("str5와 str6는 같은 문자열입니다");
			}
			else {
				System.out.println("str5와 str6는 다른 문자열입니다");
			}
			//str6 hello를 hell로 바꾸고 o를 더해준것 //초기값이 달라서 false라 다름
			
			boolean b = str5.equals(str6); 
			if( b == true ) {
				System.out.println("str5와 str6는 같은 문자열입니다");
			}
			//equals 문자열과 문자열 비교하는 ex)회원번호/주민등록번호
			
			//indexOf : 지정 문자의 위치
			// lastIndexOf
			//예시
			char cArr[] = {'a','b','c'};
			System.out.println(cArr);
			
			String str7 = "abcdefghabcd";
			//d를 찾고싶을때     0123
			int n;
			n = str7.indexOf("d");		//앞에서부터 찾아가는
					System.out.println("n = " + n);
			n = str7.lastIndexOf("d");	//뒤에서부터 찾아가는
					System.out.println("n = " + n);
		
					
			//길이 length -> len(길이변수)
			int Array[] = { 1,2,3,4,5 };
			System.out.println("배열의 길이 = " + Array.length);
			
			str7 = "I can do it";
			int len = str7.length();//아래에 있는거는 길이 함수
			System.out.println("문자열의 길이 = " + len);
			
			//replace(수정)
			String str8 = "A*B**C";
			String repStr = str8.replace("*", "-");
			System.out.println("repStr: " + repStr);
			//활용은 문자열 편집할때
			//예시//내용도 웹도 가능
			String s = "코로나 기사이다. 코로나 바이러스 (내용이나 단어/웹페이지도 받을수 있다).";
			String rs = s.replace("코로나", "감기");
			System.out.println("rs: " + rs);
			
			//split
			/*
				split : token을 활용해서 문자열을 자른다.(편집 기능)
				ex) aaa-bbb-ccc     - : 토큰
				
				저장 매개체 :	file
							database(oracle)
				ex)파일매체안
				홍길동-24-2001/10/12-177.7
				토큰 - 를 통해 데이터를 나눠서 원하는 데이터를 짤라 받을수 있다
			 */	
			String str9 = "홍길동-24-2001/10/12-177.7";
			String splitArr[] = str9.split("-");
			
			for (int i = 0; i < splitArr.length; i++) {
				System.out.println(splitArr[i]);
			}
			//==
			System.out.println(splitArr[0]);
			System.out.println(splitArr[1]);
			System.out.println(splitArr[2]);
			System.out.println(splitArr[3]);
			
			// substring (범위를 통해서 문자열을 취득하는 함수)~부터~까지 부르는 
			String str10 = "abcdefghij";
			String subStr = str10.substring(0, 4);//4번째 전까지 불러옴
			System.out.println("subStr = " + subStr);
			//다른 사용처
			subStr = str10.substring(4);
			System.out.println("subStr = " + subStr);//4번째부터 끝까지
			
			// toUppercase (모든 문자를 대문자로 변경)
			// toLowercase (모든 문자를 소문자로 변경)
			// 잘 사용하지 않는
			// abcd == ABCD == AbCd 옛날엔 같은거로 인식
			String str11 = "abcDEF";
			String upStr = str11.toUpperCase();
			System.out.println("upStr = " + upStr);
			String lowStr = str11.toLowerCase();
			System.out.println("lowStr = " + lowStr);
			
			// trim 앞뒤의 공백을 없애주는 함수
			String str12 = "			java c언어 python  ";//앞tab 뒤space
			String trimStr = str12.trim();
			System.out.println("trimStr:" + trimStr + "--");
			//id입력했을때 뒤에 실수로 스페이스 누르는 사람을 위해
			//검색엔진 검색할때 앞뒤에 없애주는  "     아이폰       " 검색
			
			// valueOf(숫자 -> 문자열)
			/*
				문자열 -> 숫자			"123" ->  123
				숫자 -> 문자열			 123  -> "123" 전송을 문자열로
			*/
			int num = 123;
			long lo = 1234L;
			double d = 123.4567;
			String is = String.valueOf(num);
			String ls = String.valueOf(lo);
			String ds = String.valueOf(d);
			System.out.println(num + lo + d);
			System.out.println(is + ls + ds);
			System.out.println(is +" "+ ls +" "+ ds);
			
			int number = 234;
			String numStr = number +"";
			System.out.println(numStr);
	//==		String numStr = number;
			
			// contains (탐색용)
			String str13 = "서울시 강남구";
			boolean b1 = str13.contains("서울");
			System.out.println("b1 = " + b1);
			//서울사이에 " "있으면 false
			
			// charAt		array[2] ->
			// String str = "hello";   ==	charArray[5]
			String str14 = "가나다라마";// == charArray[5] = "가나다라마";
			char ch = str14.charAt(3);//0부터 나간다..
			System.out.println("ch = " + ch);
		}
	 
	}

