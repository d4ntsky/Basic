package util;

import java.util.List;

import calendarEx.CalendarDto;

public class UtilEx {
//프로그램 검사, 만들어 주는 부분

//----------------------------------------------------------------------------------	
	// 날짜를 클릭하면, 그 날의 일정이 모두 볼 수 있는 callist.jsp로 이동하는 함수
	
	public static String callist(int year, int month, int day) { 	//캘린더 리스트
		
		String str = "";
		
		str += String.format("&nbsp;<a href='%s?year=%d&month=%d&day=%d'>",		//%d는 10진수	//%s는 문자열
									        "callist.jsp", year, month, day); 	//format c언어의 printf와 동일
											//%s, %d, %d, %d
		
		str += String.format("%2d", day);	//%2d 2는 두칸이란 뜻 ex 2를 적으면 ' '2란뜻
		str += "</a>";
		
		// <a href='%s?year=%d&month=%d&day=%d'>_5</a>	모냥새
		// <a href='%s?year=2020&month=03&day=01'>_5</a>	모냥새
		
		//이건 숫자를 누르면 링크를 걸수 있게 만든 함수 
		
		
		return str;
	}
	
//----------------------------------------------------------------------------------	
	//일정을 기입하기 위해서 pen이미지를 클릭하면, calwrite.jsp로 이동하는 함수
	
	public static String showPen(int year, int month, int day) {	
		
		String str = "";
		
		String image = "<img src='../image/pen.gif' width='18px' height='18px'>";
				//이 구문이 적힐 jsp에서 점을 두 개 찍어 한 칸 나가는
				
		str = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", 
							"calwrite.jsp", year, month, day, image);
		
		/*
			<a href='%s?year=%d&month=%d&day=%d'>
				<img src='../image/pen2.png' width='18px' height='18px'>
			</a>
		 */
		return str;
	}
//----------------------------------------------------------------------------------
	// 1일이면 -> 01로 표현해야함으로 20/7/3 -> 20/07/03 만들어 주는 함수
	
	public static String two(String msg) {
		
		return msg.trim().length()<2?"0"+msg.trim():msg.trim();
	}

//----------------------------------------------------------------------------------
	//달력의 날짜 안에 설정할 테이블(달력 날짜에 한 칸 안에 일정을 테이블로 넣는...)	
		//여기서 two, dot3 쓰였음
	
	public static String makeTable(int year, int month, int day, List<CalendarDto> list) {	//리스트를 넘겨주면 테이블로 만들어주는
		
		String str = "";
		
		// 2020 7 31 -> 20200731
		String dates = (year + "") + two(month + "") + two(day + "");	//two는 method 위에꺼
		
		str += "<table>";
		str += "<col width='98'>";
		
		for (CalendarDto dto : list) {
			if(dto.getRdate().substring(0, 8).equals(dates)) {	//위에 날짜와 같은 날짜일 때
				str += "<tr bgcolor='#000000'>";
				str += "<td style='border:hidden'>";
				str += "<a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";	//title를 클릭하면 이동하게끔 만드는 anchor
				str += "<font style='font-size:9px; color:white'>";
				str +=  dot3(dto.getTitle());	//타이틀을 보이게 하는데 너무 길어지면 달력형태 이상해지므로	
				str += "</font>";
				str += "</a>";
				str += "</td>";
				str += "</tr>";
			}
			
		}
		str += "</table>";
		return str;
	}
	
//----------------------------------------------------------------------------------	
	//일정 제목이 길 때 내용"'...'"으로 처리 하는 함수
	
	public static String dot3(String msg) {
		
		String str = "";
		if(msg.length() >= 6) { 	// 여섯 글자 이상일 경우
			str = msg.substring(0, 6);	// 0부터 5 글자까지 - 앞부분 내용 표시
			str += "...";				// 그 뒤는 ... 쓰는
		}else {
			str = msg.trim();
		}
		return str;
	}
//----------------------------------------------------------------------------------	
	
}
