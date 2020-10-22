<%@page import="calendarEx.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%
//들어온 날짜값 rdate
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

System.out.println(year + " " + month + " " + day);

int seq = Integer.parseInt(request.getParameter("seq"));
String from = request.getParameter("from");

System.out.println(seq);
System.out.println(from);
%>

<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- callist에서 삭제된게 들어오면 -->
<%-- 
<input type="hidden" value="<%=from %>" id="imfrom"> --%>

<script type="text/javascript">
let from = "<%=from %>";
alert(from);

</script>

<%
CalendarDao dao = CalendarDao.getInstance();
boolean isS = dao.deleteCal(seq);

if(isS){
	
%>	
	<script type="text/javascript">
	alert("정상적으로 삭제되었습니다");
		
		if(from == "lis") {
			
			location.href = "callist.jsp?year=" + <%=year %> + "&month=" + <%=month %> + "&day=" + <%=day %>;
			
		}else if(from == "det") {
			
			location.href = "calendar.jsp";
		}
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("삭제되지 않았습니다");
	location.href = "calendar.jsp";
	</script>
<%
}
%>

</body>
</html>