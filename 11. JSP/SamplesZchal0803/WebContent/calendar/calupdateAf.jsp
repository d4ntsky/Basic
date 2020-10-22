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
int seq = Integer.parseInt(request.getParameter("seq"));
String from = request.getParameter("from");
String rdate = request.getParameter("rdate");
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println(seq);
System.out.println(from);
System.out.println(rdate);
System.out.println(title);
System.out.println(content);

String year = rdate.substring(0, 4);
String month = rdate.substring(4, 6);
String day = rdate.substring(6, 8);

System.out.println(year);
System.out.println(month);
System.out.println(day);

CalendarDao dao = CalendarDao.getInstance();
boolean isS = dao.updateCal(seq, title, content, rdate);
if(isS){
%>

	<script type="text/javascript">
	
	alert("글이 성공적으로 등록 되었습니다");
	
	let from = "<%=from %>";
	alert(from);
	
	if(from == "lis") {
		
		location.href = "callist.jsp?year=" + <%=year %> + "&month=" + <%=month %> + "&day=" + <%=day %>;
		
	}else if(from == "det") {
		
		location.href = "calendar.jsp";
	}
	
	</script>
<%
}else{	//시퀀스 번호 초기화 안되는데?
%>
	<script type="text/javascript">
	alert("다시 기입해 주십시오");
	location.href = "bbswrite.jsp";
	</script>
<%
}
%>


</body>
</html>