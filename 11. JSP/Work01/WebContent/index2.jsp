<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%!
	public String setColorHTML(String str, String color) {
		return "<font color=\"" + color + "\">" + str + "</font>";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<font color="#ff0000">빨간색 텍스트</font>
<br>
<%
String green = setColorHTML("초록색 텍스트", "#00ff00");
String blue = setColorHTML("파란색 텍스트", "#0000ff");
%>

<%=green %>
<br>
<%=blue %>

<br><hr><br>
<%-- ----------------------------------------------------------- --%>

</body>
</html>