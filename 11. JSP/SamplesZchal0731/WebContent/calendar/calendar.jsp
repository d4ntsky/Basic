<%@page import="util.UtilEx"%>
<%@page import="calendarEx.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="calendarEx.CalendarDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 실무 여기 하면 공개 되버림 -->
<%!
// nvl 함수 - 문자열 확인 함수
public boolean nvl(String msg) {	//문자열이 들어왔을 빈 문자열이나 null이면 true를 내보내주겠다. 
	return msg == null || msg.trim().equals("")?true:false;
}

//UtilEx에 다 넣어둠... 
%>

<%
//로그인 정보 가져오는 - 세션 끝났나 확인하는
Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null) {
	response.sendRedirect("goCheck.jsp?proc=login");	//세션이 없어져서 경로를 잡아주는 jsp를 잡는법
}
mem = (MemberDto)ologin;	//로그인 정보 얻어옴..
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4 align="left" style="background-color: #f0f0f0">환영합니다. <%=mem.getId() %>님</h4>

<%
	//오늘 날짜 얻어오기 date calendar 써서
	Calendar cal = Calendar.getInstance(); 	//모델 2로 했을때 컨트롤러로 가야되는게 좋음
	cal.set(Calendar.DATE, 1);	// 7월 31일 기준 7월1일로 바꿔주는 // 이유는 처음부터 값을 넣기위해
	
	//달력 화면에서 계속 년도랑 월이 바꿀수있게 초기화되는 부분 refresh 되는거
	String syear = request.getParameter("year");
	String smonth = request.getParameter("month");
	//위에 것이 안넘어오니까 처음 설정을 둬야한다.(처음엔 받아올게 없으니까)
	int year = cal.get(Calendar.YEAR);				
	if(nvl(syear) == false) { //비워져있지 않는 값일 때	//위에 파라미터 값이 넘어온 경우
		year = Integer.parseInt(syear);				//파라미터의 값으로 세팅을 한다!
	}
	
	int month = cal.get(Calendar.MONTH) + 1;
	if(nvl(smonth) == false) {
		month = Integer.parseInt(smonth);
	}
	
	if(month < 1) {	//전년도로 바뀌면서 12월로 넘어가는
		month = 12;
		year--;
	}
	if(month > 12) {
		month = 1;
		year++;
	}
	
	cal.set(year, month -1, 1); //년 월 일 셋팅이 완료	ex) 2020 07 31이면 >
	
	//요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	//플러그인을 사용하는데 지금은 만들어서 사용하는
		//이미지명 확인
	
	// year--	<<	연도 하나 뒤로
	String pp =	String.format("<a href='%s?year=%d&month=%d'>" + "<img src='../image/left.gif'></a>", 
								"calendar.jsp", year-1, month);
	
	// month--  <	달을 하나 뒤로
	String p =	String.format("<a href='%s?year=%d&month=%d'>" + "<img src='../image/prec.gif'></a>", 
								"calendar.jsp", year, month-1);
	
	// month++  >	달을 하나 앞으로
	String n =	String.format("<a href='%s?year=%d&month=%d'>" + "<img src='../image/next.gif'></a>", 
								"calendar.jsp", year, month+1);
	
	// year++	>>	연도 하나 앞으로
	String nn =	String.format("<a href='%s?year=%d&month=%d'>" + "<img src='../image/last.gif'></a>", 
								"calendar.jsp", year+1, month);
	
	//db에서 데이터 꺼내오기
	CalendarDao dao = CalendarDao.getInstance();
	List<CalendarDto> list = dao.getCalendarList(mem.getId(), year + UtilEx.two(month + "") );	//UtilEx two함수 사용
	
%>

<div align="center">

<table border="1">
	<col width="100"><col width="100"><col width="100"><col width="100"><col width="100"><col width="100"><col width="100">

	<!-- 캘린더의 제일 윗부분 -->
	<tr height="100">
		<td colspan="7" align="center" style="padding-top: 20px">
			<%=pp %>&nbsp;&nbsp;<%=p %>&nbsp;
			<font color="black" style="font-size: 50px">
				<%=String.format("%d년&nbsp;&nbsp;%2d월", year, month) %>
			</font>
			<%=n %>&nbsp;&nbsp;<%=nn %>&nbsp;
		</td>
	</tr>
	
	<!-- 캘린더의 요일 부분 -->
	<tr height="50">
		<th align="center"><font color="red">일</font></th>
		<th align="center">월</th>
		<th align="center">화</th>
		<th align="center">수</th>
		<th align="center">목</th>
		<th align="center">금</th>
		<th align="center"><font color="gray">토</font></th>
	</tr>
	
	<!-- 캘린더의 요일 부분 -->
	<tr	height="100" align="left" valign="top">
		<%
		//위쪽 빈칸 표현
		for(int i = 1; i < dayOfWeek; i++) {
			%>
			<td style="background-color: #cecece">&nbsp;</td>
			<%
		}
		%>
		
		<%
		//날짜 표현
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i = 1; i <= lastday; i++) {
			%>
			<td>
				<%=UtilEx.callist(year, month, i) %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=UtilEx.showPen(year, month, i) %>
				<%=UtilEx.makeTable(year, month, i, list) %>	<!-- list는 위의 리스트 -->		
			</td>
			<%
			if( (i+ dayOfWeek - 1) % 7 == 0 && i != lastday) {
				%>
				<tr><tr height="100" align="left" valign="top">			<!-- 개행 -->
				<%
			}
			
		}
		%>
		<%
		//밑칸
		cal.set(Calendar.DATE, lastday);	//그 달의 마지막 날짜로 세팅
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		for(int i = 0; i < 7 - weekday; i++) {
			%>
			<td style="background-color: #cecece">&nbsp;</td>
			<%
		}
		%>
	</tr>
	
	
</table>

</div>

<!--
일정관리는 자기만 볼수 있게 되있음
 
 추가하면 좋을 법한
화면 왼쪽에 일정을 검색할 수있는
언제부터 언제까지의 일정을 확인하는
  -->

</body>
</html>