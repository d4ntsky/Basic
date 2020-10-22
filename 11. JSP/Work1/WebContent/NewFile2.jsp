<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	int globalNum = 0;
%> 
<% 
	int localNum = 0;
	globalNum++;
	localNum++;
%>
글로벌<br>
<%=globalNum %><br>
로컬<br>
<%=localNum %>
<br><hr><br>

<table border="1">
<%
for(int i = 0 ; i < 4; i++) {
	out.println("<tr>");
	for(int j = 0 ; j < 4; j++) {
		out.println("<td>"+i+"*"+j+"="+i*j+"</td>");
	}
	out.println("</tr><br>");
}
%>
</table>
<br><hr><br>

<table border="1">
<%
for(int i = 0 ; i < 5; i++) {
%>
<%
	out.println("<tr>");
%>
<%
	for(int j = 0 ; j < 5; j++) {
%>
<%
		out.println("<td>"+i+"*"+j+"="+i*j+"</td>");
%>
<%
	}
%>
<%
	out.println("</tr><br>");
%>
<%
}
%>
</table>
<br><hr><br>

<%!
int cnt = 0;
%><br>
Count: <%=cnt %>
<br><hr><br>


</body>
</html>