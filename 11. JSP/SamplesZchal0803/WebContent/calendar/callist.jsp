<%@page import="util.UtilEx"%>
<%@page import="calendarEx.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="calendarEx.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

MemberDto mem = (MemberDto)session.getAttribute("login");

System.out.println(year + " " + " " + month + " " + day);

CalendarDao dao = CalendarDao.getInstance();
List<CalendarDto> list = dao.getTheCalList(mem.getId(), year + UtilEx.two(month + "") + UtilEx.two(day + "") );
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	

</head>
<body>

<button type="button" onclick="location.href='calendar.jsp'">돌아가기</button>
<br><br>

<div align="center">
<%
if(list == null || list.size() == 0) { 
	%>
	<%
}else{
	for (CalendarDto dto : list) {		//form으로 잡히고 for문으로  i 돌려서 frm01, frm02
	%>
	<form action="caldelete.jsp?from=lis&seq=<%=dto.getSeq() %>" method="post">
	<table border="1" >
		<col width="50"><col width="300">
		<tr>
		<th>일정</th>
			<td>
			<%=dto.getTitle() %>
			</td>
		<tr>	
		
		<tr>
		<th>약속날짜</th>
			<td>
			<%=dto.getRdate() %>
			<input type="hidden" value="<%=year %>" name="year">
			<input type="hidden" value="<%=month %>" name="month">
			<input type="hidden" value="<%=day %>" name="day">
			</td>
		</tr>
		
		<tr>
		<th colspan="2">내용</th>
		</tr>
		
		<tr>
			<td colspan="2">
			<%=dto.getContent() %>
			</td>
		</tr>	
				
		<tr>
			<td>
				<button type="submit">삭제
				</button>		<!-- 디테일로 옮겨가는 버튼만 해야되나 여기서 따로 기능이 되게 해야되나? -->
			</td>
			<td>
				<button type="button" onclick="location.href='calupdate.jsp?from=lis&seq=<%=dto.getSeq() %>'">수정 						<!-- 여기서 바로 수정되야하나?  -->
				</button>
			</td>
		</tr>
		
		<tr>
			<td>
			확인용
			</td>
			<td>
				<%=dto.getSeq() %>
			</td>
		</tr>
		
	</table>
	</form>
	<br>
	<br>
	<%
	}
}
%>
</div>

<!-- 번호를 누르면 그 날의 모든 일정들을 확인할 수 있는 jsp 
 날짜 주면 일정 가져오는거 쿼리문으로
 디테일로도 갈수 있게
-->



</body>
</html>