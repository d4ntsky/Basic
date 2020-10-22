<%@page import="util.UtilEx"%>
<%@page import="calendarEx.CalendarDto"%>
<%@page import="calendarEx.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>

<%
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String hour = request.getParameter("hour");
String min = request.getParameter("min");

System.out.println("id:" + id);
System.out.println("title:" + title);
System.out.println("content:" + content);
System.out.println(year + "년 " + month + "월 " +  day + "일 " +  hour + "시 " +  min + "분");

// 2020/7/31 14:52 -> 202007311452
String rdate = year + UtilEx.two(month) + UtilEx.two(day) + UtilEx.two(hour) + UtilEx.two(min);
System.out.println(rdate);

CalendarDao dao = CalendarDao.getInstance();
boolean isS = dao.addCalendar(new CalendarDto(id, title, content, rdate));
if(isS) {
	%>
		<script type="text/javascript">
			alert("일정이 추가되었습니다");
			location.href = "calendar.jsp";
		</script>
	<%
	}else {
	%>
		<script type="text/javascript">
			alert("일정이 추가되지 않았습니다");
			location.href = "calendar.jsp";
		</script>
	<%	
	}	
%>

</body>
</html>