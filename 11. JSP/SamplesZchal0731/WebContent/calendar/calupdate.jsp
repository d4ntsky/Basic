<%@page import="calendarEx.CalendarDto"%>
<%@page import="calendarEx.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
int seq = Integer.parseInt(request.getParameter("seq"));
String from = request.getParameter("from");

System.out.println(seq);
System.out.println(from);
%>

<%
CalendarDao dao = CalendarDao.getInstance();

CalendarDto dto = dao.getMeeting(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
수정
수정할곳은 한곳으로 from들고와서 각각 수정받은곳으로 나가게 
방법2 고친값 바로 넘겨주는거도
-->

<div>
<form action="calupdateAf.jsp?from=<%=from %>&seq=<%=seq %>" method="post">
<table border="1">
	<tr>
		<th>작성자</th>
		<td>
		<%=dto.getId() %>
		</td>
	</tr>

	<tr>
		<th>일정</th>
		<td><input name="title" value="<%=dto.getTitle() %>"></td>
	</tr>

	<tr>
		<th>약속 날짜</th>
		<td><input name="rdate" value="<%=dto.getRdate() %>"></td>
	</tr>
	
	<tr>
		<th colspan="2">일정내용</th>
		
	</tr>
	
	<tr>
		<td colspan="2"><textarea name="content" cols="50" rows="20"><%=dto.getContent() %></textarea></td>
	</tr>
	
	<tr>
	<td colspan="2">
		<input type="submit" value="수정하기">
	</td>
	</tr>
	
</table>
</form>
</div>


</body>
</html>