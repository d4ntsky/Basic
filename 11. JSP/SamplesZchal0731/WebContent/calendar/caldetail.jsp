<%@page import="calendarEx.CalendarDto"%>
<%@page import="calendarEx.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

int seq = Integer.parseInt(request.getParameter("seq"));

MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<%
CalendarDao dao = CalendarDao.getInstance();

CalendarDto dto = dao.getMeeting(seq);
%>

<!-- 그 날의 제목과 내용을 볼수 있다
		일정 눌러서 확인 
		삭제 기능도 추가...
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<form>
<table border="1">
	<tr>
		<th>작성자</th>
		<td>
		<%=dto.getId() %>
		</td>
	</tr>

	<tr>
		<th>일정</th>
		<td><%=dto.getTitle() %></td>
	</tr>
	
	<tr>
		<th>작성 날짜</th>
		<td><%=dto.getWdate() %></td>
	</tr>
	
	<tr>
		<th>약속 날짜</th>
		<td><%=dto.getRdate() %></td>
	</tr>
	
	<tr>
		<th colspan="2">일정내용</th>
		
	</tr>
	
	<tr>
		<td colspan="2"><%=dto.getContent() %></td>
	</tr>
	
	<tr>
		<td><button type="button" onclick="location.href='calupdate.jsp?from=det&seq=<%=seq %>'">수정</button></td>					<!-- update -->
		<td><button type="button" onclick="location.href='caldelete.jsp?from=det&seq=<%=seq %>'">삭제</button></td>		 			<!-- delete -->
	</tr>
	
	
</table>
</form>
</div>


</body>
</html>