<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String str = "Hello World";
out.println("<h1>"+str+"</h1>");
%>
<p><%=str %></p>

<br><hr><br>
<%-- ----------------------------------------------------------- --%>

<%
Date nowtime = new Date();
%>
<p>시간출력</p>
<p>
	현재 시간은 <%=nowtime %>
</p>
<input type="text" value="<%=nowtime %>>">

<br><hr><br>
<%-- ----------------------------------------------------------- --%>

<%
Calendar cal = Calendar.getInstance();
//Calendar cal = new GregorianCalendar();

int nowhour = cal.get(Calendar.HOUR_OF_DAY);
%>
<p>	현재 시각은 <%=nowhour %>시입니다.</p>
<%
	if(nowhour > 6 && nowhour <12) {
%>		
	<h3>안녕히 주무셨습니까?</h3>
<%
	}else if(nowhour >= 12 && nowhour < 18) {
%>		
		<h3>안녕하세요</h3>
<%		
	}else {
%>		
		<h3>안녕히 주무세요</h3>
<%
	}
%>


</body>
</html>